package com.hotelmanagement.controller;

import com.hotelmanagement.model.ProvidedService;
import com.hotelmanagement.service.ProvidedServiceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ProvidedServiceController {

    @Autowired
    private ProvidedServiceService providedServiceService;

    @GetMapping("/services")
    public String getAllProvidedServices(Model model) {
        model.addAttribute("providedServices", providedServiceService.getAllProvidedServices());
        return "services"; // Assuming the Thymeleaf template name is "services.html"
    }

    @PostMapping("/providedServices/add")
    public String addProvidedService(@ModelAttribute ProvidedService providedService) {
        providedServiceService.saveProvidedService(providedService);
        return "redirect:/services"; // Redirect to the page showing all provided services
    }

    @PostMapping("/providedServices/delete/{id}")
    public String deleteProvidedService(@PathVariable Long id) {
        providedServiceService.deleteProvidedService(id);
        return "redirect:/services"; // Redirect to the page showing all provided services
    }
}
