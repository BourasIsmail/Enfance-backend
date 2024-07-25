package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.SituationDeRue;
import ma.entraide.enfance.service.SituationDeRueService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituationDeRueRepo extends JpaRepository<SituationDeRue, Long> {
}
