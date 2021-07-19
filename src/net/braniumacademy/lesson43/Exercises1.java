package net.braniumacademy.lesson43;

import java.util.Comparator;
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
        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            queue.enqueue(x);
            queue.sort(comparator);
            while (!queue.isEmpty() && queue.peek() == max) {
                System.out.print(queue.dequeue() + " ");
                --max;
            }
            System.out.println();
        }
    }
}

class Queue<E extends Integer> {
    private final LinkedList<E> data;
    private int countElement;

    public Queue() {
        data = new LinkedList<>();
        countElement = 0;
    }

    public void enqueue(E e) {
        countElement++;
        data.add(e);
    }

    public E dequeue() {
        if (!isEmpty()) {
            countElement--;
        }
        return data.remove();
    }

    public boolean isEmpty() {
        return countElement == 0;
    }

    public E peek() {
        return data.front();
    }

    public int size() {
        return countElement;
    }

    public void sort(Comparator<Integer> comparator) {
        data.sort(comparator);
    }
}

class LinkedList<E extends Integer> {
    private Node<E> head;
    private Node<E> tail;

    public void sort(Comparator<Integer> comparator) {
        for (Node<E> p = head; p != null; p = p.next) {
            for(Node<E> node = head; node != null; node = node.next) {
                if(comparator.compare(p.data, node.data) < 0) {
                    E x  = p.data;
                    p.data = node.data;
                    node.data = x;
                }
            }
        }
    }

    static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(E e) {
        Node<E> p = new Node<>(e);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public E remove() {
        if (!isEmpty()) {
            E tmp = head.data;
            head = head.next;
            return tmp;
        }
        return null;
    }

    public E front() {
        return isEmpty() ? null : head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}