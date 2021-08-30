package net.braniumacademy.lesson104.exercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Exercises2 {
    static class Vertex implements Comparable<Vertex> { // lớp mô tả thông tin 1 đỉnh
        private static int autoIndex = 0; // vị trí tự tăng từ 0
        private final char label;   // tên đỉnh
        private int weight;      // trọng số tính từ đỉnh bắt đầu
        private final int index;          // vị trí đỉnh trong danh sách

        public Vertex(char label) {
            this.label = label;
            index = autoIndex++; // gán vị trí tự động cho các đỉnh theo thứ tự
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

        @Override
        public int compareTo(Vertex o) {
            return Double.compare(weight, o.weight);
        }
    }

    public static void addVertex(Vertex[] vertices, char label, int index) {
        Vertex vertex = new Vertex(label);
        vertices[index] = vertex;
    }

    public static void addEdge(int[][] weightMatrix, int start, int end, int value) {
        weightMatrix[start][end] = value;
    }

    /**
     * Phương thức triển khai thuật toán Dijkstra
     *
     * @param vertices     danh sách đỉnh của đồ thị
     * @param weightMatrix ma trận trọng số của đồ thị
     * @param source       đỉnh bắt đầu duyệt
     * @param target       đỉnh đích
     * @return mảng chứa đường đi từ đỉnh nguồn đến đỉnh đích
     */
    public static Vertex[] dijkstra(Vertex[] vertices,
                                    int[][] weightMatrix, int source, char target) {
        List<Vertex> unvisited = new ArrayList<>(); // tạo tập đỉnh chưa thăm
        Vertex[] prev = new Vertex[vertices.length]; // mảng chứa lưu vết đường đi
        for (Vertex vertex : vertices) { // xét từng đỉnh
            vertex.weight = Integer.MAX_VALUE; // khởi tạo giá trị trọng số cho đỉnh
            unvisited.add(vertex); // thêm đỉnh vào tập đỉnh unvisited
        }
        vertices[source].weight = 0; // đỉnh bắt đầu duyệt sẽ có trọng số bằng 0
        while (!unvisited.isEmpty()) { // lặp đến khi danh sách unvisited rỗng
            var u = findMinWeightVertex(unvisited); // tìm đỉnh có trọng số nhỏ nhất
//            if (u.label == target) { // nếu u là đỉnh đích
//                break; // kết thúc thuật toán
//            }
            unvisited.remove(u); // xóa khỏi tập đỉnh unvisited
            for (int v = 0; v < vertices.length; v++) { // duyệt từng đỉnh của đồ thị
                if (weightMatrix[u.index][v] != 0 && unvisited.contains(vertices[v])) {
                    var alt = u.weight + weightMatrix[u.index][v]; // tính trọng số thành phần
                    if (alt < vertices[v].weight) { // nếu trọng số tính được nhỏ hơn thì
                        vertices[v].weight = alt; // cập nhật trọng số của đỉnh v
                        prev[v] = u; // cập nhật đỉnh trước v là u
                    }
                }
            }
            if (u.label == target) { // nếu u là đỉnh đích
                break; // kết thúc thuật toán
            }
        }
        return prev; // trả về danh sách chứa đường đi của thuật toán
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
        var input = new Scanner(new File("./src/net/braniumacademy/lesson104/exercises2/weight.dat"));
        var n = input.nextInt(); // số đỉnh
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            var label = (char) (i + 1 + 48);
            addVertex(vertices, label, i);
        }
        // đọc ma trận kề
        int[][] weightMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                weightMatrix[i][j] = input.nextInt();
            }
        }
        // thực hiện thuật toán Dijkstra
        for (int i = 1; i < n; i++) {
            var target = vertices[i];
            var prev = dijkstra(vertices, weightMatrix, 0, target.label);
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
//
//    private static void showPath(Vertex[] prev, Vertex target) {
//        System.out.printf("Đường đi ngắn nhất từ đỉnh đầu đến đỉnh %c: ", target.label);
//        var prevVertex = prev[target.index];
//        System.out.print(target.label);
//        while (prevVertex != null && !prevVertex.equals(prev[0])) {
//            System.out.printf(" <- %c", prevVertex.label);
//            prevVertex = prev[prevVertex.index];
//        }
//        System.out.printf("\nTổng quãng đường: %d\n", target.weight);
//    }
}
