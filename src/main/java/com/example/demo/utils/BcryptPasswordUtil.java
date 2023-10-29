package com.example.demo.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BcryptPasswordUtil {

    final static int cost = 15;

    public static String password_hash(String password)
    {
        return BCrypt.withDefaults().hashToString(cost, password.toCharArray());
    }

    public static boolean password_verify(String inputPassword, String hashPassword)
    {
        return BCrypt.verifyer().verify(inputPassword.toCharArray(), hashPassword).verified;
    }


}
