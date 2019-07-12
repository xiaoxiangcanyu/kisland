package kisland.kislandmain.Util;

import com.alibaba.fastjson.JSON;
import kisland.kislandmain.DO.IncomeCategoryDO;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 每隔3位加一逗号
 */
public class AddColumn {
    /**
     * 给收款类型
     * @param incomeMap
     */
    public static Map<String,String> AddIncomeColumnMethod(Map<String,String> incomeMap){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormat decimalFormat1 = new DecimalFormat("#,##0.00");

        try {
            incomeMap.put("凯知乐", decimalFormat1.format(decimalFormat.parse(incomeMap.get("凯知乐"))));
            incomeMap.put("北区", decimalFormat1.format(decimalFormat.parse(incomeMap.get("北区"))));
            incomeMap.put("总计", decimalFormat1.format(decimalFormat.parse(incomeMap.get("总计"))));
//            List<IncomeCategoryDO> list = JSON.parseArray(incomeMap.get("收款渠道"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  incomeMap;
    }

    /**
     * 给付款类型
     * @param chargeMap
     */
    public static Map<String,String> AddChargeColumnMethod(Map<String,String> chargeMap){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormat decimalFormat1 = new DecimalFormat("#,##0.00");

        try {
            chargeMap.put("凯知乐", decimalFormat1.format(decimalFormat.parse(chargeMap.get("凯知乐"))));
            chargeMap.put("北区", decimalFormat1.format(decimalFormat.parse(chargeMap.get("北区"))));
            chargeMap.put("总计", decimalFormat1.format(decimalFormat.parse(chargeMap.get("总计"))));
//            List<IncomeCategoryDO> list = JSON.parseArray(incomeMap.get("收款渠道"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chargeMap;
    }
}
