package pl.kowalczyk.maciej.java.app.bookingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.rental.RentalException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Rental;
import pl.kowalczyk.maciej.java.app.bookingapp.service.RentalService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/rentals")
public class RentalController {

    private static final Logger LOGGER = Logger.getLogger(RentalController.class.getName());

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");

        List<Rental> rentals = rentalService.list();
        modelMap.addAttribute("rentals", rentals);

        String result = "rentals.html";

        LOGGER.info("list(...) = " + result);
        return result;
    }

    @GetMapping(value = "/create/reservation/{id}")
    public String createFromReservation(@PathVariable Long id) throws ReservationReadException {
        LOGGER.info("createFromReservation(" + id + ")");

        rentalService.createFromReservation(id);
        String result = "redirect:/rentals";

        LOGGER.info("createFromReservation(...) = " + result);
        return result;
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(Long id) throws RentalException {
        LOGGER.info("delete(" + id + ")");

        rentalService.delete(id);
        String result = "redirect:/rentals";

        LOGGER.info("delete(...) = " + result);
        return result;
    }
}
