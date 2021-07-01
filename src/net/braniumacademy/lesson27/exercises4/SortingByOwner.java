package net.braniumacademy.lesson27.exercises4;

import java.util.Comparator;

public class SortingByOwner implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        String owner1Name = getName(o1.getOwner());
        String owner2Name = getName(o2.getOwner());
        return owner1Name.compareTo(owner2Name);
    }

    private String getName(String owner) {
        String name = "";
        int startNameIndex = owner.lastIndexOf(" ");
        if (startNameIndex == -1) {
            name = owner;
        } else {
            name = owner.substring(startNameIndex + 1);
        }
        return name;
    }
}
