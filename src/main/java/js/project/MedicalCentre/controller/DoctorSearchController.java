package js.project.MedicalCentre.controller;

import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.service.FindDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class DoctorSearchController {

    private FindDoctorService findDoctorService;

    @Autowired
    public DoctorSearchController(FindDoctorService findDoctorService) {
        this.findDoctorService = findDoctorService;
    }

    @GetMapping
    @PostMapping
    public String searchForDoctors(@RequestParam String surname, @RequestParam String specialization,
                                 @RequestParam String city, Model model){

        try{
            List<Doctor> foundDoctors
                    = findDoctorService.findDoctorBySurnameAndSpecializationAndCity(surname, specialization, city);

            model.addAttribute("doctorsList", foundDoctors);

        }catch(IllegalArgumentException ex){

            model.addAttribute("warning", "Invalid SPECIALIZATION provided.");
        }

        return "searchResults";
    }
}
