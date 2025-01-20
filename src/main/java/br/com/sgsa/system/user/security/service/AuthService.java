package br.com.sgsa.system.user.security.service;

import br.com.sgsa.system.user.security.dto.LoginRequestDTO;

public interface AuthService {

    String authenticate( LoginRequestDTO loginRequest);
}