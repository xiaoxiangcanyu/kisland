package kisland.kislandmain.DAO;

import kisland.kislandmain.DO.DbsBankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DbsDAO extends JpaRepository<DbsBankDO,Long> {
    /**
     * 根据时间段和公司名称查询农行的数据
     */
    @Query("select a from DbsBankDO a where a.accountName=?3 and a.businessDate between ?1 and ?2 group by a.accountNumber,a.accountName,a.date,a.businessDate,a.currency")
    List<DbsBankDO> findByDateAndAccountTitle(String startTime, String endTime, String accountTitle);
}
