package other;

import java.util.ArrayList;
import java.util.Comparator;

public class Queue<E extends Number> {
    private int currentElement; // số lượng phần tử hiện thời có trong queue
    private ArrayList<E> data; // lưu trữ các phần tử trong queue

    public Queue() {
        currentElement = 0;
        data = new ArrayList<>();
    }

    public void enqueue(E e) {
        data.add(e); // thêm vào cuối array list
        currentElement++;
    }

    public E dequeue() {
        if (!isEmpty()) {
            currentElement--; // giảm số lượng phần tử thực tế hiện có của queue
            E e = data.get(0); // lấy ở đầu array list
            data.remove(0); // xóa phần tử đầu
            return e;
        }
        return null; // trong trường hợp queue rỗng
    }

    public boolean isEmpty() {
        return currentElement == 0;
    }

    public E peek() {
        return isEmpty() ? null : data.get(0);
    }

    public int size() {
        return currentElement;
    }

    public void sort() {
        data.sort(new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o2.intValue() - o1.intValue();
            }
        });
    }
}
