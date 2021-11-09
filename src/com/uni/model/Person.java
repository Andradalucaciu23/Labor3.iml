package com.uni.model;

public class Person {
    /**
     *
     * @param nachname
     * @param vorname
     */
    public String nachname;
    public String vorname;

    /**
     *Constructor pentru clasa Person
     */
    public Person(String nachname, String vorname) {
        this.nachname = nachname;
        this.vorname = vorname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                '}';
    }


    //Getters
    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    //Setters
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
