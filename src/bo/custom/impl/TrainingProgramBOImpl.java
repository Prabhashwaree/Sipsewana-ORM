package bo.custom.impl;

import bo.custom.StudentBO;
import bo.custom.TrainingProgramBO;
import dao.DAOFactory;
import dao.custom.impl.StudentDAOImpl;
import dao.custom.impl.TrainingProgramDAOImpl;
import dto.StudentDTO;
import dto.TrainingProgramDTO;
import entity.Student;
import entity.TrainingProgram;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.tm.StudentTm;
import view.tm.TrainingProgramTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainingProgramBOImpl implements TrainingProgramBO {

    TrainingProgramDAOImpl trainingProgramDAOImpl= (TrainingProgramDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.TRAININGPROGRAM);


    @Override
    public boolean addProgram(TrainingProgramDTO p) throws Exception, ClassNotFoundException {
        return trainingProgramDAOImpl.add(new TrainingProgram(p.getProgramId(),p.getProgram(),p.getDuration(),p.getFee()));
    }

    @Override
    public boolean updateProgram(TrainingProgramDTO p) throws Exception, ClassNotFoundException {
        return trainingProgramDAOImpl.update(new TrainingProgram(p.getProgramId(),p.getProgram(),p.getDuration(),p.getFee()));
    }

    @Override
    public boolean deleteProgram(String id) throws Exception, ClassNotFoundException {
        return trainingProgramDAOImpl.delete(id);
    }

    @Override
    public TrainingProgram searchProgram(String id) throws SQLException, ClassNotFoundException {
        return trainingProgramDAOImpl.search(id);
    }

    @Override
    public ObservableList<TrainingProgramTm> getAll() throws Exception, ClassNotFoundException {
        ArrayList<TrainingProgram> programList = trainingProgramDAOImpl.getAll();
        ObservableList<TrainingProgramTm> observableList= FXCollections.observableArrayList();
        programList.forEach(e->observableList.addAll(new TrainingProgramTm(e.getProgramId(),e.getProgram(),e.getDuration(),e.getFee())));
        return observableList;
    }
}
