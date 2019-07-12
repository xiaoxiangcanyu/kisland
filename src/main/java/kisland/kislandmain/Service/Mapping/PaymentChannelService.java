package kisland.kislandmain.Service.Mapping;

import kisland.kislandmain.DO.Mapping.PaymentMappingDO;

import java.util.List;

/**
 * 付款Mapping的业务层
 */
public interface PaymentChannelService {
    //查询所有的付款渠道
    List<PaymentMappingDO> findByTradescope(String region);
    //根据id查询付款mapping
    PaymentMappingDO FindById(long id);
    //根据id删除mapping数据
    void DeleteById(long id);
    //添加新的mapping数据
    void AddPaymentMapping(PaymentMappingDO paymentMappingDO);
    //修改新的mapping数据
    void UpdatePaymentMapping(PaymentMappingDO paymentMappingDO);
}
