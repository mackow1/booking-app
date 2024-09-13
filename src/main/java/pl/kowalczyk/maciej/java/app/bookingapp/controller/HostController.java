package pl.kowalczyk.maciej.java.app.bookingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;
import pl.kowalczyk.maciej.java.app.bookingapp.service.HostService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/hosts")
public class HostController {
    
    private static final Logger LOGGER = Logger.getLogger(HostController.class.getName());
    
    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }
    
    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");

        List<Host> hosts = hostService.list();
        modelMap.addAttribute("hosts", hosts);

        String result = "hosts.html";
        
        LOGGER.info("list(...) = " + result);
        return result;
    }
    
    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");

        modelMap.addAttribute("host", new Host());
        String result = "create-host.html";
        
        LOGGER.info("createView(...) = " + result);
        return result;
    }
    
    @PostMapping
    public String create(Host host) throws HostCreateException {
        LOGGER.info("create()");

        Host hostCreated = hostService.create(host);
        String result = "redirect:/hosts";

        LOGGER.info("create(...) = " + result);
        return result;
    }

    // TODO: 11.09.2024 Dokończyć controller, połączyć z servisem + html i TESTY!!! 
}
