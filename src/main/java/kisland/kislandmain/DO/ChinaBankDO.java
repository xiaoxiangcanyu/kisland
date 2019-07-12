package kisland.kislandmain.DO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "china_bank", schema = "kidsland", catalog = "")
public class ChinaBankDO {
    private int id;
    private String transactionType;
    private String businessType;
    private String accountHoldingBankNumberPayer;
    private String payerAccountBank;
    private String debitAccountNo;
    private String payerName;
    private String accountHoldingBeneficiaryBankNumber;
    private String beneficiaryAccountBank;
    private String payeeAccountNumber;
    private String payeeName;
    private String transactionDate;
    private String transactionTime;
    private String tradeCurrency;
    private String tradeAmount;
    private String afterTransactionBalance;
    private String valueDate;
    private String exchangeRate;
    private String transactionReferenceNumber;
    private String onlineBankingTransactionRef;
    private String customerTransactionRef;
    private String voucherType;
    private String voucherNumber;
    private String recordId;
    private String reference;
    private String purpose;
    private String remark;
    private String remarks;
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
    @Column(name = "transaction_type")
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Basic
    @Column(name = "business_type")
    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Basic
    @Column(name = "account_holding_bank_number_payer")
    public String getAccountHoldingBankNumberPayer() {
        return accountHoldingBankNumberPayer;
    }

    public void setAccountHoldingBankNumberPayer(String accountHoldingBankNumberPayer) {
        this.accountHoldingBankNumberPayer = accountHoldingBankNumberPayer;
    }

    @Basic
    @Column(name = "payer_account_bank")
    public String getPayerAccountBank() {
        return payerAccountBank;
    }

    public void setPayerAccountBank(String payerAccountBank) {
        this.payerAccountBank = payerAccountBank;
    }

    @Basic
    @Column(name = "debit_account_no")
    public String getDebitAccountNo() {
        return debitAccountNo;
    }

    public void setDebitAccountNo(String debitAccountNo) {
        this.debitAccountNo = debitAccountNo;
    }

    @Basic
    @Column(name = "payer_name")
    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    @Basic
    @Column(name = "account_holding_beneficiary_bank_number")
    public String getAccountHoldingBeneficiaryBankNumber() {
        return accountHoldingBeneficiaryBankNumber;
    }

    public void setAccountHoldingBeneficiaryBankNumber(String accountHoldingBeneficiaryBankNumber) {
        this.accountHoldingBeneficiaryBankNumber = accountHoldingBeneficiaryBankNumber;
    }

    @Basic
    @Column(name = "beneficiary_account_bank")
    public String getBeneficiaryAccountBank() {
        return beneficiaryAccountBank;
    }

    public void setBeneficiaryAccountBank(String beneficiaryAccountBank) {
        this.beneficiaryAccountBank = beneficiaryAccountBank;
    }

    @Basic
    @Column(name = "payee_account_number")
    public String getPayeeAccountNumber() {
        return payeeAccountNumber;
    }

    public void setPayeeAccountNumber(String payeeAccountNumber) {
        this.payeeAccountNumber = payeeAccountNumber;
    }

    @Basic
    @Column(name = "payee_name")
    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
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
    @Column(name = "transaction_time")
    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Basic
    @Column(name = "trade_currency")
    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    @Basic
    @Column(name = "trade_amount")
    public String getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    @Basic
    @Column(name = "after_transaction_balance")
    public String getAfterTransactionBalance() {
        return afterTransactionBalance;
    }

    public void setAfterTransactionBalance(String afterTransactionBalance) {
        this.afterTransactionBalance = afterTransactionBalance;
    }

    @Basic
    @Column(name = "value_date")
    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    @Basic
    @Column(name = "exchange_rate")
    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Basic
    @Column(name = "transaction_reference_number")
    public String getTransactionReferenceNumber() {
        return transactionReferenceNumber;
    }

    public void setTransactionReferenceNumber(String transactionReferenceNumber) {
        this.transactionReferenceNumber = transactionReferenceNumber;
    }

    @Basic
    @Column(name = "online_banking_transaction_ref")
    public String getOnlineBankingTransactionRef() {
        return onlineBankingTransactionRef;
    }

    public void setOnlineBankingTransactionRef(String onlineBankingTransactionRef) {
        this.onlineBankingTransactionRef = onlineBankingTransactionRef;
    }

    @Basic
    @Column(name = "customer_transaction_ref")
    public String getCustomerTransactionRef() {
        return customerTransactionRef;
    }

    public void setCustomerTransactionRef(String customerTransactionRef) {
        this.customerTransactionRef = customerTransactionRef;
    }

    @Basic
    @Column(name = "voucher_type")
    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
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
    @Column(name = "record_id")
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "reference")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        ChinaBankDO that = (ChinaBankDO) o;
        return id == that.id &&
                Objects.equals(transactionType, that.transactionType) &&
                Objects.equals(businessType, that.businessType) &&
                Objects.equals(accountHoldingBankNumberPayer, that.accountHoldingBankNumberPayer) &&
                Objects.equals(payerAccountBank, that.payerAccountBank) &&
                Objects.equals(debitAccountNo, that.debitAccountNo) &&
                Objects.equals(payerName, that.payerName) &&
                Objects.equals(accountHoldingBeneficiaryBankNumber, that.accountHoldingBeneficiaryBankNumber) &&
                Objects.equals(beneficiaryAccountBank, that.beneficiaryAccountBank) &&
                Objects.equals(payeeAccountNumber, that.payeeAccountNumber) &&
                Objects.equals(payeeName, that.payeeName) &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(transactionTime, that.transactionTime) &&
                Objects.equals(tradeCurrency, that.tradeCurrency) &&
                Objects.equals(tradeAmount, that.tradeAmount) &&
                Objects.equals(afterTransactionBalance, that.afterTransactionBalance) &&
                Objects.equals(valueDate, that.valueDate) &&
                Objects.equals(exchangeRate, that.exchangeRate) &&
                Objects.equals(transactionReferenceNumber, that.transactionReferenceNumber) &&
                Objects.equals(onlineBankingTransactionRef, that.onlineBankingTransactionRef) &&
                Objects.equals(customerTransactionRef, that.customerTransactionRef) &&
                Objects.equals(voucherType, that.voucherType) &&
                Objects.equals(voucherNumber, that.voucherNumber) &&
                Objects.equals(recordId, that.recordId) &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(purpose, that.purpose) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(bDs, that.bDs) &&
                Objects.equals(date, that.date) &&
                Objects.equals(accountTitle, that.accountTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, transactionType, businessType, accountHoldingBankNumberPayer, payerAccountBank, debitAccountNo, payerName, accountHoldingBeneficiaryBankNumber, beneficiaryAccountBank, payeeAccountNumber, payeeName, transactionDate, transactionTime, tradeCurrency, tradeAmount, afterTransactionBalance, valueDate, exchangeRate, transactionReferenceNumber, onlineBankingTransactionRef, customerTransactionRef, voucherType, voucherNumber, recordId, reference, purpose, remark, remarks, bDs, date, accountTitle);
    }
}
