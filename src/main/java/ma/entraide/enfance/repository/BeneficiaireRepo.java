package ma.entraide.enfance.repository;

import ma.entraide.enfance.entity.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaireRepo extends JpaRepository<Beneficiaire, Long> {
}
