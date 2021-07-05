package net.braniumacademy.lesson28.exercises2;

public class Exercises2 {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.insertTail("Nam");
        strings.insertTail("Mai");
        strings.insertTail("Hong");
        strings.insertTail("Phong");
        strings.insertTail("Bac");
        strings.insertTail("Linh");
        strings.insertTail("Mai");
        strings.insertTail("Mai");
        String value = "Mai";
        System.out.println("Các phần tử trong danh sách: ");
        strings.showList();
        int occurent = strings.search(value);
        System.out.println("Giá trị " + value + " xuất hiện " + occurent + " lần trong danh sách.");
    }
}
