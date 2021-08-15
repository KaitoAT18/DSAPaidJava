package net.braniumacademy.lesson62.exercises3;

import java.lang.reflect.Array;

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
        if(currentSize == 0) {
            System.err.println("Heap rỗng.");
        } else {
            for (int i = 0; i < currentSize; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }
    // trả về giá trị lớn nhất trong heap
    public E max() {
        if (currentSize == 0) {
            return null;
        } else {
            return data[currentSize - 1];
        }
    }
    // trả vể giá trị nhỏ nhất trong heap
    public E min() {
        if (currentSize == 0) {
            return null;
        } else {
            return data[0];
        }
    }
}
