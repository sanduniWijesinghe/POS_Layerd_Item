package lk.ijse.pos.bo.custom;

import lk.ijse.pos.model.Customer;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerBO {
    boolean addCustomer(Customer customer) throws Exception;

    boolean deleteCustomer(String id) throws Exception;

    boolean updateCustomer(Customer customer) throws Exception;

    Customer searchCustomer(String id) throws Exception;

    ArrayList<Customer> getAllCustomers() throws Exception;
}
