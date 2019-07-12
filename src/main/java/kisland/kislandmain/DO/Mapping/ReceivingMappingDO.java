package kisland.kislandmain.DO.Mapping;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "receiving_mapping", schema = "kidsland", catalog = "")
public class ReceivingMappingDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String legelMajority;
    private String bankAccount;
    private String bankNumber;
    private String otherAccountName;
    private String tradeAbstract;
    private String receivingChannel;
    private String tradeScope;

    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "legel_majority")
    public String getLegelMajority() {
        return legelMajority;
    }

    public void setLegelMajority(String legelMajority) {
        this.legelMajority = legelMajority;
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
    @Column(name = "bank_number")
    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    @Basic
    @Column(name = "other_account_name")
    public String getOtherAccountName() {
        return otherAccountName;
    }

    public void setOtherAccountName(String otherAccountName) {
        this.otherAccountName = otherAccountName;
    }

    @Basic
    @Column(name = "trade_abstract")
    public String getTradeAbstract() {
        return tradeAbstract;
    }

    public void setTradeAbstract(String tradeAbstract) {
        this.tradeAbstract = tradeAbstract;
    }

    @Basic
    @Column(name = "receiving_channel")
    public String getReceivingChannel() {
        return receivingChannel;
    }

    public void setReceivingChannel(String receivingChannel) {
        this.receivingChannel = receivingChannel;
    }

    @Basic
    @Column(name = "trade_scope")
    public String getTradeScope() {
        return tradeScope;
    }

    public void setTradeScope(String tradeScope) {
        this.tradeScope = tradeScope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceivingMappingDO that = (ReceivingMappingDO) o;
        return id == that.id &&
                Objects.equals(legelMajority, that.legelMajority) &&
                Objects.equals(bankAccount, that.bankAccount) &&
                Objects.equals(bankNumber, that.bankNumber) &&
                Objects.equals(otherAccountName, that.otherAccountName) &&
                Objects.equals(tradeAbstract, that.tradeAbstract) &&
                Objects.equals(receivingChannel, that.receivingChannel) &&
                Objects.equals(tradeScope, that.tradeScope);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, legelMajority, bankAccount, bankNumber, otherAccountName, tradeAbstract, receivingChannel);
    }
}
