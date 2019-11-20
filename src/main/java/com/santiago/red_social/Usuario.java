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
public class Usuario {
    //atributos
    int id_usuario;
    String correo;
    String clave;
    String nombre_completo;
    
    //constructores
    public Usuario(){
    }

    //constructor para borrar usuario
    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    //constructor para iniciar sesión
    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    } 
    
    //constructor para traer datos de inicio de sesión
     public Usuario(int id_usuario, String correo, String nombre_completo) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.nombre_completo = nombre_completo;
    }  
    
    //constructor para crear, editar usuario
    public Usuario(int id_usuario, String correo, String clave, String nombre_completo) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.clave = clave;
        this.nombre_completo = nombre_completo;
    }
        
    //getters y setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }
     
}
