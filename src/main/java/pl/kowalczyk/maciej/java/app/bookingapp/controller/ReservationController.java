package pl.kowalczyk.maciej.java.app.bookingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

    private static final Logger LOGGER = Logger.getLogger(ReservationController.class.getName());

    @GetMapping(value = "/create/{id}")
    public String createView(@PathVariable Long id, ModelMap modelMap) {
        LOGGER.info("createView(" + id + ")");

        modelMap.addAttribute("reservation", new Reservation());
        String result = "create-reservation";

        LOGGER.info("createView(...) = " + result);
        return result;
    }

    @PostMapping
    public String create(Reservation reservation) {
        LOGGER.info("create(" + reservation + ")");

        String result = "redirect:/dashboard";

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
