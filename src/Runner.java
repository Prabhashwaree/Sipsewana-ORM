import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import entity.Student;
import entity.Student_Registration;
import entity.TrainingProgram;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.io.IOException;
import java.util.Date;

public class Runner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/MainForm.fxml"))));
        primaryStage.setTitle("");
        primaryStage.centerOnScreen();
        primaryStage.show();


       /* Student student=new Student();
        student.setId("S006");
        student.setName("Nethmini");
        student.setAge("22");
        student.setGender("Female");
        student.setAddress("Panadura");

        System.out.println(student);

        TrainingProgram trainingProgram = new TrainingProgram();
        trainingProgram.setProgramId("P006");
        trainingProgram.setDate("2021/12/27");
        trainingProgram.setProgramName("Maths");
        trainingProgram.setDuration("6 month");
        trainingProgram.setFee(5000);

        Student_Registration student_registration = new Student_Registration();
        student_registration.setRegistrationId("R006");
        student_registration.setStudent(student);
        student_registration.setTrainingProgram(trainingProgram);
        student_registration.setDate("2021/12/26");
        student_registration.setRegistrationProgram("math");
        student_registration.setPayment(50000);



        System.out.println(trainingProgram);

        System.out.println(FactoryConfiguration.getSessionFactory());

        SessionFactory sessionFactory=FactoryConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
*//*session.save(customer);
        session.save(item);
        session.save(person);
        session.save(passport);

session.save(owner);
        session.save(pet1);
        session.save(pet2);*//*

        session.save(student);
        session.save(trainingProgram);
        session.save(student_registration);

        transaction.commit();
        session.close();*/

    }
}
