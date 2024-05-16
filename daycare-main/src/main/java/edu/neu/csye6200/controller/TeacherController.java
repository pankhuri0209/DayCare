package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.service.TeacherService;
import edu.neu.csye6200.util.TestDataUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.Optional;



@Component
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    public void addTestData(){

       // teacherService.saveTeachers(new TestDataUtilities().populateTeacherData("C:\\Users\\HP\\Desktop\\NEU_Study\\Semester1\\OOPS\\FinalProject\\Archive (2)\\workspace_final_project_team7\\daycare-main\\src\\main\\resources\\Teachers.csv"));
      //  teacherService.saveTeachers(new TestDataUtilities().populateTeacherData("C:\\Users\\HP\\Desktop\\NEU_Study\\Semester1\\OOPS\\FinalProject\\Archive (2)\\workspace_final_project_team7\\daycare-main\\src\\main\\resources\\Teachers.csv"));

        // Get the resource URL
        URL resourceUrl = getClass().getResource("/Teachers.csv");

// Check if the resource exists
        if (resourceUrl != null) {
            // Convert the URL to a file path
            String filePath = resourceUrl.getPath();

            // Use the file path to populate student data
            teacherService.saveTeachers(new TestDataUtilities().populateTeacherData(filePath));
        } else {
            System.err.println("Unable to locate Students.csv in the resources folder.");
        }
    }

    public void displayAllTeachers(){
        teacherService.getAllTeachers().forEach(System.out::println);
    }

    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }
    public void removeTeacherById(Integer id){
        teacherService.deleteTeacherById(id);
    }
    public Optional<Teacher> getTeacherById(Integer id){
        return teacherService.getTeacherById(id);
    }

    public void addTeacher(String csv){
        teacherService.saveTeacher(csv);
    }


}
