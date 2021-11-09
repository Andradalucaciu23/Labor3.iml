package com.uni;
import com.uni.model.Teacher;
import com.uni.model.Student;
import com.uni.model.Course;
import com.uni.repository.RegistrationSystem;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Teacher teacher1 = new Teacher("Ana", "Popescu", 1);
        Teacher teacher2 = new Teacher("Maria", "Pop", 2);

        Course course1 = new Course("MAP", teacher1.getTeacherId(), 1, 1, 160, 6);
        Course course2 = new Course("BD", teacher1.getTeacherId(), 2, 2, 90, 5);
        Course course3 = new Course("RC", teacher2.getTeacherId(), 2, 3, 100, 6);

        Student student1 = new Student("Andrada", "Lucaciu", 10);
        Student student2 = new Student("Maria", "Lucaciu", 11);

        RegistrationSystem registrationSystem = new RegistrationSystem();
        registrationSystem.getStudentRepository().save(student1);
        registrationSystem.getStudentRepository().save(student2);

        registrationSystem.getCourseRepository().save(course1);
        registrationSystem.getCourseRepository().save(course2);
        registrationSystem.getCourseRepository().save(course3);

        System.out.println("---------------------------");
        //courses list
        for (Course course : registrationSystem.getAllCourses()) {
            System.out.println(course);
        }

        //registrationSystem.register(course1, student1);
        //registrationSystem.register(course1.getCourseId(), student2.getStudentId());



        System.out.println("----------------------------");
        //free places
        for (Map.Entry map : registrationSystem.retrieveCoursesWithFreePlaces().entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }

        registrationSystem.changeCredits(100, 10);

        System.out.println("----------------------------------");
        //courses list
        for (Course course : registrationSystem.getAllCourses()) {
            System.out.println(course);
        }

        System.out.println("-----------------------------");
        //delete courses
        registrationSystem.deleteCourse((int) course3.getCourseId());

        System.out.println("---------------------------");
        //the current list of courses
        for (Course course:registrationSystem.getAllCourses()) {
            System.out.println(course);
        }
    }
}