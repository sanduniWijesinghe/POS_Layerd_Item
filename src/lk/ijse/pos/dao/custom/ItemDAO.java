package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.Item;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface ItemDAO extends CrudDAO<Item, String> {
    boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception;
}
