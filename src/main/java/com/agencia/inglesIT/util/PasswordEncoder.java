package com.agencia.inglesIT.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
   public static void main(String[] args) {
    var password = "123";
    System.out.println("password = " + password);
    System.out.println("password encriptado= " + passwordEncrypt(password));
    }

    public static String passwordEncrypt(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
