/*
 * Author : Ankit Kishor
 * Date: 28-11-2022
 * Created with :Intellij IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.StudentData;
import com.niit.jdp.service.StudentDatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentSalesRepository {
    Connection connection;
    StudentDatabaseService service;

    public StudentSalesRepository() throws SQLException, ClassNotFoundException {
        service=new StudentDatabaseService();
        connection= service.getConnectionToDatabase();
    }
    public List<StudentData> getAllStudentDatabase(){
        List<StudentData> list=new ArrayList<>();

        String selectQuery="SELECT * FROM `school`.`schooltable`;";
        try(Statement statement=connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()){
                int rollNo = resultSet.getInt("rollNo");
                String name = resultSet.getString("name");
                String grades = resultSet.getString("grades");
                StudentData studentData=new StudentData(rollNo,name,grades);
                list.add(studentData);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


return list;
        }
        public boolean updateStudentByRollNo(int rollNo,String grades ) {
            int numberOfRowsAffected = 0;
            String updateQuery = "update `school`.`schooltable` set `grades` = ?" +
                    "where (`rollNo` = ?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

                preparedStatement.setInt(1, rollNo);
                preparedStatement.setString(2, grades);

                numberOfRowsAffected = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);


            }
            return numberOfRowsAffected > 0;
        }

    public boolean deleteByRollNo(int salesId) {
        int numberOfRowsAffected = 0;

        String deleteQuery = "delete from `school`.`schooltable` where (`rollNo` = ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, salesId);

            numberOfRowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numberOfRowsAffected > 0;
    }

}
