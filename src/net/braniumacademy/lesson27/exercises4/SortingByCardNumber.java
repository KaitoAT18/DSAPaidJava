package net.braniumacademy.lesson27.exercises4;

import java.util.Comparator;

public class SortingByCardNumber implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getCardNumber().compareTo(o2.getCardNumber());
    }
}
