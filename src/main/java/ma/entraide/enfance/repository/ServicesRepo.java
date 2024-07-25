package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepo extends JpaRepository<Services, Long> {
}
