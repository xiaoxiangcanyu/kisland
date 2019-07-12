package kisland.kislandmain.Service.BankService.Impl;

import kisland.kislandmain.DAO.EconomicConstructionBankDAO;
import kisland.kislandmain.DO.EconomicConstructionBankDO;
import kisland.kislandmain.Service.BankService.EconomicConstructionBankService;
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
public class EconomicConstructionBankServiceImpl implements EconomicConstructionBankService {
    @Autowired
    EconomicConstructionBankDAO economicConstructionBankDAO;


    @Override
    public List<EconomicConstructionBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime) {
        return economicConstructionBankDAO.findByDateAAndAccountTitle(startDateTime,endDateTime,accountTitle);
    }

    @Override
    public List<EconomicConstructionBankDO> findAll() {
        return economicConstructionBankDAO.findAll();
    }



    /**
     * 根据时间段查寻中国建设银行的数据
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<EconomicConstructionBankDO> findByDate(String startTime, String endTime) {
        return economicConstructionBankDAO.findByDate(startTime,endTime);
    }


}
