package com.santiago.red_social;

import java.util.Scanner;

import com.santiago.red_social.model.User;
import com.santiago.red_social.service.MessageService;
import com.santiago.red_social.service.UserService;

public class MenuSesion {

    public static void menuSesion(User usuario, Scanner sc){
        int option = 0;
        String sessionMenuMessage = ("=================== \n"
                + "\n red social, hola "+usuario.getFullName()+" \n"
                + "1. escribir mensaje \n"
                + "2. leer mensajes \n"
                + "3. eliminar mensaje \n"
                + "4. editar perfil \n"
                + "5. ver usuarios \n"
                + "6. cerrar sesión \n");

        //menu when session starts
        do{
            System.out.println(sessionMenuMessage);
            //Read user input
            option = sc.nextInt();

            switch (option){
                case 1:
                    MessageService.createMessage(usuario, sc);
                    break;
                case 2:
                    MessageService.listMessages();
                    break;
                case 3:
                    MessageService.deleteMessage(usuario, sc);
                    break;
                case 4:
                    UserService.editUser(usuario, sc);
                    break;
                case 5:
                    UserService.listUsers();
                    break;
                default:
                    break;
            }
        }while(option != 6);
    }
}
