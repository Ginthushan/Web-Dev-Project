package com.hotelmanagement.controller;

import com.hotelmanagement.model.ProvidedService;
import com.hotelmanagement.service.ProvidedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
public class ProvidedServiceController {

    private final ProvidedServiceService providedServiceService;

    @Autowired
    public ProvidedServiceController(ProvidedServiceService providedServiceService) {
        this.providedServiceService = providedServiceService;
    }

    @GetMapping("/list")
    public String listServices(Model model) {
        List<ProvidedService> services = providedServiceService.getAllServices();
        model.addAttribute("services", services);
        return "services/list";
    }

    @GetMapping("/add")
    public String showAddServiceForm(Model model) {
        model.addAttribute("service", new ProvidedService());
        return "services/add";
    }

    @PostMapping("/add")
    public String addService(@ModelAttribute("service") ProvidedService service) {
        providedServiceService.addService(service);
        return "redirect:/services/list";
    }

    @PostMapping("/update/{id}")
    public String updateService(@PathVariable("id") long id, @ModelAttribute("service") ProvidedService updatedService) {
        providedServiceService.updateService(id, updatedService);
        return "redirect:/services/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable("id") long id) {
        providedServiceService.deleteService(id);
        return "redirect:/services/list";
    }
}

