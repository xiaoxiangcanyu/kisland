package kisland.kislandmain.Service.charge;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import kisland.kislandmain.DAO.IncomeAndCharge.ChargeCategoryDAO;
import kisland.kislandmain.DO.ChargeCategoryDO;
import kisland.kislandmain.DO.IncomeCategoryDO;
import kisland.kislandmain.Service.Mid.MiddleIncomeAndChargeService;
import kisland.kislandmain.Service.North.NorthIncomeAndChargeService;
import kisland.kislandmain.Service.South.SouthIncomeAndChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kisland.kislandmain.Util.AddColumn.AddChargeColumnMethod;

@Transactional
@Service
public class ChargeServiceImpl implements ChargeService {
    @Autowired
    private ChargeCategoryDAO chargeCategoryDAO;
    @Autowired
    private NorthIncomeAndChargeService northIncomeAndChargeService;
    @Autowired
    private SouthIncomeAndChargeService southIncomeAndChargeService;
    @Autowired
    private MiddleIncomeAndChargeService middleIncomeAndChargeService;
    @Override
    public List<ChargeCategoryDO> getChargeList() {
        List<ChargeCategoryDO> list = chargeCategoryDAO.findAll();
        return list;
    }

    @Override
    public void AddChargeCategory(ChargeCategoryDO chargeCategoryDO) {
        chargeCategoryDAO.save(chargeCategoryDO);
    }

    @Override
    public void DeleteChargeCategory(int id) {
        chargeCategoryDAO.deleteById(id);
    }

    @Override
    public Map<String, String> CombineAllCharge(String startTime, String endTime) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Map<String,String> finalMap = new HashMap<>();
        Map<String, String> map = northIncomeAndChargeService.getNorthChargeByType(startTime, endTime);
        List<ChargeCategoryDO> list = JSONArray.parseArray(map.get("支出项目"),ChargeCategoryDO.class);
        Map<String, String> map1 = middleIncomeAndChargeService.getMidChargeByType(startTime, endTime,list);
        List<ChargeCategoryDO> list2 = JSONArray.parseArray(map1.get("支出项目"),ChargeCategoryDO.class);
        Map<String, String> map2 = southIncomeAndChargeService.getSouthChargeByType(startTime, endTime,list2);
        List<ChargeCategoryDO> list3 = JSONArray.parseArray(map2.get("支出项目"),ChargeCategoryDO.class);
        finalMap.put("付款渠道", JSON.toJSONString(list3));
        finalMap.put("北区付款",map.get("北区"));
        finalMap.put("凯知乐付款",map.get("凯知乐"));
        finalMap.put("中区付款",map1.get("中区"));
        finalMap.put("南区付款",map2.get("南区"));
        Double sum = Double.parseDouble(finalMap.get("北区付款").replace(",","")) + Double.parseDouble(finalMap.get("中区付款").replace(",",""))+ Double.parseDouble(finalMap.get("南区付款").replace(",",""));
        finalMap.put("付款总计",decimalFormat.format(sum)+"");
        finalMap = AddChargeColumnMethod(finalMap,"付款总计");
        return finalMap;
    }
}
