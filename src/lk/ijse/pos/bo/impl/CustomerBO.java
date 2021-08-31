package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerBO extends SuperBO {
    boolean addCustomer(CustomerDTO customer) throws Exception;

    boolean deleteCustomer(String id) throws Exception;

    boolean updateCustomer(CustomerDTO customer) throws Exception;

    CustomerDTO searchCustomer(String id) throws Exception;

    ArrayList<CustomerDTO> getAllCustomers() throws Exception;
}
