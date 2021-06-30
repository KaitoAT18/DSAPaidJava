package net.braniumacademy.lesson26.exercises4;

import java.util.Date;
import java.util.Objects;

public class BankAccount {
    private String owner;
    private String cardNumber;
    private String accountNumber;
    private String cardType;
    private String bankName;
    private Date startDate;
    private Date endDate;
    private long ballance;

    public BankAccount() {
    }

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccount(String owner, String cardNumber,
                       String accountNumber, String cardType,
                       String bankName, Date startDate,
                       Date endDate, long ballance) {
        this.owner = owner;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.cardType = cardType;
        this.bankName = bankName;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        return Objects.equals(cardNumber, that.cardNumber) || Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, accountNumber);
    }
}
