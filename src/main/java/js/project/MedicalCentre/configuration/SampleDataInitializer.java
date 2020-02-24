package js.project.MedicalCentre.configuration;

import js.project.MedicalCentre.model.AcademicTitle;
import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.model.Localization;
import js.project.MedicalCentre.model.Specialization;
import js.project.MedicalCentre.repository.DoctorRepository;
import js.project.MedicalCentre.repository.LocalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class SampleDataInitializer {

    private DoctorRepository doctorRepository;
    private LocalizationRepository localizationRepository;

    @Autowired
    public SampleDataInitializer(DoctorRepository doctorRepository, LocalizationRepository localizationRepository) {
        this.doctorRepository = doctorRepository;
        this.localizationRepository = localizationRepository;
    }


    @PostConstruct
    public void init(){

        Localization l1 = new Localization("Mazovian", "Warsaw", "Al. Jerozolimskie",
                "14A", "34A", "3", null );

        Localization l2 = new Localization("Mazovian", "Warsaw", "Al. Niepodległosci",
                "69", "58", "4", null );

        Localization l3 = new Localization("Mazovian", "Cracow", "Krakowska",
                "40", "58", "6", null );

        localizationRepository.save(l1);
        localizationRepository.save(l2);
        localizationRepository.save(l3);

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
        d5.setSpecializations(Arrays.asList(Specialization.CARDIOLOGIST));

        d1.setLocalizations(Arrays.asList(l1));
        d2.setLocalizations(Arrays.asList(l2));
        d3.setLocalizations(Arrays.asList(l3));
        d4.setLocalizations(Arrays.asList(l3, l1));

        doctorRepository.save(d1);
        doctorRepository.save(d2);
        doctorRepository.save(d3);
        doctorRepository.save(d4);
        doctorRepository.save(d5);

    }
}
