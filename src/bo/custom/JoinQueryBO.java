package bo.custom;

import bo.SuperBO;
import dto.customDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface JoinQueryBO extends SuperBO {
    ObservableList<customDTO> observebleCustomList(String id)throws SQLException,ClassNotFoundException;
}
