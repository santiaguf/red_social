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
  
    public static void crearMensaje(Usuario usuario, Scanner sc){
        System.out.println("Escribe el mensaje, máx 280 caracteres");
        String el_mensaje = sc.next();
        Mensaje mensaje = new Mensaje(el_mensaje, usuario.getId_usuario());
        MensajeDAO.crearMensajeDB(mensaje);
    }
 
    public static void listarmensajes(){
        MensajeDAO.listarmensajesDB();
    }
    
    public static void borrarMensaje(Usuario usuario, Scanner sc){
        System.out.println("Indica el id del mensaje a borrar");
        int id_mensaje = sc.nextInt();
        Mensaje mensaje = new Mensaje(id_mensaje,usuario.getId_usuario());
        MensajeDAO.borrarMensajeDB(mensaje);
    }
}
