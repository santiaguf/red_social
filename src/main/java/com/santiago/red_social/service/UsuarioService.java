/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social.service;

import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;

import com.santiago.red_social.dao.UsuarioDAO;
import com.santiago.red_social.model.Usuario;

/**
 *
 * @author santiaguf
 */
public class UsuarioService {

    public static void createUser(Scanner sc){
        System.out.println("indica tu nombre completo");
        String fullName = sc.nextLine();
        System.out.println("indica tu email");
        String email = sc.nextLine();
        System.out.println("indica tu password");
        String password = sc.nextLine();

        password = getMd5Hash(password);

        Usuario newUser = new Usuario(0, email, password, fullName);
        UsuarioDAO.createUserOnDB(newUser);
    }

    public static void listUsers(){
        UsuarioDAO.listUsersOnDB();
    }

    public static void editUser(Usuario usuario, Scanner sc) {
        System.out.println("indica tu nombre completo");
        String fullName = sc.nextLine();
        System.out.println("indica tu email");
        String email = sc.nextLine();
        System.out.println("indica tu password");
        String password = sc.nextLine();

        String passwordHashed = getMd5Hash(password);
        Usuario updatedUser = new Usuario(usuario.getUserId(), email, passwordHashed, fullName);
        UsuarioDAO.editUserOnDB(updatedUser);
    }

    public static String getMd5Hash(String password){
        return DigestUtils.md5Hex(password);
    }

    public static Usuario login(Scanner sc){
    	//create an instance of Scanner class to read user input
        System.out.println("indica tu email");
        String email = sc.next();
        System.out.println("indica tu password");
        String password = sc.next();

        String passwordHashed = getMd5Hash(password);

        Usuario login = new Usuario(email, passwordHashed);
        Usuario result = UsuarioDAO.loginDB(login);
        return result;
    }

}
