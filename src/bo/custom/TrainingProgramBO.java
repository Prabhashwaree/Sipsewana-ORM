package bo.custom;

import bo.SuperBO;
import dto.TrainingProgramDTO;
import entity.TrainingProgram;
import javafx.collections.ObservableList;
import view.tm.TrainingProgramTm;

import java.sql.SQLException;


public interface TrainingProgramBO extends SuperBO {

    boolean addProgram(TrainingProgramDTO trainingProgramDTO)throws Exception, ClassNotFoundException;

    boolean updateProgram(TrainingProgramDTO trainingProgramDTO)throws Exception, ClassNotFoundException;

    boolean deleteProgram(String id)throws  Exception, ClassNotFoundException;

    TrainingProgram searchProgram(String id)throws SQLException, ClassNotFoundException;

    ObservableList<TrainingProgramTm> getAll()throws Exception, ClassNotFoundException;
}
