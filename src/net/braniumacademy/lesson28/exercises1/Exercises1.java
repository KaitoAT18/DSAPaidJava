package net.braniumacademy.lesson28.exercises1;

public class Exercises1 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertTail(1);
        linkedList.insertTail(7);
        linkedList.insertTail(2);
        linkedList.insertTail(3);
        linkedList.insertTail(4);
        linkedList.insertTail(5);
        linkedList.insertTail(6);
        System.out.println("Các phần tử trong danh sách: ");
        linkedList.showList();
        int value = 5;
        if (linkedList.search(value)) {
            System.out.println("Tìm thấy giá trị " + value + " trong danh sách.");
        } else {
            System.out.println("Không tìm thấy giá trị " + value + " trong danh sách.");
        }
    }
}
