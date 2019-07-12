package kisland.kislandmain.Service.BankService;

import kisland.kislandmain.DO.BankBalanceDO;

import java.util.List;
import java.util.Map;

/**
 * 期初受限资金和期末受限资金统计
 */
public interface BankBalanceService {

    //根据时间段查询期初可用资金合计和期末可用资金合计
    Map<String,String> findBankBalanceByDate(String startTime, String endTime);

    //根据时间段和公司名称查询
    List<BankBalanceDO> findByDateAndAccountTitle(String startTime,String endTime,String accountTitle);

    //查询所有的余额
    List<BankBalanceDO> findAll(String startTime, String endTime);
}
