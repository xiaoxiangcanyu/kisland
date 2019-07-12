package kisland.kislandmain.Service.BankService.Impl;

import kisland.kislandmain.DAO.MerchantsBankDAO;
import kisland.kislandmain.DO.MerchantsBankDO;
import kisland.kislandmain.Service.BankService.MerchantsBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Transactional
@Service
public class MerchantsBankServiceImpl implements MerchantsBankService {
    @Autowired
    MerchantsBankDAO merchantsBankDAO;


    @Override
    public List<MerchantsBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime) {

        return merchantsBankDAO.findByDateAAndAccountTitle(startDateTime,endDateTime,accountTitle);
    }

    @Override
    public List<MerchantsBankDO> findAll() {
        return merchantsBankDAO.findAll();
    }

    /**
     * 根据时间段查寻招商银行的数据
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<MerchantsBankDO> findByDate(String startTime, String endTime) {
        return merchantsBankDAO.findByDate(startTime,endTime);
    }
}
