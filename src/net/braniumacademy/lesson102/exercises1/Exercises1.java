package net.braniumacademy.lesson102.exercises1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        var pathName = "./src/net/braniumacademy/lesson102/exercises1/input.dat";
        var input = new Scanner(new File(pathName));
        var t = input.nextInt(); // số đỉnh
        while (t-- > 0) {
            var n = input.nextInt(); // đỉnh đích
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
            // kiểm tra tính liên thông
            if (dfs(vertices, adjMatrix, 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            relaxVertices(vertices);
        }
        input.close();

    }

    private static void relaxVertices(Vertex[] vertices) {
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].visited = false;
        }
    }
}
