package kisland.kislandmain.Service.BankService;

import kisland.kislandmain.DO.AgriculturalBankDO;
import kisland.kislandmain.DO.ChinaBankDO;

import java.util.List;

public interface ChinaBankService {
    /**
     * 根据公司名称和时间获取银行明细
     * @param accountTitle
     * @return
     */
    List<ChinaBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime);

    List<ChinaBankDO> findAll();

    /**
     * 根据时间段查寻农行数据
     * @param startTime
     * @param endTime
     * @return
     */
    List<ChinaBankDO> findByDate(String startTime, String endTime);
}
