package kisland.kislandmain.Controller;

import com.alibaba.fastjson.JSON;
import kisland.kislandmain.DO.ChargeCategoryDO;
import kisland.kislandmain.DO.Mapping.PaymentMappingDO;
import kisland.kislandmain.DO.Mapping.ReceivingMappingDO;
import kisland.kislandmain.Service.Mapping.PaymentChannelService;
import kisland.kislandmain.Service.Mapping.ReceivingChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MappingController {
    @Autowired
    private ReceivingChannelService receivingChannelService;
    @Autowired
    private PaymentChannelService paymentChannelService;

    /**
     * 根据区域名获取收款规则
     * @param region
     * @return
     */
    @RequestMapping(value = "/getAllIncomeMapping")
    @ResponseBody
    public List<ReceivingMappingDO> getIncomeMapping(@RequestParam(value = "region") String region){
        List<ReceivingMappingDO> list = receivingChannelService.findByTradeScope(region);
        return list;
    }

    /**
     * 添加收款规则
     * @param receivingMappingDO
     * @return
     */
    @RequestMapping(value = "/addIncomeMapping")
    @ResponseBody
    public Map<String,String> addIncomeMapping(ReceivingMappingDO receivingMappingDO){
        Map<String,String> map = new HashMap<>();
        receivingChannelService.AddReceivingMapping(receivingMappingDO);
        map.put("result","success");
        return map;
    }
    /**
     * 删除收款规则
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteIncomeMapping")
    @ResponseBody
    public Map<String,String> deleteIncomeMapping(@RequestParam(value = "id") long id){
        Map<String,String> map = new HashMap<>();
        receivingChannelService.DeleteReceivingMapping(id);
        map.put("result","success");
        return map;
    }

    @RequestMapping(value = "/getAllChargeMapping")
    @ResponseBody
    public List<PaymentMappingDO> getAllChargeMapping(@RequestParam(value = "region") String region){
        List<PaymentMappingDO> list = paymentChannelService.findByTradescope(region);
        System.out.println(JSON.toJSONString(list,true));
        return list;
    }
    /**
     * 添加付款规则
     * @param paymentMappingDO
     * @return
     */
    @RequestMapping(value = "/addChargeMapping")
    @ResponseBody
    public Map<String,String> addChargeMapping(PaymentMappingDO paymentMappingDO){
        System.out.println(JSON.toJSONString(paymentMappingDO));
        Map<String,String> map = new HashMap<>();
        paymentChannelService.AddPaymentMapping(paymentMappingDO);
        map.put("result","success");
        return map;
    }
    /**
     * 删除付款规则
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteChargeMapping")
    @ResponseBody
    public Map<String,String> deleteChargeMapping(@RequestParam(value = "id") long id){
        Map<String,String> map = new HashMap<>();
        paymentChannelService.DeleteById(id);
        map.put("result","success");
        return map;
    }
}
