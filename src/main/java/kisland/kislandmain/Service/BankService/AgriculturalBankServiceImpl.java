package kisland.kislandmain.Service.BankService.Impl;

import kisland.kislandmain.DAO.AgriculturalBankDAO;
import kisland.kislandmain.DO.AgriculturalBankDO;
import kisland.kislandmain.Service.BankService.AgriculturalBankService;
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
public class AgriculturalBankServiceImpl implements AgriculturalBankService {
    @Autowired
    AgriculturalBankDAO agriculturalBankDAO;

    @Override
    public List<AgriculturalBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime) {

        return agriculturalBankDAO.findByDateAAndAccountTitle(startDateTime,endDateTime,accountTitle);
    }

    @Override
    public List<AgriculturalBankDO> findAll() {
        return agriculturalBankDAO.findAll();
    }


    /**
     * 根据时间段查寻农业银行的数据
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<AgriculturalBankDO> findByDate(String startTime, String endTime) {
        return agriculturalBankDAO.findByDate(startTime,endTime);
    }


}
