package js.project.MedicalCentre.configuration;

import js.project.MedicalCentre.model.AcademicTitle;
import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.model.Specialization;
import js.project.MedicalCentre.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

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

        Doctor d2 = new Doctor("jannowak", AcademicTitle.MD, "Jan", "Nowak",
                "123 456 788", "jannowak@gmail.com", "77010145649", "1234568");

        Doctor d3 = new Doctor("karoliksinski", AcademicTitle.PROF, "Karol", "Iksinski",
                "123 456 787", "karoliksinski@gmail.com", "66010152933", "1234569");

        Doctor d4 = new Doctor("janinanowakowska", AcademicTitle.PROF, "Janina", "Nowakowska",
                "123 456 786", "janinanowakowska@gmail.com", "80010181388", "2234569");

        Doctor d5 = new Doctor("rozaliakowalczykowa", AcademicTitle.PROF, "Rozalia", "Kowalczykowa",
                "123 456 785", "rozaliakowalczykowa@gmail.com", "70010111883", "3234569");

        d1.setSpecializations(Arrays.asList(Specialization.CARDIOLOGIST, Specialization.HEART_SURGEON));
        d2.setSpecializations(Arrays.asList(Specialization.INTERNIST));
        d3.setSpecializations(Arrays.asList(Specialization.ONCOLOGIST));
        d4.setSpecializations(Arrays.asList(Specialization.DERMATOLOGIST));
        d5.setSpecializations(Arrays.asList(Specialization.INTERNIST));

        doctorRepository.save(d1);
        doctorRepository.save(d2);
        doctorRepository.save(d3);
        doctorRepository.save(d4);
        doctorRepository.save(d5);

    }
}
