package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.ClassificationCas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClassificationCasRepo extends JpaRepository<ClassificationCas, Long> {
}
