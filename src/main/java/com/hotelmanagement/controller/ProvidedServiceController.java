package com.hotelmanagement.controller;

import com.hotelmanagement.model.ProvidedService;
import com.hotelmanagement.service.ProvidedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/services")
    public String addProvidedService(@ModelAttribute ProvidedService providedService) {
        providedServiceService.saveProvidedService(providedService);
        return "redirect:/services";
    }

    @DeleteMapping("/services/{id}")
    public String deleteProvidedService(@PathVariable Long id) {
        providedServiceService.deleteProvidedService(id);
        return "redirect:/services";
    }
}
