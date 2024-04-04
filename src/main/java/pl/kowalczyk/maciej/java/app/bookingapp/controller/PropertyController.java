package pl.kowalczyk.maciej.java.app.bookingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.service.PropertyService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/accommodations")
public class PropertyController {

    private static final Logger LOGGER = Logger.getLogger(PropertyController.class.getName());

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");

        List<Property> properties = propertyService.list();
        modelMap.addAttribute("accommodations", properties);
        String result = "accommodations.html";

        LOGGER.info("list(...) = " + result);
        return result;
    }

    // TODO: 02.04.2024 Zaimplementować controller z metodą list()
    // Stworzyć html z listą nieruchomości
    // Zrobić mappera dla property
    // Zrobić dashboard dla nieruchomości analogicznie do tych ze spring-learn
}
