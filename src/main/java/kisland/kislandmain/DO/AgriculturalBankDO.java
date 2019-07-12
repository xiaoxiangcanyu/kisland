package kisland.kislandmain.DO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "agricultural_bank", schema = "kidsland", catalog = "")
public class AgriculturalBankDO {
    @Id
    private int id;
    private String transactionTime;
    private String amountIncome;
    private String amountCost;
    private String accountBalance;
    private String bankName;
    private String otherPartyProvincesAndCities;
    private String otherPartyAccount;
    private String otherPartyName;
    private String tradingPurpose;
    private String bDs;
    private String date;
    private String accountTitle;
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "transaction_time")
    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Basic
    @Column(name = "amount_income")
    public String getAmountIncome() {
        return amountIncome;
    }

    public void setAmountIncome(String amountIncome) {
        this.amountIncome = amountIncome;
    }

    @Basic
    @Column(name = "amount_cost")
    public String getAmountCost() {
        return amountCost;
    }

    public void setAmountCost(String amountCost) {
        this.amountCost = amountCost;
    }

    @Basic
    @Column(name = "account_balance")
    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Basic
    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "other_party_provinces_and_cities")
    public String getOtherPartyProvincesAndCities() {
        return otherPartyProvincesAndCities;
    }

    public void setOtherPartyProvincesAndCities(String otherPartyProvincesAndCities) {
        this.otherPartyProvincesAndCities = otherPartyProvincesAndCities;
    }

    @Basic
    @Column(name = "other_party_account")
    public String getOtherPartyAccount() {
        return otherPartyAccount;
    }

    public void setOtherPartyAccount(String otherPartyAccount) {
        this.otherPartyAccount = otherPartyAccount;
    }

    @Basic
    @Column(name = "other_party_name")
    public String getOtherPartyName() {
        return otherPartyName;
    }

    public void setOtherPartyName(String otherPartyName) {
        this.otherPartyName = otherPartyName;
    }

    @Basic
    @Column(name = "trading_purpose")
    public String getTradingPurpose() {
        return tradingPurpose;
    }

    public void setTradingPurpose(String tradingPurpose) {
        this.tradingPurpose = tradingPurpose;
    }

    @Basic
    @Column(name = "B_DS")
    public String getbDs() {
        return bDs;
    }

    public void setbDs(String bDs) {
        this.bDs = bDs;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "account_title")
    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgriculturalBankDO that = (AgriculturalBankDO) o;
        return id == that.id &&
                Objects.equals(transactionTime, that.transactionTime) &&
                Objects.equals(amountIncome, that.amountIncome) &&
                Objects.equals(amountCost, that.amountCost) &&
                Objects.equals(accountBalance, that.accountBalance) &&
                Objects.equals(bankName, that.bankName) &&
                Objects.equals(otherPartyProvincesAndCities, that.otherPartyProvincesAndCities) &&
                Objects.equals(otherPartyAccount, that.otherPartyAccount) &&
                Objects.equals(otherPartyName, that.otherPartyName) &&
                Objects.equals(tradingPurpose, that.tradingPurpose) &&
                Objects.equals(bDs, that.bDs) &&
                Objects.equals(date, that.date) &&
                Objects.equals(accountTitle, that.accountTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, transactionTime, amountIncome, amountCost, accountBalance, bankName, otherPartyProvincesAndCities, otherPartyAccount, otherPartyName, tradingPurpose, bDs, date, accountTitle);
    }
}
