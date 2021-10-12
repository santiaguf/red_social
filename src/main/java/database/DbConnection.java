/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author santiaguf
 */
public class DbConnection {

    public Connection get_connection(){

    Dotenv dotenv = Dotenv.load();

    Connection connection= null;
    try{
        connection = DriverManager.getConnection("jdbc:mysql://"
    +dotenv.get("DATABASE_HOST")+
    ":"+dotenv.get("DATABASE_PORT")+
    "/"+dotenv.get("DATABASE_NAME")+"",
        dotenv.get("DATABASE_USER"),
        dotenv.get("DATABASE_PASSWORD"));
    }catch(Exception e){
        System.out.println(e);
    }
    return connection;
    }
}
