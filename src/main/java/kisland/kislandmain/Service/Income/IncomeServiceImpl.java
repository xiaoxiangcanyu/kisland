package kisland.kislandmain.Service.Income;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import kisland.kislandmain.DAO.IncomeAndCharge.IncomeCategoryDAO;
import kisland.kislandmain.DO.IncomeCategoryDO;
import kisland.kislandmain.Service.Mid.MiddleIncomeAndChargeService;
import kisland.kislandmain.Service.North.NorthIncomeAndChargeService;
import kisland.kislandmain.Service.South.SouthIncomeAndChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kisland.kislandmain.Util.AddColumn.AddChargeColumnMethod;
import static kisland.kislandmain.Util.AddColumn.AddIncomeColumnMethod;

@Transactional
@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeCategoryDAO incomeCategoryDAO;
    @Autowired
    private NorthIncomeAndChargeService northIncomeAndChargeService;
    @Autowired
    private SouthIncomeAndChargeService southIncomeAndChargeService;
    @Autowired
    private MiddleIncomeAndChargeService middleIncomeAndChargeService;
    /**
     * 获取收款名单的集合
     * @return
     */
    @Override
    public List<IncomeCategoryDO> getIncomeService() {
        List<IncomeCategoryDO> list = incomeCategoryDAO.findAll();
        return list;
    }

    /**
     * 添加收款种类
     */
    @Override
    public void AddIncomeCategory(IncomeCategoryDO incomeCategoryDO) {
        incomeCategoryDAO.save(incomeCategoryDO);
    }

    /**
     * 根据id删除收款种类
     */
    @Override
    public void DeleteIncomeCategory(int id) {
        incomeCategoryDAO.deleteById(id);
    }

    @Override
    public Map<String, String> CombineAllIncome(String startTime,String endTime) {
        Map<String,String> finalMap = new HashMap<>();
        Map<String, String> map = northIncomeAndChargeService.getNorthIncomeByType(startTime, endTime);
        List<IncomeCategoryDO> list = JSONArray.parseArray(map.get("收款渠道"),IncomeCategoryDO.class);
        Map<String, String> map1 = middleIncomeAndChargeService.getMidIncomeByType(startTime, endTime,list);
        List<IncomeCategoryDO> list2 = JSONArray.parseArray(map1.get("收款渠道"),IncomeCategoryDO.class);
        Map<String, String> map2 = southIncomeAndChargeService.getSouthIncomeByType(startTime, endTime,list2);
        List<IncomeCategoryDO> list3 = JSONArray.parseArray(map2.get("收款渠道"),IncomeCategoryDO.class);
        finalMap.put("收款渠道", JSON.toJSONString(list3));
        finalMap.put("北区收款",map.get("北区"));
        finalMap.put("凯知乐收款",map.get("凯知乐"));
        finalMap.put("中区收款",map1.get("中区"));
        finalMap.put("南区收款",map2.get("南区"));
        Double sum = Double.parseDouble(finalMap.get("北区收款").replace(",","")) + Double.parseDouble(finalMap.get("中区收款").replace(",",""))+ Double.parseDouble(finalMap.get("南区收款").replace(",",""));
        finalMap.put("收款总计",sum+"");
        finalMap = AddIncomeColumnMethod(finalMap,"收款总计");
        return finalMap;
    }
}
