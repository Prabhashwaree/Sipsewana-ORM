package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO{
    boolean add(T t)throws Exception, ClassNotFoundException;

    boolean delete(ID id)throws  Exception, ClassNotFoundException;

    boolean update(T t)throws Exception, ClassNotFoundException;

    T search(ID id) throws SQLException, ClassNotFoundException;

    ArrayList<T> getAll()throws Exception, ClassNotFoundException;
}
