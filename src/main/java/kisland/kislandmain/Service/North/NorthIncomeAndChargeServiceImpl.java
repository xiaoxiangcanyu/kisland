package kisland.kislandmain.Service.North;

import com.alibaba.fastjson.JSON;
import kisland.kislandmain.DO.*;
import kisland.kislandmain.DO.Mapping.PaymentMappingDO;
import kisland.kislandmain.DO.Mapping.ReceivingMappingDO;
import kisland.kislandmain.DO.StatisticsData.MatchedDO;
import kisland.kislandmain.DO.StatisticsData.StatisticsDataDO;
import kisland.kislandmain.Service.BankService.*;
import kisland.kislandmain.Service.Income.IncomeService;
import kisland.kislandmain.Service.Mapping.PaymentChannelService;
import kisland.kislandmain.Service.Mapping.ReceivingChannelService;
import kisland.kislandmain.Service.charge.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static kisland.kislandmain.Util.AddColumn.AddChargeColumnMethod;
import static kisland.kislandmain.Util.AddColumn.AddIncomeColumnMethod;

/**
 * 北方收付款服务
 */
@Transactional
@Service
public class NorthIncomeAndChargeServiceImpl implements NorthIncomeAndChargeService {
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
    String reg = "([\\w\\W]*)(中国银行)([\\w\\W]*)";
    String reg1 = "([\\w\\W]*)(农业银行)([\\w\\W]*)";
    String reg2 = "([\\w\\W]*)(招商银行)([\\w\\W]*)";
    String reg3 = "([\\w\\W]*)(建设银行)([\\w\\W]*)";
    String reg4 = "([\\w\\W]*)(民生银行)([\\w\\W]*)";
    String reg5 = "([\\w\\W]*)(工商银行)([\\w\\W]*)";


    @Override
    public Map<String, String> getNorthIncomeByType(String startTime, String endTime) {
        List<AgriculturalBankDO> agriculturalBankDOList = agriculturalBankService.findByDate(startTime, endTime);
        List<ChinaBankDO> chinaBankDOList = chinaBankService.findByDate(startTime, endTime);
        List<EconomicConstructionBankDO> economicConstructionBankDOList = economicConstructionBankService.findByDate(startTime, endTime);
        List<IndustrialAndCommercialBankDO> industrialAndCommercialBankDOList = industrialAndCommercialBankService.findByDate(startTime, endTime);
        List<MerchantsBankDO> merchantsBankDOList = merchantsBankService.findByDate(startTime, endTime);
        List<MinshengBankDO> minshengBankDOList = minshengBankService.findByDate(startTime, endTime);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormat decimalFormat1 = new DecimalFormat("#,##0.00");

        List<IncomeCategoryDO> incomeCategoryDOS = incomeService.getIncomeService();
        List<ReceivingMappingDO> list = receivingChannelService.findByTradeScope("北区");
        Map<String, String> map = new HashMap();
        Map<String, String> map1 = new HashMap<>();
        map1.put("北区", "0.00");
        Set<String> set = new LinkedHashSet<>();//公司名去重集合
        Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合

        for (ReceivingMappingDO receivingMappingDO : list) {
            set.add(receivingMappingDO.getLegelMajority());
        }

        for (String str : set) {
            double sum = 0.00;
            for (ReceivingMappingDO receivingMappingDO : list) {
                try {
                    if (str.equals(receivingMappingDO.getLegelMajority())) {
                        if (receivingMappingDO.getBankAccount().matches(reg)) {
                            for (ChinaBankDO chinaBankDO : chinaBankDOList) {
                                if (str.equals(chinaBankDO.getAccountTitle()) && chinaBankDO.getPayeeName().equals(receivingMappingDO.getOtherAccountName())) {
                                    for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                        if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getReceivingChannel())) {
                                            if (str.contains("凯知乐")) {
                                                incomeCategoryDO.setKzlCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(chinaBankDO.getTradeAmount().replace("-", "")) + "");
                                            } else {
                                                incomeCategoryDO.setNorthCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(chinaBankDO.getTradeAmount().replace("-", "")) + "");

                                            }
                                        }
                                    }
                                    sum = sum + Double.parseDouble(chinaBankDO.getTradeAmount().replace("-", ""));
                                }
                            }
                        } else
                        if (receivingMappingDO.getBankAccount().matches(reg1)) {
                            for (AgriculturalBankDO agriculturalBankDO : agriculturalBankDOList) {
                                if (str.equals(agriculturalBankDO.getAccountTitle()) && agriculturalBankDO.getOtherPartyName().equals(receivingMappingDO.getOtherAccountName())) {
                                    for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                        if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getReceivingChannel())) {
                                            if (str.contains("凯知乐")) {
                                                incomeCategoryDO.setKzlCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(agriculturalBankDO.getAmountIncome().replace("-", "")) + "");
                                            } else {
                                                incomeCategoryDO.setNorthCategoryValue(Double.parseDouble(incomeCategoryDO.getNorthCategoryValue()) + Double.parseDouble(agriculturalBankDO.getAmountIncome().replace("-", "")) + "");
                                            }
                                        }
                                    }
                                    sum = sum + Double.parseDouble(agriculturalBankDO.getAmountIncome().replace("-", ""));
                                }
                            }
                        }
                        else if (receivingMappingDO.getBankAccount().matches(reg2)) {
                            for (MerchantsBankDO merchantsBankDO : merchantsBankDOList) {
                                if (str.equals(merchantsBankDO.getAccountTitle()) && merchantsBankDO.equals(merchantsBankDO.getPayerPayeeName())) {
                                    if (merchantsBankDO.getDebitAmount() != null && merchantsBankDO.getDebitAmount().length() > 0) {
                                        for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                            if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getReceivingChannel())) {
                                                if (str.contains("凯知乐")) {
                                                    incomeCategoryDO.setKzlCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(merchantsBankDO.getCreditAmount().replace("-", "")) + "");
                                                } else {
                                                    incomeCategoryDO.setNorthCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(merchantsBankDO.getCreditAmount().replace("-", "")) + "");

                                                }
                                            }
                                        }
                                        sum = sum + Double.parseDouble(merchantsBankDO.getCreditAmount().replace("-", ""));
                                    }
                                }
                            }
                        } else if (receivingMappingDO.getBankAccount().matches(reg3)) {
                            for (EconomicConstructionBankDO economicConstructionBankDO : economicConstructionBankDOList) {
                                if (economicConstructionBankDO.getAccountTitle().equals(str) && economicConstructionBankDO.getCounterAccount().equals(receivingMappingDO.getOtherAccountName())) {
                                    if (economicConstructionBankDO.getDebitAmount() != null && economicConstructionBankDO.getDebitAmount().length() > 0) {
                                        for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                            if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getReceivingChannel())) {
                                                if (str.contains("凯知乐")) {
                                                    incomeCategoryDO.setKzlCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(economicConstructionBankDO.getCreditAmount().replace("-", "")) + "");
                                                } else {
                                                    incomeCategoryDO.setNorthCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(economicConstructionBankDO.getCreditAmount().replace("-", "")) + "");

                                                }
                                            }
                                        }
                                        sum = sum + Double.parseDouble(economicConstructionBankDO.getCreditAmount().replace("-", ""));

                                    }
                                }
                            }
                        } else if (receivingMappingDO.getBankAccount().matches(reg4)) {
                            for (MinshengBankDO minshengBankDO : minshengBankDOList) {
                                if (minshengBankDO.getAccountTitle().equals(str) && minshengBankDO.getOtherAccounts().equals(receivingMappingDO.getOtherAccountName())) {
                                    if (minshengBankDO.getDebitAmount() != null && minshengBankDO.getDebitAmount().length() > 0) {
                                        for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                            if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getOtherAccountName())) {
                                                if (str.contains("凯知乐")) {
                                                    incomeCategoryDO.setKzlCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(minshengBankDO.getCreditAmount().replace("-", "")) + "");
                                                } else {
                                                    incomeCategoryDO.setNorthCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(minshengBankDO.getCreditAmount().replace("-", "")) + "");

                                                }
                                            }
                                        }
                                        sum = sum + Double.parseDouble(minshengBankDO.getCreditAmount().replace("-", ""));
                                    }
                                }
                            }
                        } else if (receivingMappingDO.getBankAccount().matches(reg5)) {
                            for (IndustrialAndCommercialBankDO industrialAndCommercialBankDO : industrialAndCommercialBankDOList) {
                                if (industrialAndCommercialBankDO.getAccountTitle().equals(str) && industrialAndCommercialBankDO.getOtherPartyCompanyName().equals(receivingMappingDO.getOtherAccountName())) {
                                    if (industrialAndCommercialBankDO.getDebitAmount() != null && industrialAndCommercialBankDO.getDebitAmount().length() > 0) {
                                        for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                            if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getReceivingChannel())) {
                                                if (str.contains("凯知乐")) {
                                                    incomeCategoryDO.setKzlCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(industrialAndCommercialBankDO.getCreditAmount().replace("-", "")) + "");
                                                } else {
                                                    incomeCategoryDO.setNorthCategoryValue(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(industrialAndCommercialBankDO.getCreditAmount().replace("-", "")) + "");

                                                }
                                            }
                                        }
                                        sum = sum + Double.parseDouble(industrialAndCommercialBankDO.getCreditAmount().replace("-", ""));

                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    continue;
                }

            }
            map.put(str, decimalFormat.format(sum/2)
            );
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().contains("凯知乐")) {
                map1.put("凯知乐", entry.getValue());
            } else {
                Double sum = Double.parseDouble(entry.getValue());
                map1.put("北区", Double.parseDouble(map1.get("北区")) + sum + "");
            }
        }
        for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
            incomeCategoryDO.setKzlCategoryValue(decimalFormat.format(Double.parseDouble(incomeCategoryDO.getKzlCategoryValue())/2));
            incomeCategoryDO.setNorthCategoryValue(decimalFormat.format(Double.parseDouble(incomeCategoryDO.getNorthCategoryValue())/2));

        }
        //各公司求和
        map1.put("总计",decimalFormat.format(Double.parseDouble(map1.get("凯知乐"))+Double.parseDouble(map1.get("北区"))));
        //        ============================================给收款种类每三位加一个逗号=================================================
        for (IncomeCategoryDO incomeCategoryDO:incomeCategoryDOS){
            try {
                incomeCategoryDO.setNorthCategoryValue(decimalFormat1.format(decimalFormat.parse(incomeCategoryDO.getNorthCategoryValue())));
                incomeCategoryDO.setMiddleCategoryValue(decimalFormat1.format(decimalFormat.parse(incomeCategoryDO.getMiddleCategoryValue())));
                incomeCategoryDO.setSouthCategoryValue(decimalFormat1.format(decimalFormat.parse(incomeCategoryDO.getSouthCategoryValue())));
                incomeCategoryDO.setKzlCategoryValue(decimalFormat1.format(decimalFormat.parse(incomeCategoryDO.getKzlCategoryValue())));
                incomeCategoryDO.setYlbCategoryValue(decimalFormat1.format(decimalFormat.parse(incomeCategoryDO.getYlbCategoryValue())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //        ============================================给收款种类每三位加一个逗号=================================================

        map1.put("收款渠道", JSON.toJSONString(incomeCategoryDOS));
        map1 = AddIncomeColumnMethod(map1);
        System.out.println(JSON.toJSONString(map1, true));
//======================================读取表中的数据+++++++++++++++++++++++++++++++++++++++++++++++++
        return map1;
    }

    @Override
    public  Map<String, String> getNorthChargeByType(String startTime, String endTime) {
        List<AgriculturalBankDO> agriculturalBankDOList = agriculturalBankService.findByDate(startTime, endTime);
        List<ChinaBankDO> chinaBankDOList = chinaBankService.findByDate(startTime, endTime);
        List<EconomicConstructionBankDO> economicConstructionBankDOList = economicConstructionBankService.findByDate(startTime, endTime);
        List<IndustrialAndCommercialBankDO> industrialAndCommercialBankDOList = industrialAndCommercialBankService.findByDate(startTime, endTime);
        List<MerchantsBankDO> merchantsBankDOList = merchantsBankService.findByDate(startTime, endTime);
        List<MinshengBankDO> minshengBankDOList = minshengBankService.findByDate(startTime, endTime);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormat decimalFormat1 = new DecimalFormat("#,##0.00");

        List<ChargeCategoryDO> chargeCategoryDOS = chargeService.getChargeList();
        List<PaymentMappingDO> list = paymentChannelService.findByTradescope("北区");
        Map<String, String> map = new HashMap();
        Map<String, String> map1 = new HashMap<>();
        map1.put("北区", "0.00");
        Set<String> set = new LinkedHashSet<>();//公司名去重集合
        Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合

        for (PaymentMappingDO paymentMappingDO : list) {
            set.add(paymentMappingDO.getLegelmajority());
        }

        for (String str : set) {
            double sum = 0.00;
            for (PaymentMappingDO paymentMappingDO : list) {
                try {
                    if (str.equals(paymentMappingDO.getLegelmajority())) {
                        if (paymentMappingDO.getBankaccount().matches(reg)) {
                            for (ChinaBankDO chinaBankDO : chinaBankDOList) {
                                if (str.equals(chinaBankDO.getAccountTitle()) && chinaBankDO.getPayeeName().equals(paymentMappingDO.getOtheraccountname())) {
                                    for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                        if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                            if (str.contains("凯知乐")) {
                                                chargeCategoryDO.setKzlCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(chinaBankDO.getTradeAmount().replace("-", "")) + "");
                                            } else {
                                                chargeCategoryDO.setNorthCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(chinaBankDO.getTradeAmount().replace("-", "")) + "");

                                            }
                                        }
                                    }
                                    sum = sum + Double.parseDouble(chinaBankDO.getTradeAmount().replace("-", ""));
                                }
                            }
                        } else if (paymentMappingDO.getBankaccount().matches(reg1)) {
                            for (AgriculturalBankDO agriculturalBankDO : agriculturalBankDOList) {
                                if (str.equals(agriculturalBankDO.getAccountTitle()) && agriculturalBankDO.getOtherPartyName().equals(paymentMappingDO.getOtheraccountname())) {
                                    for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                        if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                            if (str.contains("凯知乐")) {
                                                chargeCategoryDO.setKzlCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(agriculturalBankDO.getAmountCost().replace("-", "")) + "");
                                            } else {
                                                chargeCategoryDO.setNorthCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(agriculturalBankDO.getAmountCost().replace("-", "")) + "");

                                            }
                                        }
                                    }
                                    sum = sum + Double.parseDouble(agriculturalBankDO.getAmountCost().replace("-", ""));
                                }
                            }
                        } else if (paymentMappingDO.getBankaccount().matches(reg2)) {
                            for (MerchantsBankDO merchantsBankDO : merchantsBankDOList) {
                                if (str.equals(merchantsBankDO.getAccountTitle()) && merchantsBankDO.equals(merchantsBankDO.getPayerPayeeName())) {
                                    if (merchantsBankDO.getDebitAmount() != null && merchantsBankDO.getDebitAmount().length() > 0) {
                                        for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                            if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                                if (str.contains("凯知乐")) {
                                                    chargeCategoryDO.setKzlCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(merchantsBankDO.getDebitAmount().replace("-", "")) + "");
                                                } else {
                                                    chargeCategoryDO.setNorthCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(merchantsBankDO.getDebitAmount().replace("-", "")) + "");

                                                }
                                            }
                                        }
                                        sum = sum + Double.parseDouble(merchantsBankDO.getDebitAmount().replace("-", ""));
                                    }
                                }
                            }
                        } else if (paymentMappingDO.getBankaccount().matches(reg3)) {
                            for (EconomicConstructionBankDO economicConstructionBankDO : economicConstructionBankDOList) {
                                if (economicConstructionBankDO.getAccountTitle().equals(str) && economicConstructionBankDO.getCounterAccount().equals(paymentMappingDO.getOtheraccountname())) {
                                    if (economicConstructionBankDO.getDebitAmount() != null && economicConstructionBankDO.getDebitAmount().length() > 0) {
                                        for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                            if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                                if (str.contains("凯知乐")) {
                                                    chargeCategoryDO.setKzlCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(economicConstructionBankDO.getDebitAmount().replace("-", "")) + "");
                                                } else {
                                                    chargeCategoryDO.setNorthCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(economicConstructionBankDO.getDebitAmount().replace("-", "")) + "");

                                                }
                                            }
                                        }
                                        sum = sum + Double.parseDouble(economicConstructionBankDO.getDebitAmount().replace("-", ""));

                                    }
                                }
                            }
                        } else if (paymentMappingDO.getBankaccount().matches(reg4)) {
                            for (MinshengBankDO minshengBankDO : minshengBankDOList) {
                                if (minshengBankDO.getAccountTitle().equals(str) && minshengBankDO.getOtherAccounts().equals(paymentMappingDO.getOtheraccountname())) {
                                    if (minshengBankDO.getDebitAmount() != null && minshengBankDO.getDebitAmount().length() > 0) {
                                        for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                            if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                                if (str.contains("凯知乐")) {
                                                    chargeCategoryDO.setKzlCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(minshengBankDO.getDebitAmount().replace("-", "")) + "");
                                                } else {
                                                    chargeCategoryDO.setNorthCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(minshengBankDO.getDebitAmount().replace("-", "")) + "");

                                                }
                                            }
                                        }
                                        sum = sum + Double.parseDouble(minshengBankDO.getDebitAmount().replace("-", ""));
                                    }
                                }
                            }
                        } else if (paymentMappingDO.getBankaccount().matches(reg5)) {
                            for (IndustrialAndCommercialBankDO industrialAndCommercialBankDO : industrialAndCommercialBankDOList) {
                                if (industrialAndCommercialBankDO.getAccountTitle().equals(str) && industrialAndCommercialBankDO.getOtherPartyCompanyName().equals(paymentMappingDO.getOtheraccountname())) {
                                    if (industrialAndCommercialBankDO.getDebitAmount() != null && industrialAndCommercialBankDO.getDebitAmount().length() > 0) {
                                        for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                            if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                                if (str.contains("凯知乐")) {
                                                    chargeCategoryDO.setKzlCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(industrialAndCommercialBankDO.getDebitAmount().replace("-", "")) + "");
                                                } else {
                                                    chargeCategoryDO.setNorthCategoryValue(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue()) + Double.parseDouble(industrialAndCommercialBankDO.getDebitAmount().replace("-", "")) + "");

                                                }
                                            }
                                        }
                                        sum = sum + Double.parseDouble(industrialAndCommercialBankDO.getDebitAmount().replace("-", ""));

                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    continue;
                }

            }
            map.put(str, decimalFormat.format(sum)
            );
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().contains("凯知乐")) {
                map1.put("凯知乐", entry.getValue());
            } else {
                Double sum = Double.parseDouble(entry.getValue())/2;
                map1.put("北区", Double.parseDouble(map1.get("北区")) + sum + "");
            }
        }
        for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
            chargeCategoryDO.setKzlCategoryValue(decimalFormat.format(Double.parseDouble(chargeCategoryDO.getKzlCategoryValue())));
            chargeCategoryDO.setNorthCategoryValue(decimalFormat.format(Double.parseDouble(chargeCategoryDO.getNorthCategoryValue())));

        }
        map1.put("总计",decimalFormat.format(Double.parseDouble(map1.get("凯知乐"))+Double.parseDouble(map1.get("北区"))));
//        ============================================给付款种类每三位加一个逗号=================================================
        for (ChargeCategoryDO chargeCategoryDO:chargeCategoryDOS){
            try {
                chargeCategoryDO.setNorthCategoryValue(decimalFormat1.format(decimalFormat.parse(chargeCategoryDO.getNorthCategoryValue())));
                chargeCategoryDO.setMiddleCategoryValue(decimalFormat1.format(decimalFormat.parse(chargeCategoryDO.getMiddleCategoryValue())));
                chargeCategoryDO.setSouthCategoryValue(decimalFormat1.format(decimalFormat.parse(chargeCategoryDO.getSouthCategoryValue())));
                chargeCategoryDO.setKzlCategoryValue(decimalFormat1.format(decimalFormat.parse(chargeCategoryDO.getKzlCategoryValue())));
                chargeCategoryDO.setYlbCategoryValue(decimalFormat1.format(decimalFormat.parse(chargeCategoryDO.getYlbCategoryValue())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //        ============================================给付款种类每三位加一个逗号=================================================

        map1.put("支出项目", JSON.toJSONString(chargeCategoryDOS));
        map1 = AddChargeColumnMethod(map1);
        System.out.println(JSON.toJSONString(map1, true));
        return map1;
    }


}
