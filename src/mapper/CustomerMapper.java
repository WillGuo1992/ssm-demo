package mapper;

import pojo.Customer;
import pojo.QueryVo;

import java.util.List;

public interface CustomerMapper {

    List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    int queryCountByQueryVo(QueryVo queryVo);

    Customer queryCustomerById(Long id);

    void updateCustomer(Customer customer);

    void deleteCustomerById(Long id);
}
