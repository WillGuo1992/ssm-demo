package service.impl;

import mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Customer;
import pojo.QueryVo;
import service.CustomerService;
import sun.util.resources.cldr.chr.CalendarData_chr_US;
import utils.Page;

import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-08-12 18:27
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());
        List<Customer> list = customerMapper.queryCustomerByQueryVo(queryVo);
        int total = customerMapper.queryCountByQueryVo(queryVo);

        Page<Customer> page = new Page<>(total, queryVo.getPage(), queryVo.getRows(), list);
        return page;
    }

    @Override
    public Customer queryCustomerById(Long id) {
        return customerMapper.queryCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerMapper.deleteCustomerById(id);
    }


}
