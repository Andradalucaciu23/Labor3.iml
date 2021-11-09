package com.uni.model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    /**
     * @param name
     * @param teacherId
     * @param techerId
     * @param courseId
     * @param maxEnrollment
     * @param credits
     * atributele necesare pentru clasa Course
     */
    private String name;
    private int techerId;
    private long courseId;
    private int maxEnrollment;
    private List<Long> studentsEnrolled;
    private int credits;

    /**
     *Constructor pentru clasa Course
     * courseId folosit pentru a identifica mai usor cursul despre care este vorba
     */
    public Course(String name, long teacherId, int techerId, int courseId, long maxEnrollment, int credits){
        this.name = name;
        this.techerId = techerId;
        this.courseId = courseId;
        this.maxEnrollment = (int) maxEnrollment;
        this.studentsEnrolled = new ArrayList<>();
        this.credits = credits;
    }


    public Course(String name, int techerId, long courseId, int maxEnrollment) {
        this.name = name;
        this.techerId = techerId;
        this.courseId = courseId;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getTecher() {
        return techerId;
    }

    public long getCourseId() {
        return courseId;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public List<Long> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTecher(int techerId) {
        this.techerId = techerId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public void setStudentsEnrolled(List<Long> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Vorlesung{" +
                "name='" + name + '\'' +
                ", lehrer=" + techerId +
                ", vorlesungID=" + courseId +
                ", maxEnrollment=" + maxEnrollment +
                ", studentsEnrolled=" + studentsEnrolled +
                ", credits=" + credits +
                '}';
    }

}
