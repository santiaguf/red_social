/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social.service;

import java.util.Scanner;

import com.santiago.red_social.dao.MensajeDAO;
import com.santiago.red_social.model.Mensaje;
import com.santiago.red_social.model.Usuario;

/**
 *
 * @author santiaguf
 */
public class MensajeService {

    public static void createMessage(Usuario usuario, Scanner sc){
        System.out.println("Escribe el mensaje, máx 280 caracteres");
        String messageText = sc.next();
        Mensaje message = new Mensaje(messageText, usuario.getUserId());
        MensajeDAO.createMessageDB(message);
    }

    public static void listMessages(){
        MensajeDAO.listMessagesDB();
    }

    public static void deleteMessage(Usuario usuario, Scanner sc){
        System.out.println("Indica el id del mensaje a borrar");
        int messageId = sc.nextInt();
        Mensaje message = new Mensaje(messageId, usuario.getUserId());
        MensajeDAO.deleteMessageDB(message);
    }
}
