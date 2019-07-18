package kisland.kislandmain.Controller;

import com.alibaba.fastjson.JSON;
import kisland.kislandmain.DO.*;
import kisland.kislandmain.Service.BankService.*;
import kisland.kislandmain.Service.Income.IncomeService;
import kisland.kislandmain.Service.North.NorthIncomeAndChargeService;
import kisland.kislandmain.Service.charge.ChargeService;
import kisland.kislandmain.Util.ClearZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    AgriculturalBankService agriculturalBankService;
    @Autowired
    ChinaBankService chinaBankService;
    @Autowired
    EconomicConstructionBankService economicConstructionBankService;
    @Autowired
    IndustrialAndCommercialBankService industrialAndCommercialBankService;
    @Autowired
    MerchantsBankService merchantsBankService;
    @Autowired
    MinshengBankService minshengBankService;
    @Autowired
    DbsBankService dbsBankService;
    @Autowired
    IncomeService incomeService;
    @Autowired
    ChargeService chargeService;
    @Autowired
    NorthIncomeAndChargeService northIncomeAndChargeService;
    @Autowired
    BankBalanceService bankBalanceService;
    @Autowired
    ClearZero clearZero;
    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/main")
    public String index(){
        return "index";
    }

    /**
     * 获取资金日报表的统计量
     * @return
     */
    @RequestMapping(value = "/CapitalStatisticsList")
    @ResponseBody
    Map<String,String> findCapitalStatisticsList(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime){
        Map<String,String> finalMap = new HashMap<>();
        Map<String,String> IncomeMap = incomeService.CombineAllIncome(startTime,endTime);
        Map<String,String> ChargeMap = chargeService.CombineAllCharge(startTime,endTime);
        finalMap.putAll(IncomeMap);
        finalMap.putAll(ChargeMap);
        clearZero.ClearIncomeZeroMethod();
        clearZero.ClearChargeZeroMethod();
        //============================================查询期初受限资金和期末受限资金==========================================================
        Map<String, String> BalanceMap = bankBalanceService.findBankBalanceByDate(startTime,endTime);
        //==================================================封装以上3项==========================================================
        finalMap.putAll(BalanceMap);
        return finalMap;
    }

    /**
     * 添加收款种类
     * @param categoryname
     * @return
     */
    @RequestMapping(value = "/AddIncomeCategory")
    @ResponseBody
    public  Map<String, String> AddIncomeCategory(@RequestParam(value = "categoryname") String categoryname){
        Map<String, String> map = new HashMap<>();
        IncomeCategoryDO incomeCategoryDO = new IncomeCategoryDO();
        incomeCategoryDO.setCategoryName(categoryname);
        incomeService.AddIncomeCategory(incomeCategoryDO);
        map.put("result","success");
        return map;
    }
//
    /**
     * 根据id删除收款种类
     * @param id
     * @return
     */
    @RequestMapping(value = "/DeleteIncomeCategory")
    @ResponseBody
    public Map<String,String> DeleteIncomeCategory(@RequestParam(value = "Id") int id){
        Map<String,String> map = new HashMap<>();
        incomeService.DeleteIncomeCategory(id);
        map.put("result","success");
        return  map;
    }
    /**
     * 添加收款种类
     * @param categoryname
     * @return
     */
    @RequestMapping(value = "/AddChargeCategory")
    @ResponseBody
    public Map<String,String> AddChargeCategory(@RequestParam(value = "categoryname") String categoryname){
        Map<String,String> map = new HashMap<>();
        ChargeCategoryDO chargeCategoryDO = new ChargeCategoryDO();
        chargeCategoryDO.setCategoryName(categoryname);
        chargeService.AddChargeCategory(chargeCategoryDO);
        map.put("result","success");
        return map;
    }

    /**
     * 根据id删除收款种类
     * @param id
     * @return
     */
    @RequestMapping(value = "/DeleteChargeCategory")
    @ResponseBody
    public Map<String,String> DeleteChargeCategory(@RequestParam(value = "Id") int id){
        Map<String,String> map = new HashMap<>();
        chargeService.DeleteChargeCategory(id);
        map.put("result","success");
        return map;
    }
    /**
     * 根据公司名称查询中国银行数据
     * @param AccountTitle
     * @return
     */
    @RequestMapping(value = "/findChinaBankByAccountTitleAndDate")
    @ResponseBody
    List<ChinaBankDO> findChinaBankByAccountTitleAndDate(@RequestParam(value = "AccountTitle") String AccountTitle, @RequestParam(value = "StartDateTime") String StartDateTime, @RequestParam(value = "EndDateTime") String EndDateTime){
        return chinaBankService.findByAccountTitleAndDatetime(StartDateTime,EndDateTime,AccountTitle);
    }
    /**
     * 根据公司名称查询中国农业银行数据
     * @param AccountTitle
     * @return
     */
    @RequestMapping(value = "/findAgriculturalBankByAccountTitleAndDate")
    @ResponseBody
    List<AgriculturalBankDO> findAgriculturalBankByAccountTitleAndDate(@RequestParam(value = "AccountTitle") String AccountTitle, @RequestParam(value = "StartDateTime") String StartDateTime, @RequestParam(value = "EndDateTime") String EndDateTime){
        return agriculturalBankService.findByAccountTitleAndDatetime(AccountTitle,StartDateTime,EndDateTime);
    }
    /**
     * 根据公司名称查询中国建设银行数据
     * @param AccountTitle
     * @return
     */
    @RequestMapping(value = "/findEconomicConstructionBankByAccountTitleAndDate")
    @ResponseBody
    List<EconomicConstructionBankDO> findEconomicConstructionBankByAccountTitleAndDate(@RequestParam(value = "AccountTitle") String AccountTitle, @RequestParam(value = "StartDateTime") String StartDateTime, @RequestParam(value = "EndDateTime") String EndDateTime){
        System.out.println(JSON.toJSONString(economicConstructionBankService.findByAccountTitleAndDatetime(AccountTitle,StartDateTime,EndDateTime)));
        System.out.println(AccountTitle);
        return economicConstructionBankService.findByAccountTitleAndDatetime(AccountTitle,StartDateTime,EndDateTime);
    }
    /**
     * 根据公司名称查询中国工商银行数据
     * @param AccountTitle
     * @return
     */
    @RequestMapping(value = "/findIndustrialAndCommercialBankByAccountTitleAndDate")
    @ResponseBody
    List<IndustrialAndCommercialBankDO> findIndustrialAndCommercialBankByAccountTitleAndDate(@RequestParam(value = "AccountTitle") String AccountTitle, @RequestParam(value = "StartDateTime") String StartDateTime, @RequestParam(value = "EndDateTime") String EndDateTime){
        System.out.println(AccountTitle);
        return industrialAndCommercialBankService.findByAccountTitleAndDatetime(AccountTitle,StartDateTime,EndDateTime);
    }
    /**
     * 根据公司名称查询中国民生银行数据
     * @param AccountTitle
     * @return
     */
    @RequestMapping(value = "/findMinshengBankByAccountTitleAndDate")
    @ResponseBody
    List<MinshengBankDO> findMinshengBankByAccountTitleAndDate(@RequestParam(value = "AccountTitle") String AccountTitle, @RequestParam(value = "StartDateTime") String StartDateTime, @RequestParam(value = "EndDateTime") String EndDateTime){
        return minshengBankService.findByAccountTitleAndDatetime(AccountTitle,StartDateTime,EndDateTime);
    }
    /**
     * 根据公司名称查询中国招商银行数据
     * @param AccountTitle
     * @return
     */
    @RequestMapping(value = "/findMerchantsBankByAccountTitleAndDate")
    @ResponseBody
    List<MerchantsBankDO> findMerchantsBankByAccountTitleAndDate(@RequestParam(value = "AccountTitle") String AccountTitle, @RequestParam(value = "StartDateTime") String StartDateTime, @RequestParam(value = "EndDateTime") String EndDateTime){
        return merchantsBankService.findByAccountTitleAndDatetime(StartDateTime,EndDateTime,AccountTitle);
    }

    @RequestMapping(value = "findDbsBankByAccountTitleAndDate")
    @ResponseBody
    List<DbsBankDO> findDbsBankByAccountTitleAndDate(@RequestParam(value = "AccountTitle") String AccountTitle, @RequestParam(value = "StartDateTime") String StartDateTime, @RequestParam(value = "EndDateTime") String EndDateTime){

        return dbsBankService.findByAccountTitleAndDate(StartDateTime,EndDateTime,AccountTitle);
    }

    @RequestMapping(value = "/SearchBankBalance")
    @ResponseBody
    List<BankBalanceDO> SearchBankBalance(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime,@RequestParam(value = "accountTitle") String accountTitle){
        List<BankBalanceDO> list = new ArrayList<>();
        if ("所有公司".equals(accountTitle)){
            list = bankBalanceService.findAll(startTime,endTime);
        }else {
            list =bankBalanceService.findByDateAndAccountTitle(startTime,endTime,accountTitle);
        }
        return list;
    }

}
