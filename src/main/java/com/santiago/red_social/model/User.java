/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social.model;

/**
 *
 * @author santiaguf
 */
public class User {
    //atributos
    int userId;
    String email;
    String password;
    String fullName;

    //constructores
    public User(){
    }

    //constructor para borrar usuario
    public User(int userId) {
        this.userId = userId;
    }

    //constructor para iniciar sesión
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //constructor para traer datos de inicio de sesión
    public User(int userId, String email, String fullName) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
    }

    //constructor para crear, editar usuario
    public User(int userId, String email, String password, String fullName) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    //getters y setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
