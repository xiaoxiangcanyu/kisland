package kisland.kislandmain.Service.BankService.Impl;

import kisland.kislandmain.DAO.BankBalanceDAO;
import kisland.kislandmain.DO.BankBalanceDO;
import kisland.kislandmain.DO.Mapping.ReceivingMappingDO;
import kisland.kislandmain.Service.BankService.BankBalanceService;
import kisland.kislandmain.Service.Mapping.ReceivingChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static kisland.kislandmain.Util.ClassificationGroupByRegion.SumByYesterdyAndtoday;
import static kisland.kislandmain.Util.OperationBankBalance.getYesterday;

@Transactional
@Service
public class BankBalanceServiceImpl implements BankBalanceService {
    @Autowired
    private BankBalanceDAO bankBalanceDAO;
    @Autowired
    private ReceivingChannelService receivingChannelService;

    @Override
    public Map<String, String> findBankBalanceByDate(String startTime, String endTime) {
        Map<String, String> FinalMap = new HashMap<>();

        //        =================================初始化=======================================
        FinalMap.put("期初可用资金-中区", "0.00");
        FinalMap.put("期初可用资金-总和", "0.00");
        FinalMap.put("期末可用资金-总和", "0.00");
        FinalMap.put("期末可用资金-中区", "0.00");
        FinalMap.put("期末可用资金-凯知乐-凯知乐贸易（天津）有限公司", "0.00");
        FinalMap.put("期初可用资金-凯知乐-凯知乐贸易（天津）有限公司", "0.00");
        FinalMap.put("期初可用资金-北区", "0.00");
        FinalMap.put("期初可用资金-南区", "0.00");
        FinalMap.put("期末可用资金-北区", "0.00");
        FinalMap.put("期末可用资金-南区", "0.00");
        //        =================================初始化=======================================

        String[] vl = new String[]{"北区", "中区", "南区"};
        Set<String> set = new LinkedHashSet<>();
        Map<String, String> YesterdayCompanyMap = new HashMap<>();
        Map<String, String> TodayCompanyMap = new HashMap<>();
        //获取该区域所有公司名称
        for (String scope : vl) {
            List<ReceivingMappingDO> companyList = receivingChannelService.findByTradeScope(scope);
            for (ReceivingMappingDO receivingMappingDO : companyList) {
                set.add(receivingMappingDO.getLegelMajority());
            }
        }
        //获取该区域所有公司名称

        //根据公司名称获取前一天时间段最新时刻的余额列表
        for (String str : set) {
            if (str != null && str.length() > 0) {
                List<BankBalanceDO> bankBalanceDOList = bankBalanceDAO.findByLatestDateAndAccountName(getYesterday(startTime), str);
                if (bankBalanceDOList != null && bankBalanceDOList.size() > 0) {
                    YesterdayCompanyMap.put(str, bankBalanceDOList.get(0).getAccountBalance());
                }
            }
        }
//        //根据公司名称获取前一天时间段最新时刻的余额列表
////
//        //根据公司名称获取当前时间段所有时刻的余额列表
        for (String str : set) {
            if (str != null && str.length() > 0) {
                List<BankBalanceDO> bankBalanceDOList = bankBalanceDAO.findByLatestDateAndAccountName(endTime, str);
                if (bankBalanceDOList != null && bankBalanceDOList.size() > 0) {
                    TodayCompanyMap.put(str, bankBalanceDOList.get(0).getAccountBalance());
                }
            }
        }
//===========================================================期初求和======================================================
        FinalMap = SumByYesterdyAndtoday(FinalMap, YesterdayCompanyMap, "期初可用资金");
////===========================================================期末求和======================================================
        FinalMap = SumByYesterdyAndtoday(FinalMap, TodayCompanyMap, "期末可用资金");

        return FinalMap;
    }

    @Override
    public List<BankBalanceDO> findByDateAndAccountTitle(String startTime, String endTime, String accountTitle) {
        return bankBalanceDAO.findByDate(startTime, endTime, accountTitle);
    }

    @Override
    public List<BankBalanceDO> findAll(String startTime, String endTime) {
        return bankBalanceDAO.findAllByDate(startTime, endTime);
    }
}
