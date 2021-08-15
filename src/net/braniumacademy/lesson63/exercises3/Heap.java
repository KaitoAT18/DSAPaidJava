package net.braniumacademy.lesson63.exercises3;

import java.lang.reflect.Array;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">Branium Academy</a>
 */

public class Heap<E extends Comparable<E>> {
    private E[] data;
    private final int MAX_SIZE;
    private int currentSize;

    public Heap(Class<E> dataType, int size) {
        MAX_SIZE = size;
        currentSize = 0;
        data = (E[]) Array.newInstance(dataType, MAX_SIZE);
    }

    // thêm phần tử mới vào heap
    public boolean add(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize - 1] = e;
            siftUp(currentSize - 1);
            return true; // thêm thành công
        } else {
            return false; // thêm thất bại
        }
    }

    // sàng lên để tái cân bằng heap
    public void siftUp(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) < 0) {
            E tmp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = tmp;
            siftUp(parentIndex);
        }
    }

    // hiển thị các phần tử hiện có của heap
    public void showElements() {
        if (currentSize == 0) {
            System.err.println("Heap rỗng.");
        } else {
            for (int i = 0; i < currentSize; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }

    // trả về giá trị lớn nhất trong heap
    public E min() {
        if (currentSize == 0) {
            return null;
        } else {
            return data[0];
        }
    }

    public int size() {
        return currentSize;
    }

    public boolean remove(E e) {
        var index = findNode(e);
        if (index >= 0) {
            data[index] = data[currentSize - 1];
            data[currentSize - 1] = null;
            currentSize--;
            siftDown(index);
            return true; // xóa thành công
        } else {
            return false; // xóa thất bại
        }
    }

    public void siftDown(int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < currentSize && data[left].compareTo(data[largest]) < 0) {
            largest = left;
        }
        if (right < currentSize && data[right].compareTo(data[largest]) < 0) {
            largest = right;
        }
        if (largest != index) {
            E tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(largest);
        }
    }

    public int findNode(E e) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].compareTo(e) == 0) {
                return i;
            }
        }
        return -1; // không tìm thấy node e trong heap
    }
}
