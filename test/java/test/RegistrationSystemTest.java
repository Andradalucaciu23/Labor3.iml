package test;


import com.uni.model.Course;
import com.uni.model.Student;
import com.uni.model.Teacher;
import com.uni.repository.RegistrationSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegistrationSystemTest {
    private RegistrationSystem registrationSystem = new RegistrationSystem();

    private final Student student1 = new Student("Bun", "Ioana", 9);
    private final Student student2 = new Student("Pop", "Cristian", 10);
    private final Student student3 = new Student("Capusan", "Victor", 11);

    private final Teacher teacher1 = new Teacher("Popescu", "Lucian", 2);
    private final Teacher teacher2 = new Teacher("Pop", "Ileana", 3);
    private final Teacher teacher3 = new Teacher("Mitroi", "Iuliana", 4);

    private final Course course1 = new Course("MAP", 2, 160, 58);
    private final Course course2 = new Course("BD", 3, 161, 70);
    private final Course course3 = new Course("RC", 4, 162, 100);

    public RegistrationSystemTest(){

        registrationSystem.getStudentRepository().save(student1);
        registrationSystem.getStudentRepository().save(student2);

        registrationSystem.getTeacherRepository().save(teacher1);
        registrationSystem.getTeacherRepository().save(teacher2);
        registrationSystem.getTeacherRepository().save(teacher3);

        registrationSystem.getCourseRepository().save(course1);
        registrationSystem.getCourseRepository().save(course2);
        registrationSystem.getCourseRepository().save(course3);
    }


    @Test
    void registerTest(){

    }

    @Test
    void retrieveCoursesWithFreePlaces() throws IOException {

    }


    @Test
    void retrieveStudentsEnrolledForACourse() throws IOException{
    }



    @Test
    void gettAllCourses() throws IOException{
        Assertions.assertEquals(3, registrationSystem.getAllCourses().size());
    }



    @Test
    void changeCredits() throws IOException{
        Assertions.assertTrue(registrationSystem.changeCredits(160, 5));
    }

    @Test
    void deleteCourse() throws IOException{
        Assertions.assertTrue(registrationSystem.deleteCourse((int) course1.getCourseId()));
    }




}
