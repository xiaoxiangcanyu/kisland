package kisland.kislandmain.Service.BankService.Impl;

import com.alibaba.fastjson.JSON;
import kisland.kislandmain.DAO.BankBalanceDAO;
import kisland.kislandmain.DO.BankBalanceDO;
import kisland.kislandmain.DO.Mapping.ReceivingMappingDO;
import kisland.kislandmain.Service.BankService.BankBalanceService;
import kisland.kislandmain.Service.Mapping.ReceivingChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

import static kisland.kislandmain.Util.OperationBankBalance.createGroupByDay;
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
        startTime = startTime + " 00:00:00";
        endTime = endTime + " 24:59:59";
        String[] vl = new String[]{"北区"};
        Set<String> set = new LinkedHashSet<>();
        Map<String, Map<String, String>> YesterdayMap = new HashMap<>();
        Map<String, Map<String, String>> TodayMap = new HashMap<>();
        Map<String, String> YesterdayCompanyMap = new HashMap<>();
        Map<String, String> TodayCompanyMap = new HashMap<>();
        Map<String, String> FinalMap = new HashMap<>();
        Map<String, String> FinalFinalMap = new HashMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

//        ==================================计算各公司在查询时间段的余额查询====================================
        //获取该区域所有公司名称
        for (String scope : vl) {
            List<ReceivingMappingDO> companyList = receivingChannelService.findByTradeScope(scope);
            for (ReceivingMappingDO receivingMappingDO : companyList) {
                set.add(receivingMappingDO.getLegelMajority());
            }
        }
        //获取该区域所有公司名称
        //根据公司名称获取前一天时间段所有时刻的余额列表
        for (String str : set) {
            if (str != null && str.length() > 0) {
                List<BankBalanceDO> list = bankBalanceDAO.findByDate(getYesterday(startTime), getYesterday(endTime), str);
                //获取该公司每天最新余额数据
                try {
                    Map<String, String> map = createGroupByDay(list);
                    YesterdayMap.put(str, map);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        //根据公司名称获取前一天时间段所有时刻的余额列表

        //根据公司名称获取当前时间段所有时刻的余额列表
        for (String str : set) {
            if (str != null && str.length() > 0) {
                List<BankBalanceDO> list = bankBalanceDAO.findByDate(startTime, endTime, str);
                //获取该公司每天最新余额数据
                try {
                    Map<String, String> map = createGroupByDay(list);
                    TodayMap.put(str, map);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        //        ========================================北区的期初受限资金进行累积求和==========================
        for (Map.Entry<String, Map<String, String>> mapEntry : YesterdayMap.entrySet()) {
            Double sum = 0.00;
            for (Map.Entry<String, String> map : mapEntry.getValue().entrySet()) {
                sum = Double.parseDouble(map.getValue().replace(",","")) + sum;
            }
            YesterdayCompanyMap.put(mapEntry.getKey(), decimalFormat.format(sum));
        }
        //        ========================================北区的期初受限资金进行累积求和==========================

//        ========================================北区的期末受限资金进行累积求和==========================
        for (Map.Entry<String, Map<String, String>> mapEntry : TodayMap.entrySet()) {
            Double sum = 0.00;
            for (Map.Entry<String, String> map : mapEntry.getValue().entrySet()) {
                sum = Double.parseDouble(map.getValue().replace(",","")) + sum;
            }
            TodayCompanyMap.put(mapEntry.getKey(), decimalFormat.format(sum));
        }
        //        ========================================北区的期末受限资金进行累积求和==========================

//===============================================凯知乐和北区其他的公司进行期初和期末的求和=================================
//===========================================================期初求和======================================================
        Double YesterdayNorthBalanceAmount = 0.00;
        for (Map.Entry<String, String> entry : YesterdayCompanyMap.entrySet()) {
            if (!entry.getKey().contains("凯知乐")) {
                YesterdayNorthBalanceAmount = YesterdayNorthBalanceAmount+Double.parseDouble(entry.getValue());
            }else {
                FinalMap.put("期初受限资金-"+entry.getKey(),entry.getValue());
            }
            FinalMap.put("期初受限资金-北区",decimalFormat.format(YesterdayNorthBalanceAmount));
        }
//===========================================================期末求和======================================================
        Double TodayNorthBalanceAmount = 0.00;
        for (Map.Entry<String, String> entry : TodayCompanyMap.entrySet()) {
            if (!entry.getKey().contains("凯知乐")) {
                TodayNorthBalanceAmount = TodayNorthBalanceAmount+Double.parseDouble(entry.getValue());
            }else {
                FinalMap.put("期末受限资金-"+entry.getKey(),entry.getValue());
            }
            FinalMap.put("期末受限资金-北区",decimalFormat.format(TodayNorthBalanceAmount));
        }
        Double yesterdaySum = 0.00;
        Double todaySum = 0.00;
        for (Map.Entry<String,String> entry:FinalMap.entrySet()){
            if (entry.getKey().contains("期初受限资金")){
                yesterdaySum =Double.parseDouble(entry.getValue().replace(",",""))+yesterdaySum;
            }else if (entry.getKey().contains("期末受限资金")){
                todaySum =  Double.parseDouble(entry.getValue().replace(",",""))+todaySum;
            }
            FinalFinalMap.put("期初受限资金总和",decimalFormat.format(yesterdaySum));
            FinalFinalMap.put("期末受限资金总和",decimalFormat.format(todaySum));
            FinalFinalMap.put("期初受限资金-凯知乐",FinalMap.get("期初受限资金-凯知乐贸易（天津）有限公司"));
            FinalFinalMap.put("期末受限资金-凯知乐",FinalMap.get("期末受限资金-凯知乐贸易（天津）有限公司"));
            FinalFinalMap.put("期初受限资金-北区",FinalMap.get("期初受限资金-北区"));
            FinalFinalMap.put("期末受限资金-北区",FinalMap.get("期末受限资金-北区"));

        }
//===============================================凯知乐和北区其他的公司进行期初和期末的求和=================================
//        ==================================计算各公司在查询时间段的余额查询====================================
        return FinalFinalMap;
    }

    @Override
    public List<BankBalanceDO> findByDateAndAccountTitle(String startTime, String endTime,String accountTitle) {
        return bankBalanceDAO.findByDate(startTime,endTime,accountTitle);
    }

    @Override
    public List<BankBalanceDO> findAll(String startTime, String endTime) {
        return bankBalanceDAO.findAllByDate(startTime,endTime);
    }
}
