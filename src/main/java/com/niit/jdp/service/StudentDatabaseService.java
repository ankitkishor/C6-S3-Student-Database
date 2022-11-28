/*
 * Author : Ankit Kishor
 * Date: 28-11-2022
 * Created with :Intellij IDEA Community Edition
 */


package com.niit.jdp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDatabaseService {
    Connection connection;
    public  StudentDatabaseService(){
        connection=null;
    }
    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","Ankit");

    }
    public Connection getConnectionToDatabase() throws SQLException, ClassNotFoundException {
        connect();
        return connection;
    }

    public void printConnectionStatus() {
        if (connection != null) {
            System.out.println("\u001B[32m Connected to Database \u001B[0m");
        } else {
            System.err.println("!! Database Connection Failed !!");
        }
    }

}
