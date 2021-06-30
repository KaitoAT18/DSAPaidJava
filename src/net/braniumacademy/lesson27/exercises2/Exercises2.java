package net.braniumacademy.lesson27.exercises2;

public class Exercises2 {
    public static void main(String[] args) {
        DoublyLinkedList<Double> listString = new DoublyLinkedList<>();
        listString.insertTail(3.25);
        listString.insertTail(25.31);
        listString.insertTail(13.25);
        listString.insertTail(26.41);
        listString.insertTail(6.47);
        listString.insertTail(17.58);
        listString.insertTail(1.42);
        // hiển thị
        System.out.println("Danh sách trước khi sắp xếp: ");
        listString.traversalFromHead();
        // sắp xếp tăng dần
        System.out.println("Danh sách sau khi sắp xếp tăng dần: ");
        listString.sortList();
        listString.traversalFromHead();
        // sắp xếp giảm dần
        System.out.println("Danh sách sau khi sắp xếp giảm dần: ");
        listString.sortListDESC();
        listString.traversalFromHead();
    }
}
