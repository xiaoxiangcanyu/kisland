package kisland.kislandmain.DAO;

import kisland.kislandmain.DO.ChinaBankDO;
import kisland.kislandmain.DO.EconomicConstructionBankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EconomicConstructionBankDAO extends JpaRepository<EconomicConstructionBankDO,Long> {
    /**
     * 根据公司名称和时间获取银行明细
     * @param accountTitle
     * @return
     */
    @Query("select a from EconomicConstructionBankDO a where a.accountTitle = ?1")
    List<EconomicConstructionBankDO> findByAccountTitle(String accountTitle);

    /**
     * 根据时间段查询农行的数据
     */
    @Query("select a from EconomicConstructionBankDO a where a.date between ?1 and ?2")
    List<EconomicConstructionBankDO> findByDate(String startTime, String endTime);

    /**
     * 根据时间段和公司名称查询农行的数据
     */
    @Query("select a from EconomicConstructionBankDO a where a.accountTitle =?3 and a.date between ?1 and ?2 group by a.date,a.accountTitle,a.transactionTime")
    List<EconomicConstructionBankDO> findByDateAAndAccountTitle(String startTime,String endTime,String accountTitle);
}
