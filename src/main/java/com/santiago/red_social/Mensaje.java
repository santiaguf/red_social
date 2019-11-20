/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social;

/**
 *
 * @author ohmyfi
 */
public class Mensaje {
    //atributos
    int id_mensaje;
    String mensaje;
    String fecha;
    //atributos foráneos
    int id_usuario;
    String nombre_completo;
    
    //constructores
    public Mensaje(){
    }

    //borrar mensaje por su ID
    public Mensaje(int id_mensaje, int id_usuario) {
        this.id_mensaje = id_mensaje;
        this.id_usuario = id_usuario;
    }
    
    //crear mensaje
    public Mensaje(String mensaje, int id_usuario) {
        this.mensaje = mensaje;
        this.id_usuario = id_usuario;
    }
    
    //listar mensajes
    public Mensaje(int id_mensaje, String mensaje, String fecha, String nombre_completo) {
        this.id_mensaje = id_mensaje;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.nombre_completo = nombre_completo;
    }
    
    //getters y setters
    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }
   
    
}
