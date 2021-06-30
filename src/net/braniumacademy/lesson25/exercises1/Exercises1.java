package net.braniumacademy.lesson25.exercises1;

public class Exercises1 {
    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();
        stringList.insertTail("Linh");
        stringList.insertTail("Nam");
        stringList.insertTail("Ngân");
        stringList.insertTail("Hồng");
        stringList.insertTail("Khánh");
        stringList.insertTail("Hương");
        stringList.insertTail("Nhung");
        // hiển thị danh sách phần tử
        System.out.println("Các phần tử trong danh sách: ");
        stringList.showList();
        removeNode(stringList, "Nam");
        removeNode(stringList, "Hoàng");
        removeNode(stringList, "Nhung");
    }

    private static void removeNode(LinkedList<String> stringList, String key) {
        System.out.println("Dữ liệu trong node cần xóa: " + key);
        var result = stringList.removeNode(key);
        if (result) { // xóa thành công
            System.out.println("Xóa thành công! Danh sách sau khi xóa: ");
            stringList.showList();
        } else {
            System.out.println("Xóa thất bại. Node cần xóa không tồn tại.");
        }
    }
}
