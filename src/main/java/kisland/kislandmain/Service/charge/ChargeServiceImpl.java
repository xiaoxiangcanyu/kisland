package kisland.kislandmain.Service.charge;

import kisland.kislandmain.DAO.IncomeAndCharge.ChargeCategoryDAO;
import kisland.kislandmain.DO.ChargeCategoryDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ChargeServiceImpl implements ChargeService {
    @Autowired
    private ChargeCategoryDAO chargeCategoryDAO;
    @Override
    public List<ChargeCategoryDO> getChargeList() {
        List<ChargeCategoryDO> list = chargeCategoryDAO.findAll();
        return list;
    }

    @Override
    public void AddChargeCategory(ChargeCategoryDO chargeCategoryDO) {
        chargeCategoryDAO.save(chargeCategoryDO);
    }

    @Override
    public void DeleteChargeCategory(int id) {
        chargeCategoryDAO.deleteById(id);
    }
}
