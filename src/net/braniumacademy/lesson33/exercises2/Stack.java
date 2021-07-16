package net.braniumacademy.lesson33.exercises2;

public class Stack<T> {
    private LinkedList<T> data; // lưu dữ liệu các phần tử của stack
    private int counter; // giám sát số phần tử hiện có của stack

    public Stack() {
        data = new LinkedList<>();
        counter = 0;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int size() {
        return counter;
    }

    public void push(T e) {
        counter++;
        data.add(e);
    }

    public T pop() {
        if (!isEmpty()) {
            counter--;
        }
        return data.remove();
    }

    public T peek() {
        return data.front();
    }
}
