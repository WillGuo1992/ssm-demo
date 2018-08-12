package controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.BaseDict;
import pojo.Customer;
import pojo.QueryVo;
import service.BaseDictService;
import service.CustomerService;
import utils.Page;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-08-12 16:37
 **/
@Controller
@RequestMapping(value = "customer")
public class CustomerController {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("list")
    public String queryCustomerList(QueryVo queryVo,Model model) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(queryVo.getCustName())) {
            queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
        }

        List<BaseDict> fromType = baseDictService.getBaseDictByCode("002");
        List<BaseDict> industryType = baseDictService.getBaseDictByCode("001");
        List<BaseDict> levelType = baseDictService.getBaseDictByCode("006");
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        Page<Customer> page = customerService.queryCustomerByQueryVo(queryVo);
        model.addAttribute("page", page);

        model.addAttribute("custName", queryVo.getCustName());
        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustry());
        model.addAttribute("custLevel", queryVo.getCustLevel());
        return "customer";
    }

    @RequestMapping("edit")
    @ResponseBody
    public Customer queryCustomerById(Long id) {
        Customer customer = customerService.queryCustomerById(id);
        return customer;
    }

    @RequestMapping("update")
    @ResponseBody
    public String updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
        return "OK";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String deleteCustomerById(Long id) {
        customerService.deleteCustomerById(id);
        return "OK";
    }
}
