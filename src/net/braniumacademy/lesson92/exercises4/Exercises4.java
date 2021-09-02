package net.braniumacademy.lesson92.exercises4;

/**
 * @author Branium Academy
 * @version 2021.09
 * @see <a href="https://braniumacademy.net/">Branium Academy</a>
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Exercises4 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        readDataFromFile(employees);
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.err.println("========================== MENU ==========================");
            System.err.println("*\t1. Tìm nhân viên theo mã.                            *");
            System.err.println("*\t2. Tìm nhân viên theo tên gần đúng.                  *");
            System.err.println("*\t3. Tìm nhân viên có mức lương x.                     *");
            System.err.println("*\t4. Tìm nhân viên có mức lương trong đoạn [x, y].     *");
            System.err.println("*\t5. Sắp xếp danh sách nhân viên theo lương giảm dần.  *");
            System.err.println("*\t6. Hiển thị danh sách nhân viên.                     *");
            System.err.println("*\t7. Thoát chương trình.                               *");
            System.err.println("==========================================================");
            System.err.println("Xin mời chọn chức năng số: ");
            choice = input.nextInt();
            input.nextLine(); // đọc bỏ dòng trước đó
            switch (choice) {
                case 1:
                    System.out.println("Nhập mã nhân viên cần tìm: ");
                    var id = input.nextLine();
                    var searchResult = searchById(employees, id);
                    if (searchResult == null) {
                        System.err.println("==== Không có kết quả ====");
                    } else {
                        System.out.printf("==== Tìm thấy sinh viên mã \"%s\" trong danh sách ====\n", id);
                        showHeader();
                        showEachEmp(searchResult);
                    }
                    break;
                case 2:
                    if (!employees.isEmpty()) {
                        System.out.println("Nhập tên cần tìm: ");
                        var nameToSearch = input.nextLine();
                        var resultList = searchByName(employees, nameToSearch);
                        if (resultList.size() > 0) {
                            System.out.println("==== Kết quả tìm kiếm ====");
                            showEmpInfo(resultList);
                        } else {
                            System.err.println("==== Không tìm thấy kết quả nào ====");
                        }
                    } else {
                        System.err.println("=== Danh sách nhân viên rỗng! ===");
                    }
                    break;
                case 3:
                    if (!employees.isEmpty()) {
                        System.out.println("Nhập mức lương: ");
                        var salaryToSearch = Integer.parseInt(input.nextLine());
                        var resultList = searchBySalary(employees, salaryToSearch);
                        if (resultList.size() > 0) {
                            System.out.println("==== Kết quả tìm kiếm ====");
                            showEmpInfo(resultList);
                        } else {
                            System.err.println("==== Không tìm thấy kết quả nào ====");
                        }
                    } else {
                        System.err.println("=== Danh sách nhân viên rỗng! ===");
                    }
                    break;
                case 4:
                    if (!employees.isEmpty()) {
                        System.out.println("Nhập giới hạn mức lương cách nhau bởi dấu cách: ");
                        var fromSalary = input.nextInt();
                        var toSalary = input.nextInt();
                        var resultList = searchBySalary(employees, fromSalary, toSalary);
                        if (resultList.size() > 0) {
                            System.out.println("==== Kết quả tìm kiếm ====");
                            showEmpInfo(resultList);
                        } else {
                            System.err.println("==== Không tìm thấy kết quả nào ====");
                        }
                    } else {
                        System.err.println("=== Danh sách nhân viên rỗng! ===");
                    }
                    break;
                case 5:
                    if (!employees.isEmpty()) {
                        mergeSort(employees, 0, employees.size() - 1, (first, other) -> {
                            var salaryCompare = other.getSalary() - first.getSalary();
                            if (salaryCompare != 0) {
                                return salaryCompare;
                            } else { // nếu lương bằng nhau thì sắp xếp theo tên tăng dần
                                var nameCompare = first.getFirst().compareTo(other.getFirst());
                                if (nameCompare != 0) {
                                    return nameCompare;
                                } else { // nếu lương và tên trùng nhau thì sắp xếp theo họ tăng dần
                                    return first.getLast().compareTo(other.getLast());
                                }
                            }
                        });
                        System.out.println("==== Sắp xếp hoàn tất ====");
                    } else {
                        System.err.println("=== Danh sách nhân viên rỗng! ===");
                    }
                    break;
                case 6:
                    if (!employees.isEmpty()) {
                        System.out.println("================== DANH SÁCH NHÂN VIÊN ===================");
                        showEmpInfo(employees);
                    } else {
                        System.err.println("=== Danh sách nhân viên rỗng! ===");
                    }
                    break;
                case 7:
                    System.out.println("=== Chương trình kết thúc ===");
                    break;
                default:
                    System.err.println("=== Sai chức năng, vui lòng chọn lại! ===");
                    break;
            }
        } while (choice != 7);
    }

    // thuật toán sắp xếp trộn đệ quy, first, last: chỉ số phần tử đầu, cuối
    public static void mergeSort(List<Employee> employees,
                                 int first, int last, Comparator<Employee> comparator) { // employees: mảng đầu vào
        if (first < last) {              // nếu first nhỏ hơn last
            int middle = (first + last) / 2;  // tìm chỉ số phần tử giữa
            mergeSort(employees, first, middle, comparator); // sắp xếp trộn nửa đầu mảng
            mergeSort(employees, middle + 1, last, comparator); // sắp xếp trộn nửa sau mảng
            merge(employees, first, middle, last, comparator);  // trộn hai nửa đã sắp xếp
        }
    }

    // thuật toán trộn hai mảng đã sắp xếp tăng dần
    private static void merge(List<Employee> employees,
                              int first, int middle, int last, Comparator<Employee> comparator) {
        // xác định kích thước hai mảng con cần trộn
        int size1 = middle - first + 1; // kích thước mảng con trái
        int size2 = last - middle; // kích thước mảng con phải
        // tạo mảng con để lưu các phần tử để trộn
        ArrayList<Employee> leftArr = new ArrayList<>();
        ArrayList<Employee> rightArr = new ArrayList<>();
        // chép dữ liệu vào mảng con trái
        for (int i = 0; i < size1; i++) {
            leftArr.add(employees.get(first + i));
        }
        // chép dữ liệu vào mảng con phải
        for (int j = 0; j < size2; j++) {
            rightArr.add(employees.get(middle + j + 1));
        }
        // tiến hành trộn
        int i = 0, j = 0, k = first;
        while (i < size1 && j < size2) {
            if (comparator.compare(leftArr.get(i), rightArr.get(j)) <= 0) {
                // gán employees[k] = leftArr[i] sau đó tăng k, i
                employees.set(k++, leftArr.get(i++));
            } else {
                employees.set(k++, rightArr.get(j++)); // gán sau đó tăng k, j
            }
        }
        // chép các phần tử còn lại của mảng trái vào mảng employees
        while (i < size1) {
            employees.set(k++, leftArr.get(i++));
        }
        // chép các phần tử còn lại của mảng phải vào mảng employees
        while (j < size2) {
            employees.set(k++, rightArr.get(j++));
        }
    }

    private static List<Employee> searchBySalary(List<Employee> employees, int fromSalary, int toSalary) {
        List<Employee> result = new ArrayList<>();
        for (var e : employees) {
            if (e.getSalary() >= fromSalary && e.getSalary() <= toSalary) {
                result.add(e);
            }
        }
        return result;
    }

    private static List<Employee> searchBySalary(List<Employee> employees, int salaryToSearch) {
        List<Employee> result = new ArrayList<>();
        for (var e : employees) {
            if (e.getSalary() == salaryToSearch) {
                result.add(e);
            }
        }
        return result;
    }

    private static List<Employee> searchByName(List<Employee> employees, String nameToSearch) {
        List<Employee> result = new ArrayList<>();
        for (var e : employees) {
            if (e.getFirst().toLowerCase().matches(".*" + nameToSearch.toLowerCase() + ".*")) {
                result.add(e);
            }
        }
        return result;
    }

    // tìm nhân viên theo mã nhân viên
    private static Employee searchById(List<Employee> employees, String id) {
        for (var e : employees) {
            if (e.getId().compareTo(id) == 0) {
                return e;
            }
        }
        return null;
    }

    private static void showEmpInfo(List<Employee> employees) {
        showHeader();
        for (var e : employees) {
            showEachEmp(e);
        }
    }

    private static void showEachEmp(Employee e) {
        System.out.printf("%-10s%-12s%-15s%-12s%-15d\n",
                e.getId(), e.getLast(), e.getMid(), e.getFirst(), e.getSalary());
    }

    private static void showHeader() {
        System.out.printf("%-10s%-12s%-15s%-12s%-15s\n",
                "Mã NV", "Họ", "Đệm", "Tên", "Lương");
    }

    private static void readDataFromFile(List<Employee> employees) {
        var pathName = "./src/net/braniumacademy/lesson92/exercises4/INPUT.DAT";
        try (var input = new Scanner(new File(pathName));) {
            int numberOfEmployee = input.nextInt();
            input.nextLine();
            for (int i = 0; i < numberOfEmployee; i++) {
                var empStr = input.nextLine();
                employees.add(createEmp(empStr));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Employee createEmp(String empStr) {
        var data = empStr.split("\\s+");
        var id = data[0];
        var salary = Integer.parseInt(data[data.length - 1]);
        var first = data[data.length - 2];
        var last = data[1];
        var mid = new StringBuilder();
        for (int i = 2; i < data.length - 2; i++) {
            mid.append(data[i]).append(" ");
        }
        return new Employee(id, first, last, mid.toString(), salary);
    }
}
