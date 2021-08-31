package net.braniumacademy.lesson105.exercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercises2 {
    static class Vertex { // lớp mô tả thông tin 1 đỉnh
        private static int autoIndex = 0; // vị trí tự tăng từ 0
        private final char label;   // tên đỉnh
        private long weight;      // trọng số tính từ đỉnh bắt đầu
        private final int index;          // vị trí đỉnh trong danh sách

        public Vertex(char label) {
            this.label = label;
            index = autoIndex++; // gán vị trí tự động cho các đỉnh theo thứ tự
        }
    }

    static class Edge { // lớp mô tả thông tin cạnh
        private final int start;      // đỉnh mút đầu
        private final int end;        // đỉnh mút cuối
        private final long weight;  // trọng số của cạnh

        public Edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void addVertex(Vertex[] vertices, char label, int index) {
        Vertex vertex = new Vertex(label);
        vertices[index] = vertex;
    }

    public static void addEdge(int[][] weightMatrix, int start, int end, int value) {
        weightMatrix[start][end] = value;
    }

    public static Vertex[] bellmanFord(Vertex[] vertices, List<Edge> edges, int source) {
        // b1: khởi tạo
        Vertex[] prev = new Vertex[vertices.length];
        for (Vertex vertex : vertices) {
            vertex.weight = Integer.MAX_VALUE;
        }
        vertices[source].weight = 0;
        // b2: lặp |V| - 1
        var k = 0;
        while (k < vertices.length - 1) {
            for (Edge e : edges) {
                var alt = vertices[e.start].weight + e.weight;
                if (alt < vertices[e.end].weight) {
                    vertices[e.end].weight = alt;
                    prev[e.end] = vertices[e.start];
                }
            }
            k++;
        }
        // b3: kiểm tra chu trình âm
        for (Edge e : edges) {
            var alt = vertices[e.start].weight + e.weight;
            if (alt < vertices[e.end].weight) {
                System.out.println("Đồ thị có chu trình âm.");
                return null;
            }
        }
        return prev;
    }

    private static Vertex findMinWeightVertex(List<Vertex> unvisited) {
        var minIndex = 0;
        double minWeight = Integer.MAX_VALUE;
        for (int i = 0; i < unvisited.size(); i++) {
            if (minWeight > unvisited.get(i).weight) {
                minIndex = i;
                minWeight = unvisited.get(i).weight;
            }
        }
        return unvisited.get(minIndex);
    }

    public static void main(String[] args) throws FileNotFoundException {
        var input = new Scanner(new File("./src/net/braniumacademy/lesson105/exercises2/weight.dat"));
        var n = input.nextInt(); // số đỉnh
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            var label = (char) (i + 1 + 48);
            addVertex(vertices, label, i);
        }
        // đọc ma trận kề
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                var value = input.nextInt();
                if (value != 0) {
                    edges.add(new Edge(i, j, value));
                }
            }
        }
        input.close();
        // thực hiện thuật toán Bellman-Ford
        var prev = bellmanFord(vertices, edges, 0);
        for (int i = 1; i < n; i++) {
            var target = vertices[i];
            showPath(prev, target);
        }
    }

    private static void showPath(Vertex[] prev, Vertex target) {
        System.out.printf("%d\n", target.weight);
        var prevVertex = prev[target.index];
        List<Vertex> trace = new ArrayList<>();
        trace.add(target);
        while (prevVertex != null && !prevVertex.equals(prev[0])) {
            trace.add(prevVertex);
            prevVertex = prev[prevVertex.index];
        }
        for (var i = trace.size() - 1; i >= 0; i--) {
            var delim = i > 0 ? " -> " : "";
            System.out.printf("%c%s", trace.get(i).label, delim);
        }
        System.out.println();
    }
}
