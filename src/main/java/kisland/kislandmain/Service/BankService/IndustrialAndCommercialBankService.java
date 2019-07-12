package kisland.kislandmain.Service.BankService;

import kisland.kislandmain.DO.AgriculturalBankDO;
import kisland.kislandmain.DO.IndustrialAndCommercialBankDO;

import java.util.List;

public interface IndustrialAndCommercialBankService {
    /**
     * 根据公司名称和时间获取银行明细
     * @param accountTitle
     * @return
     */
    List<IndustrialAndCommercialBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime);

    List<IndustrialAndCommercialBankDO> findAll();

    /**
     * 根据时间段查寻农行数据
     * @param startTime
     * @param endTime
     * @return
     */
    List<IndustrialAndCommercialBankDO> findByDate(String startTime, String endTime);
}
