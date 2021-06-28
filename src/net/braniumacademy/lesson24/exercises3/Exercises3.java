package net.braniumacademy.lesson24.exercises3;

import java.util.Scanner;

public class Exercises3 {
    public static void main(String[] args) {
        DoublyLinkedList<Student> listStudent = new DoublyLinkedList<>();
        fillDemoData(listStudent);
        System.out.println("Các phần tử trong danh sách: ");
        listStudent.traversalFromHead();
        String id;
        String email;
        float gpa;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên cần cập nhật");
        id = input.nextLine();
        System.out.println("Nhập email mới: ");
        email = input.nextLine();
        System.out.println("Điểm TB: ");
        gpa = input.nextFloat();
        var foundNode = listStudent.getNode(new Student(id));
        if(foundNode != null) {
            var data = foundNode.getData();
            data.setEmail(email);
            data.setGpa(gpa);
            listStudent.updateNodeData(new DoublyLinkedList.Node(new Student(id)), data);
            System.out.println("Cập nhật thành công.");
            listStudent.traversalFromHead();
        } else {
            System.out.println("Không tồn tại sinh viên cần tìm trong danh sách.");
        }
    }

    private static void fillDemoData(DoublyLinkedList<Student> listStudent) {
        listStudent.insertTail(new Student("B25DCCN100", "Hoàng Trọng Tuyên", "Hà Nội", "tuyen@xmail.com", 22, 3.26f));
        listStudent.insertTail(new Student("B25DCCN102", "Lê Văn Tuấn", "Hà Nội", "tuan@xmail.com", 22, 3.65f));
        listStudent.insertTail(new Student("B25DCCN108", "Ngô Bá Nam", "Hà Nội", "nam@xmail.com", 22, 2.35f));
        listStudent.insertTail(new Student("B25DCCN101", "Trần Đức Bưởi", "Hà Nội", "buoi@xmail.com", 22, 3.68f));
        listStudent.insertTail(new Student("B25DCCN106", "Đặng Tiến Lâm", "Hà Nội", "lamhaha@xmail.com", 22, 3.27f));
        listStudent.insertTail(new Student("B25DCCN105", "Khúc Thừa Dụ", "Hà Nội", "daicadu@xmail.com", 22, 3.06f));
    }
}
