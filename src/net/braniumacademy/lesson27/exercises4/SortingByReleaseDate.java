package net.braniumacademy.lesson27.exercises4;

import java.util.Comparator;

public class SortingByReleaseDate implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return Long.compare(o1.getReleaseDate().getTime(), o2.getReleaseDate().getTime());
    }
}
