package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepo extends JpaRepository<Centre, Long> {
}
