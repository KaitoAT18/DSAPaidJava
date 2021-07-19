package net.braniumacademy.lesson44;

public class Exercises1 {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.display();
        queue.dequeue();
        queue.dequeue();
        queue.display();
        queue.enqueue(100);
        queue.enqueue(300);
        queue.enqueue(500);
        queue.enqueue(800);
        queue.enqueue(900);
        queue.display();
        System.out.println("Phần tử đầu queue: " + queue.peek());
        System.out.println("Số phần tử trong queue: " + queue.size());
    }
}
