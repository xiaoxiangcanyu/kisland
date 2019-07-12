package kisland.kislandmain.DAO.Mapping;

import kisland.kislandmain.DO.Mapping.ReceivingMappingDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ReceivingChannelMappingDAO extends JpaRepository<ReceivingMappingDO,Long> {

    @Query("select r from ReceivingMappingDO r where r.tradeScope = ?1")
    List<ReceivingMappingDO> findByTradeScope(String region);


}
