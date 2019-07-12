package kisland.kislandmain.Service.North;


import kisland.kislandmain.DO.ChargeCategoryDO;
import kisland.kislandmain.DO.IncomeCategoryDO;

import java.util.List;
import java.util.Map;

/**
 * 北区的收款
 */
public interface NorthIncomeAndChargeService {
    //根据分类获取北区收款数据
    Map<String, String> getNorthIncomeByType(String startTime,String endTime);
    //根据分类获取北区付款数据
    Map<String, String> getNorthChargeByType(String startTime,String endTime);


}
