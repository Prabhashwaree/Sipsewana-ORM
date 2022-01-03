package dao.custom;

import dao.CrudDAO;
import entity.Student;
import entity.TrainingProgram;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TrainingProgramDAO extends CrudDAO<TrainingProgram,String> {

}
