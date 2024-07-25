package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.SituationFamilial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituationFamilialRepo extends JpaRepository<SituationFamilial, Long> {
}
