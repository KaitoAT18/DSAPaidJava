package net.braniumacademy.lesson44.exercises1;

public class CircularQueue<E> {
    private int currentElement; // số phần tử hiện thời của hàng đợi vòng
    private final LinkedList<E> data; // mảng dùng để lưu trữ các phần tử của hàng đợi vòng

    public CircularQueue(int capacity) {
        currentElement = 0;
        data = new LinkedList<>();
    }

    public boolean isEmpty() {
        return currentElement == 0;
    }

    public boolean enqueue(E e) { // phương thức thêm mới phần tử vào queue vòng
        currentElement++; // tăng số phần tử hiện có trong queue lên 1
        data.add(e); // thêm phần tử mới vào arraylist
        return true;
    }

    public E dequeue() { // phương thức xóa và trả về phần tử đầu queue vòng
        if (isEmpty()) {
            System.out.println("Queue rỗng.");
            return null;
        } else {
            currentElement--;
            return data.remove(); // trả về kết quả
        }
    }

    public E peek() { // phương thức lấy phần tử đầu queue vòng
        if (!isEmpty()) {
            return data.front();
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
            for (var e : data) {
                System.out.print(e + " ");
            }
            System.out.println(data.back());
        }
    }
}