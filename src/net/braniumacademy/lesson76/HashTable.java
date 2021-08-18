package net.braniumacademy.lesson76;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HashTable<K, V> {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private int count; // tổng số phần tử trong bảng băm
    private Entry<?, ?>[] table; // dữ liệu của bảng băm
    private int threshold; // ngưỡng
    private float loadFactor; // load factor
    private int modCount = 0; // số lần bảng băm sửa đổi cấu trúc, ví dụ băm lại

    public HashTable(int capacity, float loadFactor) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Illegal Load: " + loadFactor);
        }
        if (capacity == 0) {
            capacity = 1;
        }
        this.loadFactor = loadFactor;
        table = new Entry<?, ?>[capacity];
        threshold = (int) Math.min(capacity * loadFactor, MAX_ARRAY_SIZE + 1);
    }

    public HashTable(int capacity) {
        this(capacity, 0.75f);
    }

    public HashTable() {
        this(11, 0.75f);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private boolean contains(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        Entry<?, ?>[] tab = table;
        for (int i = tab.length - 1; i >= 0; i--) {
            for (var e = tab[i]; e != null; e = e.next) {
                if (e.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        return contains(value);
    }

    public boolean containsKey(Object key) {
        Entry<?, ?>[] tab = table;
        int hash = key.hashCode();
        int index = (hash & 0x7fffffff) % tab.length;
        for (var e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Phương thức lấy value tương ứng với key
     *
     * @param key khóa cần lấy giá trị tương ứng trong bảng băm
     * @return giá trị value liên kết với key
     */
    public V get(Object key) {
        Entry<?, ?>[] tab = table; // lấy bảng băm
        int hash = key.hashCode(); // lãy mã băm của key
        int index = (hash & 0x7fffffff) % tab.length; // lấy chỉ số trong bảng băm
        for (var e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) { // tìm thấy
                return (V) e.value; // trả về giá trị value
            }
        }
        return null; // không tìm thấy, trả về null
    }

    /**
     * Phương thức thêm mới một cặp key-value vào bảng băm
     *
     * @param key   // khóa
     * @param value // giá trị liên kết với khóa
     * @return giá trị value cũ tại vị trí index
     */
    public V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        Entry<?, ?>[] tab = table;
        int hash = key.hashCode();
        int index = (hash & 0x7fffffff) % tab.length;
        var entry = (Entry<K, V>) tab[index];
        for (; entry != null; entry = entry.next) {
            if (entry.hash == hash && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        addEntry(hash, key, value, index);
        return null;
    }

    /**
     * Phương thức thêm mới entry vào bảng băm
     *
     * @param hash  // mã băm của key
     * @param key   // khóa
     * @param value // giá trị liên kết với khóa
     * @param index // vị trí
     */
    private void addEntry(int hash, K key, V value, int index) {
        Entry<?, ?>[] tab = table;
        if (count >= threshold) { // nếu đạt ngưỡng băm lại bảng
            rehash(); // băm lại
            tab = table;
            hash = key.hashCode(); // lấy mã băm
            index = (hash & 0x7fffffff) % tab.length; // lấy chỉ số
        }
        var e = (Entry<K, V>) tab[index]; // phần tử next của entry mới
        tab[index] = new Entry<>(hash, key, value, e);
        count++; // tăng số phần tử trong bảng băm
        modCount++;
    }

    /**
     * Phương thức dùng để băm lại các phần tử trong bảng băm cũ
     */
    protected void rehash() {
        int oldCapacity = table.length; // lưu lại kích thước bảng cũ
        Entry<?, ?>[] oldMap = table; // lưu lại bảng cũ
        // nhân đôi kích thước bảng băm, sử dụng phép dịch trái bít
        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - MAX_ARRAY_SIZE > 0) { // nếu kích thước mới quá lớn
            if (oldCapacity == MAX_ARRAY_SIZE) // nếu kích thước cũ bằng khả năng tối đa
                return; // tiếp tục sử dụng mảng cũ, không cần băm lại
            newCapacity = MAX_ARRAY_SIZE; // gán lại kích thước mới = kích thước cũ
        }
        Entry<?, ?>[] newMap = new Entry<?, ?>[newCapacity]; // cấp phát mảng mới
        modCount++; // tăng số lần sửa đổi bảng băm
        // tính toán lại ngưỡng mới
        threshold = (int) Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        table = newMap; // cập nhật lại bảng băm

        for (int i = oldCapacity - 1; i >= 0; i--) { // duyệt từ cuối mảng cũ
            // cập nhật tất cả các phần tử trong danh sách các phần tử tại vị trí đang xét
            for (Entry<K, V> old = (Entry<K, V>) oldMap[i]; old != null; ) {
                Entry<K, V> e = old; // lấy phần tử tại vị trí i
                old = old.next; // chuyển đến phần tử(node) kế tiếp
                int index = (e.hash & 0x7FFFFFFF) % newCapacity; // tìm vị trí mới trong newMap
                e.next = (Entry<K, V>) newMap[index]; // phần tử(node) kế tiếp của node mới
                newMap[index] = e; // gắn phần tử vừa băm lại vào vị trí index trong newMap
            }
        }
    }

    /**
     * Phương thức xóa một phần tử trong bảng băm theo tên.
     *
     * @param key khóa cần xóa khỏi bảng
     * @return value liên kết với key của phần tử có key bị xóa hoặc null nếu xóa thất bại
     */
    public V remove(Object key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (Entry<K, V> prev = null; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                if (prev != null) {
                    prev.next = e.next;
                } else {
                    tab[index] = e.next;
                }
                modCount++;
                count--;
                V oldValue = e.value;
                e.value = null;
                return oldValue;
            }
            prev = e;
        }
        return null;
    }

    /**
     * Phương thức thay thế value của cặp key-value hiện tại trong bảng băm
     * bởi một giá trị khác.
     *
     * @param key      khóa có value cần cập nhật
     * @param newValue giá trị value mới để thay thế
     * @return giá trị value cũ của key hoặc null nếu không tồn tại key
     */
    public V replace(K key, V newValue) {
        Objects.requireNonNull(newValue); // giá trị để thay thế phải khác null
        var tab = table; // gán bảng
        var hash = key.hashCode(); // mã băm của key
        var index = (hash & 0x7FFFFFFF) % tab.length; // lấy chỉ số phần tử trong bảng
        var e = (Entry<K, V>) tab[index]; // lấy phần tử tại vị trí index
        for (; e != null; e = e.next) { // tìm phần tử có key cho trước
            if ((e.hash == hash) && e.key.equals(key)) { // tìm thấy
                var oldValue = e.value; // lưu lại giá trị value cũ
                e.value = newValue; // update value mới
                return oldValue; // trả về giá trị cũ
            }
        }
        return null; // trả về null khi không tìm thấy key trong bảng băm
    }

    public void clear() {
        var tab = table;
        for (int index = tab.length; --index >= 0; ) {
            tab[index] = null;
            modCount++;
            count = 0;
        }
    }

    public List<K> getKeys() {
        if (count > 0) {
            List<K> keyList = new ArrayList<>();
            for (var e : table) {
                var current = e;
                while (current != null) {
                    keyList.add((K) current.getKey());
                    current = current.next;
                }
            }
            return keyList;
        }
        return null;
    }

    public List<V> getValues() {
        if (count > 0) {
            List<V> valueList = new ArrayList<>();
            for (var e : table) {
                var current = e;
                while (current != null) {
                    valueList.add((V) current.getValue());
                    current = current.next;
                }
            }
            return valueList;
        }
        return null;
    }

    public List<Entry<K, V>> elements() {
        if (count > 0) {
            List<Entry<K, V>> entries = new ArrayList<>();
            for (var e : table) {
                var current = e;
                while (current != null) {
                    entries.add((Entry<K, V>) current);
                    current = current.next;
                }
            }
            return entries;
        }
        return null;
    }

    public void showKeys() {
        var keyList = getKeys();
        System.out.print("[");
        for (int i = 0; i < keyList.size(); i++) {
            var e = keyList.get(i);
            var delimiter = ", ";
            System.out.printf("%s", e);
            if (i != keyList.size() - 1) {
                System.out.print(delimiter);
            }
        }
        System.out.println("]");
    }

    public void showValues() {
        var valueList = getValues();

        for (int i = 0; i < valueList.size(); i++) {
            System.out.print("[");
            var e = valueList.get(i);
            System.out.printf("%s", e);
            System.out.println("]");
        }
    }

    /**
     * Hiển thị danh sách các cặp key-value ra màn hình
     */
    public void showEntries() {
        var entries = elements();
        for (int i = 0; i < entries.size(); i++) {
            var e = entries.get(i);
            System.out.print("[");
            System.out.printf("(%s-%s)", e.getKey(), e.getValue());
            System.out.println("]");
        }
    }

    private static class Entry<K, V> implements Map.Entry<K, V> {
        final int hash;     // mã băm
        final K key;        // khóa
        V value;            // giá trị liên kết với khóa
        Entry<K, V> next;   // con trỏ next

        protected Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        protected Object clone() {
            return new Entry<>(hash, key, value,
                    (next == null ? null : (Entry<K, V>) next.clone()));
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            if (value == null) {
                throw new NullPointerException();
            }
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            return (key == null ? e.getKey() == null : key.equals(e.getKey())) &&
                    (value == null ? e.getValue() == null : value.equals(e.getValue()));
        }

        @Override
        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
