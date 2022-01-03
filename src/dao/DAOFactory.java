package dao;

import dao.custom.impl.QueryDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dao.custom.impl.Student_RegistrationDAOImpl;
import dao.custom.impl.TrainingProgramDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        if(daoFactory==null){
           daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    public SuperDAO getDAO(DAOType type){
        switch (type){
            case STUDENT:
                return new StudentDAOImpl();
            case TRAININGPROGRAM:
                return new TrainingProgramDAOImpl();
            case STUDENT_REGISTRATION:
                return new Student_RegistrationDAOImpl();
            case PROGRAM_INFORMATION:
                return new QueryDAOImpl();
            default:
                return null;
        }

    }
    public enum DAOType{
        STUDENT, TRAININGPROGRAM, STUDENT_REGISTRATION,PROGRAM_INFORMATION;
    }
}
