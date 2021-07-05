package net.braniumacademy.lesson29.exercises1;

import java.util.Comparator;

public class SortingByName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
