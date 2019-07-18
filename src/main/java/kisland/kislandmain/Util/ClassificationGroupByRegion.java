package kisland.kislandmain.Util;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据区域将公司划分
 */
public class ClassificationGroupByRegion {
    public static Map<String, String> ClassificationMethodGroupByRegion(Map<String, String> map) {
        Map<String, String> groupMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().contains("凯知乐")) {
                groupMap.put("凯知乐-"+entry.getKey(),entry.getValue());
            } else if (entry.getKey().contains("北京") || (entry.getKey().contains("天津") && !entry.getKey().contains("凯知乐"))) {
                groupMap.put("北区-"+entry.getKey(),entry.getValue());
            } else if (entry.getKey().contains("上海")) {
                groupMap.put("中区-"+entry.getKey(),entry.getValue());
            } else if (entry.getKey().contains("广州") || entry.getKey().contains("深圳") || entry.getKey().contains("成都")) {
                groupMap.put("南区-"+entry.getKey(),entry.getValue());
            }
        }
        return groupMap;
    }

    public static Double SumByGroup(Double sum,String value){
        sum = Double.parseDouble(value.replace(",",""));
        return sum;
    }

    public static Map<String,String> SumByYesterdyAndtoday(Map<String,String> FinalMap,Map<String,String> CompanyMap,String timescope){
        Double KZLBalanceAmount = 0.00;
        Double NorthBalanceAmount = 0.00;
        Double MiddleBalanceAmount = 0.00;
        Double SouthBalanceAmount = 0.00;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        CompanyMap = ClassificationMethodGroupByRegion(CompanyMap);
        for (Map.Entry<String, String> entry : CompanyMap.entrySet()) {
            if (entry.getKey().contains("凯知乐")) {
                KZLBalanceAmount = Double.parseDouble(entry.getValue().replace(",",""));
                FinalMap.put(timescope+"-" + entry.getKey(), entry.getValue());
            } else if (entry.getKey().contains("北区")){
                NorthBalanceAmount = SumByGroup(NorthBalanceAmount,entry.getValue());
            }else if (entry.getKey().contains("中区")){
                MiddleBalanceAmount = SumByGroup(MiddleBalanceAmount,entry.getValue());
            }else if (entry.getKey().contains("南区")){
                SouthBalanceAmount = SumByGroup(SouthBalanceAmount,entry.getValue());
            }
            FinalMap.put(timescope+"-北区", decimalFormat.format(NorthBalanceAmount));
            FinalMap.put(timescope+"-中区", decimalFormat.format(MiddleBalanceAmount));
            FinalMap.put(timescope+"-南区", decimalFormat.format(SouthBalanceAmount));
            FinalMap.put(timescope+"-总和",decimalFormat.format(SouthBalanceAmount+NorthBalanceAmount+MiddleBalanceAmount+KZLBalanceAmount));

        }
        return FinalMap;
    }
}
