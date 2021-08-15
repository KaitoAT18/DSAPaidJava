package net.braniumacademy.lesson62.exercises2;

import java.lang.reflect.Array;

public class Heap {
    private int[] data;
    private final int MAX_SIZE;
    private int currentSize;

    public Heap(int size) {
        MAX_SIZE = size;
        currentSize = 0;
        data = new int[MAX_SIZE];
    }
    // thêm phần tử mới vào heap
    public boolean add(int e) {
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
        if (data[index] > data[parentIndex]) {
            int tmp = data[index];
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
    public int max() throws Exception {
        if (currentSize == 0) {
            throw new Exception("Heap rỗng.");
        } else {
            return data[0];
        }
    }
    // trả vể giá trị nhỏ nhất trong heap
    public int min() throws Exception {
        if (currentSize == 0) {
            throw new Exception("Heap rỗng.");
        } else {
            return data[currentSize - 1];
        }
    }
    // trả về kích thước của heap
    public int size() {
        return currentSize;
    }
}
