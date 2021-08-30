package lk.ijse.pos.dao.impl;

import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

public interface OrderDAO {
    boolean addOrder(Orders orders) throws Exception;
    boolean deleteOrder();
    boolean updateOrder();
    Orders searchOrder();
    ArrayList<Orders> getAllOrders();
}

