package pl.kowalczyk.maciej.java.app.bookingapp.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Role;
import pl.kowalczyk.maciej.java.app.bookingapp.model.User;
import pl.kowalczyk.maciej.java.app.bookingapp.service.RoleService;
import pl.kowalczyk.maciej.java.app.bookingapp.service.UserService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");

        List<User> users = userService.list();
        modelMap.addAttribute("users", users);
        String result = "users.html";

        LOGGER.info("list(...) = " + result);
        return result;
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");

        List<Role> roles = roleService.list();
        modelMap.addAttribute("roles", roles);
        modelMap.addAttribute("user", new User());
        String result = "create-user.html";

        LOGGER.info("createView(...) = " + result);
        return result;
    }

    @PostMapping
    public String create(User user) {
        LOGGER.info("create(" + user + ")");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.create(user);
        String result = "redirect:/users";

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
