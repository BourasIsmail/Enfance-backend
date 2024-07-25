package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.Mendicite;
import ma.entraide.enfance.entity.SituationMedical;
import ma.entraide.enfance.repository.MendiciteRepo;
import ma.entraide.enfance.repository.SituationMedicalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MendiciteService {
    @Autowired
    private MendiciteRepo mendiciteRepo;
    public List<Mendicite> getAllMendicites() {
        return mendiciteRepo.findAll();
    }
    public Mendicite getMendiciteByID(Long id) {
        Optional<Mendicite> mendicite = mendiciteRepo.findById(id);
        if (mendicite.isPresent()) {
            return mendicite.get();
        }
        else {
            throw new ResourceNotFoundException(" cas de Mendicite  introuvable");
        }
    }
    public Mendicite addMendicite(Mendicite mendicite) {
        return mendiciteRepo.save(mendicite);
    }

    public void deleteMendicite(Long id) {
        mendiciteRepo.deleteById(id);
    }
}
