package kisland.kislandmain.Service.BankService.Impl;

import kisland.kislandmain.DAO.ChinaBankDAO;
import kisland.kislandmain.DO.ChinaBankDO;
import kisland.kislandmain.Service.BankService.ChinaBankService;
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
public class ChinaBankServiceImpl implements ChinaBankService {
    @Autowired
    ChinaBankDAO chinaBankDAO;


    @Override
    public List<ChinaBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime) {

        return chinaBankDAO.findByDateAAndAccountTitle(accountTitle,startDateTime,endDateTime);
    }

    @Override
    public List<ChinaBankDO> findAll() {
        return chinaBankDAO.findAll();
    }

    /**
     * 根据时间段查寻中国银行的数据
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<ChinaBankDO> findByDate(String startTime, String endTime) {
        return chinaBankDAO.findByDate(startTime,endTime);
    }
}
