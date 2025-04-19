package org.ac.cst8277.mohamed.yazid.ums;

import org.ac.cst8277.mohamed.yazid.ums.User;
import org.ac.cst8277.mohamed.yazid.ums.SessionStore;
import org.ac.cst8277.mohamed.yazid.ums.UmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UmsRepository userRepo;

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody User loginRequest) {
    System.out.println("Login request: " + loginRequest.getUsername() + " / " + loginRequest.getPassword());
    User user = userRepo.findByUsernameAndPassword(
        loginRequest.getUsername(),
        loginRequest.getPassword()
    );

    if (user != null) {
        String token = SessionStore.generateToken(user.getUsername());
        return ResponseEntity.ok("Bearer " + token);
    } else {
        System.out.println(" No user found or credentials incorrect.");
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}

}
