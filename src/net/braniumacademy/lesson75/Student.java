package net.braniumacademy.lesson75;

import java.util.Objects;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">Branium Academy</a>
 */

public class Student implements Comparable<Student> {
    private String id;
    private String first;
    private String last;
    private String mid;
    private float gpa;

    public Student() {
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String first, String last, String mid, float gpa) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.mid = mid;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student other) {
        return id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", mid='" + mid + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
