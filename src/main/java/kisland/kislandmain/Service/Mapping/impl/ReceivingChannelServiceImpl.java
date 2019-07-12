package kisland.kislandmain.Service.Mapping.impl;

import kisland.kislandmain.DAO.Mapping.ReceivingChannelMappingDAO;
import kisland.kislandmain.DO.Mapping.ReceivingMappingDO;
import kisland.kislandmain.Service.Mapping.ReceivingChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ReceivingChannelServiceImpl implements ReceivingChannelService{

    @Autowired
    ReceivingChannelMappingDAO receivingChannelMappingDAO;

    @Override
    public List<ReceivingMappingDO> findByTradeScope(String region) {
        return receivingChannelMappingDAO.findByTradeScope(region);
    }

    @Override
    public ReceivingMappingDO findById(long id) {
        Optional<ReceivingMappingDO> receivingMappingDO =  receivingChannelMappingDAO.findById(id);
        return receivingMappingDO.get();
    }

    @Override
    public void AddReceivingMapping(ReceivingMappingDO receivingMappingDO) {
        receivingChannelMappingDAO.save(receivingMappingDO);
    }

    @Override
    public void DeleteReceivingMapping(long id) {
        receivingChannelMappingDAO.deleteById(id);
    }

    @Override
    public void UpdateReceivingMapping(ReceivingMappingDO receivingMappingDO) {
        receivingChannelMappingDAO.save(receivingMappingDO);
    }
}
