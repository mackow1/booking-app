package pl.kowalczyk.maciej.java.app.bookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.service.PropertyService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class.getName());

    private PropertyService propertyService;

    public DashboardController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public String dashboardView(ModelMap modelMap) {
        LOGGER.info("dashboardView()");

        List<Property> properties = propertyService.list();
        modelMap.addAttribute("properties", properties);
        String result = "dashboard.html";

        LOGGER.info("dashboardView(...) = " + result);
        return result;
    }
}

// tabela w html z listą nieruchomości i akcjami dla danej nieruchomości
// TODO: 05.04.2024 Zrobić powyższe w formie fragmentu thymeleaf