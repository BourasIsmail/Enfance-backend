package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.SituationFinanciere;
import ma.entraide.enfance.entity.SituationFinanciere;
import ma.entraide.enfance.entity.SituationFinanciere;
import ma.entraide.enfance.repository.SituationFinanciereRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SituationFinanciereService {
    @Autowired
    private SituationFinanciereRepo situationFinanciereRepo;
    
    public List<SituationFinanciere> getAllSituationFinancieres() {
        return situationFinanciereRepo.findAll();
    }
    public SituationFinanciere getSituationFinanciereById(Long id) {
        Optional<SituationFinanciere>situationFinanciere = situationFinanciereRepo.findById(id);
        if (situationFinanciere.isPresent()) {
            return situationFinanciere.get();
        }
        else {
            throw new ResourceNotFoundException("cas de SituationFinanciere introuvable");
        }
    }
    public SituationFinanciere addSituationFinanciere(SituationFinanciere situationFinanciere){
        return situationFinanciereRepo.save(situationFinanciere);
    }

    public void deleteSituationFinanciere(Long id) {
        situationFinanciereRepo.deleteById(id);
    }
}
