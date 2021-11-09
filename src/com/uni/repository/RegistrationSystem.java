package com.uni.repository;

import com.uni.model.Course;
import com.uni.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RegistrationSystem {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public RegistrationSystem() {
        this.courseRepository = new CourseRepository();
        this.studentRepository = new StudentRepository();
        this.teacherRepository = new TeacherRepository();
    }

    //Getters

    public CourseRepository getCourseRepository() {
        return this.courseRepository;
    }

    public StudentRepository getStudentRepository() {
        return this.studentRepository;
    }

    public TeacherRepository getTeacherRepository() {
        return this.teacherRepository;
    }

public boolean register(Course course, Student student) throws IOException {
    boolean courseCheck = false;
    boolean studentCheck = false;

    //verificam daca exista cursrul repsectiv
    for (int i = 0; i < this.courseRepository.repoList.size(); i++) {
        if (course.getName() == this.courseRepository.repoList.get(i).getName()) {
            courseCheck = true;
            break;
        }
    }
    //verificam daca exista studentul respectiv
    for (int i = 0; i < this.studentRepository.repoList.size(); i++) {
        if (student.getStudentId() == this.studentRepository.repoList.get(i).getStudentId()) {
            studentCheck = true;
            break;
        }
    }
    //calculam numarul total de credite -> creditele pe care le are deja studentul + creditele cursului curent
    int totalCredit = student.getTotalCredits() + course.getCredits();


    //daca se depaseste nr maxim de credite (30) atunci se afiseaza mesaj de aroare -> exceptie
    if (totalCredit > 30 || course.getStudentsEnrolled().size() > course.getMaxEnrollment()) {
        System.out.println("Anzahl der Credits oder Anzahl der Studierenden überschritten");
        throw new IOException();
    }
    else {
        //altfel  daca nu se depaseste trebuie sa facem inregistrarea
        boolean courseLCheck = false;
        boolean studentLCheck = false;

        List<Long> courseList = new ArrayList<>();
        //si verificam daca in lista de cursuri a studentului se regaseste si cursrul pe care noi il cautam
        for (int i = 0; i < studentRepository.repoList.size(); i++) {
            if (studentRepository.repoList.get(i).getStudentId() == student.getStudentId()) {
                for (int j = 0; j < studentRepository.repoList.get(i).getEnrolledCourses().size(); j++) {
                    if (studentRepository.repoList.get(i).getEnrolledCourses().get(j) != course.getCourseId()) {
                        courseLCheck = true;
                        break;
                    }
                    //daca nu il gaseste il adauga
                    courseList.add(studentRepository.repoList.get(i).getEnrolledCourses().get(j));
                }
            }
        }
        //daca nu exista deloc il pune in lista de cursuri
        if (courseLCheck = false) {
            courseList.add(course.getCourseId());
        }

        List<Long> studentList = new ArrayList<>();

        //la fel si in cazul studentilor
        for (int i = 0; i < courseRepository.repoList.size(); i++) {
            if (courseRepository.repoList.get(i).getName() == course.getName()) {
                for (int j = 0; j < courseRepository.repoList.get(i).getStudentsEnrolled().size(); j++) {
                    if (student.getStudentId() == courseRepository.repoList.get(i).getStudentsEnrolled().get(j)) {
                        studentLCheck = true;
                        break;
                    }
                    studentList.add(courseRepository.repoList.get(i).getStudentsEnrolled().get(j));
                }
            }
        }

        if (studentLCheck = false) {
            studentList.add(student.getStudentId());
        }

        //si se face update pt noul curs si noul student
        Course newCourse = new Course(course.getName(), course.getTecher(), course.getMaxEnrollment(), course.getCredits());
        courseRepository.update(newCourse);

        Student newStudent = new Student(student.getVorname(), student.getNachname(), student.getStudentId(), student.getTotalCredits(), student.getEnrolledCourses());
        studentRepository.update(newStudent);

        courseRepository.update(newCourse);
        studentRepository.update(newStudent);

    }
    return true;
}

    public HashMap<Integer, Course> retrieveCoursesWithFreePlaces() {
        HashMap<Integer, Course> map = new HashMap<Integer, Course>();
        int free = 0;
        for (Course c : courseRepository.findAll()) {
            if (c.getMaxEnrollment() > c.getStudentsEnrolled().size()) {
                free = (int) (c.getMaxEnrollment() - c.getStudentsEnrolled().size());
                map.put(free, c);
            }
        }
        return map;
    }

    public List<Long> retrieveStudentsEnrolledForACourse(int courseID) {
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < this.courseRepository.repoList.size(); i++) {
            if (this.courseRepository.repoList.get(i).getCourseId() == courseID) {
                list.addAll(this.courseRepository.repoList.get(i).getStudentsEnrolled());
                break;
            }
        }
        return list;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    public boolean changeCredits(int courseId, int newCredit) throws IOException{
        for(int i=0; i<courseRepository.repoList.size();i++){
            if(courseRepository.repoList.get(i).getCredits() == newCredit)
                return true;
            else{
                Course course = this.courseRepository.repoList.get(i);
                Course newCourse = new Course(course.getName(), course.getTecher(), (int) course.getCourseId(), course.getMaxEnrollment());

                this.courseRepository.update(newCourse);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(int courseId){
        for(int i=0;i<courseRepository.repoList.size(); i++){
            if(this.courseRepository.repoList.get(i).getCourseId() == courseId)
                this.courseRepository.delete(this.courseRepository.repoList.get(i));
                //this.courseRepository.repoList := this.courseRepository.findAll()
        }
        /*
        //parcurgem repo student pt a sterge cursul repsectiv
        for(int i=0;i<studentRepository.repoList.size();i++){
            if(this.courseRepository.repoList.get(i).getCourseId() == courseId)
                this.studentRepository.delete(this.studentRepository.repoList.get(i));
        }

        //parcurgem repo teacher pt a sterge cursul repsectiv
        for(int i=0;i<teacherRepository.repoList.size();i++){
            if(this.courseRepository.repoList.get(i).getCourseId() == courseId)
                this.teacherRepository.delete(this.teacherRepository.repoList.get(i));
        }
*/
        return true;
    }



}
