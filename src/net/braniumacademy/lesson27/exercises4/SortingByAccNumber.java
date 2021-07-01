package net.braniumacademy.lesson27.exercises4;

import java.util.Comparator;

public class SortingByAccNumber implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return o2.getAccountNumber().compareTo(o1.getAccountNumber());
    }
}
