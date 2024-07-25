package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.Violence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolenceRepo extends JpaRepository<Violence, Long> {
}
