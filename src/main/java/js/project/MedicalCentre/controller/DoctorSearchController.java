package js.project.MedicalCentre.controller;

import js.project.MedicalCentre.service.FindDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        model.addAttribute("doctorsList",
        findDoctorService.findDoctorBySurnameAndSpecializationAndCity(surname, specialization, city));

        return "searchResults";
    }
}
