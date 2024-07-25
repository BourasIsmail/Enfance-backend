package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.SituationFinanciere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituationFinanciereRepo extends JpaRepository<SituationFinanciere, Long> {
}
