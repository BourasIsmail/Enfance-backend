package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.Mendicite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MendiciteRepo extends JpaRepository<Mendicite, Long> {
}
