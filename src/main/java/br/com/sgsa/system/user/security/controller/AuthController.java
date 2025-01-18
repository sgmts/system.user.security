package br.com.sgsa.system.user.security.controller;

import br.com.sgsa.system.user.security.dto.JwtResponseDTO;
import br.com.sgsa.system.user.security.dto.LoginRequestDTO;
import br.com.sgsa.system.user.security.model.User;
import br.com.sgsa.system.user.security.service.AuthService;
import br.com.sgsa.system.user.security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok("Usuário registrado com sucesso: " + registeredUser.getEmail());
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequest) {
        String token = authService.authenticate(loginRequest);
        return ResponseEntity.ok(new JwtResponseDTO(token));
    }

}
