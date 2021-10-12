/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social.service;

import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;

import com.santiago.red_social.dao.UsuarioDAO;
import com.santiago.red_social.model.Usuario;

/**
 *
 * @author santiaguf
 */
public class UsuarioService {
       
    public static void crearUsuario(Scanner sc){
        System.out.println("indica tu nombre completo");
        String nombre_completo = sc.nextLine();
        System.out.println("indica tu correo");
        String correo = sc.nextLine();
        System.out.println("indica tu clave");
        String clave = sc.nextLine();
        
        clave = cifrarMD5(clave);
        
        Usuario registro = new Usuario(0, correo, clave, nombre_completo);
        UsuarioDAO.crearUsuarioDB(registro);
    }
    
    public static void listarUsuarios(){
        UsuarioDAO.leerUsuariosDB();
    }
    
    public static void editarUsuario(Usuario usuario, Scanner sc) {        
        System.out.println("indica tu nombre completo");
        String nombre_completo = sc.nextLine();
        System.out.println("indica tu correo");
        String correo = sc.nextLine();
        System.out.println("indica tu clave");
        String clave = sc.nextLine();
        
        clave = cifrarMD5(clave);
        
        Usuario registro = new Usuario(usuario.getId_usuario(), correo, clave, nombre_completo);
        UsuarioDAO.editarUsuarioDB(registro);
    }
        
    public static String cifrarMD5(String clave){ 
        return DigestUtils.md5Hex(clave);
    }   
    
    public static Usuario iniciarSesion(Scanner sc){
    	//create an instance of Scanner class to read user input
        System.out.println("indica tu correo");
        String correo = sc.next();
        System.out.println("indica tu clave");
        String clave = sc.next();
        
        clave = cifrarMD5(clave);
        
        Usuario login = new Usuario(correo, clave);
        Usuario resultado = UsuarioDAO.iniciarSesionDB(login);
        return resultado;  
    }
    
}
