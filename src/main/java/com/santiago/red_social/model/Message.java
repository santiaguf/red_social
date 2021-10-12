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
public class Message {
    //attributes
    int messageId;
    String message;
    String date;
    String fullName;
    //foreign attributes
    int userId;

    //constructors
    public Message(){
    }

    //delete message by Id
    public Message(int messageId, int userId) {
        this.messageId = messageId;
        this.userId = userId;
    }

    //create message
    public Message(String message, int userId) {
        this.message = message;
        this.userId = userId;
    }

    //list messages
    public Message(int messageId, String message, String date, String fullName) {
        this.messageId = messageId;
        this.message = message;
        this.date = date;
        this.fullName = fullName;
    }

    //getters and setters
    public int getmessageId() {
        return messageId;
    }

    public void setmessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }
}
