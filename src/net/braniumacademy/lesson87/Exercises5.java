package net.braniumacademy.lesson87;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercises5 {

    public static <T extends Comparable<T>> void quickSort(T[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = partition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
        T pivot = arr[right];
        var i = left;
        for (int j = left; j <= right; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                T tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        T tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;
        return i;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        getDataFromFile(employees);
        Employee[] arrayEmployees = new Employee[employees.size()];
        employees.toArray(arrayEmployees);
        quickSort(arrayEmployees, 0, employees.size() - 1);
        showResult(arrayEmployees);
    }

    private static void showResult(Employee[] employees) {
        System.out.printf("%-15s%-15s%-20s%-15s%-20s\n", "Mã NV", "Họ", "Đệm", "Tên", "Lương");
        for (var e : employees) {
            System.out.printf("%-15s%-15s%-20s%-15s%-20.2f\n",
                    e.getId(), e.getLastName(), e.getMidName(), e.getFirstName(), e.getSalary());
        }
    }

    // thuật toán sắp xếp trộn đệ quy, first, last: chỉ số phần tử đầu, cuối
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

    static class Employee implements Comparable<Employee> {
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

        @Override
        public int compareTo(Employee other) {
            var salaryCompare = Float.compare(other.salary, salary);
            if (salaryCompare != 0) {
                return salaryCompare;
            } else { // nếu lương bằng nhau thì sắp xếp theo tên tăng dần
                var nameCompare = firstName.compareTo(other.firstName);
                if (nameCompare != 0) {
                    return nameCompare;
                } else { // nếu lương và tên trùng nhau thì sắp xếp theo họ tăng dần
                    return lastName.compareTo(other.lastName);
                }
            }
        }
    }

    private static <T> void printResult(T[] numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
