package lk.ijse.pos.bo.custom;

import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface PurchaseOrderBO {
    boolean purchaseOrder(Orders order, ArrayList<OrderDetails> orderDetails) throws Exception;
}
