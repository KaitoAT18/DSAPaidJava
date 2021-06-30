package net.braniumacademy.lesson25.exercises3;

import java.util.Scanner;

public class Exercises3 {
    public static void main(String[] args) {
        int choice = 7;
        Scanner input = new Scanner(System.in);
        LinkedList listStudents = new LinkedList();
        do {
            System.out.println("============== MENU ==============");
            System.out.println("1. Thêm mới sinh viên vào danh sách.");
            System.out.println("2. Xóa sinh viên theo mã.");
            System.out.println("3. Xóa sinh viên theo tên.");
            System.out.println("4. Xóa tối đa n sinh viên có điểm trung bình nhỏ hơn x.");
            System.out.println("5. Xóa tất cả các sinh viên có tuổi bằng x.");
            System.out.println("6. Hiển thị danh sách sinh viên ra màn hình.");
            System.out.println("7. Thoát chương trình.");
            System.out.println("Bạn chọn? ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    Student student;
                    String id;
                    String fullName;
                    String address;
                    String email;
                    int age;
                    float gpa;
                    System.out.println("Mã sinh viên: ");
                    id = input.nextLine();
                    System.out.println("Họ tên: ");
                    fullName = input.nextLine();
                    System.out.println("Địa chỉ: ");
                    address = input.nextLine();
                    System.out.println("Email: ");
                    email = input.nextLine();
                    System.out.println("Tuổi: ");
                    age = input.nextInt();
                    System.out.println("Điểm TB: ");
                    gpa = input.nextFloat();
                    input.nextLine(); // đọc bỏ kí tự thừa
                    student = new Student(id, fullName, address, email, age, gpa);
                    listStudents.insertTail(student);
                    break;
                case 2:
                    if (!listStudents.isEmpty()) {
                        System.out.println("Nhập mã sinh viên cần xóa: ");
                        id = input.nextLine();
                        boolean result = listStudents.removeNode(new Student(id));
                        if (result) {
                            System.out.println("Xóa thành công!");
                        } else {
                            System.out.println("Xóa thất bại!");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng.");
                    }
                    break;
                case 3:
                    if (!listStudents.isEmpty()) {
                        System.out.println("Nhập tên sinh viên cần xóa: ");
                        fullName = input.nextLine();
                        boolean isRemoved = false;
                        while (true) {
                            boolean result = listStudents.removeStudentByName(fullName);
                            if (!result) {
                                break;
                            } else {
                                isRemoved = true;
                            }
                        }
                        if (isRemoved) {
                            System.out.println("Xóa sinh viên thành công!");
                        } else {
                            System.out.println("Sinh viên cần xóa không tồn tại!");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng.");
                    }
                    break;
                case 4:
                    if (!listStudents.isEmpty()) {
                        int n;
                        System.out.println("Nhập số sinh viên tối đa cần xóa: ");
                        n = input.nextInt();
                        if (n > 0) {
                            System.out.println("Nhập mức điểm trung bình để xóa: ");
                            gpa = input.nextFloat();
                            int counter = 0;
                            while (true) {
                                boolean result = listStudents.removeStudentByGPA(gpa);
                                if (!result || counter >= n) {
                                    break;
                                } else {
                                    counter++;
                                }
                            }
                        } else {
                            System.out.println("Số sinh viên cần xóa không hợp lệ. Vui lòng nhập n > 0.");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng.");
                    }
                    break;
                case 5:
                    if (!listStudents.isEmpty()) {
                        System.out.println("Nhập tuổi của sinh viên cần xóa: ");
                        age = input.nextInt();
                        boolean isRemoved = false;
                        while (true) {
                            boolean result = listStudents.removeStudentByAge(age);
                            if (!result) {
                                break;
                            } else {
                                isRemoved = true;
                            }
                        }
                        if (isRemoved) {
                            System.out.printf("Các sinh viên có tuổi bằng %d đã được xóa khỏi danh sách!\n", age);
                        } else {
                            System.out.printf("Không có sinh viên nào có tuổi bằng %d.\n", age);
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng.");
                    }
                    break;
                case 6:
                    if (!listStudents.isEmpty()) {
                        listStudents.showList();
                    } else {
                        System.out.println("Danh sách sinh viên rỗng.");
                    }
                    break;
                case 7:
                    System.out.println("<== Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại quý khách. ==>");
                    break;
                default:
                    System.out.println("Sai chức năng, vui lòng kiểm tra lại!");
                    break;
            }

        } while (choice != 7);
    }
}
