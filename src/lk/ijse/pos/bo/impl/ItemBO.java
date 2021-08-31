package lk.ijse.pos.bo.custom;

import lk.ijse.pos.model.Item;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface ItemBO {
    boolean addItem(Item item) throws Exception;

    boolean deleteItem(String code) throws Exception;

    boolean updateItem(Item item) throws Exception;

    Item searchItem(String code) throws Exception;

    ArrayList<Item> getAllItems() throws Exception;

    boolean updateItemQtyOnHand(String code, int qtyOnHand)throws Exception;
}
