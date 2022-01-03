package dao.custom;

import dao.SuperDAO;
import dto.customDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO{
    ArrayList<customDTO>  getAllDetailsList(String id)throws SQLException, ClassNotFoundException;
}
