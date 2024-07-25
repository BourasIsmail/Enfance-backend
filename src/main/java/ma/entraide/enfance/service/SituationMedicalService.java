package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.SituationMedical;
import ma.entraide.enfance.repository.SituationMedicalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SituationMedicalService {
    @Autowired
    private SituationMedicalRepo situationMedicalRepo;
    public List<SituationMedical> getAllSituationsMedical() {
        return situationMedicalRepo.findAll();
    }
    public SituationMedical getSituationMedicalById(Long id) {
        Optional<SituationMedical> situationMedical = situationMedicalRepo.findById(id);
        if (situationMedical.isPresent()) {
            return situationMedical.get();
        }
        else {
            throw new ResourceNotFoundException(" cas de Situation medical introuvable");
        }
    }
    public SituationMedical addSituationMedical(SituationMedical situationMedical) {
        return situationMedicalRepo.save(situationMedical);
    }

    public void deleteSituationMedicalById(Long id) {
        situationMedicalRepo.deleteById(id);
    }
}
