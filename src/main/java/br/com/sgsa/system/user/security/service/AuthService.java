package br.com.sgsa.system.user.security.service;

import br.com.sgsa.system.user.security.dto.LoginRequestDTO;
import br.com.sgsa.system.user.security.model.User;
import br.com.sgsa.system.user.security.repository.UserRepository;
import br.com.sgsa.system.user.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticate(LoginRequestDTO loginRequest) {
        // Verifica se o usuário existe
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Credenciais inválidas"));

        // Verifica a senha
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Credenciais inválidas");
        }

        // Gera o token JWT
        return jwtUtil.generateToken(user.getEmail());
    }
}
