package kisland.kislandmain.Service.BankService;

import kisland.kislandmain.DO.AgriculturalBankDO;

import java.util.List;

public interface AgriculturalBankService {
    /**
     * 根据公司名称和时间获取银行明细
     * @param accountTitle
     * @return
     */
    List<AgriculturalBankDO> findByAccountTitleAndDatetime(String accountTitle, String startDateTime, String endDateTime);

    List<AgriculturalBankDO> findAll();

    /**
     * 根据时间段查寻农行数据
     * @param startTime
     * @param endTime
     * @return
     */
    List<AgriculturalBankDO> findByDate(String startTime,String endTime);
}
