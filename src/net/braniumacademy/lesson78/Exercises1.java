package net.braniumacademy.lesson78;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">Branium Academy</a>
 */

import java.util.Hashtable;
import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        Hashtable<String, Student> hashTable = new Hashtable<>(100); // 1
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.err.println("========================== MENU ==============================");
            System.err.println("*\t1. Thêm mới 1 sinh viên.                                 *");
            System.err.println("*\t2. Hiển thị danh sách sinh viên                          *");
            System.err.println("*\t3. Tìm sinh viên theo mã sinh viên.                      *");
            System.err.println("*\t4. Kiểm tra xem một sinh viên có tồn tại không.          *");
            System.err.println("*\t5. Kiểm tra key là mã sinh viên nào đó có tồn tại không. *");
            System.err.println("*\t6. Kiểm tra bảng băm có rỗng không.                      *");
            System.err.println("*\t7. Kiểm tra kích thước của bảng băm.                     *");
            System.err.println("*\t8. Xóa sinh viên theo mã sinh viên.                      *");
            System.err.println("*\t9. Cập nhật thông tin sinh viên.                         *");
            System.err.println("*\t10. Lấy và hiển thị tất cả các key trong bảng băm.       *");
            System.err.println("*\t11. Lấy và hiển thị tất cả các sinh viên trong bảng băm. *");
            System.err.println("*\t12. Xóa tất cả các sinh viên trong bảng băm.             *");
            System.err.println("*\t13. Kết thúc chương trình.                               *");
            System.err.println("==============================================================");
            System.err.println("Xin mời chọn chức năng số: ");
            choice = input.nextInt();
            input.nextLine(); // đọc bỏ dòng trước đó
            switch (choice) {
                case 1: // test phương thức put()4 và addEntry()2
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
                    hashTable.put(id, new Student(id, first, last, mid, gpa));
                    break;
                case 2: // test phương thức forEach()14
                    if (!hashTable.isEmpty()) {
                        System.out.println("=== Danh sách sinh viên ===");
                        hashTable.forEach((key, value) -> System.out.println("(" + key + " - " + value + ")"));
                    } else {
                        System.err.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 3: // test phương thức get(key)3
                    if (!hashTable.isEmpty()) {
                        System.out.println("Nhập mã sinh viên cần tìm: ");
                        id = input.nextLine();
                        var result = hashTable.get(id);
                        if (result != null) {
                            System.out.printf("Tìm thấy sinh viên mã \"%s\"\n", id);
                            System.out.println(result);
                        } else {
                            System.out.printf("Không tìm thấy sinh viên mã \"%s\"\n", id);
                        }
                    } else {
                        System.err.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 4: // test phương thức containsValue(value)6
                    if (!hashTable.isEmpty()) {
                        System.out.println("Nhập mã sinh viên cần tìm: ");
                        id = input.nextLine();
                        var newStudent = new Student(id);
                        var checkStudent = hashTable.containsValue(newStudent);
                        // or
                        checkStudent = hashTable.contains(newStudent); // 5
                        if (checkStudent) {
                            System.out.printf("Tồn tại sinh viên mã \"%s\"\n", id);
                        } else {
                            System.out.printf("Không tồn tại sinh viên mã \"%s\"\n", id);
                        }
                    } else {
                        System.err.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 5: // test phương thức containsKey(key)7
                    if (!hashTable.isEmpty()) {
                        System.out.println("Nhập mã sinh viên cần tìm: ");
                        id = input.nextLine();
                        var checkKey = hashTable.containsKey(id);
                        if (checkKey) {
                            System.out.printf("Tồn tại sinh viên mã \"%s\"\n", id);
                        } else {
                            System.out.printf("Không tồn tại sinh viên mã \"%s\"\n", id);
                        }
                    } else {
                        System.err.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 6: // test phương thức isEmpty()8
                    System.out.println(hashTable.isEmpty() ? "Rỗng" : "Không rỗng.");
                    break;
                case 7: // test phương thức size()9
                    System.out.println("Số phần tử hiện có trong bảng băm: " + hashTable.size());
                    break;
                case 8: // test phương thức remove(key)10
                    if (!hashTable.isEmpty()) {
                        System.out.println("Nhập mã sinh viên cần xóa: ");
                        id = input.nextLine();
                        var removeStudent = hashTable.remove(id);
                        if (removeStudent != null) {
                            System.out.printf("Xóa sinh viên mã \"%s\" thành công.\n", id);
                        } else {
                            System.err.printf("Không thể xóa sinh viên mã \"%s\"\n", id);
                        }
                    } else {
                        System.err.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 9: // test phương thức replace(key, value) 11
                    if (!hashTable.isEmpty()) {
                        System.out.println("Nhập mã sinh viên cần cập nhật: ");
                        id = input.nextLine();
                        var student = hashTable.get(id);
                        if (student != null) {
                            System.out.println("Nhập điểm TB: ");
                            gpa = Float.parseFloat(input.nextLine());
                            student.setGpa(gpa);
                            var updateResult = hashTable.replace(id, student);
                            if (updateResult != null) {
                                System.out.println("Cập nhật điểm sinh viên thành công.");
                            } else {
                                System.out.println("Cập nhật điểm sinh viên thất bại.");
                            }
                        } else {
                            System.err.printf("Không tồn tại sinh viên mã \"%s\"\n", id);
                        }
                    } else {
                        System.err.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 10: // test phương thức keySet()12
                    if (!hashTable.isEmpty()) {
                        System.out.println("Các key hiện có trong bảng băm: ");
                        System.out.println(hashTable.keySet());
                    } else {
                        System.err.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 11: // test phương thức values()13
                    if (!hashTable.isEmpty()) {
                        System.out.println("Các Sinh viên hiện có trong bảng băm: ");
                        var studentsInHashTable = hashTable.values();
                        for (var s : studentsInHashTable) {
                            System.out.println(s);
                        }
                    } else {
                        System.err.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 12: // test phương thức clear()14
                    if (!hashTable.isEmpty()) {
                        System.out.println("=== Đã xóa tất cả các sinh viên trong bảng băm ===");
                        hashTable.clear();
                    } else {
                        System.err.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 13:
                    System.out.println("=== Chương trình kết thúc ===");
                    break;
                default:
                    System.err.println("=== Sai chức năng, vui lòng chọn lại! ===");
                    break;
            }
        } while (choice != 13);
    }
}
