package com.uni.repository;
import com.uni.model.Student;

public class StudentRepository extends InMemoryRepository<Student>{

    public StudentRepository(){
        super();
    }

    /**
     * @param entity
     * @return studentUpdate
     */

    @Override
    public Student update(Student entity) {
        Student studentUpdate = this.repoList.stream().filter(student -> student.getStudentId() == entity.getStudentId()).findFirst().orElseThrow();

        studentUpdate.setVorname(entity.getVorname());
        studentUpdate.setNachname(entity.getNachname());
        studentUpdate.setTotalCredits(entity.getTotalCredits());
        studentUpdate.setEnrolledCourses(entity.getEnrolledCourses());

        return studentUpdate;
    }
}
