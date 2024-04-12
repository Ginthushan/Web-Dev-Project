package com.hotelmanagement.controller;

import com.hotelmanagement.model.ProvidedService;
import com.hotelmanagement.service.ProvidedServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProvidedServiceController {

    @Autowired
    private ProvidedServiceService providedServiceService;

 // Retrieves all provided services and renders them on the services page.
    @GetMapping("/services")
    public String getAllProvidedServices(Model model) {
        model.addAttribute("providedServices", providedServiceService.getAllProvidedServices());
        return "services";
    }

 // Adds a new provided service to the system.
    @PostMapping("/providedServices/add")
    public String addProvidedService(@ModelAttribute ProvidedService providedService) {
        providedServiceService.saveProvidedService(providedService);
        return "redirect:/services"; // Redirect to the page showing all provided services
    }

 // Deletes a provided service by its ID.
    @PostMapping("/providedServices/delete/{id}")
    public String deleteProvidedService(@PathVariable Long id) {
        providedServiceService.deleteProvidedService(id);
        return "redirect:/services"; // Redirect to the page showing all provided services
    }
}
