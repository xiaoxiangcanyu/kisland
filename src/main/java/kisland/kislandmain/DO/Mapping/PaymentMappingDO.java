package kisland.kislandmain.DO.Mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_mapping", schema = "kidsland", catalog = "")
public class PaymentMappingDO {
    @Id
    @GeneratedValue
    private long id;
    private String legelmajority;
    private String bankaccount;
    private String banknumber;
    private String expendproject;
    private String otheraccountname;
    private String otheraccount;
    private String tradeabstract;
    private String tradescope;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLegelmajority() {
        return legelmajority;
    }

    public void setLegelmajority(String legelmajority) {
        this.legelmajority = legelmajority;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public String getExpendproject() {
        return expendproject;
    }

    public void setExpendproject(String expendproject) {
        this.expendproject = expendproject;
    }

    public String getOtheraccountname() {
        return otheraccountname;
    }

    public void setOtheraccountname(String otheraccountname) {
        this.otheraccountname = otheraccountname;
    }

    public String getOtheraccount() {
        return otheraccount;
    }

    public void setOtheraccount(String otheraccount) {
        this.otheraccount = otheraccount;
    }

    public String getTradeabstract() {
        return tradeabstract;
    }

    public void setTradeabstract(String tradeabstract) {
        this.tradeabstract = tradeabstract;
    }

    public String getTradescope() {
        return tradescope;
    }

    public void setTradescope(String tradescope) {
        this.tradescope = tradescope;
    }
}
