package kisland.kislandmain.DO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "merchants_bank", schema = "kidsland", catalog = "")
public class MerchantsBankDO {
    private int id;
    private String transactionDay;
    private String transactionHour;
    private String interestDate;
    private String transactionType;
    private String debitAmount;
    private String creditAmount;
    private String balance;
    private String bankAbstract;
    private String serialNumber;
    private String processExampleNumber;
    private String businessName;
    private String purpose;
    private String businessReferenceNumber;
    private String businessAbstract;
    private String otherAbstract;
    private String payerPayeeBranchname;
    private String payerPayeeName;
    private String payerPayeeAccount;
    private String payerPayeeOpeningbanknumber;
    private String payerPayeeOpeningbankname;
    private String payerPayeeOpeningbankaddress;
    private String parentSubsidiaryBranchname;
    private String parentSubsidiaryAccount;
    private String parentSubsidiaryName;
    private String informationSigns;
    private String attachmentInformation;
    private String rushMark;
    private String extendedAbstract;
    private String transactionAnalysisCode;
    private String billingNumber;
    private String businessPaymentOrdernumber;
    private String internalNumber;
    private String bDs;
    private String date;
    private String accountTitle;
    private String payerPayeeAccountnumber;
    private String payerPayeeBankname;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "transaction_day")
    public String getTransactionDay() {
        return transactionDay;
    }

    public void setTransactionDay(String transactionDay) {
        this.transactionDay = transactionDay;
    }

    @Basic
    @Column(name = "transaction_hour")
    public String getTransactionHour() {
        return transactionHour;
    }

    public void setTransactionHour(String transactionHour) {
        this.transactionHour = transactionHour;
    }

    @Basic
    @Column(name = "interest_date")
    public String getInterestDate() {
        return interestDate;
    }

    public void setInterestDate(String interestDate) {
        this.interestDate = interestDate;
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
    @Column(name = "balance")
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
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
    @Column(name = "serial_number")
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "process_example_number")
    public String getProcessExampleNumber() {
        return processExampleNumber;
    }

    public void setProcessExampleNumber(String processExampleNumber) {
        this.processExampleNumber = processExampleNumber;
    }

    @Basic
    @Column(name = "business_name")
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
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
    @Column(name = "business_reference_number")
    public String getBusinessReferenceNumber() {
        return businessReferenceNumber;
    }

    public void setBusinessReferenceNumber(String businessReferenceNumber) {
        this.businessReferenceNumber = businessReferenceNumber;
    }

    @Basic
    @Column(name = "business_abstract")
    public String getBusinessAbstract() {
        return businessAbstract;
    }

    public void setBusinessAbstract(String businessAbstract) {
        this.businessAbstract = businessAbstract;
    }

    @Basic
    @Column(name = "other_abstract")
    public String getOtherAbstract() {
        return otherAbstract;
    }

    public void setOtherAbstract(String otherAbstract) {
        this.otherAbstract = otherAbstract;
    }

    @Basic
    @Column(name = "payer_payee_branchname")
    public String getPayerPayeeBranchname() {
        return payerPayeeBranchname;
    }

    public void setPayerPayeeBranchname(String payerPayeeBranchname) {
        this.payerPayeeBranchname = payerPayeeBranchname;
    }

    @Basic
    @Column(name = "payer_payee_name")
    public String getPayerPayeeName() {
        return payerPayeeName;
    }

    public void setPayerPayeeName(String payerPayeeName) {
        this.payerPayeeName = payerPayeeName;
    }

    @Basic
    @Column(name = "payer_payee_account")
    public String getPayerPayeeAccount() {
        return payerPayeeAccount;
    }

    public void setPayerPayeeAccount(String payerPayeeAccount) {
        this.payerPayeeAccount = payerPayeeAccount;
    }

    @Basic
    @Column(name = "payer_payee_openingbanknumber")
    public String getPayerPayeeOpeningbanknumber() {
        return payerPayeeOpeningbanknumber;
    }

    public void setPayerPayeeOpeningbanknumber(String payerPayeeOpeningbanknumber) {
        this.payerPayeeOpeningbanknumber = payerPayeeOpeningbanknumber;
    }

    @Basic
    @Column(name = "payer_payee_openingbankname")
    public String getPayerPayeeOpeningbankname() {
        return payerPayeeOpeningbankname;
    }

    public void setPayerPayeeOpeningbankname(String payerPayeeOpeningbankname) {
        this.payerPayeeOpeningbankname = payerPayeeOpeningbankname;
    }

    @Basic
    @Column(name = "payer_payee_openingbankaddress")
    public String getPayerPayeeOpeningbankaddress() {
        return payerPayeeOpeningbankaddress;
    }

    public void setPayerPayeeOpeningbankaddress(String payerPayeeOpeningbankaddress) {
        this.payerPayeeOpeningbankaddress = payerPayeeOpeningbankaddress;
    }

    @Basic
    @Column(name = "parent_subsidiary_branchname")
    public String getParentSubsidiaryBranchname() {
        return parentSubsidiaryBranchname;
    }

    public void setParentSubsidiaryBranchname(String parentSubsidiaryBranchname) {
        this.parentSubsidiaryBranchname = parentSubsidiaryBranchname;
    }

    @Basic
    @Column(name = "parent_subsidiary_account")
    public String getParentSubsidiaryAccount() {
        return parentSubsidiaryAccount;
    }

    public void setParentSubsidiaryAccount(String parentSubsidiaryAccount) {
        this.parentSubsidiaryAccount = parentSubsidiaryAccount;
    }

    @Basic
    @Column(name = "parent_subsidiary_name")
    public String getParentSubsidiaryName() {
        return parentSubsidiaryName;
    }

    public void setParentSubsidiaryName(String parentSubsidiaryName) {
        this.parentSubsidiaryName = parentSubsidiaryName;
    }

    @Basic
    @Column(name = "information_signs")
    public String getInformationSigns() {
        return informationSigns;
    }

    public void setInformationSigns(String informationSigns) {
        this.informationSigns = informationSigns;
    }

    @Basic
    @Column(name = "attachment_information")
    public String getAttachmentInformation() {
        return attachmentInformation;
    }

    public void setAttachmentInformation(String attachmentInformation) {
        this.attachmentInformation = attachmentInformation;
    }

    @Basic
    @Column(name = "rush_mark")
    public String getRushMark() {
        return rushMark;
    }

    public void setRushMark(String rushMark) {
        this.rushMark = rushMark;
    }

    @Basic
    @Column(name = "extended_abstract")
    public String getExtendedAbstract() {
        return extendedAbstract;
    }

    public void setExtendedAbstract(String extendedAbstract) {
        this.extendedAbstract = extendedAbstract;
    }

    @Basic
    @Column(name = "transaction_analysis_code")
    public String getTransactionAnalysisCode() {
        return transactionAnalysisCode;
    }

    public void setTransactionAnalysisCode(String transactionAnalysisCode) {
        this.transactionAnalysisCode = transactionAnalysisCode;
    }

    @Basic
    @Column(name = "billing_number")
    public String getBillingNumber() {
        return billingNumber;
    }

    public void setBillingNumber(String billingNumber) {
        this.billingNumber = billingNumber;
    }

    @Basic
    @Column(name = "business_payment_ordernumber")
    public String getBusinessPaymentOrdernumber() {
        return businessPaymentOrdernumber;
    }

    public void setBusinessPaymentOrdernumber(String businessPaymentOrdernumber) {
        this.businessPaymentOrdernumber = businessPaymentOrdernumber;
    }

    @Basic
    @Column(name = "internal_number")
    public String getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(String internalNumber) {
        this.internalNumber = internalNumber;
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
    @Column(name = "payer_payee_accountnumber")
    public String getPayerPayeeAccountnumber() {
        return payerPayeeAccountnumber;
    }

    public void setPayerPayeeAccountnumber(String payerPayeeAccountnumber) {
        this.payerPayeeAccountnumber = payerPayeeAccountnumber;
    }

    @Basic
    @Column(name = "payer_payee_bankname")
    public String getPayerPayeeBankname() {
        return payerPayeeBankname;
    }

    public void setPayerPayeeBankname(String payerPayeeBankname) {
        this.payerPayeeBankname = payerPayeeBankname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchantsBankDO that = (MerchantsBankDO) o;
        return id == that.id &&
                Objects.equals(transactionDay, that.transactionDay) &&
                Objects.equals(transactionHour, that.transactionHour) &&
                Objects.equals(interestDate, that.interestDate) &&
                Objects.equals(transactionType, that.transactionType) &&
                Objects.equals(debitAmount, that.debitAmount) &&
                Objects.equals(creditAmount, that.creditAmount) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(bankAbstract, that.bankAbstract) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(processExampleNumber, that.processExampleNumber) &&
                Objects.equals(businessName, that.businessName) &&
                Objects.equals(purpose, that.purpose) &&
                Objects.equals(businessReferenceNumber, that.businessReferenceNumber) &&
                Objects.equals(businessAbstract, that.businessAbstract) &&
                Objects.equals(otherAbstract, that.otherAbstract) &&
                Objects.equals(payerPayeeBranchname, that.payerPayeeBranchname) &&
                Objects.equals(payerPayeeName, that.payerPayeeName) &&
                Objects.equals(payerPayeeAccount, that.payerPayeeAccount) &&
                Objects.equals(payerPayeeOpeningbanknumber, that.payerPayeeOpeningbanknumber) &&
                Objects.equals(payerPayeeOpeningbankname, that.payerPayeeOpeningbankname) &&
                Objects.equals(payerPayeeOpeningbankaddress, that.payerPayeeOpeningbankaddress) &&
                Objects.equals(parentSubsidiaryBranchname, that.parentSubsidiaryBranchname) &&
                Objects.equals(parentSubsidiaryAccount, that.parentSubsidiaryAccount) &&
                Objects.equals(parentSubsidiaryName, that.parentSubsidiaryName) &&
                Objects.equals(informationSigns, that.informationSigns) &&
                Objects.equals(attachmentInformation, that.attachmentInformation) &&
                Objects.equals(rushMark, that.rushMark) &&
                Objects.equals(extendedAbstract, that.extendedAbstract) &&
                Objects.equals(transactionAnalysisCode, that.transactionAnalysisCode) &&
                Objects.equals(billingNumber, that.billingNumber) &&
                Objects.equals(businessPaymentOrdernumber, that.businessPaymentOrdernumber) &&
                Objects.equals(internalNumber, that.internalNumber) &&
                Objects.equals(bDs, that.bDs) &&
                Objects.equals(date, that.date) &&
                Objects.equals(accountTitle, that.accountTitle) &&
                Objects.equals(payerPayeeAccountnumber, that.payerPayeeAccountnumber) &&
                Objects.equals(payerPayeeBankname, that.payerPayeeBankname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, transactionDay, transactionHour, interestDate, transactionType, debitAmount, creditAmount, balance, bankAbstract, serialNumber, processExampleNumber, businessName, purpose, businessReferenceNumber, businessAbstract, otherAbstract, payerPayeeBranchname, payerPayeeName, payerPayeeAccount, payerPayeeOpeningbanknumber, payerPayeeOpeningbankname, payerPayeeOpeningbankaddress, parentSubsidiaryBranchname, parentSubsidiaryAccount, parentSubsidiaryName, informationSigns, attachmentInformation, rushMark, extendedAbstract, transactionAnalysisCode, billingNumber, businessPaymentOrdernumber, internalNumber, bDs, date, accountTitle, payerPayeeAccountnumber, payerPayeeBankname);
    }
}
