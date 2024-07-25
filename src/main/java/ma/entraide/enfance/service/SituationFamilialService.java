package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.SituationFamilial;
import ma.entraide.enfance.entity.SituationFamilial;
import ma.entraide.enfance.repository.SituationFamilialRepo;
import ma.entraide.enfance.repository.SituationFamilialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SituationFamilialService {
    @Autowired
    private SituationFamilialRepo situationFamilialRepo;

    public List<SituationFamilial> getAllSituationsFamilial() {
        return situationFamilialRepo.findAll();
    }

    public SituationFamilial getById(Long id) {
        Optional<SituationFamilial> situationFamilial = situationFamilialRepo.findById(id);
        if(situationFamilial.isPresent()){
            return situationFamilial.get();
        }
        else {
            throw new ResourceNotFoundException("cas de SituationFamilial introuvable");
        }
    }

    public SituationFamilial addSituationFamilial(SituationFamilial situationFamilial){
        return situationFamilialRepo.save(situationFamilial);
    }

    public void deleteSituationFamilial(Long id){
        situationFamilialRepo.deleteById(id);
    }
}
