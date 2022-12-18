package ces.augusto108.hroauth.model.controllers;

import ces.augusto108.hroauth.model.entities.User;
import ces.augusto108.hroauth.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/list/email")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User u = userService.findByEmail(email);

        if (u != null) return ResponseEntity.ok(u);
        else return ResponseEntity.notFound().build();
    }
}
