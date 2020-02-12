package js.project.MedicalCentre.controller;

import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.service.SearchDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorSearchController {

    private SearchDoctorService searchDoctorService;

    @Autowired
    public DoctorSearchController(SearchDoctorService searchDoctorService) {
        this.searchDoctorService = searchDoctorService;
    }

    @GetMapping(value = "/doctors")
    public List<Doctor> getAllDoctors(){
        return searchDoctorService.findAll();
    }
}
