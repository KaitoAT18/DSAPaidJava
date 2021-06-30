package net.braniumacademy.lesson27.exercises3;

import java.util.Scanner;

public class Exercises3 {
    public static void main(String[] args) {
        LinkedList listStudent = new LinkedList();
        int choice = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("============== MENU ==============");
            System.out.println("1. Thêm mới sinh viên vào danh sách.");
            System.out.println("2. Sắp xếp danh sách sinh viên theo mã tăng dần.");
            System.out.println("3. Sắp xếp danh sách sinh viên theo tên tăng dần.");
            System.out.println("4. Sắp xếp danh sách sinh viên theo tuổi tăng dần.");
            System.out.println("5. Sắp xếp danh sách sinh viên theo điểm TB tăng dần.");
            System.out.println("6. Sắp xếp danh sách sinh viên theo điểm TB giảm dần.");
            System.out.println("7. Hiển thị các sinh viên có trong danh sách.");
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
                    listStudent.insertTail(student);
                    break;
                case 2:
                    if (!listStudent.isEmpty()) {
                        listStudent.sortList(new SortingById());
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 3:
                    if (!listStudent.isEmpty()) {
                        listStudent.sortList(new SortingByName());
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 4:
                    if (!listStudent.isEmpty()) {
                        listStudent.sortList(new SortingByAge());
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 5:
                    if (!listStudent.isEmpty()) {
                        listStudent.sortList(new SortingByGPA());
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 6:
                    if (!listStudent.isEmpty()) {
                        listStudent.sortList(new SortingByGPADESC());
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 7:
                    if (!listStudent.isEmpty()) {
                        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10s%-15s\n",
                                "Mã SV", "Họ", "Đệm", "Tên", "Địa chỉ", "Email", "Tuổi", "Điểm TB");
                        listStudent.showList();
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                default:
                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại!");
                    break;
            }
        } while (choice != 0);
    }
}
