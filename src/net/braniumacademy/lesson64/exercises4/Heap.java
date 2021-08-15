package net.braniumacademy.lesson64.exercises4;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">Branium Academy</a>
 */

public class Heap<E extends Student> {
    private Student[] data;
    private final int MAX_SIZE;
    private int currentSize;

    public Heap(int size) {
        MAX_SIZE = size;
        currentSize = 0;
        data = new Student[MAX_SIZE];
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
            Student tmp = data[index];
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
                System.out.println(data[i]);
            }
        }
    }

    // trả về giá trị lớn nhất trong heap
    public Student min() {
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
            Student tmp = data[index];
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

    // cập nhật node có giá trị x
    public boolean update(E oldNode, E newNode) {
        var index = findNode(oldNode); // tìm vị trí node cần update
        if (index >= 0) {  // nếu tìm thấy
            data[index] = newNode; // update node đó
            var parentIndex = (index - 1) / 2; // tìm vị trí của node cha
            if (data[parentIndex].compareTo(data[index]) > 0) {
                siftUp(index); // nếu cha < con(index) thì sàng lên
            } else { // ngược lại, vun xuống
                siftDown(index);
            }
            return true; // cập nhật thành công
        }
        return false; // cập nhật thất bại
    }
}
