/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.red_social;


import java.util.Scanner;

import com.santiago.red_social.model.Usuario;
import com.santiago.red_social.service.UsuarioService;

/**
 *
 * @author santiaguf
 */
public class Inicio {

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
            System.out.println("=================== \n"
                + "\n Mini red social \n"
                + "1. Registrarse \n"
                + "2. Iniciar sesión \n"
                + "3. salir \n");
            //Read user input
            option = sc.nextInt();

            switch (option){
                case 1:
                    UsuarioService.createUser(sc);
                    break;
                case 2:
                    Usuario resultado = UsuarioService.login(sc);
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
