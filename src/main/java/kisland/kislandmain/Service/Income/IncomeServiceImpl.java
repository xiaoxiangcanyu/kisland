package kisland.kislandmain.Service.Income;

import kisland.kislandmain.DAO.IncomeAndCharge.IncomeCategoryDAO;
import kisland.kislandmain.DO.IncomeCategoryDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeCategoryDAO incomeCategoryDAO;

    /**
     * 获取收款名单的集合
     * @return
     */
    @Override
    public List<IncomeCategoryDO> getIncomeService() {
        List<IncomeCategoryDO> list = incomeCategoryDAO.findAll();
        return list;
    }

    /**
     * 添加收款种类
     */
    @Override
    public void AddIncomeCategory(IncomeCategoryDO incomeCategoryDO) {
        incomeCategoryDAO.save(incomeCategoryDO);
    }

    /**
     * 根据id删除收款种类
     */
    @Override
    public void DeleteIncomeCategory(int id) {
        incomeCategoryDAO.deleteById(id);
    }
}
