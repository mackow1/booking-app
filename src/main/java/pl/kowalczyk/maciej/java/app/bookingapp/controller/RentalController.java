package pl.kowalczyk.maciej.java.app.bookingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.java.app.bookingapp.service.RentalService;

import java.util.logging.Logger;

@Controller
@RequestMapping(name = "/rentals")
public class RentalController {

    private static final Logger LOGGER = Logger.getLogger(RentalController.class.getName());

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public String list() {
        LOGGER.info("list()");

        rentalService.list();
        String result = "rentals.html";

        LOGGER.info("list(...) = " + result);
        return result;
    }
}
