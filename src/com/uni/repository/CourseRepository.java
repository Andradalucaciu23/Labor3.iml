package com.uni.repository;

import com.uni.model.Course;

public class CourseRepository extends InMemoryRepository<Course>{

    public CourseRepository(){
        super();
    }

    /**
     * se actualizeaza cursul
     * filter: The filter method is used to select elements as per the Predicate passed as argument.
     * forEach: The forEach method is used to iterate through every element of the stream.
     * orElseThrwo:is used to get the value of this Optional instance if present.
     * @param entity
     * @return courseUpdate
     */

    @Override
    public Course update(Course entity) {
        Course courseUpdate = this.repoList.stream().filter(course -> course.getCourseId() == entity.getCourseId()).findFirst().orElseThrow();

        courseUpdate.setName(entity.getName());
        courseUpdate.setTecher(entity.getTecher());
        courseUpdate.setMaxEnrollment(entity.getMaxEnrollment());
        courseUpdate.setStudentsEnrolled(entity.getStudentsEnrolled());
        courseUpdate.setCredits(entity.getCredits());

        return courseUpdate;
    }
}
