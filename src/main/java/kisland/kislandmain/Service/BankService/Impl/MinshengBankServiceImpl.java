package kisland.kislandmain.Service.BankService.Impl;

import kisland.kislandmain.DAO.MinshengBankDAO;
import kisland.kislandmain.DO.MinshengBankDO;
import kisland.kislandmain.Service.BankService.MinshengBankService;
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
public class MinshengBankServiceImpl implements MinshengBankService {
    @Autowired
    MinshengBankDAO minshengBankDAO;


    @Override
    public List<MinshengBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime) {
        return minshengBankDAO.findByDateAAndAccountTitle(startDateTime,endDateTime,accountTitle);
    }

    @Override
    public List<MinshengBankDO> findAll() {
        return minshengBankDAO.findAll();
    }

    /**
     * 根据时间段查寻民生银行的数据
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<MinshengBankDO> findByDate(String startTime, String endTime) {
        return minshengBankDAO.findByDate(startTime,endTime);
    }
}
