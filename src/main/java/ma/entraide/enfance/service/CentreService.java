package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.Centre;
import ma.entraide.enfance.repository.CentreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentreService {
    @Autowired
    private CentreRepo centreRepo;

    public List<Centre> getAllCentres() {
        return centreRepo.findAll();
    }

    public Centre getCentreById(Long id) {
        Optional<Centre> centre = centreRepo.findById(id);
        if (centre.isPresent()) {
            return centre.get();
        }
        else {
            throw new ResourceNotFoundException("Centre not found");
        }
    }
}
