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

import com.santiago.red_social.model.Message;

import database.DbConnection;

/**
 *
 * @author santiaguf
 */
public class MessageDAO {
	
	static String cantCreateMessage = "\n no se pudo crear el mensaje \n";
	static String createdMessage = "\n mensaje creado \n";
	static String cantListMessages = "\n no se pudo listar los mensajes \n";
	static String deletedMessage = "\n mensaje eliminado \n";
	static String cantDeleteMessages = "\n no se pudo eliminar el mensaje \n";
	
    public static void createMessageDB(Message mensaje){
        DbConnection dbConnection = new DbConnection();
        try (Connection conexion = dbConnection.get_connection()) {
                PreparedStatement ps=null;
                try {
                    String query="insert into mensajes(id_usuario,mensaje,fecha) values (?,?,CURRENT_TIMESTAMP)";
                    ps=conexion.prepareStatement(query);
                    ps.setInt(1, mensaje.getUserId());
                    ps.setString(2, mensaje.getMessage());
                    ps.executeUpdate();
                    System.out.println(createdMessage);
                } catch (SQLException e) {
                    System.out.println(cantCreateMessage);
                }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void listMessagesDB(){
        DbConnection dbConnection = new DbConnection();
        try(Connection conexion = dbConnection.get_connection()){
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
                    System.out.println(cantListMessages);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void deleteMessageDB(Message mensaje){
        DbConnection db_connect = new DbConnection();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps=null;
            try {
                String query="delete from mensajes where id_mensaje = ? and id_usuario = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, mensaje.getmessageId());
                ps.setInt(2, mensaje.getUserId());
                ps.executeUpdate();
                System.out.println(deletedMessage);
            } catch (SQLException e) {
                System.out.println(cantDeleteMessages);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}
