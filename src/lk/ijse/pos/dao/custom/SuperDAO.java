package lk.ijse.pos.dao.custom;

import lk.ijse.pos.model.Customer;

import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface SuperDAO<T,ID> {
    static boolean add(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(ID id) throws Exception;

    T search(ID id) throws Exception;

    ArrayList<T> getAll() throws Exception;

}
