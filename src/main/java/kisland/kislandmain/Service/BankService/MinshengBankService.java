package kisland.kislandmain.Service.BankService;

import kisland.kislandmain.DO.AgriculturalBankDO;
import kisland.kislandmain.DO.MinshengBankDO;

import java.util.List;

public interface MinshengBankService {
    /**
     * 根据公司名称和时间获取银行明细
     * @param accountTitle
     * @return
     */
    List<MinshengBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime);

    List<MinshengBankDO> findAll();

    /**
     * 根据时间段查寻农行数据
     * @param startTime
     * @param endTime
     * @return
     */
    List<MinshengBankDO> findByDate(String startTime, String endTime);
}
