package pl.kowalczyk.maciej.java.app.bookingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.property.PropertyException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Property;
import pl.kowalczyk.maciej.java.app.bookingapp.service.HostService;
import pl.kowalczyk.maciej.java.app.bookingapp.service.PropertyService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/properties")
public class PropertyController {

    private static final Logger LOGGER = Logger.getLogger(PropertyController.class.getName());

    private final PropertyService propertyService;
    private final HostService hostService;

    public PropertyController(PropertyService propertyService, HostService hostService) {
        this.propertyService = propertyService;
        this.hostService = hostService;
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
    public String createView(@RequestParam(value = "id", required = false) Long id, ModelMap modelMap) {
        LOGGER.info("createView()");

        List<Host> hosts = hostService.list();

        modelMap.addAttribute("property", new Property());
        modelMap.addAttribute("hosts", hosts);
        modelMap.addAttribute("id", false);
        String result = "create-property.html";

        LOGGER.info("createView(...) = " + result);
        return result;
    }

    @PostMapping
    public String create(Property property) throws PropertyException {
        LOGGER.info("create(" + property + ")");

        Property propertyCreated = propertyService.create(property);
        LOGGER.info("##### --- Property created " + propertyCreated);
        String result = "redirect:/properties";

        LOGGER.info("create(...) = " + result);
        return result;
    }

    @GetMapping(value = "/{id}")
    public String read(@PathVariable Long id, ModelMap modelMap) throws PropertyException {
        LOGGER.info("read(" + id + ")");

        Property readProperty = propertyService.read(id);
        modelMap.addAttribute("property", readProperty);

        String result = "property-details.html";

        LOGGER.info("read(...) = " + result);
        return result;
    }

    @GetMapping(value = "/update/{id}")
    public String updateView(@PathVariable Long id, ModelMap modelMap) throws PropertyException {
        LOGGER.info("updateView(" + id + ")");

        Property readProperty = propertyService.read(id);
        modelMap.addAttribute("property", readProperty);
        modelMap.addAttribute("id", true);

        String result = "create-property.html";

        LOGGER.info("updateView(...) = " + result);
        return result;
    }

    @PostMapping(value = "/{id}")
    public String update(Property property) throws PropertyException {
        LOGGER.info("update(" + property + ")");

        propertyService.update(property);
        String result = "redirect:/properties";

        LOGGER.info("update(...) = " + result);
        return result;
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) throws PropertyException {
        LOGGER.info("delete(" + id + ")");

        propertyService.delete(id);
        String result = "redirect:/dashboard";

        LOGGER.info("delete(...) = " + result);
        return result;
    }
    // Zrobić dashboard dla nieruchomości analogicznie do tych ze spring-learn
}
