package com.uni.model;

import java.util.List;

public class Teacher extends Person {
    /**
     *
     * @param nachname
     * @param vorname
     * @param teacherId
     * atributele necesare pentru clasa Teacher
     */
    private long teacherId;
    private List<Long> courses;

    /**
     *Constructor pentru clasa Teacher
     */
    public Teacher(String nachname, String vorname, long teacherId) {
        super(nachname, vorname);
        this.teacherId = teacherId;
    }

    public Teacher(String nachname, String vorname, long teacherId, List<Long> courses) {
        super(nachname, vorname);
        this.teacherId = teacherId;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", courses=" + courses +
                '}'+ super.toString();
    }

    //Getters

    public long getTeacherId() {
        return teacherId;
    }

    public List<Long> getCourses() {
        return courses;

    }

    @Override
    public String getNachname() {
        return super.getNachname();
    }
    @Override
    public String getVorname() {
        return super.getVorname();
    }
    //Setters
    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public void setCourses(List<Long> courses) {
        this.courses = courses;
    }

    @Override
    public void setNachname(String nachname) {
        super.setNachname(nachname);
    }

    @Override
    public void setVorname(String vorname) {
        super.setVorname(vorname);
    }
}
