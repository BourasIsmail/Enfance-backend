package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.Violence;
import ma.entraide.enfance.repository.ViolenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViolenceService {
    @Autowired
    private ViolenceRepo violenceRepo;

    public List<Violence> getAllViolences() {
        return violenceRepo.findAll();
    }

    public Violence getById(Long id) {
        Optional<Violence> violence = violenceRepo.findById(id);
        if(violence.isPresent()){
            return violence.get();
        }
        else {
            throw new ResourceNotFoundException("cas de violence introuvable");
        }
    }

    public Violence addViolence(Violence violence){
        return violenceRepo.save(violence);
    }

    public void deleteById(Long id) {
        violenceRepo.deleteById(id);
    }
}
