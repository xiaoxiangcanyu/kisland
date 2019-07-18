package kisland.kislandmain.DAO;

import kisland.kislandmain.DO.AgriculturalBankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AgriculturalBankDAO extends JpaRepository<AgriculturalBankDO,Long> {

    /**
     * 根据公司名和时间称获取银行明细
     * @param accountTitle
     * @return
     */
    @Query("select a from AgriculturalBankDO a where a.accountTitle = ?1")
    List<AgriculturalBankDO> findByAccountTitle(String accountTitle);

    /**
     * 根据时间段查询农行的数据
     */
    @Query("select a from AgriculturalBankDO a where a.date between ?1 and ?2 group by a.transactionTime,a.amountIncome,a.amountCost,a.otherPartyName")
    List<AgriculturalBankDO> findByDate(String startTime,String endTime);

    /**
     * 根据时间段和公司名称查询农行的数据
     */
    @Query("select a from AgriculturalBankDO a where a.accountTitle =?3 and a.date between ?1 and ?2 group by a.date,a.accountTitle,a.accountBalance,a.accountBalance,a.amountCost,a.amountCost,a.amountIncome,a.bankName,a.otherPartyAccount,a.otherPartyName,a.otherPartyProvincesAndCities,a.transactionTime")
    List<AgriculturalBankDO> findByDateAAndAccountTitle(String startTime,String endTime,String accountTitle);
}
