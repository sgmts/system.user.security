package br.com.sgsa.system.user.security.mapper;

import br.com.sgsa.system.user.security.dto.UserDTO;
import br.com.sgsa.system.user.security.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public User mapDTOToModel(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO mapModelToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}