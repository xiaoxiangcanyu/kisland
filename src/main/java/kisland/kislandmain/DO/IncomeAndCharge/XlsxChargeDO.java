package kisland.kislandmain.DO.IncomeAndCharge;

/**
 * Excel的付款信息实体类
 */
public class XlsxChargeDO {
    private String LegalSubject;//法律主体
    private String BankName;//银行账户
    private String BankAccount;//银行账号
    private String OtherBankName;//对方账户
    private String OtherBankAccount;//对方银行账号
    private String OutputChannel;//售货渠道

    public String getLegalSubject() {
        return LegalSubject;
    }

    public void setLegalSubject(String legalSubject) {
        LegalSubject = legalSubject;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getBankAccount() {
        return BankAccount;
    }

    public void setBankAccount(String bankAccount) {
        BankAccount = bankAccount;
    }

    public String getOtherBankName() {
        return OtherBankName;
    }

    public void setOtherBankName(String otherBankName) {
        OtherBankName = otherBankName;
    }

    public String getOtherBankAccount() {
        return OtherBankAccount;
    }

    public void setOtherBankAccount(String otherBankAccount) {
        OtherBankAccount = otherBankAccount;
    }

    public String getOutputChannel() {
        return OutputChannel;
    }

    public void setOutputChannel(String outputChannel) {
        OutputChannel = outputChannel;
    }
}
