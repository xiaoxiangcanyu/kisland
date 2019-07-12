package kisland.kislandmain.DO.StatisticsData;

public class MatchedDO {
    private String accountTitle;
    private String otherPartyName;
    private String date;
    private String amountIncome;
    private String amountCost;
    private String incomePath;

    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public String getIncomePath() {
        return incomePath;
    }

    public void setIncomePath(String incomePath) {
        this.incomePath = incomePath;
    }

    public String getOtherPartyName() {
        return otherPartyName;
    }

    public void setOtherPartyName(String otherPartyName) {
        this.otherPartyName = otherPartyName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmountIncome() {
        return amountIncome;
    }

    public void setAmountIncome(String amountIncome) {
        this.amountIncome = amountIncome;
    }

    public String getAmountCost() {
        return amountCost;
    }

    public void setAmountCost(String amountCost) {
        this.amountCost = amountCost;
    }
}
