package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root1234";

    private static Connection connection;

    public static void main(String[] args) {

    }

    public static Connection getConnection() {
        try {
        connection = DriverManager.getConnection(
                URL,
                USERNAME, PASSWORD);
    } catch (SQLException e) {
        throw new RuntimeException(e);
        //System.out.println("Connection OK"); // это для проверки коннекта
    }
        return connection;
    }
    public static void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
