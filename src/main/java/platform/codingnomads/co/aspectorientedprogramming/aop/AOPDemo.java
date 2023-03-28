package platform.codingnomads.co.aspectorientedprogramming.aop;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import platform.codingnomads.co.aspectorientedprogramming.aop.model.Student;
import platform.codingnomads.co.aspectorientedprogramming.aop.service.StudentService;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class AOPDemo implements CommandLineRunner {

    private final StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(AOPDemo.class);
    }

    @Override
    public void run(String... args) throws Exception {

        studentService.saveAllStudents(Arrays.asList(
                Student.builder().email("student1@example.com").name("student1").build(),
                Student.builder().email("student2@example.com").name("student2").build(),
                Student.builder().email("student3@example.com").name("student3").build()
        ));

        studentService.fetchAllStudents();


            List<Student> studentsToSave = Arrays.asList(
                    Student.builder().email("student25@example.com").name("Student 25").build(),
                    Student.builder().email("student50@example.com").name("student 50").build(),
                    Student.builder().email("student75@example.com").name("student 75").build()
            );


            studentService.saveAllStudents(studentsToSave);
        }



    }


