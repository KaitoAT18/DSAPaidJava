package net.braniumacademy.lesson24.exercises4;

import java.util.Objects;

public class BankAccount {
    private String owner;
    private String cardNumber;
    private String accountNumber;
    private String bankName;
    private long ballance;

    public BankAccount() {
    }

    public BankAccount(String accNumber) {
        this.accountNumber = accNumber;
    }

    public BankAccount(String owner, String cardNumber,
                       String accountNumber, String bankName, long ballance) {
        this.owner = owner;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.ballance = ballance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getBallance() {
        return ballance;
    }

    public void setBallance(long ballance) {
        this.ballance = ballance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", ballance=" + ballance +
                '}';
    }
}
