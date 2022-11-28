/*
 * Author : Ankit Kishor
 * Date: 28-11-2022
 * Created with :Intellij IDEA Community Edition
 */


package com.niit.jdp.repository;

import java.sql.SQLException;

public class RepoMain {
    public static void main(String[] args) {
        try {
            StudentSalesRepository repository=new StudentSalesRepository();
            System.out.println(repository.getAllStudentDatabase());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
