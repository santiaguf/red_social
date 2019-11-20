/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social;

import java.util.Scanner;

/**
 *
 * @author ohmyfi
 */
public class MensajeService {
  
    public static void crearMensaje(Usuario usuario){
        //instanciamos la clase scanner para leer datos
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el mensaje, máx 280 caracteres");
        String el_mensaje = sc.nextLine();
        Mensaje mensaje = new Mensaje(el_mensaje, usuario.getId_usuario());
        MensajeDAO.crearMensajeDB(mensaje);
    }
 
    public static void listarmensajes(){
        MensajeDAO.listarmensajesDB();
    }
    
    public static void borrarMensaje(Usuario usuario){
        //instanciamos la clase scanner para leer datos
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el id del mensaje a borrar");
        int id_mensaje = sc.nextInt();
        Mensaje mensaje = new Mensaje(id_mensaje,usuario.getId_usuario());
        MensajeDAO.borrarMensajeDB(mensaje);
    }
}
