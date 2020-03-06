package js.project.MedicalCentre.repository;

import js.project.MedicalCentre.model.Doctor;
import js.project.MedicalCentre.model.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Long> {

    @Query("SELECT doctors FROM Localization l WHERE (:city like '' or l.city = :city)")
    List<Doctor> findDoctorByCity(@Param("city") String city);
}
