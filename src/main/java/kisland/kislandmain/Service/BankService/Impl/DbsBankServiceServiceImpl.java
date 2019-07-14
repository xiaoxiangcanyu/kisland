package kisland.kislandmain.Service.BankService.Impl;

import kisland.kislandmain.DAO.DbsDAO;
import kisland.kislandmain.DO.DbsBankDO;
import kisland.kislandmain.Service.BankService.DbsBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DbsBankServiceServiceImpl implements DbsBankService {
    @Autowired
    private DbsDAO dbsDAO;

    @Override
    public List<DbsBankDO> findByAccountTitleAndDate(String startTime, String endTime, String accountTitle) {
        switch (accountTitle){
            case "凯知乐贸易（天津）有限公司":
                accountTitle = "KIDSLAND TRADING (TIANJIN) CO. LTD.";
                break;
//            case "":
//                break;
//            case "":
//                break;
            default:
                break;
        }
        System.out.println("StartDateTime:"+startTime);
        System.out.println("EndDateTime:"+endTime);
        return dbsDAO.findByDateAndAccountTitle(startTime,endTime,accountTitle);
    }
}
