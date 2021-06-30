package net.braniumacademy.lesson27.exercises2;

import net.braniumacademy.lesson27.exercises1.LinkedList;

public class Exercises2 {
    public static void main(String[] args) {
        LinkedList<Double> listString = new LinkedList<>();
        listString.insertTail(3.25);
        listString.insertTail(25.31);
        listString.insertTail(13.25);
        listString.insertTail(26.41);
        listString.insertTail(6.47);
        listString.insertTail(17.58);
        listString.insertTail(1.42);
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
