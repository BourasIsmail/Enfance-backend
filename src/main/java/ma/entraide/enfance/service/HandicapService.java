package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.Handicap;
import ma.entraide.enfance.repository.HandicapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HandicapService {

    @Autowired
    private HandicapRepo handicapRepo;

    public List<Handicap> getAllHandicaps() {
        return handicapRepo.findAll();
    }

    public Handicap getHandicapById(Long id) {
        Optional<Handicap> handicap = handicapRepo.findById(id);
        if (handicap.isPresent()){
            return handicap.get();
        }
        else {
            throw new ResourceNotFoundException("cas d'handicap n'existe pas");
        }
    }

    public Handicap addHandicap(Handicap handicap) {
        return handicapRepo.save(handicap);
    }

    public void deleteHandicap(Long id) {
        handicapRepo.deleteById(id);
    }

}
