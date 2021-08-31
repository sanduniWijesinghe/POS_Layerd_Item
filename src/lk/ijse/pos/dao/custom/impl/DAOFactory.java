package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dao.custom.impl.*;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public lk.ijse.pos.dao.SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERDETAILS:
                return new OrderDetailsDAOImpl();
            case QUERY:
                return (SuperDAO) new QueryDAOImpl();
            default:
                return null;
        }

    }

    /*Supply Types*/
    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAILS, QUERY
    }


}
