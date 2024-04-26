package pl.kowalczyk.maciej.java.app.bookingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.reservation.ReservationDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Reservation;
import pl.kowalczyk.maciej.java.app.bookingapp.service.ReservationService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/reservations")
@SessionAttributes(value = {"propertyId"})
public class ReservationController {

    private static final Logger LOGGER = Logger.getLogger(ReservationController.class.getName());
    public static final String PROPERTY_ID = "propertyId";

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");

        List<Reservation> reservations = reservationService.list();
        modelMap.addAttribute("reservations", reservations);
        String result = "reservations.html";

        LOGGER.info("list(...) = " + result);
        return result;
    }

    @GetMapping(value = "/create/{id}")
    public String createView(@PathVariable Long id, ModelMap modelMap) {
        LOGGER.info("createView(" + id + ")");

        modelMap.addAttribute("reservation", new Reservation());
        modelMap.addAttribute(PROPERTY_ID, id);
        String result = "create-reservation";

        LOGGER.info("createView(...) = " + result);
        return result;
    }

    @PostMapping
    public String create(Reservation reservation, ModelMap modelMap) throws ReservationCreateException {
        LOGGER.info("create(" + reservation + ")");

        Long id = (Long) modelMap.getAttribute(PROPERTY_ID);
        reservation.setPropertyId(id);

        reservationService.create(reservation);

        String result = "redirect:/dashboard";

        LOGGER.info("create(...) = " + result);
        return result;
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) throws ReservationDeleteException {
        LOGGER.info("delete(" + id + ")");

        reservationService.delete(id);
        String result = "redirect:/reservations";

        LOGGER.info("delete(...) = " + result);
        return result;
    }
}
