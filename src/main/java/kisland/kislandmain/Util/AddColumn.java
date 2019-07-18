package kisland.kislandmain.Util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Map;

/**
 * 每隔3位加一逗号
 */
public class AddColumn {
    /**
     * 给收款类型
     *
     * @param incomeMap
     */
    public static Map<String, String> AddIncomeColumnMethod(Map<String, String> incomeMap, String scope) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormat decimalFormat1 = new DecimalFormat("#,##0.00");
        switch (scope){
            case "北区":
            try {
                incomeMap.put("凯知乐", decimalFormat1.format(decimalFormat.parse(incomeMap.get("凯知乐"))));
                incomeMap.put("北区", decimalFormat1.format(decimalFormat.parse(incomeMap.get("北区"))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            break;
            case "中区":
                try {
                    incomeMap.put("中区", decimalFormat1.format(decimalFormat.parse(incomeMap.get("中区"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "南区":
                try {
                    incomeMap.put("南区", decimalFormat1.format(decimalFormat.parse(incomeMap.get("南区"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "总计":
                try {
                    incomeMap.put("总计", decimalFormat1.format(decimalFormat.parse(incomeMap.get("总计"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "收款总计":
                try {
                    incomeMap.put("收款总计", decimalFormat1.format(decimalFormat.parse(incomeMap.get("收款总计"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

//            List<IncomeCategoryDO> list = JSON.parseArray(incomeMap.get("收款渠道"));

        return incomeMap;
    }

    /**
     * 给付款类型
     *
     * @param chargeMap
     */
    public static Map<String, String> AddChargeColumnMethod(Map<String, String> chargeMap,String scope) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        DecimalFormat decimalFormat1 = new DecimalFormat("#,##0.00");
        switch (scope){
            case "北区":
                try {
                    chargeMap.put("凯知乐", decimalFormat1.format(decimalFormat.parse(chargeMap.get("凯知乐"))));
                    chargeMap.put("北区", decimalFormat1.format(decimalFormat.parse(chargeMap.get("北区"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "中区":
                try {
                    chargeMap.put("中区", decimalFormat1.format(decimalFormat.parse(chargeMap.get("中区"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "南区":
                try {
                    chargeMap.put("南区", decimalFormat1.format(decimalFormat.parse(chargeMap.get("南区"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "总计":
                try {
                    chargeMap.put("总计", decimalFormat1.format(decimalFormat.parse(chargeMap.get("总计"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "付款总计":
                try {
                    chargeMap.put("付款总计", decimalFormat1.format(decimalFormat.parse(chargeMap.get("付款总计"))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        return chargeMap;
    }
}
