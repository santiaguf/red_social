/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.red_social;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ohmyfi
 */
public class Conexion {
   
    public Connection get_connection(){
        Connection connection= null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/red_social","root","");
        }catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }   
}
