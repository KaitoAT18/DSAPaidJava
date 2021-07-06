package net.braniumacademy.lesson211.exercises2;

import java.util.Date;
import java.util.Objects;

public class BankAccount {
    private String owner;
    private String cardNumber;
    private String accountNumber;
    private String cardType;
    private String bankName;
    private Date releaseDate;
    private Date expirationDate;
    private long ballance;

    public BankAccount() {
    }

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccount(String owner, String cardNumber,
                       String accountNumber, String cardType,
                       String bankName, Date releaseDate,
                       Date expirationDate, long ballance) {
        this.owner = owner;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.cardType = cardType;
        this.bankName = bankName;
        this.releaseDate = releaseDate;
        this.expirationDate = expirationDate;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public long getBallance() {
        return ballance;
    }

    public void setBallance(long ballance) {
        this.ballance = ballance;
    }

    public boolean withdraw(long amount) { // rút tiền
        if(ballance < amount) { // không đủ số dư để rút
            return false;
        }
        ballance -=  amount;
        return true;
    }

    public boolean deposit(long amount) {
        if(amount < 0) { // lượng tiền gửi không hợp lệ
            return false;
        }
        ballance += amount;
        return true;
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

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                ", bankName='" + bankName + '\'' +
                ", releaseDate=" + releaseDate +
                ", expirationDate=" + expirationDate +
                ", ballance=" + ballance +
                '}';
    }
}
