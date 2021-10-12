/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social.service;

import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;

import com.santiago.red_social.dao.UserDAO;
import com.santiago.red_social.model.User;

/**
 *
 * @author santiaguf
 */
public class UserService {

    public static void createUser(Scanner sc){
        System.out.println("indica tu nombre completo");
        String fullName = sc.nextLine();
        System.out.println("indica tu email");
        String email = sc.nextLine();
        System.out.println("indica tu password");
        String password = sc.nextLine();

        password = getMd5Hash(password);

        User newUser = new User(0, email, password, fullName);
        UserDAO.createUserOnDB(newUser);
    }

    public static void listUsers(){
        UserDAO.listUsersOnDB();
    }

    public static void editUser(User usuario, Scanner sc) {
        System.out.println("indica tu nombre completo");
        String fullName = sc.nextLine();
        System.out.println("indica tu email");
        String email = sc.nextLine();
        System.out.println("indica tu password");
        String password = sc.nextLine();

        String passwordHashed = getMd5Hash(password);
        User updatedUser = new User(usuario.getUserId(), email, passwordHashed, fullName);
        UserDAO.editUserOnDB(updatedUser);
    }

    public static String getMd5Hash(String password){
        return DigestUtils.md5Hex(password);
    }

    public static User login(Scanner sc){
    	//create an instance of Scanner class to read user input
        System.out.println("indica tu email");
        String email = sc.next();
        System.out.println("indica tu password");
        String password = sc.next();

        String passwordHashed = getMd5Hash(password);

        User login = new User(email, passwordHashed);
        User result = UserDAO.loginDB(login);
        return result;
    }

}
