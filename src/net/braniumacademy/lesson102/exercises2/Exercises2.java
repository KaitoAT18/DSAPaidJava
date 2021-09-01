package net.braniumacademy.lesson102.exercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

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

    public static boolean dfs(Vertex[] vertices, boolean[][] adjMatrix, int index) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        while (!stack.isEmpty()) {
            index = stack.pop();
            if (!vertices[index].visited) {
                vertices[index].visited = true;
                count++;
                for (int i = 0; i < vertices.length; i++) {
                    if (adjMatrix[index][i]) {
                        stack.push(i);
                    }
                }
            }
        }
        return count == vertices.length;
    }

    public static void main(String[] args) throws FileNotFoundException {
        var pathName = "./src/net/braniumacademy/lesson102/exercises2/input.dat";
        var input = new Scanner(new File(pathName));
        var t = input.nextInt(); // số bộ test
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
            // kiểm tra tính liên thông
            if (dfs(vertices, adjMatrix, 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        input.close();
    }
}
