package js.project.MedicalCentre.service;

import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.model.Specialization;
import js.project.MedicalCentre.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindDoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public FindDoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findDoctorBySurnameAndSpecializationAndCity(String surname, String specialization, String city){

        return doctorRepository.findDoctorByLastNameAndSpecializationAndCity(surname,
                (specialization.length() == 0) ? null : Specialization.valueOf(specialization),
                city);
    }
}
