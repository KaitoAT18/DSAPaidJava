package net.braniumacademy.lesson102.exercises3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

// tham khảo thuật toán Kosaraju
public class Exercises3 {
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

    public static void dfs(Vertex[] vertices, boolean[][] adjMatrix, int index) {
        vertices[index].visited = true;
        System.out.printf("%c ", vertices[index].label);
        for (int i = 0; i < vertices.length; i++) {
            if (adjMatrix[index][i] && !vertices[i].visited) {
                dfs(vertices, adjMatrix, i);
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

    public static void printStrongConnectedComponents(Vertex[] vertices,
                                                      boolean[][] adjMatrix) {
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
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            if (!v.visited) {
                // đưa từ kí tự số về chữ số phải trừ 48(tham khảo bảng mã ASCII)
                // trừ thêm 1 vì nhãn đánh số từ 1
                dfs(vertices, revAdjMatrix, (v.label - 48 - 1));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        var pathName = "./src/net/braniumacademy/lesson102/exercises3/input.dat";
        var input = new Scanner(new File(pathName));
        var t = input.nextInt(); // số bộ test
        for (int test = 1; test <= t; test++) {
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
            System.out.printf("Test %d: \n", test);
            printStrongConnectedComponents(vertices, adjMatrix);
        }
        input.close();
    }
}
