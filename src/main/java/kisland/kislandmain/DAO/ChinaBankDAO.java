package kisland.kislandmain.DAO;

import kisland.kislandmain.DO.AgriculturalBankDO;
import kisland.kislandmain.DO.ChinaBankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ChinaBankDAO extends JpaRepository<ChinaBankDO,Long> {
    /**
     * 根据公司名称和时间获取银行明细
     * @param accountTitle
     * @return
     */
    @Query("select a from ChinaBankDO a where a.accountTitle = ?1")
    List<ChinaBankDO> findByAccountTitle(String accountTitle);
    /**
     * 根据时间段查询农行的数据
     */
    @Query("select a from ChinaBankDO a where a.date between ?1 and ?2 group by a.date,a.accountTitle,a.transactionTime")
    List<ChinaBankDO> findByDate(String startTime, String endTime);
    /**
     * 根据时间段和公司名称查询农行的数据
     */
    @Query("select a from ChinaBankDO a where a.accountTitle =?3 and a.date between ?1 and ?2 group by a.date,a.accountTitle,a.transactionTime")
    List<ChinaBankDO> findByDateAAndAccountTitle(String startTime,String endTime,String accountTitle);
}
