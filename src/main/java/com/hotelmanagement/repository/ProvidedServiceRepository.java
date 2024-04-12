package com.hotelmanagement.repository;

import com.hotelmanagement.model.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, Long> {
}
