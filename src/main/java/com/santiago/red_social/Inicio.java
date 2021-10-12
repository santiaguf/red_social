/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.red_social;


import java.util.Scanner;

import com.santiago.red_social.model.User;
import com.santiago.red_social.service.UserService;
/**
 *
 * @author santiaguf
 */
public class Inicio {
	
	static String mainMenuMessage = ("=================== \n"
            + "\n Mini red social \n"
            + "1. Registrarse \n"
            + "2. Iniciar sesión \n"
            + "3. salir \n");

    public static void main(String[] args) {
        //create an instance of Scanner class to read user input
        Scanner sc = new Scanner(System.in);
        mainMenu(sc);
        sc.close();
    }

    public static void mainMenu(Scanner sc){

        int option = 0;

        //First Menu
        do{
            System.out.println(mainMenuMessage);
            //Read user input
            option = sc.nextInt();

            switch (option){
                case 1:
                    UserService.createUser(sc);
                    break;
                case 2:
                    User resultado = UserService.login(sc);
                    if(resultado.getUserId() > 0){
                        MenuSesion.menuSesion(resultado, sc);
                    }
                    break;
                default:
                    break;
            }
        }while(option != 3);
    }

}
