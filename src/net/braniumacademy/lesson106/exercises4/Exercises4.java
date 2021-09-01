package net.braniumacademy.lesson106.exercises4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercises4 {
    static class Vertex { // lớp mô tả thông tin 1 đỉnh
        private static int autoIndex = 0; // vị trí tự tăng từ 0
        private final char label;   // tên đỉnh
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

    /**
     * Thuật toán Floyd-Warshall tìm đường đi ngắn nhất trên đồ thị có trọng số.
     *
     * @param vertices danh sách đỉnh
     * @param edges    danh sách cạnh
     * @param next     ma trận đường đi
     * @return ma trận khoảng cách giữa các đỉnh
     */
    public static long[][] floydWarshall(Vertex[] vertices, List<Edge> edges, Vertex[][] next) {
        // b1: khởi tạo ma trận khoảng cách và ma trận lưu vết kết quả
        long[][] dist = new long[vertices.length][vertices.length];
        for (var i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                if (i != j) {
                    dist[i][j] = Integer.MIN_VALUE;
                } else { // i == j
                    next[i][j] = vertices[i];
                }
            }
        }
        for (Edge edge : edges) {
            dist[edge.start][edge.end] = edge.weight;
            next[edge.start][edge.end] = vertices[edge.end];
        }
        // b2: lặp tính khoảng cách nhỏ nhất giữa các cặp đỉnh
        for (int k = 0; k < vertices.length; k++) {
            for (int i = 0; i < vertices.length; i++) {
                for (int j = 0; j < vertices.length; j++) {
                    var alt = dist[i][k] + dist[k][j];
                    if (dist[i][j] < alt) {
                        dist[i][j] = alt;
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws FileNotFoundException {
        var pathName = "./src/net/braniumacademy/lesson106/exercises4/weight.dat";
        var input = new Scanner(new File(pathName));
        var n = input.nextInt(); // số đỉnh
        var v = input.nextInt(); // đỉnh đích
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
        // thực hiện thuật toán Floyd-Warshall
        var next = new Vertex[vertices.length][vertices.length];
        var distances = floydWarshall(vertices, edges, next);
        var source = vertices[0];
        var target = vertices[v - 1];
        var weight = distances[source.index][target.index];
        var path = minPath(next, source.index, target.index);
        if (path != null) {
            showPath(path, weight);
        } else {
            System.out.println("Không có đường đi ngắn nhất.");
        }
    }

    private static void showPath(List<Vertex> path, long length) {
        System.out.printf("%d\n", length);
        for (var i = 0; i < path.size(); i++) {
            var delim = "";
            if (i != path.size() - 1) {
                delim = " -> ";
            }
            var e = path.get(i);
            System.out.print(e.label + delim);
        }
    }

    /**
     * Phương thức tìm đường đi từ đỉnh u đến đỉnh v trong đồ thị.
     *
     * @param next ma trận đường đi
     * @param u    đỉnh bắt đầu
     * @param v    đỉnh đích
     * @return danh sách chứa đường đi từ u->v
     */
    private static List<Vertex> minPath(Vertex[][] next, int u, int v) {
        if (next[u][v] == null) {
            return null;
        }
        ArrayList<Vertex> path = new ArrayList<>();
        path.add(next[u][u]);
        while (u != v) {
            u = next[u][v].index;
            path.add(next[u][u]);
        }
        return path;
    }
}
