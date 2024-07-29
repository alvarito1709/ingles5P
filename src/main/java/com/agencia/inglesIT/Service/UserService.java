package com.agencia.inglesIT.Service;


import com.agencia.inglesIT.entities.User;
import com.agencia.inglesIT.repository.UserRepository;
import com.agencia.inglesIT.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void crearPrimerUsuario(){
        List<User> users = userRepository.findAll();

        if (users.isEmpty()){
            User nuevoUser = new User();
            nuevoUser.setDocumento("1111");
            nuevoUser.setUsername("sistemas");
            nuevoUser.setApellido("admin");
            nuevoUser.setNombre("admin");
            nuevoUser.setPassword(PasswordEncoder.passwordEncrypt("123"));
            nuevoUser.setEmail("admin@mail.com");
            nuevoUser.setRol("ROLE_ADMIN");
            nuevoUser.setTelefono("1111");
            userRepository.save(nuevoUser);
        }
    }

    public User guardarUsuario(User user){
        return userRepository.save(user);
    }
}
