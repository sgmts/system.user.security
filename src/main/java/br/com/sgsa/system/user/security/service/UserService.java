package br.com.sgsa.system.user.security.service;

import br.com.sgsa.system.user.security.dto.UserDTO;
import br.com.sgsa.system.user.security.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<UserDTO> getAllUsers();

    Optional<User> getUserById(Long id);

    UserDTO registerUser(UserDTO user);

    void deteleUserById(Long id);

    void updateUser(Long id, User user);
}
