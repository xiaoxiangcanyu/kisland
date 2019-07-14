package kisland.kislandmain.Service.BankService;

import kisland.kislandmain.DO.DbsBankDO;

import java.util.List;

public interface DbsBankService {

    //根据时间段和银行账户名来查询星展银行的数据
    List<DbsBankDO> findByAccountTitleAndDate(String startTime, String endTime,String accountTitle);
}
