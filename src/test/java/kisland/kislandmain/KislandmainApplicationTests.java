package kisland.kislandmain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import kisland.kislandmain.DAO.AgriculturalBankDAO;
import kisland.kislandmain.DAO.BankBalanceDAO;
import kisland.kislandmain.DAO.DbsDAO;
import kisland.kislandmain.DO.BankBalanceDO;
import kisland.kislandmain.DO.IncomeCategoryDO;
import kisland.kislandmain.DO.Mapping.PaymentMappingDO;
import kisland.kislandmain.DO.StatisticsData.MatchedDO;
import kisland.kislandmain.DO.StatisticsData.StatisticsDataDO;
import kisland.kislandmain.Service.BankService.*;
import kisland.kislandmain.Service.Income.IncomeService;
import kisland.kislandmain.Service.Mapping.PaymentChannelService;
import kisland.kislandmain.Service.Mapping.ReceivingChannelService;
import kisland.kislandmain.Service.Mid.MiddleIncomeAndChargeService;
import kisland.kislandmain.Service.North.NorthIncomeAndChargeService;
import kisland.kislandmain.Service.South.SouthIncomeAndChargeService;
import kisland.kislandmain.Service.charge.ChargeService;
import kisland.kislandmain.Util.ClearZero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kisland.kislandmain.Util.OperationBankBalance.getYesterday;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KislandmainApplicationTests {

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
    IncomeService incomeService;
    @Autowired
    ChargeService chargeService;
    @Autowired
    NorthIncomeAndChargeService northIncomeAndChargeService;
    @Autowired
    private PaymentChannelService paymentChannelService;
    @Autowired
    private ReceivingChannelService receivingChannelService;
    @Autowired
    private AgriculturalBankDAO agriculturalBankDAO;
    @Autowired
    private BankBalanceDAO bankBalanceDAO;
    @Autowired
    private BankBalanceService bankBalanceService;
    @Autowired
    private DbsDAO dbsDAO;
    @Autowired
    private MiddleIncomeAndChargeService middleIncomeAndChargeService;
    @Autowired
    private SouthIncomeAndChargeService southIncomeAndChargeService;
    @Autowired
    ClearZero clearZero;
    List<MatchedDO> FinalMatchedList = new ArrayList<>();
    List<StatisticsDataDO> statisticsDataDOS = new ArrayList<>();
    String reg = "([\\w\\W]*)(中国银行)([\\w\\W]*)";
    String reg1 = "([\\w\\W]*)(农业银行)([\\w\\W]*)";
    String reg2 = "([\\w\\W]*)(招商银行)([\\w\\W]*)";
    String reg3 = "([\\w\\W]*)(建设银行)([\\w\\W]*)";
    String reg4 = "([\\w\\W]*)(民生银行)([\\w\\W]*)";
    String reg5 = "([\\w\\W]*)(工商银行)([\\w\\W]*)";
    int count = 0;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    Double sum = 0.00;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() throws ParseException {
        List<PaymentMappingDO> list = paymentChannelService.findByTradescope("南区");
        System.out.println(JSON.toJSONString(list));

//======================================读取表中的数据+++++++++++++++++++++++++++++++++++++++++++++++++
    }

    @Test
    public void TestBalance() throws ParseException {
        String startTime = "2019-07-01";
        String endTime = "2019-07-16";
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
        System.out.println(JSON.toJSONString(BalanceMap,true));
        System.out.println(JSON.toJSONString(finalMap,true));
    }


}
