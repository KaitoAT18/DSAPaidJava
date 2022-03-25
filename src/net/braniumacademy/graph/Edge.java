package net.braniumacademy.graph;

import java.util.ArrayList;
import java.util.List;

public class Edge {
    private Object startVertext;
    private Object endVertex;
    private Object weight;

    public Edge(Object startVertext, Object endVertex, Object weight) {
        this.startVertext = startVertext;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public Edge() {
    }

    public Object getStartVertext() {
        return startVertext;
    }

    public void setStartVertext(Object startVertext) {
        this.startVertext = startVertext;
    }

    public Object getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Object endVertex) {
        this.endVertex = endVertex;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(1, 2, 50)); // đỉnh 1 kề đỉnh 2, trọng số cạnh là 50
        edgeList.add(new Edge(1, 3, 40)); // đỉnh 1 kề đỉnh 3, trọng số cạnh là 40
        edgeList.add(new Edge(2, 5, 10)); // đỉnh 2 kề đỉnh 5, trọng số cạnh là 10
    }
}
