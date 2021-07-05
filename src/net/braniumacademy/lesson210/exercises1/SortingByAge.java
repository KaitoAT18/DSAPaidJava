package net.braniumacademy.lesson210.exercises1;

import java.util.Comparator;

public class SortingByAge implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}
