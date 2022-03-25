package net.braniumacademy.lesson25.exercises2;

public class Exercises2 {
    public static void main(String[] args) {
        LinkedList<Long> longLinkedList = new LinkedList<>();
        longLinkedList.insertTail(1L); // node cuối
        longLinkedList.insertTail(10L);
        longLinkedList.insertTail(1L); // node khác đầu khác cuối
        longLinkedList.insertTail(1L); // node khác đầu khác cuối
        longLinkedList.insertTail(1L); // node khác đầu khác cuối
        longLinkedList.insertTail(1L); // node khác đầu khác cuối
        longLinkedList.insertTail(60L);
        longLinkedList.insertTail(30L);
        longLinkedList.insertTail(70L);
        longLinkedList.insertTail(18L);
        longLinkedList.insertTail(200L);
        longLinkedList.insertTail(1L); // node đầu danh sách
        // hiển thị danh sách
        System.out.println("Các phần tử trong danh sách: ");
        longLinkedList.showList();
        // xóa các node:
        removeNode(longLinkedList, 1L); // xóa ở cả 3 vị trí: đầu, cuối, khác đầu, cuối
        removeNode(longLinkedList, 15L);
        removeNode(longLinkedList, 200L);
    }

    private static void removeNode(LinkedList<Long> list, Long key) {
        System.out.println("Dữ liệu trong node cần xóa: " + key);
        var numOfRemovedNode = 0;
        var result = list.removeNode(key);
        while(result) {
            numOfRemovedNode++; // tăng biến đếm số node bị xóa
            result = list.removeNode(key);
        }
        if (numOfRemovedNode != 0) { // xóa thành công
            System.out.println("Số phần tử đã bị xóa: " + numOfRemovedNode);
            System.out.println("Danh sách sau khi xóa: ");
            list.showList();
        } else {
            System.out.println("Xóa thất bại. Node cần xóa không tồn tại.");
        }
    }
}
