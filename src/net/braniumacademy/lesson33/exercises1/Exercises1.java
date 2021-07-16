package net.braniumacademy.lesson33.exercises1;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises1 {
    public static void main(String[] args) {
        // tạo stack tối đa 100 phần tử
        Stack<Student> students = new Stack<>();
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("================== MENU ==================");
            System.out.println("1. Thêm mới sinh viên vào stack.");
            System.out.println("2. Hiển thị thông tin sinh viên ở đầu stack.");
            System.out.println("3. Kiểm tra xem stack hiện chứa bao nhiêu sinh viên.");
            System.out.println("4. Hiển thị danh sách sinh viên hiện có trong stack.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Xin mời chọn: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Phiên giao dịch kết thúc.");
                    break;
                case 1:
                    System.out.println("Mã sinh viên: ");
                    String id = input.nextLine();
                    System.out.println("Họ: ");
                    String lastName = input.nextLine();
                    System.out.println("Đệm: ");
                    String midName = input.nextLine();
                    System.out.println("Tên: ");
                    String firstName = input.nextLine();
                    System.out.println("Địa chỉ: ");
                    String address = input.nextLine();
                    System.out.println("Email: ");
                    String email = input.nextLine();
                    System.out.println("Tuổi: ");
                    int age = input.nextInt();
                    System.out.println("Điểm TB: ");
                    float gpa = input.nextFloat();
                    Student student = new Student(id, firstName, lastName, midName, address, email, age, gpa);
                    students.push(student);
                    break;
                case 2:
                    if (!students.isEmpty()) {
                        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10s%-15s\n",
                                "Mã SV", "Họ", "Đệm", "Tên", "Địa chỉ", "Email", "Tuổi", "Điểm TB");
                        showElement(students.peek());
                    } else {
                        System.out.println("Stack sinh viên rỗng!");
                    }
                    break;
                case 3:
                    System.out.println("Số lượng sinh viên hiện có trong stack: " + students.size());
                    break;
                case 4:
                    if (!students.isEmpty()) {
                        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10s%-15s\n",
                                "Mã SV", "Họ", "Đệm", "Tên", "Địa chỉ", "Email", "Tuổi", "Điểm TB");
                        while (!students.isEmpty()) {
                            showElement(students.peek());
                            students.pop();
                        }
                    } else {
                        System.out.println("Stack sinh viên rỗng!");
                    }
                    break;
                default:
                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại!");
                    break;
            }
        } while (choice != 0);
    }

    private static void showElement(Student student) {
        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10d%-15.2f\n",
                student.getId(), student.getLastName(), student.getMidName(),
                student.getFirstName(), student.getAddress(), student.getEmail(),
                student.getAge(), student.getGpa());
    }
}
