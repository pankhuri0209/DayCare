package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.service.StudentService;
import edu.neu.csye6200.util.TestDataUtilities;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudentController {
    @Autowired
    StudentService studentService;

    public void addTestData(){
        URL resourceUrl = getClass().getResource("/Students.csv");
     //   studentService.saveStudents(new TestDataUtilities().populateStudentData("C:\\Users\\HP\\Desktop\\NEU_Study\\Semester1\\OOPS\\FinalProject\\Archive (2)\\workspace_final_project_team7\\daycare-main\\src\\main\\resources\\Students.csv"));

        if (resourceUrl != null) {
            // Convert the URL to a file path
            String filePath = resourceUrl.getPath();

            // Use the file path to populate student data
            studentService.saveStudents(new TestDataUtilities().populateStudentData(filePath));
        } else {
            System.err.println("Unable to locate Students.csv in the resources folder.");
        }
    }

    public void displayAllStudents(){
        studentService.getAllStudents().forEach(System.out::println);
    }

    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }
    public void removeStudentById(Integer id){
        studentService.deleteStudentById(id);
    }
    public Optional<Student> readStudentById(Integer id){
        return studentService.getStudentById(id);
    }

    public void addStudent(String csv){
        studentService.saveStudent(csv);
    }
}
