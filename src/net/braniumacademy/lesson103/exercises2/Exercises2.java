package net.braniumacademy.lesson103.exercises2;

import net.braniumacademy.lesson103.exercises1.Exercises1;
import net.braniumacademy.lesson103.exercises1.Queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

// tham khảo thuật toán Kosaraju
public class Exercises2 {
    static class Vertex { // lớp mô tả thông tin 1 đỉnh
        private final char label;   // tên đỉnh
        private boolean visited;

        public Vertex(char label, boolean visited) {
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
    }

    public static void addVertex(Vertex[] vertices, char label, int index) {
        Vertex vertex = new Vertex(label, false);
        vertices[index] = vertex;
    }

    public static void addEdge(boolean[][] adjMatrix, int start, int end, boolean value) {
        adjMatrix[start][end] = value;
    }

    // sử dụng thuật toán duyệt theo chiều rộng duyệt các thành phần liên thông
    public static void bfs(Vertex[] vertices, boolean[][] adjMatrix, int v) {
        net.braniumacademy.lesson103.exercises1.Queue<Integer> queue = new Queue<>();
        vertices[v].visited = true;
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            v = queue.dequeue();
            for (int i = 0; i < vertices.length; i++) {
                if (adjMatrix[v][i] && !vertices[i].visited) {
                    vertices[i].visited = true;
                    queue.enqueue(i);
                }
            }
        }
    }

    public static boolean[][] transpose(boolean[][] adjMatrix) {
        boolean[][] revAdjMatrix = new boolean[adjMatrix.length][adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j]) {
                    revAdjMatrix[j][i] = true;
                }
            }
        }
        return revAdjMatrix;
    }

    public static void fillOrder(Vertex[] vertices,
                                 boolean[][] adjMatrix, int v, Stack<Vertex> stack) {
        vertices[v].visited = true;
        for (int i = 0; i < vertices.length; i++) {
            if (adjMatrix[v][i] && !vertices[i].visited) {
                fillOrder(vertices, adjMatrix, i, stack);
            }
        }
        stack.push(vertices[v]);
    }

    /**
     * Phương thức đếm số thành phần liên thông trong đồ thị có hướng
     *
     * @param vertices  danh sách đỉnh hay còn gọi là tập đỉnh
     * @param adjMatrix ma trận kề của đồ thị
     * @return số thành phần liên thông trong đồ thị
     */
    public static int findSCComponents(Vertex[] vertices, boolean[][] adjMatrix) {
        Stack<Vertex> stack = new Stack<>();
        // đưa các đỉnh vào stack theo thứ tự kết thúc của nó
        for (int i = 0; i < vertices.length; i++) {
            if (!vertices[i].visited) {
                fillOrder(vertices, adjMatrix, i, stack);
            }
        }
        // tạo một ma trận kề biểu diễn hướng đi đảo ngược
        var revAdjMatrix = transpose(adjMatrix);
        // đánh dấu lại các đỉnh là chưa được thăm
        for (Vertex vertex : vertices) {
            vertex.visited = false;
        }
        var counter = 0;
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            if (!v.visited) {
                // đưa từ kí tự số về chữ số phải trừ 48(tham khảo bảng mã ASCII)
                // trừ thêm 1 vì nhãn đánh số từ 1
                bfs(vertices, revAdjMatrix, (v.label - 48 - 1));
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) throws FileNotFoundException {
        var pathName = "./src/net/braniumacademy/lesson103/exercises2/input.dat";
        var input = new Scanner(new File(pathName));
        var t = input.nextInt(); // số bộ test
        var testCount = 1; // biến lưu thứ tự các test
        while (t-- > 0) {
            var n = input.nextInt(); // số đỉnh
            var edge = input.nextInt(); // số cạnh
            Vertex[] vertices = new Vertex[n];
            for (int i = 0; i < n; i++) {
                var label = (char) (i + 1 + 48);
                addVertex(vertices, label, i);
            }
            // đọc tập cạnh
            boolean[][] adjMatrix = new boolean[n][n];
            for (int i = 0; i < edge; i++) {
                var start = input.nextInt();
                var end = input.nextInt();
                addEdge(adjMatrix, start - 1, end - 1, true);
            }
            // Liệt kê các thành phần liên thông của đồ thị
            var result = findSCComponents(vertices, adjMatrix);
            System.out.printf("Test %d: %d\n", testCount++, result);
        }
        input.close();
    }
}
