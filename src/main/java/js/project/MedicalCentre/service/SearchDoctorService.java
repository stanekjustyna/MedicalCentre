package js.project.MedicalCentre.service;

import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.repository.DoctorRepository;
import js.project.MedicalCentre.repository.LocalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchDoctorService {

    private DoctorRepository doctorRepository;

    private LocalizationRepository localizationRepository;

    @Autowired
    public SearchDoctorService(DoctorRepository doctorRepository, LocalizationRepository localizationRepository) {
        this.doctorRepository = doctorRepository;
        this.localizationRepository = localizationRepository;
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

}
