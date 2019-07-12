package kisland.kislandmain.DAO.IncomeAndCharge;

import kisland.kislandmain.DO.ChargeCategoryDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * 付款表的DAO层
 */
@Transactional
public interface ChargeCategoryDAO extends JpaRepository<ChargeCategoryDO,Long> {
    //增加收款渠道
    @Modifying
    @Query("delete from ChargeCategoryDO c where c.id=?1")
    void deleteById(int id);
}
