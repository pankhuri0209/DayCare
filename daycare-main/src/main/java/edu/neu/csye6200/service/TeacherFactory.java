package edu.neu.csye6200.service;
import edu.neu.csye6200.model.*;


public class TeacherFactory extends AbstractPersonFactory<Teacher> {
    
    public Teacher getObject() {
        return new Teacher();
    }
    public Teacher getObject(String csvData) {
        return new Teacher(csvData);
    }


}
