package test;

import com.uni.model.Course;
import com.uni.model.Person;
import com.uni.model.Student;
import com.uni.model.Teacher;
import com.uni.repository.CourseRepository;
import com.uni.repository.PersonRepository;
import com.uni.repository.StudentRepository;
import com.uni.repository.TeacherRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryRepositoryTest {
    private final PersonRepository personRepository = new PersonRepository();
    private final Person person1 = new Person("Lucaciu", "Andrada");

    private final StudentRepository studentRepository = new StudentRepository();
    private final Student student1 = new Student("Bun", "Ioana", 9);

    private final TeacherRepository teacherRepository = new TeacherRepository();
    private final Teacher teacher1 = new Teacher("Popescu", "Lucian", 2);

    private final CourseRepository courseRepository = new CourseRepository();
    private final Course course1 = new Course("MAP", 1, 160, 58);

    @Test
    void findOne() {
        personRepository.save(person1);
        assertEquals(person1, personRepository.findOne(0));

        studentRepository.save(student1);
        assertEquals(student1, studentRepository.findOne(0));

        teacherRepository.save(teacher1);
        assertEquals(teacher1, teacherRepository.findOne(0));

        courseRepository.save(course1);
        assertEquals(course1, courseRepository.findOne(0));
    }

    @Test
    void findAll() {
        personRepository.save(person1);
        assertEquals(1, personRepository.findAll().size());

        studentRepository.save(student1);
        assertEquals(1, studentRepository.findAll().size());

        teacherRepository.save(teacher1);
        assertEquals(1, teacherRepository.findAll().size());

        courseRepository.save(course1);
        assertEquals(1, courseRepository.findAll().size());
    }

    @Test
    void save() {
        assertEquals(person1, personRepository.save(person1));

        assertEquals(student1, studentRepository.save(student1));

        assertEquals(teacher1, teacherRepository.save(teacher1));

        assertEquals(course1, courseRepository.save(course1));
    }

    @Test
    void delete() {
        personRepository.save(person1);
        assertEquals(1, personRepository.findAll().size());
        personRepository.delete(person1);
        assertEquals(0, personRepository.findAll().size());
    }
}

