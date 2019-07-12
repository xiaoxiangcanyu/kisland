package kisland.kislandmain.DO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dbs_bank", schema = "kidsland", catalog = "")
public class DbsBankDO {
    @Id
    private int id;
    private String bDs;
    private String date;
    private String accountTitle;
    private String accountNumber;
    private String debitAccountCurrency;
    private String openingBalance;
    private String closingBookBalance;
    private String closingAvailableBalance;
    private String totalCreditAmount;
    private String totalCreditCount;
    private String statementDate;
    private String totalDebitCount;
    private String totalDebitAmount;
    private String holdAmount;
    private String statementDetailValueDate;
    private String postingDate;
    private String debitAmount;
    private String creditAmount;
    private String transactionTypeCode;
    private String supplementaryDetails;
    private String statementDetailInfoToAccountOwner1;
    private String statementDetailInfoToAccountOwner2;
    private String statementDetailInfoToAccountOwner3;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "debit_account_currency")
    public String getDebitAccountCurrency() {
        return debitAccountCurrency;
    }

    public void setDebitAccountCurrency(String debitAccountCurrency) {
        this.debitAccountCurrency = debitAccountCurrency;
    }

    @Basic
    @Column(name = "opening_balance")
    public String getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(String openingBalance) {
        this.openingBalance = openingBalance;
    }

    @Basic
    @Column(name = "closing_book_balance")
    public String getClosingBookBalance() {
        return closingBookBalance;
    }

    public void setClosingBookBalance(String closingBookBalance) {
        this.closingBookBalance = closingBookBalance;
    }

    @Basic
    @Column(name = "closing_available_balance")
    public String getClosingAvailableBalance() {
        return closingAvailableBalance;
    }

    public void setClosingAvailableBalance(String closingAvailableBalance) {
        this.closingAvailableBalance = closingAvailableBalance;
    }

    @Basic
    @Column(name = "total_credit_amount")
    public String getTotalCreditAmount() {
        return totalCreditAmount;
    }

    public void setTotalCreditAmount(String totalCreditAmount) {
        this.totalCreditAmount = totalCreditAmount;
    }

    @Basic
    @Column(name = "total_credit_count")
    public String getTotalCreditCount() {
        return totalCreditCount;
    }

    public void setTotalCreditCount(String totalCreditCount) {
        this.totalCreditCount = totalCreditCount;
    }

    @Basic
    @Column(name = "statement_date")
    public String getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate;
    }

    @Basic
    @Column(name = "total_debit_count")
    public String getTotalDebitCount() {
        return totalDebitCount;
    }

    public void setTotalDebitCount(String totalDebitCount) {
        this.totalDebitCount = totalDebitCount;
    }

    @Basic
    @Column(name = "total_debit_amount")
    public String getTotalDebitAmount() {
        return totalDebitAmount;
    }

    public void setTotalDebitAmount(String totalDebitAmount) {
        this.totalDebitAmount = totalDebitAmount;
    }

    @Basic
    @Column(name = "hold_amount")
    public String getHoldAmount() {
        return holdAmount;
    }

    public void setHoldAmount(String holdAmount) {
        this.holdAmount = holdAmount;
    }

    @Basic
    @Column(name = "statement_detail_value_date")
    public String getStatementDetailValueDate() {
        return statementDetailValueDate;
    }

    public void setStatementDetailValueDate(String statementDetailValueDate) {
        this.statementDetailValueDate = statementDetailValueDate;
    }

    @Basic
    @Column(name = "posting_date")
    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
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
    @Column(name = "transaction_type_code")
    public String getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public void setTransactionTypeCode(String transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    @Basic
    @Column(name = "supplementary_details")
    public String getSupplementaryDetails() {
        return supplementaryDetails;
    }

    public void setSupplementaryDetails(String supplementaryDetails) {
        this.supplementaryDetails = supplementaryDetails;
    }

    @Basic
    @Column(name = "statement_detail_info_to_account_owner_1")
    public String getStatementDetailInfoToAccountOwner1() {
        return statementDetailInfoToAccountOwner1;
    }

    public void setStatementDetailInfoToAccountOwner1(String statementDetailInfoToAccountOwner1) {
        this.statementDetailInfoToAccountOwner1 = statementDetailInfoToAccountOwner1;
    }

    @Basic
    @Column(name = "statement_detail_info_to_account_owner_2")
    public String getStatementDetailInfoToAccountOwner2() {
        return statementDetailInfoToAccountOwner2;
    }

    public void setStatementDetailInfoToAccountOwner2(String statementDetailInfoToAccountOwner2) {
        this.statementDetailInfoToAccountOwner2 = statementDetailInfoToAccountOwner2;
    }

    @Basic
    @Column(name = "statement_detail_info_to_account_owner_3")
    public String getStatementDetailInfoToAccountOwner3() {
        return statementDetailInfoToAccountOwner3;
    }

    public void setStatementDetailInfoToAccountOwner3(String statementDetailInfoToAccountOwner3) {
        this.statementDetailInfoToAccountOwner3 = statementDetailInfoToAccountOwner3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DbsBankDO that = (DbsBankDO) o;
        return id == that.id &&
                Objects.equals(bDs, that.bDs) &&
                Objects.equals(date, that.date) &&
                Objects.equals(accountTitle, that.accountTitle) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(debitAccountCurrency, that.debitAccountCurrency) &&
                Objects.equals(openingBalance, that.openingBalance) &&
                Objects.equals(closingBookBalance, that.closingBookBalance) &&
                Objects.equals(closingAvailableBalance, that.closingAvailableBalance) &&
                Objects.equals(totalCreditAmount, that.totalCreditAmount) &&
                Objects.equals(totalCreditCount, that.totalCreditCount) &&
                Objects.equals(statementDate, that.statementDate) &&
                Objects.equals(totalDebitCount, that.totalDebitCount) &&
                Objects.equals(totalDebitAmount, that.totalDebitAmount) &&
                Objects.equals(holdAmount, that.holdAmount) &&
                Objects.equals(statementDetailValueDate, that.statementDetailValueDate) &&
                Objects.equals(postingDate, that.postingDate) &&
                Objects.equals(debitAmount, that.debitAmount) &&
                Objects.equals(creditAmount, that.creditAmount) &&
                Objects.equals(transactionTypeCode, that.transactionTypeCode) &&
                Objects.equals(supplementaryDetails, that.supplementaryDetails) &&
                Objects.equals(statementDetailInfoToAccountOwner1, that.statementDetailInfoToAccountOwner1) &&
                Objects.equals(statementDetailInfoToAccountOwner2, that.statementDetailInfoToAccountOwner2) &&
                Objects.equals(statementDetailInfoToAccountOwner3, that.statementDetailInfoToAccountOwner3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bDs, date, accountTitle, accountNumber, debitAccountCurrency, openingBalance, closingBookBalance, closingAvailableBalance, totalCreditAmount, totalCreditCount, statementDate, totalDebitCount, totalDebitAmount, holdAmount, statementDetailValueDate, postingDate, debitAmount, creditAmount, transactionTypeCode, supplementaryDetails, statementDetailInfoToAccountOwner1, statementDetailInfoToAccountOwner2, statementDetailInfoToAccountOwner3);
    }
}
