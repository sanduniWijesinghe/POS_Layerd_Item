package lk.ijse.pos.dao.impl;

import lk.ijse.pos.model.OrderDetails;

public interface OrderDetailsDAO {
    boolean addOrderDetails(OrderDetails oDetails) throws Exception;
}

