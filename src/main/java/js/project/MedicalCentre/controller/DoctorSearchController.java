package js.project.MedicalCentre.controller;

import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.model.Specialization;
import js.project.MedicalCentre.service.SearchDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/doctors/surname/{lastname}")
    public List<Doctor> getDoctorsBySurname(@PathVariable String lastname){
        return searchDoctorService.findByLastName(lastname);
    }

    @GetMapping(value = "/doctors/specialization/{specialization}")
    public List<Doctor> getDoctorsBySpecialization(@PathVariable Specialization specialization){
        return searchDoctorService.findBySpecialization(specialization);
    }


}
