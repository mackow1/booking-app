package pl.kowalczyk.maciej.java.app.bookingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.service.PropertyService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/properties")
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
        modelMap.addAttribute("properties", properties);
        String result = "properties.html";

        LOGGER.info("list(...) = " + result);
        return result;
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");

        modelMap.addAttribute("property", new Property());
        String result = "create-property.html";

        LOGGER.info("createView(...) = " + result);
        return result;
    }

    @PostMapping
    public String create(Property property) throws PropertyCreateException {
        LOGGER.info("create(" + property + ")");

        Property propertyCreated = propertyService.create(property);
        String result = "redirect:/properties";

        LOGGER.info("create(...) = " + result);
        return result;
    }

    @GetMapping(value = "/{id}")
    public String read(@PathVariable Long id, ModelMap modelMap) throws PropertyReadException {
        LOGGER.info("read(" + id + ")");

        Property readProperty = propertyService.read(id);
        modelMap.addAttribute("property", readProperty);

        String result = "property-details.html";

        LOGGER.info("read(...) = " + result);
        return result;
    }

    // TODO: 02.04.2024 Zaimplementować controller z metodą list()
    // Stworzyć html z listą nieruchomości
    // Zrobić mappera dla property
    // Zrobić dashboard dla nieruchomości analogicznie do tych ze spring-learn
}
