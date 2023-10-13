package com.jacksonsr45.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    private IUserRepository repository;

    public UserResponseDTO execute(UserRequestDTO data) throws UserException {
        var user = this.repository.findByUsername(data.username());
        this.validate(user);
        var model = createUserModel(data);
        model.setRole(Role.USER);
        var created = this.repository.save(model);
        return createUserResponseDTO(created);
    }

    private UserModel createUserModel(UserRequestDTO data) {
        UserModel model = new UserModel(data);
        model.setPassword(this.passwordEncoder().encode(data.password()));
        return model;
    }

    private void validate(UserModel user) throws UserException {
        if (user != null)
            throw new UserException("Username already exists!");
    }

    private UserResponseDTO createUserResponseDTO(UserModel model) {
        return new UserResponseDTO(
            model.getId(), 
            model.getUsername(), 
            model.getName(), 
            model.getPassword(), 
            model.getEmail(), 
            model.getRole().getRole(), 
            model.getCreatedAt(), 
            model.getUpdatedAt()
       );
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
