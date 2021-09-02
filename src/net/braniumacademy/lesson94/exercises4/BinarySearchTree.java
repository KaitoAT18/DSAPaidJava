package net.braniumacademy.lesson94.exercises4;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    static class Node {
        private Employee data;
        private Node leftNode;
        private Node rightNode;

        public Node(Employee data) {
            this.data = data;
            leftNode = null;
            rightNode = null;
        }
    }

    public void add(Employee data) {
        root = add(root, data);
    }

    private Node add(Node r, Employee data) {
        if (r == null) {
            return new Node(data);
        }
        if (r.data.compareTo(data) > 0) {
            r.leftNode = add(r.leftNode, data);
        } else if (r.data.compareTo(data) <= 0) {
            r.rightNode = add(r.rightNode, data);
        }
        return r;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Employee searchById(Employee x) {
        return searchById(root, x);
    }

    private Employee searchById(Node r, Employee x) {
        if (r == null) {
            return null;
        }
        if (r.data.compareTo(x) == 0) {
            return r.data;
        } else if (r.data.compareTo(x) > 0) {
            return searchById(r.leftNode, x);
        } else {
            return searchById(r.rightNode, x);
        }
    }

    public List<Employee> searchByName(String key) {
        List<Employee> employees = new ArrayList<>();
        searchByName(root, employees, key);
        return employees;
    }

    private void searchByName(Node r, List<Employee> employees, String key) {
        if(r != null) {
            searchByName(r.leftNode, employees, key);
            if (r.data.getFirst().matches(".*" + key + ".*")) {
                employees.add(r.data);
            }
            searchByName(r.rightNode, employees, key);
        }
    }
}
