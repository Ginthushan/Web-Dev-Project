package com.hotelmanagement.controller;

import com.hotelmanagement.model.ProvidedService;
import com.hotelmanagement.service.ProvidedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProvidedServiceController {

    private final ProvidedServiceService providedServiceService;

    @Autowired
    public ProvidedServiceController(ProvidedServiceService providedServiceService) {
        this.providedServiceService = providedServiceService;
    }

    @GetMapping("/services")
    public String getAllProvidedServices(Model model) {
        List<ProvidedService> providedServices = providedServiceService.getAllProvidedServices();
        model.addAttribute("providedServices", providedServices);
        return "services";
    }
}
