/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.santiago.red_social.Conexion;
import com.santiago.red_social.model.Usuario;

/**
 *
 * @author santiaguf
 */
public class UsuarioDAO {
    
    //métodos crud
    public static void crearUsuarioDB(Usuario usuario){
        Conexion db_connect = new Conexion();
	try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps=null;
            try {
                String query="insert into usuarios(correo,clave,nombre_completo) values (?,?,?)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo());
                ps.setString(2, usuario.getClave());
                ps.setString(3, usuario.getNombre_completo());    
                ps.executeUpdate();
                System.out.println("\n usuario creado, ahora puedes iniciar sesión \n");
            } catch (SQLException e) {
                System.out.println("\n no se pudo crear el usuario \n");
            }
	}catch(Exception ex){
            System.out.println(ex);
        }        
    }   
    
    public static void leerUsuariosDB(){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection();){
            PreparedStatement ps=null;
            ResultSet rs=null;
            try {
                String query="select * from usuarios";
                ps=conexion.prepareStatement(query);
                rs=ps.executeQuery();
                while(rs.next()){
                    System.out.print("\n[ID: "+rs.getString("id_usuario")+" | ");
                    System.out.print("Correo: -"+rs.getString("correo")+" | ");
                    System.out.print("Nombre: "+rs.getString("nombre_completo")+" ] ");
                }
            } catch (SQLException e) {
                    System.out.println("\n no se pudo listar los usuarios \n");
            }
        	}catch(Exception ex){
            System.out.println(ex);
        }     
    }
       
    public static void editarUsuarioDB(Usuario usuario){
        Conexion db_connect = new Conexion();
	try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps=null;
            try {
                String query="update usuarios set correo = ?, clave = ?, nombre_completo = ? where id_usuario = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo());
                ps.setString(2, usuario.getClave());
                ps.setString(3, usuario.getNombre_completo());
                ps.setInt(4, usuario.getId_usuario());
                ps.executeUpdate();
                System.out.println("\n usuario actualizado \n");
            } catch (SQLException e) {
                System.out.println("\n no se pudo actualizar el usuario \n");
            }
	}catch(Exception ex){
            System.out.println(ex);
        }        
    } 
    
    public static Usuario iniciarSesionDB(Usuario usuario){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection();){
            PreparedStatement ps=null;
            ResultSet rs=null;
            try {
                String query="select * from usuarios where correo=? and clave= ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, usuario.getCorreo());
                ps.setString(2, usuario.getClave());
                rs=ps.executeQuery();
                Usuario login = new Usuario();
                if(rs.next()){
                    System.out.println("login correcto!");
                    login.setId_usuario(rs.getInt("id_usuario"));
                    login.setCorreo(rs.getString("correo"));
                    login.setNombre_completo(rs.getString("nombre_completo"));
                }else{
                    System.out.println("login failed");
                }
                //retornamos el objeto usuario con los datos o vacío
                return login;
            } catch (SQLException e) {
                    System.out.println("\n no se pudo autenticar con el servidor \n");
            }
        	}catch(Exception ex){
            System.out.println(ex);
        } 
        //si no se logra iniciar sesión devolvemos un objeto vacío
        return null;
    }
    
}
