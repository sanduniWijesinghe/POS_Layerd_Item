package lk.ijse.pos.bo;

import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.impl.ItemDAOImpl;
import lk.ijse.pos.model.Item;

import java.util.ArrayList;

public class ItemBOImpl {
    ItemDAO dao=new ItemDAOImpl();

    public boolean addItem(Item item) throws Exception {
        return dao.add(item);

    }
    public boolean updateItem(Item item) throws Exception {
        return dao.update(item);

    }
    public boolean deleteItem(String id) throws Exception {
        return dao.delete(id);

    }
    public Item searchItem(String id) throws Exception {
        return dao.search(id);

    }
    public ArrayList<Item> getAllItem() throws Exception {
        return dao.getAll();

    }
    public boolean updateItemQtyOnHand(String code,int qty) throws Exception {
        return dao.updateItemQtyOnHand(code,qty);
    }
}
