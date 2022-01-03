package bo;

import bo.custom.impl.JoinQueryBOImpl;
import bo.custom.impl.StudentBOImpl;
import bo.custom.impl.Student_RegistrationBOImpl;
import bo.custom.impl.TrainingProgramBOImpl;


public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory getBoFactory(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }
    public SuperBO getBo(BOType boType){
        switch (boType){

            case STUDENT:
                return new StudentBOImpl();

            case TRAININGPROGRAM:
                return new TrainingProgramBOImpl();

            case STUDENT_REGISTRATION:
                return new Student_RegistrationBOImpl();
            case PROGRAM_INFORMATION:
                return new JoinQueryBOImpl();
            default:
                return null;
        }

    }
    public enum BOType{
        STUDENT, TRAININGPROGRAM, STUDENT_REGISTRATION,PROGRAM_INFORMATION;
    }
}


