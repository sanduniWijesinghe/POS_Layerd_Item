package lk.ijse.pos.bo;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.dao.impl.CustomerDAOImpl;
import lk.ijse.pos.dao.impl.ItemDAOImpl;
import lk.ijse.pos.dao.impl.OrderDAOImpl;
import lk.ijse.pos.dao.impl.OrderDetailDAOImpl;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.util.ArrayList;

public class OrderBOImpl {
    OrderDAO orderDAO=new OrderDAOImpl();
    CustomerDAO customerDAO=new CustomerDAOImpl();
    ItemDAO itemDAO=new ItemDAOImpl();
    OrderDetailDAO orderDetailDAO=new OrderDetailDAOImpl();

    public boolean placeOrder(Orders order, ArrayList<OrderDetails> orderDetails) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean add=orderDAO.add(order);

        if(add){
            for (OrderDetails od:orderDetails){
                boolean res=orderDetailDAO.add(od);
                if(!res){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;

                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

    }
}
