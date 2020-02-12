package js.project.MedicalCentre.repository;

import js.project.MedicalCentre.model.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Long> {

    List<Localization> findAll();

}
