package kisland.kislandmain.DO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "industrial_and_commercial_bank", schema = "kidsland", catalog = "")
public class IndustrialAndCommercialBankDO {
    private int id;
    private String voucherNumber;
    private String accountNumber;
    private String otherPartyAccountNumber;
    private String transactionTime;
    private String debtOrCredit;
    private String debitAmount;
    private String creditAmount;
    private String otherPartyNumber;
    private String bankAbstract;
    private String purpose;
    private String otherPartyCompanyName;
    private String balance;
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
    @Column(name = "voucher_number")
    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    @Basic
    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "other_party_account_number")
    public String getOtherPartyAccountNumber() {
        return otherPartyAccountNumber;
    }

    public void setOtherPartyAccountNumber(String otherPartyAccountNumber) {
        this.otherPartyAccountNumber = otherPartyAccountNumber;
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
    @Column(name = "debt_or_credit")
    public String getDebtOrCredit() {
        return debtOrCredit;
    }

    public void setDebtOrCredit(String debtOrCredit) {
        this.debtOrCredit = debtOrCredit;
    }

    @Basic
    @Column(name = "debit_amount")
    public String getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount;
    }

    @Basic
    @Column(name = "credit_amount")
    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    @Basic
    @Column(name = "other_party_number")
    public String getOtherPartyNumber() {
        return otherPartyNumber;
    }

    public void setOtherPartyNumber(String otherPartyNumber) {
        this.otherPartyNumber = otherPartyNumber;
    }

    @Basic
    @Column(name = "bank_abstract")
    public String getBankAbstract() {
        return bankAbstract;
    }

    public void setBankAbstract(String bankAbstract) {
        this.bankAbstract = bankAbstract;
    }

    @Basic
    @Column(name = "purpose")
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Basic
    @Column(name = "other_party_company_name")
    public String getOtherPartyCompanyName() {
        return otherPartyCompanyName;
    }

    public void setOtherPartyCompanyName(String otherPartyCompanyName) {
        this.otherPartyCompanyName = otherPartyCompanyName;
    }

    @Basic
    @Column(name = "balance")
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
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
        IndustrialAndCommercialBankDO that = (IndustrialAndCommercialBankDO) o;
        return id == that.id &&
                Objects.equals(voucherNumber, that.voucherNumber) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(otherPartyAccountNumber, that.otherPartyAccountNumber) &&
                Objects.equals(transactionTime, that.transactionTime) &&
                Objects.equals(debtOrCredit, that.debtOrCredit) &&
                Objects.equals(debitAmount, that.debitAmount) &&
                Objects.equals(creditAmount, that.creditAmount) &&
                Objects.equals(otherPartyNumber, that.otherPartyNumber) &&
                Objects.equals(bankAbstract, that.bankAbstract) &&
                Objects.equals(purpose, that.purpose) &&
                Objects.equals(otherPartyCompanyName, that.otherPartyCompanyName) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(bDs, that.bDs) &&
                Objects.equals(date, that.date) &&
                Objects.equals(accountTitle, that.accountTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, voucherNumber, accountNumber, otherPartyAccountNumber, transactionTime, debtOrCredit, debitAmount, creditAmount, otherPartyNumber, bankAbstract, purpose, otherPartyCompanyName, balance, bDs, date, accountTitle);
    }
}
