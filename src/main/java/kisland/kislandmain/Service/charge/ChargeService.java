package kisland.kislandmain.Service.charge;

import kisland.kislandmain.DO.ChargeCategoryDO;
import kisland.kislandmain.DO.ChargeCategoryDO;

import java.util.List;

public interface ChargeService {
    //获取付款种类列表
    List<ChargeCategoryDO> getChargeList();
    //添加收款统计种类
    void  AddChargeCategory(ChargeCategoryDO chargeCategoryDO);

    //删除收款统计种类
    void  DeleteChargeCategory(int id);
}
