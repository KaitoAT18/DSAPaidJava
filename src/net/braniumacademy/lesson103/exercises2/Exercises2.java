package net.braniumacademy.lesson103.exercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Exercises2 {
    static class Vertex { // lớp mô tả thông tin 1 đỉnh
        private final int label;   // tên đỉnh
        private boolean visited;
        private int blocked;

        public Vertex(int label, boolean visited) {
            this.label = label;
            this.visited = visited;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertex vertex)) return false;
            return label == vertex.label;
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        public int getBlocked() {
            return blocked;
        }

        public void setBlocked(int blocked) {
            this.blocked = blocked;
        }
    }

    public static void addVertex(Vertex[] vertices, int label) {
        vertices[label] = new Vertex(label, false);
    }

    // sử dụng thuật toán duyệt theo chiều rộng duyệt các thành phần liên thông
    public static int bfs(Vertex[] vertices, Vector<Integer>[] adj, int v) {
        Queue<Integer> queue = new Queue<>();
        vertices[v].visited = true;
        queue.enqueue(v);
        int count = 0;
        while (!queue.isEmpty()) {
            v = queue.dequeue();
            for (int i = 0; i < adj[v].size(); i++) {
                if (!vertices[adj[v].get(i)].visited && vertices[adj[v].get(i)].getBlocked() == 0) {
                    count++;
                    vertices[adj[v].get(i)].visited = true;
                    queue.enqueue(adj[v].get(i));
                } else if (!vertices[adj[v].get(i)].visited && vertices[adj[v].get(i)].getBlocked() == 1) {
                    count++;
                }
            }
        }
        return count + 1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        var pathName = "./src/net/braniumacademy/lesson103/exercises2/input.dat";
        var input = new Scanner(new File(pathName));
        var n = input.nextInt(); // số đỉnh
        Vertex[] vertices = new Vertex[n + 1];
        for (int i = 1; i <= n; i++) {
            addVertex(vertices, i);
        }
        // biểu diễn danh sách cạnh kề của từng đỉnh
        Vector<Integer>[] adj = new Vector[n + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Vector<>();
        }
        // thêm các cạnh kề vào danh sách kề
        // do đồ thị vô hướng nên ta add 2 lần cạnh giữa cặp đỉnh (u, v)
        for (int i = 1; i < n; i++) {
            var start = input.nextInt();
            var end = input.nextInt();
            adj[start].add(end); // cạnh thuận
            adj[end].add(start); // cạnh ngược
        }
        // đọc trạng thái của ống nước tại thành phố thứ i
        for (int i = 1; i <= n; i++) {
            int state = input.nextInt();
            vertices[i].setBlocked(state);
        }
        input.close();
        // Liệt kê các thành phần liên thông của đồ thị
        var result = findMax(vertices, adj);
        System.out.printf("%d\n", result);
    }

    private static int findMax(Vertex[] vertices, Vector<Integer>[] adj) {
        int max = 1;
        for (int i = 1; i < vertices.length; i++) {
            if (vertices[i].getBlocked() == 0 && !vertices[i].visited) {
                int result = bfs(vertices, adj, i);
                if (result > max) {
                    max = result;
                }
            }
        }
        return max;
    }
}
