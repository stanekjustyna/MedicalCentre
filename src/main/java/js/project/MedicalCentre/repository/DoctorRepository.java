package js.project.MedicalCentre.repository;

import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query(value="SELECT d FROM Doctor d JOIN d.localizations dl WHERE (:lastName like '' or d.lastName = :lastName) " +
            "and (:specializations is null or :specializations in elements(d.specializations))" +
            "and (:city like '' or dl.city = :city)")
    List<Doctor> findDoctorByLastNameAndSpecializationAndCity(@Param("lastName") String lastName,
                                                              @Param("specializations") Specialization specialization,
                                                              @Param("city") String city);
}
