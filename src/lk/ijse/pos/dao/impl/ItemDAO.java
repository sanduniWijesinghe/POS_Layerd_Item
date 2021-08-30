package lk.ijse.pos.dao.impl;

import lk.ijse.pos.model.Item;

import java.util.ArrayList;

public interface ItemDAO {
    boolean addItem(Item item) throws Exception;

    boolean deleteItem(String code) throws Exception;

    boolean updateItem(Item item) throws Exception;

    boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception;

    Item searchItem(String code) throws Exception;

    ArrayList<Item> getAllItems() throws Exception;
}

