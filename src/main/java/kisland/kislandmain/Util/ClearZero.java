package kisland.kislandmain.Util;

import kisland.kislandmain.DO.ChargeCategoryDO;
import kisland.kislandmain.DO.IncomeCategoryDO;
import kisland.kislandmain.Service.Income.IncomeService;
import kisland.kislandmain.Service.charge.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClearZero {
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private ChargeService chargeService;
    //对收款进行清零
    public  void ClearIncomeZeroMethod() {
        List<IncomeCategoryDO> List = incomeService.getIncomeService();
        for (IncomeCategoryDO incomeCategoryDO : List) {
            incomeCategoryDO.setKzlCategoryValue("0.00");
            incomeCategoryDO.setYlbCategoryValue("0.00");
            incomeCategoryDO.setMiddleCategoryValue("0.00");
            incomeCategoryDO.setSouthCategoryValue("0.00");
            incomeCategoryDO.setNorthCategoryValue("0.00");
            incomeService.AddIncomeCategory(incomeCategoryDO);
        }
    }

    //对付款进行清零
    public  void ClearChargeZeroMethod() {
        List<ChargeCategoryDO> List = chargeService.getChargeList();
        for (ChargeCategoryDO chargeCategoryDO : List) {
            chargeCategoryDO.setKzlCategoryValue("0.00");
            chargeCategoryDO.setYlbCategoryValue("0.00");
            chargeCategoryDO.setMiddleCategoryValue("0.00");
            chargeCategoryDO.setSouthCategoryValue("0.00");
            chargeCategoryDO.setNorthCategoryValue("0.00");
            chargeService.AddChargeCategory(chargeCategoryDO);
        }
    }
}
