package kisland.kislandmain.Service.Mid;

import com.alibaba.fastjson.JSON;
import kisland.kislandmain.DO.*;
import kisland.kislandmain.DO.Mapping.PaymentMappingDO;
import kisland.kislandmain.DO.Mapping.ReceivingMappingDO;
import kisland.kislandmain.Service.BankService.*;
import kisland.kislandmain.Service.Income.IncomeService;
import kisland.kislandmain.Service.Mapping.PaymentChannelService;
import kisland.kislandmain.Service.Mapping.ReceivingChannelService;
import kisland.kislandmain.Service.North.NorthIncomeAndChargeService;
import kisland.kislandmain.Service.charge.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

import static kisland.kislandmain.Util.AddColumn.AddChargeColumnMethod;
import static kisland.kislandmain.Util.AddColumn.AddIncomeColumnMethod;

@Transactional
@Service
public class MiddleIncomeAndChargeServiceImpl implements MiddleIncomeAndChargeService {
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
    public Map<String, String> getMidIncomeByType(String startTime, String endTime,List<IncomeCategoryDO> incomeCategoryDOS) {
        List<AgriculturalBankDO> agriculturalBankDOList = agriculturalBankService.findByDate(startTime, endTime);
        List<ChinaBankDO> chinaBankDOList = chinaBankService.findByDate(startTime, endTime);
        List<EconomicConstructionBankDO> economicConstructionBankDOList = economicConstructionBankService.findByDate(startTime, endTime);
        List<IndustrialAndCommercialBankDO> industrialAndCommercialBankDOList = industrialAndCommercialBankService.findByDate(startTime, endTime);
        List<MerchantsBankDO> merchantsBankDOList = merchantsBankService.findByDate(startTime, endTime);
        List<MinshengBankDO> minshengBankDOList = minshengBankService.findByDate(startTime, endTime);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormat decimalFormat1 = new DecimalFormat("#,##0.00");
        List<ReceivingMappingDO> list = receivingChannelService.findByTradeScope("中区");
        Map<String, String> map = new HashMap();
        Map<String, String> map1 = new HashMap<>();
        map1.put("中区", "0.00");
        Set<String> set = new LinkedHashSet<>();//公司名去重集合
        for (ReceivingMappingDO receivingMappingDO : list) {
            set.add(receivingMappingDO.getLegelMajority());
        }
        for (String str : set) {
            double sum = 0.00;
            for (ReceivingMappingDO receivingMappingDO : list) {
                try {
                    if (str.equals(receivingMappingDO.getLegelMajority())) {
                        if (receivingMappingDO.getBankAccount().matches(reg)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (ChinaBankDO chinaBankDO : chinaBankDOList) {
                                String uuid = chinaBankDO.getTradeAmount() + chinaBankDO.getPayeeName() + chinaBankDO.getAccountTitle() + chinaBankDO.getAccountHoldingBankNumberPayer() + chinaBankDO.getAccountHoldingBeneficiaryBankNumber() + chinaBankDO.getAfterTransactionBalance() + chinaBankDO.getBeneficiaryAccountBank() + chinaBankDO.getBusinessType() + chinaBankDO.getbDs() + chinaBankDO.getCustomerTransactionRef();
                                if (str.equals(chinaBankDO.getAccountTitle()) && chinaBankDO.getPayeeName().equals(receivingMappingDO.getOtherAccountName())) {
                                    if (set1.add(uuid)) {
                                        for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                            if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getReceivingChannel())) {
                                                incomeCategoryDO.setMiddleCategoryValue(Double.parseDouble(incomeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(chinaBankDO.getTradeAmount().replace("-", "")) + "");
                                            }
                                        }
                                        sum = sum + Double.parseDouble(chinaBankDO.getTradeAmount().replace("-", ""));
                                    }
                                }
                            }
                        } else if (receivingMappingDO.getBankAccount().matches(reg1)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (AgriculturalBankDO agriculturalBankDO : agriculturalBankDOList) {
                                String uuid = agriculturalBankDO.getAmountIncome() + agriculturalBankDO.getDate() + agriculturalBankDO.getAccountTitle() + agriculturalBankDO.getTransactionTime() + agriculturalBankDO.getTradingPurpose() + agriculturalBankDO.getAmountCost() + agriculturalBankDO.getBankName() + agriculturalBankDO.getbDs() + agriculturalBankDO.getAmountIncome() + agriculturalBankDO.getOtherPartyProvincesAndCities();
                                if (str.equals(agriculturalBankDO.getAccountTitle()) && agriculturalBankDO.getOtherPartyName().equals(receivingMappingDO.getOtherAccountName())) {
                                    if (set1.add(uuid)) {
                                        for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                            if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getReceivingChannel())) {
                                                incomeCategoryDO.setMiddleCategoryValue(Double.parseDouble(incomeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(agriculturalBankDO.getAmountIncome().replace("-", "")) + "");
                                            }
                                        }
                                        sum = sum + Double.parseDouble(agriculturalBankDO.getAmountIncome().replace("-", ""));
                                    }
                                }
                            }
                        } else if (receivingMappingDO.getBankAccount().matches(reg2)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (MerchantsBankDO merchantsBankDO : merchantsBankDOList) {
                                String uuid = merchantsBankDO.getAccountTitle() + merchantsBankDO.getDate() + merchantsBankDO.getDebitAmount() + merchantsBankDO.getAttachmentInformation() + merchantsBankDO.getBalance() + merchantsBankDO.getBankAbstract() + merchantsBankDO.getBillingNumber() + merchantsBankDO.getbDs() + merchantsBankDO.getTransactionType() + merchantsBankDO.getBusinessReferenceNumber();
                                if (str.equals(merchantsBankDO.getAccountTitle()) && merchantsBankDO.equals(merchantsBankDO.getPayerPayeeName())) {
                                    if (set1.add(uuid)) {
                                        if (merchantsBankDO.getDebitAmount() != null && merchantsBankDO.getDebitAmount().length() > 0) {
                                            for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                                if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getReceivingChannel())) {
                                                    incomeCategoryDO.setMiddleCategoryValue(Double.parseDouble(incomeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(merchantsBankDO.getCreditAmount().replace("-", "")) + "");
                                                }
                                            }
                                            sum = sum + Double.parseDouble(merchantsBankDO.getCreditAmount().replace("-", ""));
                                        }
                                    }
                                }
                            }
                        } else if (receivingMappingDO.getBankAccount().matches(reg3)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (EconomicConstructionBankDO economicConstructionBankDO : economicConstructionBankDOList) {
                                String uuid = economicConstructionBankDO.getAccountName() + economicConstructionBankDO.getAccountTitle() + economicConstructionBankDO.getCounterAccount() + economicConstructionBankDO.getAccountNumber() + economicConstructionBankDO.getBalance() + economicConstructionBankDO.getbDs() + economicConstructionBankDO.getBillingDate() + economicConstructionBankDO.getCounterName() + economicConstructionBankDO.getCurrency() + economicConstructionBankDO.getDocumentNumber() + economicConstructionBankDO.getRemark();
                                if (economicConstructionBankDO.getAccountTitle().equals(str) && economicConstructionBankDO.getCounterAccount().equals(receivingMappingDO.getOtherAccountName())) {
                                    if (set1.add(uuid)) {
                                        if (economicConstructionBankDO.getDebitAmount() != null && economicConstructionBankDO.getDebitAmount().length() > 0) {
                                            for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                                if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getReceivingChannel())) {
                                                    incomeCategoryDO.setMiddleCategoryValue(Double.parseDouble(incomeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(economicConstructionBankDO.getCreditAmount().replace("-", "")) + "");
                                                }
                                            }
                                            sum = sum + Double.parseDouble(economicConstructionBankDO.getCreditAmount().replace("-", ""));
                                        }
                                    }

                                }
                            }
                        } else if (receivingMappingDO.getBankAccount().matches(reg4)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (MinshengBankDO minshengBankDO : minshengBankDOList) {
                                String uuid = minshengBankDO.getAccountBalance() + minshengBankDO.getOtherAccounts() + minshengBankDO.getAccountName() + minshengBankDO.getAccountTitle() + minshengBankDO.getBankAccount() + minshengBankDO.getbDs() + minshengBankDO.getDebitAmount() + minshengBankDO.getDocumentNumber() + minshengBankDO.getDate();
                                if (minshengBankDO.getAccountTitle().equals(str) && minshengBankDO.getOtherAccounts().equals(receivingMappingDO.getOtherAccountName())) {
                                    if (set1.add(uuid)) {
                                        if (minshengBankDO.getDebitAmount() != null && minshengBankDO.getDebitAmount().length() > 0) {
                                            for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                                if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getOtherAccountName())) {
                                                    incomeCategoryDO.setMiddleCategoryValue(Double.parseDouble(incomeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(minshengBankDO.getCreditAmount().replace("-", "")) + "");
                                                }
                                            }
                                            sum = sum + Double.parseDouble(minshengBankDO.getCreditAmount().replace("-", ""));
                                        }
                                    }
                                }
                            }
                        } else if (receivingMappingDO.getBankAccount().matches(reg5)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (IndustrialAndCommercialBankDO industrialAndCommercialBankDO : industrialAndCommercialBankDOList) {
                                String uuid = industrialAndCommercialBankDO.getAccountNumber() + industrialAndCommercialBankDO.getOtherPartyCompanyName() + industrialAndCommercialBankDO.getDebitAmount() + industrialAndCommercialBankDO.getOtherPartyAccountNumber() + industrialAndCommercialBankDO.getAccountTitle() + industrialAndCommercialBankDO.getBalance() + industrialAndCommercialBankDO.getCreditAmount() + industrialAndCommercialBankDO.getDate();
                                if (industrialAndCommercialBankDO.getAccountTitle().equals(str) && industrialAndCommercialBankDO.getOtherPartyCompanyName().equals(receivingMappingDO.getOtherAccountName())) {
                                    if (set1.add(uuid)) {
                                        if (industrialAndCommercialBankDO.getDebitAmount() != null && industrialAndCommercialBankDO.getDebitAmount().length() > 0) {
                                            for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
                                                if (incomeCategoryDO.getCategoryName().equals(receivingMappingDO.getReceivingChannel())) {
                                                    incomeCategoryDO.setMiddleCategoryValue(Double.parseDouble(incomeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(industrialAndCommercialBankDO.getCreditAmount().replace("-", "")) + "");
                                                }
                                            }
                                            sum = sum + Double.parseDouble(industrialAndCommercialBankDO.getCreditAmount().replace("-", ""));
                                        }
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
            Double sum = Double.parseDouble(entry.getValue());
            map1.put("中区", Double.parseDouble(map1.get("中区")) + sum + "");
        }
        for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
            incomeCategoryDO.setMiddleCategoryValue(decimalFormat.format(Double.parseDouble(incomeCategoryDO.getMiddleCategoryValue())));
        }
        //        ============================================给收款种类每三位加一个逗号=================================================
        for (IncomeCategoryDO incomeCategoryDO : incomeCategoryDOS) {
            try {
                incomeCategoryDO.setMiddleCategoryValue(decimalFormat1.format(decimalFormat.parse(incomeCategoryDO.getMiddleCategoryValue())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(JSON.toJSONString(incomeCategoryDOS));
        //        ============================================给收款种类每三位加一个逗号=================================================
        map1.put("收款渠道", JSON.toJSONString(incomeCategoryDOS));
        map1 = AddIncomeColumnMethod(map1,"中区");
//        System.out.println(JSON.toJSONString(map1, true));
//======================================读取表中的数据+++++++++++++++++++++++++++++++++++++++++++++++++
        return map1;
    }

    @Override
    public Map<String, String> getMidChargeByType(String startTime, String endTime,List<ChargeCategoryDO> chargeCategoryDOS) {
        List<AgriculturalBankDO> agriculturalBankDOList = agriculturalBankService.findByDate(startTime, endTime);
        List<ChinaBankDO> chinaBankDOList = chinaBankService.findByDate(startTime, endTime);
        List<EconomicConstructionBankDO> economicConstructionBankDOList = economicConstructionBankService.findByDate(startTime, endTime);
        List<IndustrialAndCommercialBankDO> industrialAndCommercialBankDOList = industrialAndCommercialBankService.findByDate(startTime, endTime);
        List<MerchantsBankDO> merchantsBankDOList = merchantsBankService.findByDate(startTime, endTime);
        List<MinshengBankDO> minshengBankDOList = minshengBankService.findByDate(startTime, endTime);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormat decimalFormat1 = new DecimalFormat("#,##0.00");
        List<PaymentMappingDO> list = paymentChannelService.findByTradescope("中区");
        Map<String, String> map = new HashMap();
        Map<String, String> map1 = new HashMap<>();
        map1.put("中区", "0.00");
        Set<String> set = new LinkedHashSet<>();//公司名去重集合

        for (PaymentMappingDO paymentMappingDO : list) {
            set.add(paymentMappingDO.getLegelmajority());
        }

        for (String str : set) {
            double sum = 0.00;
            for (PaymentMappingDO paymentMappingDO : list) {
                try {
                    if (str.equals(paymentMappingDO.getLegelmajority())) {
                        if (paymentMappingDO.getBankaccount().matches(reg)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (ChinaBankDO chinaBankDO : chinaBankDOList) {
                                String uuid = chinaBankDO.getTradeAmount() + chinaBankDO.getPayeeName() + chinaBankDO.getAccountTitle() + chinaBankDO.getAccountHoldingBankNumberPayer() + chinaBankDO.getAccountHoldingBeneficiaryBankNumber() + chinaBankDO.getAfterTransactionBalance() + chinaBankDO.getBeneficiaryAccountBank() + chinaBankDO.getBusinessType() + chinaBankDO.getbDs() + chinaBankDO.getCustomerTransactionRef();
                                if (str.equals(chinaBankDO.getAccountTitle()) && chinaBankDO.getPayeeName().equals(paymentMappingDO.getOtheraccountname())) {
                                    if (set1.add(uuid)) {
                                        for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                            if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                                chargeCategoryDO.setMiddleCategoryValue(Double.parseDouble(chargeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(chinaBankDO.getTradeAmount().replace("-", "")) + "");
                                            }
                                        }
                                        sum = sum + Double.parseDouble(chinaBankDO.getTradeAmount().replace("-", ""));
                                    }
                                }
                            }
                        } else if (paymentMappingDO.getBankaccount().matches(reg1)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (AgriculturalBankDO agriculturalBankDO : agriculturalBankDOList) {
                                String uuid = agriculturalBankDO.getAmountIncome() + agriculturalBankDO.getDate() + agriculturalBankDO.getAccountTitle() + agriculturalBankDO.getTransactionTime() + agriculturalBankDO.getTradingPurpose() + agriculturalBankDO.getAmountCost() + agriculturalBankDO.getBankName() + agriculturalBankDO.getbDs() + agriculturalBankDO.getAmountIncome() + agriculturalBankDO.getOtherPartyProvincesAndCities();
                                if (str.equals(agriculturalBankDO.getAccountTitle()) && agriculturalBankDO.getOtherPartyName().equals(paymentMappingDO.getOtheraccountname())) {
                                    if (set1.add(uuid)) {
                                        for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                            if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                                chargeCategoryDO.setMiddleCategoryValue(Double.parseDouble(chargeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(agriculturalBankDO.getAmountCost().replace("-", "")) + "");
                                            }
                                        }
                                        sum = sum + Double.parseDouble(agriculturalBankDO.getAmountCost().replace("-", ""));
                                    }
                                }
                            }
                        } else if (paymentMappingDO.getBankaccount().matches(reg2)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (MerchantsBankDO merchantsBankDO : merchantsBankDOList) {
                                if (str.equals(merchantsBankDO.getAccountTitle()) && merchantsBankDO.equals(merchantsBankDO.getPayerPayeeName())) {
                                    if (merchantsBankDO.getDebitAmount() != null && merchantsBankDO.getDebitAmount().length() > 0) {
                                        String uuid = merchantsBankDO.getAccountTitle() + merchantsBankDO.getDate() + merchantsBankDO.getDebitAmount() + merchantsBankDO.getAttachmentInformation() + merchantsBankDO.getBalance() + merchantsBankDO.getBankAbstract() + merchantsBankDO.getBillingNumber() + merchantsBankDO.getbDs() + merchantsBankDO.getTransactionType() + merchantsBankDO.getBusinessReferenceNumber();
                                        if (set1.add(uuid)) {
                                            for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                                if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                                    chargeCategoryDO.setMiddleCategoryValue(Double.parseDouble(chargeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(merchantsBankDO.getDebitAmount().replace("-", "")) + "");
                                                }
                                            }
                                            sum = sum + Double.parseDouble(merchantsBankDO.getDebitAmount().replace("-", ""));
                                        }
                                    }
                                }
                            }
                        } else if (paymentMappingDO.getBankaccount().matches(reg3)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (EconomicConstructionBankDO economicConstructionBankDO : economicConstructionBankDOList) {
                                String uuid = economicConstructionBankDO.getAccountName() + economicConstructionBankDO.getAccountTitle() + economicConstructionBankDO.getCounterAccount() + economicConstructionBankDO.getAccountNumber() + economicConstructionBankDO.getBalance() + economicConstructionBankDO.getbDs() + economicConstructionBankDO.getBillingDate() + economicConstructionBankDO.getCounterName() + economicConstructionBankDO.getCurrency() + economicConstructionBankDO.getDocumentNumber() + economicConstructionBankDO.getRemark();
                                if (economicConstructionBankDO.getAccountTitle().equals(str) && economicConstructionBankDO.getCounterAccount().equals(paymentMappingDO.getOtheraccountname())) {
                                    if (set1.add(uuid)) {
                                        if (economicConstructionBankDO.getDebitAmount() != null && economicConstructionBankDO.getDebitAmount().length() > 0) {
                                            for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                                if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                                    chargeCategoryDO.setMiddleCategoryValue(Double.parseDouble(chargeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(economicConstructionBankDO.getDebitAmount().replace("-", "")) + "");
                                                }
                                            }
                                            sum = sum + Double.parseDouble(economicConstructionBankDO.getDebitAmount().replace("-", ""));
                                        }
                                    }
                                }
                            }
                        } else if (paymentMappingDO.getBankaccount().matches(reg4)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (MinshengBankDO minshengBankDO : minshengBankDOList) {
                                if (minshengBankDO.getAccountTitle().equals(str) && minshengBankDO.getOtherAccounts().equals(paymentMappingDO.getOtheraccountname())) {
                                    String uuid = minshengBankDO.getAccountBalance() + minshengBankDO.getOtherAccounts() + minshengBankDO.getAccountName() + minshengBankDO.getAccountTitle() + minshengBankDO.getBankAccount() + minshengBankDO.getbDs() + minshengBankDO.getDebitAmount() + minshengBankDO.getDocumentNumber() + minshengBankDO.getDate();
                                    if (minshengBankDO.getDebitAmount() != null && minshengBankDO.getDebitAmount().length() > 0) {
                                        if (set1.add(uuid)) {
                                            for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                                if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                                    chargeCategoryDO.setMiddleCategoryValue(Double.parseDouble(chargeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(minshengBankDO.getDebitAmount().replace("-", "")) + "");
                                                }
                                            }
                                            sum = sum + Double.parseDouble(minshengBankDO.getDebitAmount().replace("-", ""));
                                        }
                                    }
                                }
                            }
                        } else if (paymentMappingDO.getBankaccount().matches(reg5)) {
                            Set<String> set1 = new LinkedHashSet<>();//支出项目去重集合
                            for (IndustrialAndCommercialBankDO industrialAndCommercialBankDO : industrialAndCommercialBankDOList) {
                                String uuid = industrialAndCommercialBankDO.getAccountNumber() + industrialAndCommercialBankDO.getOtherPartyCompanyName() + industrialAndCommercialBankDO.getDebitAmount() + industrialAndCommercialBankDO.getOtherPartyAccountNumber() + industrialAndCommercialBankDO.getAccountTitle() + industrialAndCommercialBankDO.getBalance() + industrialAndCommercialBankDO.getCreditAmount() + industrialAndCommercialBankDO.getDate();
                                if (industrialAndCommercialBankDO.getAccountTitle().equals(str) && industrialAndCommercialBankDO.getOtherPartyCompanyName().equals(paymentMappingDO.getOtheraccountname())) {
                                    if (industrialAndCommercialBankDO.getDebitAmount() != null && industrialAndCommercialBankDO.getDebitAmount().length() > 0) {
                                        if (set1.add(uuid)) {
                                            for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
                                            if (chargeCategoryDO.getCategoryName().equals(paymentMappingDO.getExpendproject())) {
                                                chargeCategoryDO.setMiddleCategoryValue(Double.parseDouble(chargeCategoryDO.getMiddleCategoryValue()) + Double.parseDouble(industrialAndCommercialBankDO.getDebitAmount().replace("-", "")) + "");
                                            }
                                        }
                                        sum = sum + Double.parseDouble(industrialAndCommercialBankDO.getDebitAmount().replace("-", ""));

                                    }
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
            Double sum = Double.parseDouble(entry.getValue());
            map1.put("中区", Double.parseDouble(map1.get("中区")) + sum + "");

        }
        for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
            chargeCategoryDO.setMiddleCategoryValue(decimalFormat.format(Double.parseDouble(chargeCategoryDO.getMiddleCategoryValue())));
        }
        map1.put("总计", decimalFormat.format(Double.parseDouble(map1.get("中区"))));
//        ============================================给付款种类每三位加一个逗号=================================================
        for (ChargeCategoryDO chargeCategoryDO : chargeCategoryDOS) {
            try {
                chargeCategoryDO.setMiddleCategoryValue(decimalFormat1.format(decimalFormat.parse(chargeCategoryDO.getMiddleCategoryValue())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //        ============================================给付款种类每三位加一个逗号=================================================
        System.out.println(JSON.toJSONString(chargeCategoryDOS));
        map1.put("支出项目", JSON.toJSONString(chargeCategoryDOS));
        map1 = AddChargeColumnMethod(map1,"中区");
        System.out.println(JSON.toJSONString(map1, true));
        return map1;
    }
}
