// Provides services related to provided service operations such as retrieving, adding, and deleting provided services.
package com.hotelmanagement.service;

import com.hotelmanagement.model.ProvidedService;
import com.hotelmanagement.repository.ProvidedServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidedServiceService {

    private final ProvidedServiceRepository providedServiceRepository;

    @Autowired
    public ProvidedServiceService(ProvidedServiceRepository providedServiceRepository) {
        this.providedServiceRepository = providedServiceRepository;
    }

 // Retrieves all provided services from the database.
    public List<ProvidedService> getAllProvidedServices() {
        return providedServiceRepository.findAll();
    }

 // Retrieves a provided service by its ID.
    public ProvidedService getProvidedServiceById(Long id) {
        return providedServiceRepository.findById(id).orElse(null);
    }

 // Saves a provided service to the database.
    public ProvidedService saveProvidedService(ProvidedService providedService) {
        return providedServiceRepository.save(providedService);
    }

 // Deletes a provided service by its ID.
    public void deleteProvidedService(Long id) {
        providedServiceRepository.deleteById(id);
    }
}


