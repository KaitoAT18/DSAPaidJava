package net.braniumacademy.lesson103.exercises1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Exercises1 {
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

    public static void addEdge(boolean[][] adjMatrix, int start, int end, int value) {
        adjMatrix[start][end] = value != 0;
        adjMatrix[end][start] = value != 0;
    }

    public static boolean bfs(Vertex[] vertices, boolean[][] adjMatrix, int index) {
        var counter = 0; // biến đếm số đỉnh đã duyệt
        Queue<Integer> queue = new Queue<>();
        vertices[index].visited = true;
        queue.enqueue(index);
        while (!queue.isEmpty()) {
            index = queue.dequeue();
            counter++;
            for (int i = 0; i < vertices.length; i++) {
                if (adjMatrix[index][i] && !vertices[i].visited) {
                    vertices[i].visited = true;
                    queue.enqueue(i);
                }
            }
        }
        return counter == vertices.length;
    }

    public static void main(String[] args) throws FileNotFoundException {
        var pathName = "./src/net/braniumacademy/lesson103/exercises1/input.dat";
        var input = new Scanner(new File(pathName));
        var t = input.nextInt(); // số bộ test
        for (int test = 1; test <= t; test++) {
            var n = input.nextInt(); // số đỉnh của bộ test hiện tại
            Vertex[] vertices = new Vertex[n];
            for (int i = 0; i < n; i++) {
                var label = (char) (i + 1 + 48);
                addVertex(vertices, label, i);
            }
            // đọc ma trận kề
            boolean[][] adjMatrix = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    var value = input.nextInt();
                    addEdge(adjMatrix, i, j, value);
                }
            }
            System.out.printf("Test %d: \n", test);
            // kiểm tra tính liên thông
            if (bfs(vertices, adjMatrix, 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        input.close();

    }
}
