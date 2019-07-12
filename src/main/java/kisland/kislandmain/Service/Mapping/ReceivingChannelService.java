package kisland.kislandmain.Service.Mapping;

import kisland.kislandmain.DO.Mapping.ReceivingMappingDO;

import java.util.List;

/**
 * 收款Mapping的业务层
 */
public interface ReceivingChannelService {

    //查询所有的收款渠道
    List<ReceivingMappingDO> findByTradeScope(String region);
    //根据id查询单条mapping数据
    ReceivingMappingDO findById(long id);
    //增加收款mapping
    void AddReceivingMapping(ReceivingMappingDO receivingMappingDO);
    //删除收款mapping
    void DeleteReceivingMapping(long id);
    //更改收款mapping
    void UpdateReceivingMapping(ReceivingMappingDO receivingMappingDO);
}
