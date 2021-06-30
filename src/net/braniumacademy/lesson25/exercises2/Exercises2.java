package net.braniumacademy.lesson25.exercises2;

public class Exercises2 {
    public static void main(String[] args) {
        LinkedList<Long> longLinkedList = new LinkedList<>();
        longLinkedList.insertTail(10L);
        longLinkedList.insertTail(1L);
        longLinkedList.insertTail(60L);
        longLinkedList.insertTail(30L);
        longLinkedList.insertTail(70L);
        longLinkedList.insertTail(18L);
        // hiển thị danh sách
        System.out.println("Các phần tử trong danh sách: ");
        longLinkedList.showList();
        // xóa các node:
        removeNode(longLinkedList, 1L);
        removeNode(longLinkedList, 15L);
        removeNode(longLinkedList, 200L);
    }

    private static void removeNode(LinkedList<Long> list, Long key) {
        System.out.println("Dữ liệu trong node cần xóa: " + key);
        var result = list.removeNode(key);
        if (result) { // xóa thành công
            System.out.println("Xóa thành công! Danh sách sau khi xóa: ");
            list.showList();
        } else {
            System.out.println("Xóa thất bại. Node cần xóa không tồn tại.");
        }
    }
}
