package com.hotelmanagement.service;

import com.hotelmanagement.model.ProvidedService;
import com.hotelmanagement.repository.ProvidedServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvidedServiceService {

    private final ProvidedServiceRepository providedServiceRepository;

    @Autowired
    public ProvidedServiceService(ProvidedServiceRepository providedServiceRepository) {
        this.providedServiceRepository = providedServiceRepository;
    }

    public List<ProvidedService> getAllServices() {
        return providedServiceRepository.findAll();
    }

    public void addService(ProvidedService service) {
        providedServiceRepository.save(service);
    }

    public ProvidedService getServiceById(long id) {
        Optional<ProvidedService> result = providedServiceRepository.findById(id);
        return result.orElse(null); // You might want to handle this differently depending on your requirements
    }

    public void updateService(long id, ProvidedService updatedService) {
        ProvidedService serviceToUpdate = providedServiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid service ID: " + id));

        // Update properties of serviceToUpdate with those from updatedService
        serviceToUpdate.setName(updatedService.getName());
        serviceToUpdate.setDescription(updatedService.getDescription());
        // Update other properties as needed

        providedServiceRepository.save(serviceToUpdate);
    }

    public void deleteService(long id) {
        providedServiceRepository.deleteById(id);
    }
}

