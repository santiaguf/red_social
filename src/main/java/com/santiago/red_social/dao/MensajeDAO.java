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
import com.santiago.red_social.model.Mensaje;

/**
 *
 * @author santiaguf
 */
public class MensajeDAO {
    public static void crearMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();
	try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps=null;
            try {
                String query="insert into mensajes(id_usuario,mensaje,fecha) values (?,?,CURRENT_TIMESTAMP)";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, mensaje.getId_usuario());
                ps.setString(2, mensaje.getMensaje());
                ps.executeUpdate();
                System.out.println("\n mensaje creado \n");
            } catch (SQLException e) {
                System.out.println("\n no se pudo crear el mensaje \n");
            }
	}catch(Exception ex){
            System.out.println(ex);
        } 
    }

    public static void listarmensajesDB(){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps=null;
            ResultSet rs=null;
            try {
                String query="select m.id_mensaje,m.mensaje,m.fecha,u.nombre_completo from mensajes m join usuarios u on m.id_usuario=u.id_usuario";
                ps=conexion.prepareStatement(query);
                rs=ps.executeQuery();
                while(rs.next()){
                    System.out.print("\n[ID: "+rs.getInt("id_mensaje")+" | ");
                    System.out.print("mensaje: -"+rs.getString("mensaje")+" | ");
                    System.out.print("fecha: -"+rs.getString("fecha")+" | ");
                    System.out.print("Autor: "+rs.getString("nombre_completo")+" ] ");
                }
            } catch (SQLException e) {
                    System.out.println("\n no se pudo listar los mensajes \n");
            }
        	}catch(Exception ex){
            System.out.println(ex);
        }     
    }  
    
    public static void borrarMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps=null;
            try {
                String query="delete from mensajes where id_mensaje = ? and id_usuario = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, mensaje.getId_mensaje());
                ps.setInt(2, mensaje.getId_usuario());
                ps.executeUpdate();
                System.out.println("\n mensaje eliminado \n");
            } catch (SQLException e) {
                System.out.println("\n no se pudo eliminar el mensaje \n");
            }
        	}catch(Exception ex){
            System.out.println(ex);
        }     
    }    
    
}
