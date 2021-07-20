package net.braniumacademy.lesson44.exercises2;

import java.lang.reflect.Array;

public class CircularQueue<E extends Number> {
    private int headIndex; // chỉ số phần tử đầu hàng đợi vòng
    private int tailIndex; // chỉ số phần tử cuối hàng đợi vòng
    private int capacity; // số phần tử tối đa có thể chứa trong hàng đợi
    private int currentElement; // số phần tử hiện thời của hàng đợi vòng
    private final E[] data; // mảng dùng để lưu trữ các phần tử của hàng đợi vòng

    public CircularQueue(Class<E> eClass, int capacity) {
        currentElement = 0;
        this.capacity = capacity;
        headIndex = -1;
        tailIndex = -1;
        data = (E[]) Array.newInstance(eClass, capacity);
    }

    public boolean isEmpty() {
        return currentElement == 0;
    }

    public boolean isFull() { // kiểm tra xem hàng đợi đầy chưa
        return currentElement == capacity;
    }

    public boolean enqueue(E e) { // phương thức thêm mới phần tử vào queue vòng
        if (isFull()) {
            System.out.println("Hàng đợi đầy.");
            return false; // thêm thất bại
        } else {
            currentElement++;
            if (headIndex == -1) {
                headIndex++;
            }
            tailIndex = (tailIndex + 1) % capacity;
            data[tailIndex] = e;
            return true;
        }
    }

    public E dequeue() { // phương thức xóa và trả về phần tử đầu queue vòng
        if (isEmpty()) {
            System.out.println("Queue rỗng.");
            return null;
        } else {
            E front = data[headIndex];
            currentElement--;
            if (headIndex == tailIndex) {
                headIndex = tailIndex = -1;
            } else {
                headIndex = (headIndex + 1) % capacity;
            }
            return front;
        }
    }

    public E peek() { // phương thức lấy phần tử đầu queue vòng
        if (!isEmpty()) {
            return data[headIndex];
        }
        return null;
    }

    public int size() { // phương thức trả về số phần tử hiện có trong queue
        return currentElement;
    }

    public void display() { // phương thức hiển thị các phần tử trong queue
        if (isEmpty()) {
            System.out.println("Queue rỗng.");
        } else {
            System.out.println("Thứ tự các phần tử trong queue: ");
            for (int i = headIndex; i != tailIndex; i = (i + 1) % capacity) {
                System.out.print(data[i] + " ");
            }
            System.out.println(data[tailIndex]);
        }
    }
}