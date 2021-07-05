package net.braniumacademy.lesson210.exercises1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExercises1 {
    public static void main(String[] args) {
        ArrayList<Student> listStudent = new ArrayList<>();
        createFakeData(listStudent);
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("============== MENU ==============");
            System.out.println("1. Thêm mới sinh viên vào danh sách.");
            System.out.println("2. Tìm sinh viên theo mã sinh viên.");
            System.out.println("3. Cập nhật điểm cho sinh viên theo mã sinh viên.");
            System.out.println("4. Xóa sinh viên có mã nhập vào từ bàn phím.");
            System.out.println("5. Sắp xếp danh sách sinh viên theo tiêu chí nào đó.");
            System.out.println("6. Tìm sinh viên có điểm TB >= x.");
            System.out.println("7. Liệt kê tất cả các sinh viên trong tên có cụm từ x.");
            System.out.println("8. Hiển thị các sinh viên có trong danh sách.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Xin mời chọn: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("<== Phiên giao dịch kết thúc. " +
                            "Cảm ơn quý vị đã sử dụng dịch vụ! ==>");
                    break;
                case 1:
                    String id;
                    String firstName;
                    String lastName;
                    String midName;
                    String address;
                    String email;
                    int age;
                    float gpa;
                    System.out.println("Mã sinh viên: ");
                    id = input.nextLine();
                    System.out.println("Họ: ");
                    lastName = input.nextLine();
                    System.out.println("Đệm: ");
                    midName = input.nextLine();
                    System.out.println("Tên: ");
                    firstName = input.nextLine();
                    System.out.println("Địa chỉ: ");
                    address = input.nextLine();
                    System.out.println("Email: ");
                    email = input.nextLine();
                    System.out.println("Tuổi: ");
                    age = input.nextInt();
                    System.out.println("Điểm TB: ");
                    gpa = input.nextFloat();
                    Student student = new Student(id, firstName, lastName, midName, address, email, age, gpa);
                    listStudent.add(student);
                    break;
                case 2:
                    if (!listStudent.isEmpty()) {
                        System.out.println("Nhập mã sinh viên: ");
                        id = input.nextLine();
                        var isExist = false;
                        for (var e : listStudent) {
                            if (e.getId().toLowerCase().compareTo(id.toLowerCase()) == 0) {
                                studentInfo(e);
                                isExist = true;
                                break;
                            }
                        }
                        if (!isExist) {
                            System.out.println("Không tìm thấy sinh viên mã \"" + id + "\".");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 3:
                    if (!listStudent.isEmpty()) {
                        System.out.println("Nhập mã sinh viên: ");
                        id = input.nextLine();
                        boolean isExist = false;
                        for (int i = 0; i < listStudent.size(); i++) {
                            var e = listStudent.get(i);
                            if (e.getId().toLowerCase().compareTo(id.toLowerCase()) == 0) {
                                System.out.println("Nhập điểm: ");
                                gpa = input.nextFloat();
                                isExist = true;
                                e.setGpa(gpa);
                                listStudent.set(i, e);
                                System.out.println("Cập nhật điểm thành công!");
                                break;
                            }
                        }
                        if (!isExist) {
                            System.out.println("Không tìm thấy sinh viên mã \"" + id + "\".");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 4:
                    if (!listStudent.isEmpty()) {
                        System.out.println("Nhập mã sinh viên: ");
                        id = input.nextLine();
                        boolean isExist = false;
                        for (int i = 0; i < listStudent.size(); i++) {
                            var e = listStudent.get(i);
                            if (e.getId().toLowerCase().compareTo(id.toLowerCase()) == 0) {
                                isExist = true;
                                listStudent.remove(i);
                                System.out.println("Xóa thành công!");
                                break;
                            }
                        }
                        if (!isExist) {
                            System.out.println("Không tìm thấy sinh viên mã \"" + id + "\".");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 5:
                    if (!listStudent.isEmpty()) {
                        int option;
                        do {
                            System.out.println("1. Theo mã sinh viên tăng dần.");
                            System.out.println("2. Theo tên sinh viên a-z.");
                            System.out.println("3. Theo tuổi tăng dần.");
                            System.out.println("4. Theo điểm trung bình giảm dần.");
                            System.out.println("0. Thoát sắp xếp.");
                            System.out.println("Bạn chọn? ");
                            option = input.nextInt();
                            switch (option) {
                                case 0:
                                    System.out.println("Thoát chức năng sắp xếp.");
                                    break;
                                case 1:
                                    if (!listStudent.isEmpty()) {
                                        listStudent.sort(new SortingById());
                                    } else {
                                        System.out.println("Danh sách sinh viên rỗng!");
                                    }
                                    break;
                                case 2:
                                    if (!listStudent.isEmpty()) {
                                        listStudent.sort(new SortingByName());
                                    } else {
                                        System.out.println("Danh sách sinh viên rỗng!");
                                    }
                                    break;
                                case 3:
                                    if (!listStudent.isEmpty()) {
                                        listStudent.sort(new SortingByAge());
                                    } else {
                                        System.out.println("Danh sách sinh viên rỗng!");
                                    }
                                    break;
                                case 4:
                                    if (!listStudent.isEmpty()) {
                                        listStudent.sort(new SortingByGPADESC());
                                    } else {
                                        System.out.println("Danh sách sinh viên rỗng!");
                                    }
                                    break;
                                default:
                                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại!");
                                    break;
                            }
                        } while (option != 0);
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 6:
                    if (!listStudent.isEmpty()) {
                        int counter = 0;
                        System.out.println("Nhập điểm trung bình: ");
                        gpa = input.nextFloat();
                        System.out.println("Danh sách sinh viên có điểm TB >= " + gpa + ":");
                        for (var e : listStudent) {
                            if (e.getGpa() >= gpa) {
                                studentInfo(e);
                                counter++;
                            }
                        }
                        System.out.println("Có " + counter + " sinh viên thỏa mãn.");
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 7:
                    if (!listStudent.isEmpty()) {
                        boolean isExist = false;
                        System.out.println("Nhập cụm từ cần tìm");
                        String regex = input.nextLine();
                        System.out.println("Danh sách sinh viên thỏa mãn:");
                        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10s%-15s\n",
                                "Mã SV", "Họ", "Đệm", "Tên", "Địa chỉ", "Email", "Tuổi", "Điểm TB");
                        for (var e : listStudent) {
                            if (e.getFirstName().toLowerCase().matches(".*" + regex.toLowerCase() + ".*")) {
                                studentInfo(e);
                                isExist = true;
                            }
                        }
                        if (!isExist) {
                            System.out.println("Không tồn tại sinh viên thỏa mãn.");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 8:
                    if (!listStudent.isEmpty()) {
                        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10s%-15s\n",
                                "Mã SV", "Họ", "Đệm", "Tên", "Địa chỉ", "Email", "Tuổi", "Điểm TB");
                        showListElements(listStudent);
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                default:
                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại!");
                    break;
            }
        }
        while (choice != 0);
    }

    private static void createFakeData(ArrayList<Student> listStudent) {
        String fileName = "input2.9.1.txt";
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            while (fileReader.hasNextLine()) {
                String id;
                String firstName;
                String lastName;
                String midName;
                String address;
                String email;
                int age;
                float gpa;
                id = fileReader.nextLine();
                lastName = fileReader.nextLine();
                midName = fileReader.nextLine();
                firstName = fileReader.nextLine();
                address = fileReader.nextLine();
                email = fileReader.nextLine();
                age = Integer.parseInt(fileReader.nextLine());
                gpa = Float.parseFloat(fileReader.nextLine());
                Student s = new Student(id, firstName, lastName, midName, address, email, age, gpa);
                listStudent.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void showListElements(ArrayList<Student> list) {
        for (var e : list) {
            studentInfo(e);
        }
    }

    private static void studentInfo(Student e) {
        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10d%-15.2f\n",
                e.getId(), e.getLastName(),
                e.getMidName(), e.getFirstName(),
                e.getAddress(), e.getEmail(),
                e.getAge(), e.getGpa());
    }
}
