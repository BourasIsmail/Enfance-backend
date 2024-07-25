package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.ClassificationCas;
import ma.entraide.enfance.repository.ClassificationCasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassificationCasService {

    @Autowired
    private ClassificationCasRepo classificationCasRepo;

    public List<ClassificationCas> getAllClassificationCas() {
        return classificationCasRepo.findAll();
    }


    public ClassificationCas getClassificationCasById(Long id) {
        Optional<ClassificationCas> classificationCas = classificationCasRepo.findById(id);
        if (classificationCas.isPresent()) {
            return classificationCas.get();
        }
        else {
            throw new ResourceNotFoundException("cas de Classification cas introuvable");
        }
    }

    public  ClassificationCas addClassificationCas(ClassificationCas classificationCas) {
        return classificationCasRepo.save(classificationCas);
    }

    public void deleteClassificationCasById(Long id) {
        classificationCasRepo.deleteById(id);
    }

}
