package kisland.kislandmain.Service.BankService;

import kisland.kislandmain.DO.AgriculturalBankDO;
import kisland.kislandmain.DO.MerchantsBankDO;

import java.util.List;

public interface MerchantsBankService {
    /**
     * 根据公司名称和时间获取银行明细
     * @param accountTitle
     * @return
     */
    List<MerchantsBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime);

    List<MerchantsBankDO> findAll();

    /**
     * 根据时间段查寻农行数据
     * @param startTime
     * @param endTime
     * @return
     */
    List<MerchantsBankDO> findByDate(String startTime, String endTime);
}
