package net.braniumacademy.lesson32.exercises4;

import java.lang.reflect.Array;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Stack<T> {
    private int size;       // số phần tử thực tế hiện có trong stack
    private int capacity;   // số phần tử tối đa có thể chứa của stack
    private T[] data;       // mảng dùng để lưu các phần tử của stack

    public Stack() { // hàm tạo mặc định
        size = 0;
        capacity = 10;
        data = (T[]) Array.newInstance(Object.class, capacity);
    }

    public Stack(Class<T> t) {
        size = 0;
        capacity = 10;
        data = (T[]) Array.newInstance(t, capacity);
    }

    public Stack(Class<T> t, int capacity) {
        size = 0;
        this.capacity = capacity;
        data = (T[]) Array.newInstance(t, capacity);
    }

    public boolean isEmpty() { // kiểm tra stack có rỗng hay không
        return size == 0;
    }

    public boolean isFull() { // kiểm tra stack đã đầy hay chưa
        return size == capacity;
    }

    public void push(T t) { // thêm mới phần tử vào đầu stack
        if (!isFull()) {
            data[size++] = t;
        } else {
            System.out.println("Stack đã đầy. Không thể thêm mới phần tử.");
        }
    }

    public void pop() { // xóa phần tử đầu stack nếu stack không rỗng
        if (!isEmpty()) {
            data[size-1] = null;
            size--;
        } else {
            System.out.println("Stack rỗng.");
        }
    }

    public T peek() { // lấy phần tử ở đầu stack nhưng không xóa bỏ nó khỏi stack
        if (!isEmpty()) {
            return data[size - 1];
        }
        return null;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public T[] getData() {
        return data;
    }
}
