package net.braniumacademy.lesson22.Exercises1;

public class TestEx1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        // thêm node vào cuối danh sách liên kết đơn
        list.insertTail("A");
        list.insertTail("B");
        list.insertTail("C");
        list.insertTail("D");
        // thêm node sau node có giá trị x cho trước
        list.insertBeforeX("H", "C");
        list.showList();
        // thêm node vào sau vị trí k
        list.insertAfterK("K", 0);
        // chèn vào đầu danh sách
        list.insertHead("M");
        list.insertHead("N");
        list.showList();
        // lấy giá trị node giữa của danh sách
        System.out.println(list.findMidNodeData());
        // chèn node mới sau node giữa danh sách
        list.insertAfterMidNode("MID");
        list.showList();
    }
}
