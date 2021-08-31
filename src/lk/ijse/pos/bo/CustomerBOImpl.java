package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.CustomerBO;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.impl.DAOFactory;
import lk.ijse.pos.model.Customer;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class CustomerBOImpl implements CustomerBO {
    /* Property Injection*/
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(Customer customer) throws Exception {
        return customerDAO.add(customer);
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws Exception {
        return customerDAO.update(customer);
    }

    @Override
    public Customer searchCustomer(String id) throws Exception {
        return customerDAO.search(id);
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws Exception {
        return customerDAO.getAll();
    }


}
