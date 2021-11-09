package com.uni.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    /**
     *
     * @param vorname
     * @param nachname
     * @param studentID
     * studentID este folosit pentru a identifica mai usor studentul care trebuie identificat, la fel cum s a cerut si la teacher un ID
     */
    private long studentId;
    private int totalCredits;
    private List<Long> enrolledCourses;


    public Student(String vorname, String nachname, long studentID) {
        super(vorname, nachname);
        this.studentId = studentID;
        this.totalCredits = totalCredits;
        this.enrolledCourses = new ArrayList<>();
    }

    public Student(String vorname, String nachname, long studentID, int totalCredits, List<Long> enrolledCourses) {
        super(vorname, nachname);
        this.studentId = studentID;
        this.totalCredits = totalCredits;
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", totalCredits=" + totalCredits +
                ", enrolledCourses=" + enrolledCourses +
                '}' +super.toString();
    }

    //Getters

    @Override
    public String getNachname() {
        return super.getNachname();
    }

    @Override
    public String getVorname() {
        return super.getVorname();
    }

    public long getStudentId() {
        return studentId;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public List<Long> getEnrolledCourses() {
        return enrolledCourses;
    }

    //Setters

    @Override
    public void setNachname(String nachname) {
        super.setNachname(nachname);
    }

    @Override
    public void setVorname(String vorname) {
        super.setVorname(vorname);
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public void setEnrolledCourses(List<Long> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }


}



