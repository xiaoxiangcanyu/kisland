package kisland.kislandmain.DAO;

import kisland.kislandmain.DO.BankBalanceDO;
import kisland.kislandmain.DO.EconomicConstructionBankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankBalanceDAO extends JpaRepository<BankBalanceDO,Long> {

    /**
     * 根据时间段和公司名查询余额的数据
     */
    @Query("select a from BankBalanceDO a where a.date between ?1 and ?2 and a.accountName =?3")
    List<BankBalanceDO> findByDate(String startTime, String endTime,String companyName);

    /**
     * 根据时间段查询余额的数据
     */
    @Query("select a from BankBalanceDO a where a.date between ?1 and ?2")
    List<BankBalanceDO> findAllByDate(String startTime, String endTime);


    /**
     * 根据公司名查询当天最新余额
     */
    @Query("select a from BankBalanceDO a where  a.accountName = ?2 and a.date in (select max(b.date) from BankBalanceDO b where b.accountName = ?2 and b.date like %?1% )")
    List<BankBalanceDO> findByLatestDateAndAccountName(String startTime,String companyName);
}
