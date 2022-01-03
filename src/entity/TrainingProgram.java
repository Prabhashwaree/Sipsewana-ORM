package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TrainingProgram {
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private String programId;
    private String program;
    private String duration;
    private double fee;


    @OneToMany(mappedBy = "trainingProgram" ,cascade = CascadeType.ALL/*,fetch = FetchType.EAGER*/)
    private List<Student_Registration> student_registrations=new ArrayList();

    public TrainingProgram() {
    }

    public TrainingProgram(String programId) {
        this.programId = programId;
    }

    public TrainingProgram(String programId, String program, String duration, double fee) {
        this.programId = programId;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
    }

    public TrainingProgram(String programId, String program, String duration, double fee, List<Student_Registration> student_registrations) {
        this.setProgramId(programId);
        this.setProgram(program);
        this.setDuration(duration);
        this.setFee(fee);
        this.setStudent_registrations(student_registrations);
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<Student_Registration> getStudent_registrations() {
        return student_registrations;
    }

    public void setStudent_registrations(List<Student_Registration> student_registrations) {
        this.student_registrations = student_registrations;
    }

    @Override
    public String toString() {
        return "TrainingProgram{" +
                "programId='" + programId + '\'' +
                ", program='" + program + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                ", student_registrations=" + student_registrations +
                '}';
    }
}
