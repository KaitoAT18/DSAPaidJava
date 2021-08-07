package net.braniumacademy.lesson86;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises6 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        getDataFromFile(employees);
        mergeSort(employees, 0, employees.size() - 1, (first, other) -> {
            var salaryCompare = Float.compare(other.salary, first.salary);
            if (salaryCompare != 0) {
                return salaryCompare;
            } else { // nếu lương bằng nhau thì sắp xếp theo tên tăng dần
                var nameCompare = first.firstName.compareTo(other.firstName);
                if (nameCompare != 0) {
                    return nameCompare;
                } else { // nếu lương và tên trùng nhau thì sắp xếp theo họ tăng dần
                    return first.lastName.compareTo(other.lastName);
                }
            }
        });
        showResult(employees);
    }

    private static void showResult(List<Employee> employees) {
        System.out.printf("%-15s%-15s%-20s%-15s%-20s\n", "Mã NV", "Họ", "Đệm", "Tên", "Lương");
        for (var e : employees) {
            System.out.printf("%-15s%-15s%-20s%-15s%-20.2f\n",
                    e.getId(), e.getLastName(), e.getMidName(), e.getFirstName(), e.getSalary());
        }
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

    private static void getDataFromFile(List<Employee> employees) {
        try (Scanner input = new Scanner(new File("input8.2.txt"))) {
            var t = Integer.parseInt(input.nextLine());
            while (t > 0) {
                String line = input.nextLine();
                var data = line.split("\\s+");
                var id = data[0];
                var last = data[1];
                var salary = Float.parseFloat(data[data.length - 1]);
                var first = data[data.length - 2];
                var mid = "";
                for (int i = 2; i < data.length - 2; i++) {
                    mid += data[i] + " ";
                }
                mid = mid.trim(); // loại bỏ dấu cách thừa
                Employee e = new Employee(id, first, mid, last, salary);
                employees.add(e);
                t--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Employee {
        private String id;
        private String firstName;
        private String midName;
        private String lastName;
        private float salary;

        public Employee() {
        }

        public Employee(String id) {
            this.id = id;
        }

        public Employee(String id, String firstName, String midName, String lastName, float salary) {
            this.id = id;
            this.firstName = firstName;
            this.midName = midName;
            this.lastName = lastName;
            this.salary = salary;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMidName() {
            return midName;
        }

        public void setMidName(String midName) {
            this.midName = midName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public float getSalary() {
            return salary;
        }

        public void setSalary(float salary) {
            this.salary = salary;
        }
    }
}