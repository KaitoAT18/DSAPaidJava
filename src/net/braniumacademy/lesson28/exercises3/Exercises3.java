package net.braniumacademy.lesson28.exercises3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercises3 {
    public static void main(String[] args) {
        LinkedList listStudent = new LinkedList();
        createFakeData(listStudent);
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("============== MENU ==============");
            System.out.println("1. Thêm mới sinh viên vào danh sách.");
            System.out.println("2. Tìm sinh viên theo mã sinh viên.");
            System.out.println("3. Tìm sinh viên có tên x.");
            System.out.println("4. Tìm sinh viên theo điểm trung bình.");
            System.out.println("5. Tìm sinh viên trong tên có cụm từ x.");
            System.out.println("6. Hiển thị các sinh viên có trong danh sách.");
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
                        System.out.println("Nhập mã sinh viên: ");
                        id = input.nextLine();
                        var result = listStudent.search(id);
                        if (result != null) {
                            System.out.println("Tìm thấy sinh viên mã \"" + id + "\"");
                            System.out.println(result);
                        } else {
                            System.out.println("Không tìm thấy sinh viên mã \"" + id + "\"");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 3:
                    if (!listStudent.isEmpty()) {
                        System.out.println("Nhập tên cần tìm: ");
                        String key = input.nextLine();
                        int counter = 0;
                        for (var s : listStudent) {
                            if (s.getFirstName().toLowerCase().compareTo(key.toLowerCase()) == 0) {
                                System.out.println(s);
                                counter++;
                            }
                        }
                        if (counter == 0) {
                            System.out.println("Không có sinh viên nào thỏa mãn.");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 4:
                    System.out.println("Nhập điểm trung bình cần tìm: ");
                    gpa = input.nextFloat();
                    if (!listStudent.isEmpty()) {
                        int counter = 0;
                        for (var e : listStudent) {
                            if (e.getGpa() >= gpa) {
                                counter++;
                                System.out.println(e);
                            }
                        }
                        System.out.println("Có " + counter + " sinh viên thỏa mãn điều kiện.");
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 5:
                    if (!listStudent.isEmpty()) {
                        System.out.println("Nhập tên cần tìm: ");
                        String key = input.nextLine();
                        int counter = 0;
                        for (var s : listStudent) {
                            if (s.getFirstName().toLowerCase().matches(".*" + key + ".*")) {
                                System.out.println(s);
                                counter++;
                            }
                        }
                        if (counter == 0) {
                            System.out.println("Không có sinh viên nào thỏa mãn.");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                case 6:
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

    private static void createFakeData(LinkedList listStudent) {
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
                listStudent.insertTail(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
