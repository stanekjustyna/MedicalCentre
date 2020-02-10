package js.project.MedicalCentre.configuration;

import js.project.MedicalCentre.model.AcademicTitle;
import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SampleDoctorInitializer {

    private DoctorRepository doctorRepository;

    @Autowired
    public SampleDoctorInitializer(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @PostConstruct
    public void init(){

        Doctor d1 = new Doctor("jankowalski", AcademicTitle.DR, "Jan", "Kowalski",
                "123 456 789", "jankowalski@gmail.com", "70010173159", "1234567");

        doctorRepository.save(d1);

    }
}
