package bo.custom.impl;

import bo.custom.JoinQueryBO;
import dao.DAOFactory;
import dao.custom.impl.QueryDAOImpl;
import dto.customDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import view.tm.customTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class JoinQueryBOImpl implements JoinQueryBO {

    QueryDAOImpl queryDAO = (QueryDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PROGRAM_INFORMATION);
    @Override
    public ObservableList observebleCustomList(String id) throws SQLException, ClassNotFoundException {
        ArrayList<customDTO> arrayList  = queryDAO.getAllDetailsList(id);
        ObservableList<customTm> observableList = FXCollections.observableArrayList();
        arrayList.forEach(e->observableList.addAll(new customTm(e.getName(),e.getProgramId(),e.getProgram(),e.getDuration())));
        return observableList;
    }
}
