package kisland.kislandmain.Util;

import com.alibaba.fastjson.JSON;
import kisland.kislandmain.DO.BankBalanceDO;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 对期初和期末受限资金进行操作的工具类
 */
public class OperationBankBalance {


    /**
     * 获取某公司在一定时间段内的当天最新余额数据
     * @param list
     * @throws ParseException
     */
    public static Map<String, String>  createGroupByDay(List<BankBalanceDO> list) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, List<BankBalanceDO>> map = new HashMap<>();
        Map<String, String> MapFinal = new HashMap<>();
        Set<String> set = new LinkedHashSet<>();
//======================================将前台传来的时间段划分日=======================================================
        for (BankBalanceDO bankBalanceDO : list) {
            String date = bankBalanceDO.getDate();
            Date date1 = simpleDateFormat.parse(date);
            date = simpleDateFormat1.format(date1);
            set.add(date);
        }
//======================================将前台传来的时间段划分日========================================================
//======================================将根据日期划分不同的集合========================================================
        for (String day : set) {
            List<BankBalanceDO> list1 = new ArrayList<>();
            for (BankBalanceDO bankBalanceDO : list) {
                if (bankBalanceDO.getDate().contains(day)) {
                    list1.add(bankBalanceDO);
                }
            }
            map.put(day, list1);
        }
//======================================将根据日期划分不同的集合==========================================================

//======================================将获取每一天中最新事件的余额数======================================================
        for (Map.Entry<String, List<BankBalanceDO>> entry : map.entrySet())
        {
            List<BankBalanceDO> list1 = entry.getValue();
            List<Date> dataList = new ArrayList<>();
            //获取当天所有的时间
            for (BankBalanceDO bankBalanceDO:list1){
                if (bankBalanceDO.getDate()!=null){
                    dataList.add(simpleDateFormat.parse(bankBalanceDO.getDate()));
                }
            }
            //获取当天最新的时刻
            Date max = Collections.max(dataList);
            //根据最新时刻获取余额数
            for (BankBalanceDO bankBalanceDO:list1){
                if (bankBalanceDO.getDate().equals(simpleDateFormat.format(max))){
                    MapFinal.put(entry.getKey(),bankBalanceDO.getAccountBalance());
                }
            }
        }
        //======================================将获取每一天中最新事件的余额数======================================================
        return  MapFinal;
    }

    public static String getYesterday(String today){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = "";
        Calendar calendar = Calendar.getInstance();
        try {
            Date todayDate = simpleDateFormat.parse(today);
            calendar.setTime(todayDate);
            calendar.add(Calendar.DAY_OF_MONTH, -1);//前一天的时间
             date = simpleDateFormat1.format(calendar.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
