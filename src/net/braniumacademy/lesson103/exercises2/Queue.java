package net.braniumacademy.lesson103.exercises2;

public class Queue<T>{
    private LinkedList<T> data;
    private int countElement;

    public Queue() {
        data = new LinkedList<>();
        countElement = 0;
    }

    public void enqueue(T t) {
        data.add(t);;
        countElement++;
    }

    public T dequeue() {
        if(!isEmpty()) {
            countElement--;
        }
        return data.remove();
    }

    public boolean isEmpty() {
        return countElement == 0;
    }

    public T peek() {
        return data.front();
    }

    public int size() {
        return countElement;
    }
}
