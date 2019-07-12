package kisland.kislandmain.DO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "minsheng_bank", schema = "kidsland", catalog = "")
public class MinshengBankDO {
    private int id;
    private String transactionDate;
    private String hostTransactionSerialNumber;
    private String debitAmount;
    private String creditAmount;
    private String accountBalance;
    private String documentNumber;
    private String summary;
    private String otherpartyAccounts;
    private String otherpartyAccountName;
    private String otherpartyOpeningBank;
    private String transactionTime;
    private String bDs;
    private String date;
    private String accountTitle;
    private String accountName;
    private String bankAccount;
    private String otherAccounts;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "transaction_date")
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Basic
    @Column(name = "host_transaction_serial_number")
    public String getHostTransactionSerialNumber() {
        return hostTransactionSerialNumber;
    }

    public void setHostTransactionSerialNumber(String hostTransactionSerialNumber) {
        this.hostTransactionSerialNumber = hostTransactionSerialNumber;
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
    @Column(name = "account_balance")
    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Basic
    @Column(name = "document_number")
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Basic
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "otherparty_accounts")
    public String getOtherpartyAccounts() {
        return otherpartyAccounts;
    }

    public void setOtherpartyAccounts(String otherpartyAccounts) {
        this.otherpartyAccounts = otherpartyAccounts;
    }

    @Basic
    @Column(name = "otherparty_account_name")
    public String getOtherpartyAccountName() {
        return otherpartyAccountName;
    }

    public void setOtherpartyAccountName(String otherpartyAccountName) {
        this.otherpartyAccountName = otherpartyAccountName;
    }

    @Basic
    @Column(name = "otherparty_opening_bank")
    public String getOtherpartyOpeningBank() {
        return otherpartyOpeningBank;
    }

    public void setOtherpartyOpeningBank(String otherpartyOpeningBank) {
        this.otherpartyOpeningBank = otherpartyOpeningBank;
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

    @Basic
    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "bank_account")
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Basic
    @Column(name = "other_accounts")
    public String getOtherAccounts() {
        return otherAccounts;
    }

    public void setOtherAccounts(String otherAccounts) {
        this.otherAccounts = otherAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinshengBankDO that = (MinshengBankDO) o;
        return id == that.id &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(hostTransactionSerialNumber, that.hostTransactionSerialNumber) &&
                Objects.equals(debitAmount, that.debitAmount) &&
                Objects.equals(creditAmount, that.creditAmount) &&
                Objects.equals(accountBalance, that.accountBalance) &&
                Objects.equals(documentNumber, that.documentNumber) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(otherpartyAccounts, that.otherpartyAccounts) &&
                Objects.equals(otherpartyAccountName, that.otherpartyAccountName) &&
                Objects.equals(otherpartyOpeningBank, that.otherpartyOpeningBank) &&
                Objects.equals(transactionTime, that.transactionTime) &&
                Objects.equals(bDs, that.bDs) &&
                Objects.equals(date, that.date) &&
                Objects.equals(accountTitle, that.accountTitle) &&
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(bankAccount, that.bankAccount) &&
                Objects.equals(otherAccounts, that.otherAccounts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, transactionDate, hostTransactionSerialNumber, debitAmount, creditAmount, accountBalance, documentNumber, summary, otherpartyAccounts, otherpartyAccountName, otherpartyOpeningBank, transactionTime, bDs, date, accountTitle, accountName, bankAccount, otherAccounts);
    }
}
