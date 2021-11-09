package com.uni.repository;

import com.uni.model.Teacher;

public class TeacherRepository extends InMemoryRepository<Teacher>{

    public TeacherRepository(){
        super();
    }

    @Override
    public Teacher update(Teacher entity) {
        Teacher teacherUpdate = this.repoList.stream().filter(teacher -> teacher.getTeacherId() == entity.getTeacherId()).findFirst().orElseThrow();

        teacherUpdate.setVorname(entity.getVorname());
        teacherUpdate.setNachname(entity.getNachname());
        teacherUpdate.setCourses(entity.getCourses());

        return teacherUpdate;
    }
}
