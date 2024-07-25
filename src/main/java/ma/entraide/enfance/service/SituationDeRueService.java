package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.SituationDeRue;
import ma.entraide.enfance.repository.SituationDeRueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SituationDeRueService {
    @Autowired
    private SituationDeRueRepo situationDeRueRepo;

    public List<SituationDeRue> getAllSituationsdDeRue() {
        return situationDeRueRepo.findAll();
    }

    public SituationDeRue getById(Long id) {
        Optional<SituationDeRue> situationDeRue = situationDeRueRepo.findById(id);
        if(situationDeRue.isPresent()){
            return situationDeRue.get();
        }
        else {
            throw new ResourceNotFoundException("cas de situationDeRue introuvable");
        }
    }

    public SituationDeRue addSituationDeRue(SituationDeRue situationDeRue){
        return situationDeRueRepo.save(situationDeRue);
    }

    public void deleteSituationDeRue(Long id) {
        situationDeRueRepo.deleteById(id);
    }
}
