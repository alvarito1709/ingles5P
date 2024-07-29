package com.agencia.inglesIT.controller;


import com.agencia.inglesIT.Service.UserService;
import com.agencia.inglesIT.Service.UserServiceDetail;
import com.agencia.inglesIT.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users")
public class userController {

    @Autowired
    UserService userService;

    @GetMapping("/crearPrimerUser")
    public String crearPrimerUser(){
         userService.crearPrimerUsuario();

         return "plantilla";
    }

    @PostMapping("/crear")
    public ResponseEntity<User> crearUsuario(@RequestBody User user){

        userService.guardarUsuario(user);

        return ResponseEntity.noContent().build();

    }

}
