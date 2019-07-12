package kisland.kislandmain.DAO.Mapping;

import kisland.kislandmain.DO.Mapping.PaymentMappingDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PaymentChannelsMappingDAO extends JpaRepository<PaymentMappingDO,Long> {

    @Query("select p from PaymentMappingDO p where p.tradescope=?1")
    List<PaymentMappingDO> findByTradescope(String region);
}
