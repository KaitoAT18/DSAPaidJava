package net.braniumacademy.lesson23.Exercises1;

public class TestEx1 {
    public static void main(String[] args) {
        DoublyLinkedList<String> friends = new DoublyLinkedList<>();
        // thêm vào cuối danh sách liên kết
        friends.insertTail("Linh");
        friends.insertTail("Mai");
        System.out.println("Duyệt từ đầu danh sách liên kết: ");
        friends.traversalFromHead();
        System.out.println("Duyệt từ cuối danh sách liên kết: ");
        friends.traversalFromTail();
        // thêm vào đầu danh sách liên kết
        friends.insertHead("Khánh");
        System.out.println("Sau khi thêm vào đầu danh sách liên kết: ");
        friends.traversalFromHead();
        // thêm vào sau node có giá trị x
        friends.insertAfterX("Nhung", "Linh");
        System.out.println("Sau khi thêm vào sau node có giá trị \"Linh\":");
        friends.traversalFromHead();
        // thêm vào trước node có giá trị x
        friends.insertBeforeX("Loan", "Nhung");
        System.out.println("Sau khi thêm vào trước node có giá trị \"Nhung\":");
        friends.traversalFromHead();
        // thêm vào sau node thứ k
        friends.insertAfterK("Long", 3);
        System.out.println("Sau khi thêm node vào sau node thứ " + 3 + ": ");
        friends.traversalFromHead();
        // tìm node giữa danh sách
        System.out.println("Giá trị node giữa danh sách liên kết: " + friends.findMidNodeData());
        // thêm node vào sau node giữa dslk
        friends.insertAfterMidNode("Phương");
        System.out.println("Sau khi thêm node vào sau node giữa danh sách liên kết: ");
        friends.traversalFromHead();
    }
}
