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
        if (r != null) {
            searchByName(r.leftNode, employees, key);
            if (r.data.getFirst().matches(".*" + key + ".*")) {
                employees.add(r.data);
            }
            searchByName(r.rightNode, employees, key);
        }
    }

    public List<Employee> searchBySalary(int salary) {
        List<Employee> employees = new ArrayList<>();
        searchBySalary(root, employees, salary);
        return employees;
    }

    private void searchBySalary(Node r, List<Employee> employees, int salary) {
        if (r != null) {
            searchBySalary(r.leftNode, employees, salary);
            if (r.data.getSalary() == salary) {
                employees.add(r.data);
            }
            searchBySalary(r.rightNode, employees, salary);
        }
    }

    public List<Employee> searchBySalary(int fromSalary, int toSalary) {
        List<Employee> employees = new ArrayList<>();
        searchBySalary(root, employees, fromSalary, toSalary);
        return employees;
    }

    private void searchBySalary(Node r, List<Employee> employees, int fromSalary, int toSalary) {
        if (r != null) {
            searchBySalary(r.leftNode, employees, fromSalary, toSalary);
            if (r.data.getSalary() >= fromSalary && r.data.getSalary() <= toSalary) {
                employees.add(r.data);
            }
            searchBySalary(r.rightNode, employees, fromSalary, toSalary);
        }
    }

    public List<Employee> toList() {
        List<Employee> employees = new ArrayList<>();
        toList(root, employees);
        return employees;
    }

    private void toList(Node root, List<Employee> employees) {
        if(root != null) {
            toList(root.leftNode, employees);
            employees.add(root.data);
            toList(root.rightNode, employees);
        }
    }
}
