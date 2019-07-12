package kisland.kislandmain.Service.Mapping.impl;

import kisland.kislandmain.DAO.Mapping.PaymentChannelsMappingDAO;
import kisland.kislandmain.DO.Mapping.PaymentMappingDO;
import kisland.kislandmain.Service.Mapping.PaymentChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PaymentChannelServiceImpl implements PaymentChannelService {
    @Autowired
    PaymentChannelsMappingDAO paymentChannelsMappingDAO;


    @Override
    public List<PaymentMappingDO> findByTradescope(String region) {
        return paymentChannelsMappingDAO.findByTradescope(region);
    }

    @Override
    public PaymentMappingDO FindById(long id) {
        return paymentChannelsMappingDAO.findById(id).get();
    }

    @Override
    public void DeleteById(long id) {
        paymentChannelsMappingDAO.deleteById(id);
    }

    @Override
    public void AddPaymentMapping(PaymentMappingDO paymentMappingDO) {
        paymentChannelsMappingDAO.save(paymentMappingDO);
    }

    @Override
    public void UpdatePaymentMapping(PaymentMappingDO paymentMappingDO) {
        paymentChannelsMappingDAO.save(paymentMappingDO);
    }
}
