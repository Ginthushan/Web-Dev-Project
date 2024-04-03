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

    public List<ProvidedService> getAllProvidedServices() {
        return providedServiceRepository.findAll();
    }

    public Optional<ProvidedService> getProvidedServiceById(Long id) {
        return providedServiceRepository.findById(id);
    }

    public ProvidedService saveProvidedService(ProvidedService providedService) {
        return providedServiceRepository.save(providedService);
    }

    public void deleteProvidedService(Long id) {
        providedServiceRepository.deleteById(id);
    }
}


