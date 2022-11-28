package com.niit.jdp;

import com.niit.jdp.service.StudentDatabaseService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        StudentDatabaseService service=new StudentDatabaseService();
        try {
            service.getConnectionToDatabase();
            service.printConnectionStatus();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}