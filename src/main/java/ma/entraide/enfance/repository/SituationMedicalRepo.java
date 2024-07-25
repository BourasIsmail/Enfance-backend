package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.SituationMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituationMedicalRepo extends JpaRepository<SituationMedical, Long> {
}
