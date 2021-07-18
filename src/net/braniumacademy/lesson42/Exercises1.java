package net.braniumacademy.lesson42;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ý tưởng xử lý bài toán: đọc phần tử nào vào ta tiến hành thêm phần tử đó vào queue luôn.
 * Sau đó sắp xếp và kiểm tra xem liệu phần tử đầu queue đã trùng với giá trị max hay không.
 * Nếu giá trị max trùng với phần tử đầu queue thì in ra và giảm max đi 1 đơn vị. Tiếp tục cho
 * tới khi điều kiện trên không còn thỏa mãn. kết thúc vòng lặp con.
 * In ra xuống dòng và quay trở lại đọc dữ liệu vào.
 */

public class Exercises1 {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int max = n;
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            queue.enqueue(x);
            queue.sort();
            while (!queue.isEmpty() && queue.peek() == max) {
                System.out.print(queue.dequeue() + " ");
                --max;
            }
            System.out.println();
        }
    }
}

class Queue<E extends Integer> {
    private int currentElement; // số lượng phần tử hiện thời có trong queue
    private ArrayList<E> data; // lưu trữ các phần tử trong queue

    public Queue() {
        currentElement = 0;
        data = new ArrayList<>();
    }

    public void enqueue(E e) {
        data.add(e); // thêm vào cuối array list
        currentElement++;
    }

    public E dequeue() {
        if (!isEmpty()) {
            currentElement--; // giảm số lượng phần tử thực tế hiện có của queue
            E e = data.get(0); // lấy ở đầu array list
            data.remove(0); // xóa phần tử đầu
            return e;
        }
        return null; // trong trường hợp queue rỗng
    }

    public boolean isEmpty() {
        return currentElement == 0;
    }

    public E peek() {
        return isEmpty() ? null : data.get(0);
    }

    public int size() {
        return currentElement;
    }

    public void sort() {
        data.sort((o1, o2) -> o2.intValue() - o1.intValue());
    }
}

