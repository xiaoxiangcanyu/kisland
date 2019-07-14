package kisland.kislandmain.DO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dbs_bank", schema = "kidsland", catalog = "")
public class DbsBankDO {
    private int id;
    private String accountNumber;
    private String accountName;
    private String productType;
    private String businessDate;
    private String currency;
    private String openingBalance;
    private String ledgerBalance;
    private String availableBalance;
    private String overdraftLimit;
    private String earmarkAmount;
    private String miscellaneousHold;
    private String halfDayHold;
    private String oneDayHold;
    private String twoDayHold;
    private String totalNumberOfDebits;
    private String totalDebitAmount;
    private String totalNumberOfCredits;
    private String totalCreditAmount;
    private String accountTitle;
    private String bDs;
    private String closingAvailableBalance;
    private String closingBookBalance;
    private String creditAmount;
    private String date;
    private String debitAccountCurrency;
    private String debitAmount;
    private String holdAmount;
    private String postingDate;
    private String statementDate;
    private String statementDetailInfoToAccountOwner1;
    private String statementDetailInfoToAccountOwner2;
    private String statementDetailInfoToAccountOwner3;
    private String statementDetailValueDate;
    private String supplementaryDetails;
    private String totalCreditCount;
    private String totalDebitCount;
    private String transactionTypeCode;

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
    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "product_type")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "business_date")
    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
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
    @Column(name = "opening_balance")
    public String getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(String openingBalance) {
        this.openingBalance = openingBalance;
    }

    @Basic
    @Column(name = "ledger_balance")
    public String getLedgerBalance() {
        return ledgerBalance;
    }

    public void setLedgerBalance(String ledgerBalance) {
        this.ledgerBalance = ledgerBalance;
    }

    @Basic
    @Column(name = "available_balance")
    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    @Basic
    @Column(name = "overdraft_limit")
    public String getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(String overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Basic
    @Column(name = "earmark_amount")
    public String getEarmarkAmount() {
        return earmarkAmount;
    }

    public void setEarmarkAmount(String earmarkAmount) {
        this.earmarkAmount = earmarkAmount;
    }

    @Basic
    @Column(name = "miscellaneous_hold")
    public String getMiscellaneousHold() {
        return miscellaneousHold;
    }

    public void setMiscellaneousHold(String miscellaneousHold) {
        this.miscellaneousHold = miscellaneousHold;
    }

    @Basic
    @Column(name = "half_day_hold")
    public String getHalfDayHold() {
        return halfDayHold;
    }

    public void setHalfDayHold(String halfDayHold) {
        this.halfDayHold = halfDayHold;
    }

    @Basic
    @Column(name = "one_day_hold")
    public String getOneDayHold() {
        return oneDayHold;
    }

    public void setOneDayHold(String oneDayHold) {
        this.oneDayHold = oneDayHold;
    }

    @Basic
    @Column(name = "two_day_hold")
    public String getTwoDayHold() {
        return twoDayHold;
    }

    public void setTwoDayHold(String twoDayHold) {
        this.twoDayHold = twoDayHold;
    }

    @Basic
    @Column(name = "total_number_of_debits")
    public String getTotalNumberOfDebits() {
        return totalNumberOfDebits;
    }

    public void setTotalNumberOfDebits(String totalNumberOfDebits) {
        this.totalNumberOfDebits = totalNumberOfDebits;
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
    @Column(name = "total_number_of_credits")
    public String getTotalNumberOfCredits() {
        return totalNumberOfCredits;
    }

    public void setTotalNumberOfCredits(String totalNumberOfCredits) {
        this.totalNumberOfCredits = totalNumberOfCredits;
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
    @Column(name = "account_title")
    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    @Basic
    @Column(name = "b_ds")
    public String getbDs() {
        return bDs;
    }

    public void setbDs(String bDs) {
        this.bDs = bDs;
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
    @Column(name = "closing_book_balance")
    public String getClosingBookBalance() {
        return closingBookBalance;
    }

    public void setClosingBookBalance(String closingBookBalance) {
        this.closingBookBalance = closingBookBalance;
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
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
    @Column(name = "debit_amount")
    public String getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount;
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
    @Column(name = "posting_date")
    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
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

    @Basic
    @Column(name = "statement_detail_value_date")
    public String getStatementDetailValueDate() {
        return statementDetailValueDate;
    }

    public void setStatementDetailValueDate(String statementDetailValueDate) {
        this.statementDetailValueDate = statementDetailValueDate;
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
    @Column(name = "total_credit_count")
    public String getTotalCreditCount() {
        return totalCreditCount;
    }

    public void setTotalCreditCount(String totalCreditCount) {
        this.totalCreditCount = totalCreditCount;
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
    @Column(name = "transaction_type_code")
    public String getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public void setTransactionTypeCode(String transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DbsBankDO that = (DbsBankDO) o;
        return id == that.id &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(businessDate, that.businessDate) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(openingBalance, that.openingBalance) &&
                Objects.equals(ledgerBalance, that.ledgerBalance) &&
                Objects.equals(availableBalance, that.availableBalance) &&
                Objects.equals(overdraftLimit, that.overdraftLimit) &&
                Objects.equals(earmarkAmount, that.earmarkAmount) &&
                Objects.equals(miscellaneousHold, that.miscellaneousHold) &&
                Objects.equals(halfDayHold, that.halfDayHold) &&
                Objects.equals(oneDayHold, that.oneDayHold) &&
                Objects.equals(twoDayHold, that.twoDayHold) &&
                Objects.equals(totalNumberOfDebits, that.totalNumberOfDebits) &&
                Objects.equals(totalDebitAmount, that.totalDebitAmount) &&
                Objects.equals(totalNumberOfCredits, that.totalNumberOfCredits) &&
                Objects.equals(totalCreditAmount, that.totalCreditAmount) &&
                Objects.equals(accountTitle, that.accountTitle) &&
                Objects.equals(bDs, that.bDs) &&
                Objects.equals(closingAvailableBalance, that.closingAvailableBalance) &&
                Objects.equals(closingBookBalance, that.closingBookBalance) &&
                Objects.equals(creditAmount, that.creditAmount) &&
                Objects.equals(date, that.date) &&
                Objects.equals(debitAccountCurrency, that.debitAccountCurrency) &&
                Objects.equals(debitAmount, that.debitAmount) &&
                Objects.equals(holdAmount, that.holdAmount) &&
                Objects.equals(postingDate, that.postingDate) &&
                Objects.equals(statementDate, that.statementDate) &&
                Objects.equals(statementDetailInfoToAccountOwner1, that.statementDetailInfoToAccountOwner1) &&
                Objects.equals(statementDetailInfoToAccountOwner2, that.statementDetailInfoToAccountOwner2) &&
                Objects.equals(statementDetailInfoToAccountOwner3, that.statementDetailInfoToAccountOwner3) &&
                Objects.equals(statementDetailValueDate, that.statementDetailValueDate) &&
                Objects.equals(supplementaryDetails, that.supplementaryDetails) &&
                Objects.equals(totalCreditCount, that.totalCreditCount) &&
                Objects.equals(totalDebitCount, that.totalDebitCount) &&
                Objects.equals(transactionTypeCode, that.transactionTypeCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accountNumber, accountName, productType, businessDate, currency, openingBalance, ledgerBalance, availableBalance, overdraftLimit, earmarkAmount, miscellaneousHold, halfDayHold, oneDayHold, twoDayHold, totalNumberOfDebits, totalDebitAmount, totalNumberOfCredits, totalCreditAmount, accountTitle, bDs, closingAvailableBalance, closingBookBalance, creditAmount, date, debitAccountCurrency, debitAmount, holdAmount, postingDate, statementDate, statementDetailInfoToAccountOwner1, statementDetailInfoToAccountOwner2, statementDetailInfoToAccountOwner3, statementDetailValueDate, supplementaryDetails, totalCreditCount, totalDebitCount, transactionTypeCode);
    }
}
