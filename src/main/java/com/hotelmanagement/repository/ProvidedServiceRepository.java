package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hotelmanagement.model.ProvidedService;

@Repository
public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, Long> {

}
