package js.project.MedicalCentre.service;

import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.model.Specialization;
import js.project.MedicalCentre.repository.DoctorRepository;
import js.project.MedicalCentre.repository.LocalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindDoctorService {

    private DoctorRepository doctorRepository;
    private LocalizationRepository localizationRepository;

    @Autowired
    public FindDoctorService(DoctorRepository doctorRepository, LocalizationRepository localizationRepository) {
        this.doctorRepository = doctorRepository;
        this.localizationRepository = localizationRepository;
    }

    public List<Doctor> findDoctorBySurnameAndSpecializationAndCity(String surname, String specialization, String city){

        List<Doctor> doctorsBySurnameAndSpecialization =
                doctorRepository.findDoctorByLastNameAndSpecialization(surname,
                        (specialization.length() == 0) ? null : Specialization.valueOf(specialization));

        List<Doctor> doctorsByCity =
                localizationRepository.findDoctorByCity(city);

        doctorsBySurnameAndSpecialization.retainAll(doctorsByCity);

        return doctorsBySurnameAndSpecialization;
    }
}
