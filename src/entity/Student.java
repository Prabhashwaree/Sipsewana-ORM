package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private String id;
    private String name;
    private String age;
    private String gender;
    private String address;



    @OneToMany(mappedBy ="student",cascade = CascadeType.ALL/*,fetch = FetchType.EAGER*/ )
    private List<Student_Registration> student_registrations= new ArrayList();

    public Student() {

    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String name, String age, String gender, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public Student(String id, String name, String age, String gender, String address, List<Student_Registration> student_registrations) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
        this.setAddress(address);
        this.setStudent_registrations(student_registrations);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Student_Registration> getStudent_registrations() {
        return student_registrations;
    }

    public void setStudent_registrations(List<Student_Registration> student_registrations) {
        this.student_registrations = student_registrations;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", student_registrations=" + student_registrations +
                '}';
    }
}
