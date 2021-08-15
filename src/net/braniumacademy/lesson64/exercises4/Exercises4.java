package net.braniumacademy.lesson64.exercises4;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">Branium Academy</a>
 */

import java.util.Scanner;

public class Exercises4 {
    public static void main(String[] args) {
        Heap<Student> heap = new Heap(100);
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=================== MENU ===================");
            System.out.println("1. Thêm mới 1 phần tử.");
            System.out.println("2. Hiển thị các phần tử trong heap.");
            System.out.println("3. Tìm xem node có giá trị x có tồn tại không.");
            System.out.println("4. Cập nhật sinh viên theo mã.");
            System.out.println("5. Xóa node có giá trị x khỏi heap.");
            System.out.println("6. Cho biết phần tử nhỏ nhất trong heap.");
            System.out.println("7. Cho biết kích thước của heap hiện thời.");
            System.out.println("8. Thoát chương trình.");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Mã sinh viên: ");
                    var id = input.nextLine();
                    System.out.println("Họ: ");
                    var last = input.nextLine();
                    System.out.println("Đệm: ");
                    var mid = input.nextLine();
                    System.out.println("Tên: ");
                    var first = input.nextLine();
                    System.out.println("Điểm TB: ");
                    var gpa = Float.parseFloat(input.nextLine());
                    heap.add(new Student(id, first, last, mid, gpa));
                    break;
                case 2:
                    System.out.println("Các phần tử trong heap: ");
                    heap.showElements();
                    break;
                case 3:
                    System.out.println("Nhập mã sinh viên: ");
                    id = input.nextLine();
                    var student = new Student(id);
                    int findXIndex = heap.findNode(student);
                    if (findXIndex != -1) {
                        System.out.printf("Sinh viên mã \"%s\" tồn tại trong heap.\n", student.getId());
                    } else {
                        System.out.printf("Sinh viên mã \"%s\" không tồn tại trong heap.\n", student.getId());
                    }
                    break;
                case 4:
                    System.out.println("Nhập mã sinh viên: ");
                    id = input.nextLine();
                    var oldStudent = new Student(id);
                    System.out.println("===== Nhập thông tin mới =====");
                    System.out.println("Họ: ");
                    first = input.nextLine();
                    System.out.println("Đệm: ");
                    last = input.nextLine();
                    System.out.println("Tên: ");
                    mid = input.nextLine();
                    System.out.println("Điểm TB: ");
                    gpa = Float.parseFloat(input.nextLine());
                    var newStudent = new Student(id, first, last, mid, gpa);
                    if (heap.update(oldStudent, newStudent)) {
                        System.out.println("Cập nhật thành công.");
                    } else {
                        System.out.println("Cập nhật thất bại.");
                    }
                    break;
                case 5:
                    System.out.println("Nhập mã sinh viên: ");
                    id = input.nextLine();
                    student = new Student(id);
                    boolean removeX = heap.remove(student);
                    if (removeX) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Xóa thất bại!");
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Sinh viên có mã nhỏ nhất: " + heap.min());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("Kích thước của heap: " + heap.size());
                    break;
                case 8:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Sai chức năng. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 8);
    }
}
