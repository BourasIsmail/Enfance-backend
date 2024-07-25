package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.Handicap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandicapRepo extends JpaRepository<Handicap, Long> {
}
