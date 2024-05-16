/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.service.VaccinationService;
import edu.neu.csye6200.util.TestDataUtilities;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class VaccinationController {
    @Autowired
    VaccinationService vaccinationService;

    public void addTestData(){
        // Get the resource URL
        URL resourceUrl = getClass().getResource("/vaccines.csv");
        //vaccinationService.saveVaccinations(new TestDataUtilities().populateVaccineData("C:\\Users\\HP\\Desktop\\NEU_Study\\Semester1\\OOPS\\FinalProject\\Archive (2)\\workspace_final_project_team7\\daycare-main\\src\\main\\resources\\vaccines.csv"));
// Check if the resource exists
        if (resourceUrl != null) {
            // Convert the URL to a file path
            String filePath = resourceUrl.getPath();

            // Use the file path to populate student data
            vaccinationService.saveVaccinations(new TestDataUtilities().populateVaccineData(filePath));
        } else {
            System.err.println("Unable to locate Students.csv in the resources folder.");
        }
    }

    public void displayAllVaccines(){
        vaccinationService.getAllVaccinations().forEach(System.out::println);
    }

    public List<Immunization> getAllVaccines(){
        return vaccinationService.getAllVaccinations();
    }
    public void removeVaccineById(Integer id){
        vaccinationService.deleteVaccinationsById(id);
    }
    public Optional<Immunization> getVaccinesById(Integer id){
        return vaccinationService.getVaccinationById(id);
    }

    public void addVaccine(String csv){
        vaccinationService.saveVaccination(csv);
    }
}
