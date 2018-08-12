package service;

import pojo.Customer;
import pojo.QueryVo;
import utils.Page;

public interface CustomerService {

    Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    Customer queryCustomerById(Long id);

    void updateCustomer(Customer customer);

    void deleteCustomerById(Long id);
}
