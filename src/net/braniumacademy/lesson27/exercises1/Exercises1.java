package net.braniumacademy.lesson27.exercises1;

public class Exercises1 {
    public static void main(String[] args) {
        LinkedList<String> listString = new LinkedList<>();
        listString.insertTail("Hương");
        listString.insertTail("Nhung");
        listString.insertTail("Linh");
        listString.insertTail("Phương");
        listString.insertTail("Trang");
        listString.insertTail("Hoàng");
        listString.insertTail("Long");
        // hiển thị
        System.out.println("Danh sách trước khi sắp xếp: ");
        listString.showList();
        // sắp xếp tăng dần
        System.out.println("Danh sách sau khi sắp xếp tăng dần: ");
        listString.sortList();
        listString.showList();
        // sắp xếp giảm dần
        System.out.println("Danh sách sau khi sắp xếp giảm dần: ");
        listString.sortListDESC();
        listString.showList();
    }
}
