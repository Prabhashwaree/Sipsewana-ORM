package view.tm;

import entity.Student;
import entity.TrainingProgram;

public class Student_RegistrationTm {
    private String registerId;
    private String registerDate;
    private String programIdRegister;
    private String studentIdRegister;
    private double payment;

    public Student_RegistrationTm() {
    }


    public Student_RegistrationTm(String registerId, String registerDate, String programIdRegister, String studentIdRegister, double payment) {
        this.setRegisterId(registerId);
        this.setRegisterDate(registerDate);
        this.setProgramIdRegister(programIdRegister);
        this.setStudentIdRegister(studentIdRegister);
        this.setPayment(payment);
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getProgramIdRegister() {
        return programIdRegister;
    }

    public void setProgramIdRegister(String programIdRegister) {
        this.programIdRegister = programIdRegister;
    }

    public String getStudentIdRegister() {
        return studentIdRegister;
    }

    public void setStudentIdRegister(String studentIdRegister) {
        this.studentIdRegister = studentIdRegister;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Student_RegistrationTm{" +
                "registerId='" + registerId + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", programIdRegister='" + programIdRegister + '\'' +
                ", studentIdRegister='" + studentIdRegister + '\'' +
                ", payment=" + payment +
                '}';
    }
}
