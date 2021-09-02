package net.braniumacademy.lesson45.exercises2;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private Node[] nodes;
    private int currentSize;
    private int capacity;

    public PriorityQueue() {
        currentSize = 0;
        capacity = 10; // mặc định 10 phần tử
        nodes = new Node[capacity];
    }

    public PriorityQueue(int capacity) {
        currentSize = 0;
        this.capacity = capacity > 0 ? capacity : 10;
        nodes = new Node[capacity];
    }

    public boolean add(Number number, int priority) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            nodes[currentSize++] = new Node(number, priority);
        } else {
            Node node = new Node(number, priority);
            // nếu thứ tự ưu tiên nhỏ nhất, chèn cuối
            if (priority < nodes[currentSize - 1].priority) {
                nodes[currentSize] = node;
            } else {
                // tìm vị trí để chèn
                int insertIndex = 0;
                for (int i = 0; i < currentSize; i++) {
                    insertIndex = i;
                    if (nodes[i].priority < priority) {
                        break;
                    }
                }
                // dịch phải các phần tử phía phải vị trí cần chèn
                for (int i = currentSize; i > insertIndex; i--) {
                    nodes[i] = nodes[i - 1];
                }
                // chèn vào vị trí
                nodes[insertIndex] = node;
            }
            currentSize++; // tăng số phần tử hiện thời lên 1
        }
        return true;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == capacity;
    }

    public int size() {
        return currentSize;
    }

    public List<Number> toList() {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < currentSize; i++) {
            numbers.add(nodes[i].data);
        }
        return numbers;
    }

    public void lastMinElements() {
        if (!isEmpty()) {
            System.out.printf("%d\n", nodes[currentSize - 1].data.intValue());
        } else {
            System.out.println("Hàng đợi rỗng.");
        }
    }

    public Number remove() {
        if (!isEmpty()) {
            Number first = nodes[0].data;
            if (currentSize - 1 >= 0) System.arraycopy(nodes, 1, nodes, 0, currentSize - 1);
            currentSize--;
            return first;
        } else {
            return null;
        }
    }

    public Number peek() {
        if (!isEmpty()) {
            return nodes[0].data;
        } else {
            return null;
        }
    }

    static class Node {
        private Number data;
        private int priority;

        public Node(Number data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }
}
