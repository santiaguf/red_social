/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social.service;

import java.util.Scanner;

import com.santiago.red_social.dao.MessageDAO;
import com.santiago.red_social.model.Message;
import com.santiago.red_social.model.User;

/**
 *
 * @author santiaguf
 */
public class MessageService {
	
	static String messageTextMessage = "Escribe el mensaje, máx 280 caracteres";
	static String messageIdToBeDeletedMessage = "Indica el id del mensaje a borrar";

    public static void createMessage(User usuario, Scanner sc){
        System.out.println(messageTextMessage);
        String messageText = sc.next();
        Message message = new Message(messageText, usuario.getUserId());
        MessageDAO.createMessageDB(message);
    }

    public static void listMessages(){
        MessageDAO.listMessagesDB();
    }

    public static void deleteMessage(User usuario, Scanner sc){
        System.out.println(messageIdToBeDeletedMessage);
        int messageId = sc.nextInt();
        Message message = new Message(messageId, usuario.getUserId());
        MessageDAO.deleteMessageDB(message);
    }
}
