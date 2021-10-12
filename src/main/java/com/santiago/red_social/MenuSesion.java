package com.santiago.red_social;

import java.util.Scanner;

import com.santiago.red_social.model.Usuario;
import com.santiago.red_social.service.MensajeService;
import com.santiago.red_social.service.UsuarioService;

public class MenuSesion {

    public static void menuSesion(Usuario usuario, Scanner sc){
        int option = 0;

        //menu when session starts
        do{
            System.out.println("=================== \n"
            + "\n red social, hola "+usuario.getFullName()+" \n"
            + "1. escribir mensaje \n"
            + "2. leer mensajes \n"
            + "3. eliminar mensaje \n"
            + "4. editar perfil \n"
            + "5. ver usuarios \n"
            + "6. cerrar sesión \n");
            //Read user input
            option = sc.nextInt();

            switch (option){
                case 1:
                    MensajeService.createMessage(usuario, sc);
                    break;
                case 2:
                    MensajeService.listMessages();
                    break;
                case 3:
                    MensajeService.deleteMessage(usuario, sc);
                    break;
                case 4:
                    UsuarioService.editUser(usuario, sc);
                    break;
                case 5:
                    UsuarioService.listUsers();
                    break;
                default:
                    break;
            }
        }while(option != 6);
    }
}
