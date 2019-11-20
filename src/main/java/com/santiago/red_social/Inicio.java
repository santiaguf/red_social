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
public class Inicio {
    
    public static void main(String[] args) {            
        menuPrincipal();
    } 
    
    public static void menuPrincipal(){
        //instanciamos la clase scanner para leer datos
        Scanner sc = new Scanner(System.in);  
        int opcion = 0;  

        //primer menú
        do{
            System.out.println("===================");
            System.out.println("\n Mini red social \n");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. salir \n");
            //leemos la opción del usuario
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    UsuarioService.crearUsuario();
                    break;
                case 2:
                    Usuario resultado = UsuarioService.iniciarSesion();
                    if(resultado.getId_usuario() > 0){
                        menuSesion(resultado);
                    }   
                    break;
                default:
                    break;
            }
        }while(opcion != 3);
    }
    
    public static void menuSesion(Usuario usuario){
        //instanciamos la clase scanner para leer datos
        Scanner sc = new Scanner(System.in);  
        int opcion = 0; 

        //menú cuando inicia sesión
        do{
            System.out.println("===================");
            System.out.println("\n red social, hola "+usuario.getNombre_completo()+" \n");
            System.out.println("1. escribir mensaje");
            System.out.println("2. leer mensajes");
            System.out.println("3. eliminar mensaje");
            System.out.println("4. editar perfil");
            System.out.println("5. ver usuarios");
            System.out.println("6. cerrar sesión \n");
            //leemos la opción del usuario
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    MensajeService.crearMensaje(usuario);
                    break;
                case 2:
                    MensajeService.listarmensajes();
                    break;
                case 3:
                    MensajeService.borrarMensaje(usuario);
                    break;
                case 4:
                    UsuarioService.editarUsuario(usuario);
                    break;
                case 5:
                    UsuarioService.listarUsuarios();
                    break;    
                default:
                    break;
            }
        }while(opcion != 6);     
    }
    
}
