package kisland.kislandmain.Service.Mid;

import kisland.kislandmain.DO.ChargeCategoryDO;
import kisland.kislandmain.DO.IncomeCategoryDO;

import java.util.List;
import java.util.Map;

public interface MiddleIncomeAndChargeService {
    //根据分类获取中区收款数据
    Map<String, String> getMidIncomeByType(String startTime, String endTime, List<IncomeCategoryDO> list);
    //根据分类获取中区付款数据
    Map<String, String> getMidChargeByType(String startTime,String endTime,List<ChargeCategoryDO> list);
}
