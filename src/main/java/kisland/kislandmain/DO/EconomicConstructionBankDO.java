package kisland.kislandmain.DO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "economic_construction_bank", schema = "kidsland", catalog = "")
public class EconomicConstructionBankDO {
    private int id;
    private String accountNumber;
    private String transactionTime;
    private String debitAmount;
    private String creditAmount;
    private String currency;
    private String counterAccount;
    private String counterName;
    private String openingAccount;
    private String billingDate;
    private String summary;
    private String remark;
    private String transactionFlowUmber;
    private String enterpriseSerialNumber;
    private String documentCategory;
    private String documentNumber;
    private String accountName;
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
    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "counter_account")
    public String getCounterAccount() {
        return counterAccount;
    }

    public void setCounterAccount(String counterAccount) {
        this.counterAccount = counterAccount;
    }

    @Basic
    @Column(name = "counter_name")
    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    @Basic
    @Column(name = "opening_account")
    public String getOpeningAccount() {
        return openingAccount;
    }

    public void setOpeningAccount(String openingAccount) {
        this.openingAccount = openingAccount;
    }

    @Basic
    @Column(name = "billing_date")
    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
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
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "transaction_flow_umber")
    public String getTransactionFlowUmber() {
        return transactionFlowUmber;
    }

    public void setTransactionFlowUmber(String transactionFlowUmber) {
        this.transactionFlowUmber = transactionFlowUmber;
    }

    @Basic
    @Column(name = "enterprise_serial_number")
    public String getEnterpriseSerialNumber() {
        return enterpriseSerialNumber;
    }

    public void setEnterpriseSerialNumber(String enterpriseSerialNumber) {
        this.enterpriseSerialNumber = enterpriseSerialNumber;
    }

    @Basic
    @Column(name = "document_category")
    public String getDocumentCategory() {
        return documentCategory;
    }

    public void setDocumentCategory(String documentCategory) {
        this.documentCategory = documentCategory;
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
    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
        EconomicConstructionBankDO that = (EconomicConstructionBankDO) o;
        return id == that.id &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(transactionTime, that.transactionTime) &&
                Objects.equals(debitAmount, that.debitAmount) &&
                Objects.equals(creditAmount, that.creditAmount) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(counterAccount, that.counterAccount) &&
                Objects.equals(counterName, that.counterName) &&
                Objects.equals(openingAccount, that.openingAccount) &&
                Objects.equals(billingDate, that.billingDate) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(transactionFlowUmber, that.transactionFlowUmber) &&
                Objects.equals(enterpriseSerialNumber, that.enterpriseSerialNumber) &&
                Objects.equals(documentCategory, that.documentCategory) &&
                Objects.equals(documentNumber, that.documentNumber) &&
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(bDs, that.bDs) &&
                Objects.equals(date, that.date) &&
                Objects.equals(accountTitle, that.accountTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accountNumber, transactionTime, debitAmount, creditAmount, currency, counterAccount, counterName, openingAccount, billingDate, summary, remark, transactionFlowUmber, enterpriseSerialNumber, documentCategory, documentNumber, accountName, balance, bDs, date, accountTitle);
    }
}
