package net.braniumacademy.lesson26.exercises2;

public class Exercises2 {
    public static void main(String[] args) {
        DoublyLinkedList<Long> longNumbers = new DoublyLinkedList<>();
        longNumbers.insertTail(1L);
        longNumbers.insertTail(2L);
        longNumbers.insertTail(3L);
        longNumbers.insertTail(4L);
        longNumbers.insertTail(4L);
        longNumbers.insertTail(10L);
        longNumbers.insertTail(100L);
        longNumbers.insertTail(2L);
        removeNode(longNumbers, 2L);
        removeNode(longNumbers, 20L);
        removeNode(longNumbers, 4L);
    }

    private static void removeNode(DoublyLinkedList<Long> longNumbers, Long i) {
        System.out.println("Giá trị node cần xóa: " + i);
        int count = 0;
        while (true) {
            boolean result = longNumbers.removeNode(i);
            if (result) {
                count++;
            } else {
                break;
            }
        }
        System.out.println("Số lượng phần tử bị xóa: " + count);
    }
}
