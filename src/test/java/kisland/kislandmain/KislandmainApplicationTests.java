//package kisland.kislandmain;
//
//import com.alibaba.fastjson.JSON;
//import kisland.kislandmain.DAO.AgriculturalBankDAO;
//import kisland.kislandmain.DAO.BankBalanceDAO;
//import kisland.kislandmain.DAO.DbsDAO;
//import kisland.kislandmain.DO.DbsBankDO;
//import kisland.kislandmain.DO.StatisticsData.MatchedDO;
//import kisland.kislandmain.DO.StatisticsData.StatisticsDataDO;
//import kisland.kislandmain.Service.BankService.*;
//import kisland.kislandmain.Service.Income.IncomeService;
//import kisland.kislandmain.Service.Mapping.PaymentChannelService;
//import kisland.kislandmain.Service.Mapping.ReceivingChannelService;
//import kisland.kislandmain.Service.North.NorthIncomeAndChargeService;
//import kisland.kislandmain.Service.charge.ChargeService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class KislandmainApplicationTests {
//
//    @Autowired
//    AgriculturalBankService agriculturalBankService;
//    @Autowired
//    ChinaBankService chinaBankService;
//    @Autowired
//    EconomicConstructionBankService economicConstructionBankService;
//    @Autowired
//    IndustrialAndCommercialBankService industrialAndCommercialBankService;
//    @Autowired
//    MerchantsBankService merchantsBankService;
//    @Autowired
//    MinshengBankService minshengBankService;
//    @Autowired
//    IncomeService incomeService;
//    @Autowired
//    ChargeService chargeService;
//    @Autowired
//    NorthIncomeAndChargeService northIncomeAndChargeService;
//    @Autowired
//    private PaymentChannelService paymentChannelService;
//    @Autowired
//    private ReceivingChannelService receivingChannelService;
//    @Autowired
//    private AgriculturalBankDAO agriculturalBankDAO;
//    @Autowired
//    private BankBalanceDAO bankBalanceDAO;
//    @Autowired
//    private BankBalanceService bankBalanceService;
//    @Autowired
//    private DbsDAO dbsDAO;
//    List<MatchedDO> FinalMatchedList = new ArrayList<>();
//    List<StatisticsDataDO> statisticsDataDOS = new ArrayList<>();
//    String reg = "([\\w\\W]*)(中国银行)([\\w\\W]*)";
//    String reg1 = "([\\w\\W]*)(农业银行)([\\w\\W]*)";
//    String reg2 = "([\\w\\W]*)(招商银行)([\\w\\W]*)";
//    String reg3 = "([\\w\\W]*)(建设银行)([\\w\\W]*)";
//    String reg4 = "([\\w\\W]*)(民生银行)([\\w\\W]*)";
//    String reg5 = "([\\w\\W]*)(工商银行)([\\w\\W]*)";
//    int count = 0;
//    int count1 = 0;
//    int count2 = 0;
//    int count3 = 0;
//    int count4 = 0;
//    int count5 = 0;
//    Double sum = 0.00;
//
//    @Test
//    public void contextLoads() {
//    }
//
//    @Test
//    public void test() throws ParseException {
//
//
////======================================读取表中的数据+++++++++++++++++++++++++++++++++++++++++++++++++
//    }
//
//    @Test
//    public void TestBalance() throws ParseException {
//        String startTime = "7/5/2019";
//        String endTime = "7/9/2019";
//        List<DbsBankDO> list = dbsDAO.findByDateAndAccountTitle(startTime,endTime,"KIDSLAND TRADING (TIANJIN) CO. LTD.");
//        System.out.println(JSON.toJSONString(list,true));
//    }
//
//
//}
