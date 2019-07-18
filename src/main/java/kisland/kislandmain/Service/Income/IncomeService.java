package kisland.kislandmain.Service.Income;

import kisland.kislandmain.DO.IncomeCategoryDO;

import java.util.List;
import java.util.Map;

public interface IncomeService {
    //获取所有的收款统计列表
    List<IncomeCategoryDO> getIncomeService();

    //添加收款统计种类
    void  AddIncomeCategory(IncomeCategoryDO incomeCategoryDO);

    //删除收款统计种类
    void  DeleteIncomeCategory(int id);

    //合并北中南三区的收款数据
    Map<String,String> CombineAllIncome(String startTime,String endTime);
}
