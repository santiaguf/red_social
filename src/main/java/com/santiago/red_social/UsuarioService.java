/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social;

import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author ohmyfi
 */
public class UsuarioService {
       
    public static void crearUsuario(){
        //instanciamos la clase scanner para leer datos
        Scanner sc = new Scanner(System.in); 
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
    
    public static void editarUsuario(Usuario usuario) {
        //instanciamos la clase scanner para leer datos
        Scanner sc = new Scanner(System.in);         
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
        String md5Hex = DigestUtils.md5Hex(clave);
        return md5Hex;
    }   
    
    public static Usuario iniciarSesion(){
        //instanciamos la clase scanner para leer datos
        Scanner sc = new Scanner(System.in); 
        System.out.println("indica tu correo");
        String correo = sc.nextLine();
        System.out.println("indica tu clave");
        String clave = sc.nextLine();
        clave = cifrarMD5(clave);
        Usuario login = new Usuario(correo, clave);
        Usuario resultado = UsuarioDAO.iniciarSesionDB(login);
        return resultado;     
    }
    
}
