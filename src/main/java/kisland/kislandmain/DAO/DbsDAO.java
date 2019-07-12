package kisland.kislandmain.DAO;

import kisland.kislandmain.DO.DbsBankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DbsDAO extends JpaRepository<DbsBankDO,Long> {
    /**
     * 根据时间段和公司名称查询农行的数据
     */
    @Query("select a from DbsBankDO a where a.accountTitle =?3 and a.date between ?1 and ?2")
    List<DbsBankDO> findByDateAndAccountTitle(String startTime, String endTime, String accountTitle);
}
