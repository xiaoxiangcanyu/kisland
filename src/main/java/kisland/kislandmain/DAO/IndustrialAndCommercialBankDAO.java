package kisland.kislandmain.DAO;

import kisland.kislandmain.DO.ChinaBankDO;
import kisland.kislandmain.DO.IndustrialAndCommercialBankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IndustrialAndCommercialBankDAO extends JpaRepository<IndustrialAndCommercialBankDO,Long> {
    /**
     * 根据公司名称和时间获取银行明细
     * @param accountTitle
     * @return
     */
    @Query("select a from IndustrialAndCommercialBankDO a where a.accountTitle = ?1 ")
    List<IndustrialAndCommercialBankDO> findByAccountTitle(String accountTitle);

    /**
     * 根据时间段查询农行的数据
     */
    @Query("select a from IndustrialAndCommercialBankDO a where a.date between ?1 and ?2")
    List<IndustrialAndCommercialBankDO> findByDate(String startTime, String endTime);

    /**
     * 根据时间段和公司名称查询农行的数据
     */
    @Query("select a from IndustrialAndCommercialBankDO a where a.accountTitle =?3 and a.date between ?1 and ?2 group by a.date,a.accountTitle,a.transactionTime")
    List<IndustrialAndCommercialBankDO> findByDateAAndAccountTitle(String startTime,String endTime,String accountTitle);
}
