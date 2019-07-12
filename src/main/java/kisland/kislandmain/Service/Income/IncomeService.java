package kisland.kislandmain.Service.Income;

import kisland.kislandmain.DO.IncomeCategoryDO;

import java.util.List;

public interface IncomeService {
    //获取所有的收款统计列表
    List<IncomeCategoryDO> getIncomeService();

    //添加收款统计种类
    void  AddIncomeCategory(IncomeCategoryDO incomeCategoryDO);

    //删除收款统计种类
    void  DeleteIncomeCategory(int id);
}
