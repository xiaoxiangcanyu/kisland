package kisland.kislandmain.Service.BankService.Impl;

import kisland.kislandmain.DAO.IndustrialAndCommercialBankDAO;
import kisland.kislandmain.DO.IndustrialAndCommercialBankDO;
import kisland.kislandmain.Service.BankService.IndustrialAndCommercialBankService;
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
public class IndustrialAndCommercialBankServiceImpl implements IndustrialAndCommercialBankService {
    @Autowired
    IndustrialAndCommercialBankDAO industrialAndCommercialBankDAO;


    @Override
    public List<IndustrialAndCommercialBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime) {

        return industrialAndCommercialBankDAO.findByDateAAndAccountTitle(startDateTime,endDateTime,accountTitle);
    }

    @Override
    public List<IndustrialAndCommercialBankDO> findAll() {
        return industrialAndCommercialBankDAO.findAll();
    }

    /**
     * 根据时间段查寻工商银行的数据
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<IndustrialAndCommercialBankDO> findByDate(String startTime, String endTime) {
        return industrialAndCommercialBankDAO.findByDate(startTime,endTime);
    }
}
