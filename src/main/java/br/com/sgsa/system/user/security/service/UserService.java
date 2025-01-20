package br.com.sgsa.system.user.security.service;

import br.com.sgsa.system.user.security.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User registerUser(User user);
}
