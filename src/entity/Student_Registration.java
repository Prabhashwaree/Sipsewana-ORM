package entity;

import javax.persistence.*;

@Entity
public class Student_Registration {

    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private String registrationId;

    /* @Temporal(TemporalType.DATE)*/
    private String date;

    @ManyToOne/*(*//*fetch = FetchType.LAZY*//*cascade = CascadeType.ALL)*/
    private TrainingProgram trainingProgram;

    @ManyToOne/*(*//*fetch = FetchType.LAZY*//**//*cascade = CascadeType.ALL*//*)*/
    private Student student;

    private double payment;

    public Student_Registration() {
    }


    public Student_Registration(String registrationId, String date, TrainingProgram trainingProgram, Student student, double payment) {
        this.setRegistrationId(registrationId);
        this.setDate(date);
        this.setTrainingProgram(trainingProgram);
        this.setStudent(student);
        this.setPayment(payment);
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Student_Registration{" +
                "registrationId='" + registrationId + '\'' +
                ", date='" + date + '\'' +
                ", trainingProgram=" + trainingProgram +
                ", student=" + student +
                ", payment=" + payment +
                '}';
    }
}
