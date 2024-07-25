package ma.entraide.enfance.service;

import ma.entraide.enfance.entity.Services;
import ma.entraide.enfance.repository.ServicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    @Autowired
    private ServicesRepo servicesRepo;

    public List<Services> getAllServices() {
        return servicesRepo.findAll();
    }
    public Services getServiceById(Long id) {
        Optional<Services> service = servicesRepo.findById(id);
        if(service.isPresent()) {
            return service.get();
        }
        else {
            throw new ResourceNotFoundException("servicenot found");
        }
    }

    public Services saveService(Services service) {
        return servicesRepo.save(service);
    }

    public void deleteService(Long id) {
         servicesRepo.deleteById(id);
    }
}
