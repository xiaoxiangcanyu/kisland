package kisland.kislandmain.DAO.IncomeAndCharge;

import kisland.kislandmain.DO.IncomeCategoryDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * 收款表的DAO层
 */
@Transactional
public interface IncomeCategoryDAO extends JpaRepository<IncomeCategoryDO,Long> {
    //删除收款渠道
    @Modifying
    @Query("delete from IncomeCategoryDO i where i.id=?1")
    void deleteById(int id);
}
