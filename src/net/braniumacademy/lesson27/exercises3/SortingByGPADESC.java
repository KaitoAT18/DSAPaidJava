package net.braniumacademy.lesson27.exercises3;

import java.util.Comparator;

public class SortingByGPADESC implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int compared = Float.compare(o2.getGpa(), o1.getGpa());
        if (compared != 0) {
            return compared;
        } else {
            int comparedName = o1.getFirstName().compareTo(o2.getFirstName());
            if (comparedName == 0) {
                return o1.getLastName().compareTo(o2.getLastName());
            } else {
                return comparedName;
            }
        }
    }
}
