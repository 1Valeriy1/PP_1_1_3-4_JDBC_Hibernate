package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        String sqlQuery = "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(100) NOT NULL," +
                " lastName VARCHAR(100) NOT NULL," +
                " age TINYINT NOT NULL," +
                "PRIMARY KEY(ID))";
        try {
            super.getConnection().createStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("таблица users создана");
    }

    public void dropUsersTable() {
        String sqlQuery = "DROP TABLE IF EXISTS users";
        try {
            super.getConnection().prepareStatement(sqlQuery).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("таблица users удалена");
    }

    public void saveUser(String name, String lastName, byte age) {
        String sqlQuery = "INSERT INTO users(name, lastName, age)" + "VALUES('"+name+"','"+lastName+"','"+age+"');";
        try {
            super.getConnection().createStatement().executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("User с именем – %s добавлен в базу данных\n", name);
    }

    public void removeUserById(long id) {
        String sqlQuery = "DELETE FROM users WHERE id = " + id + ";";
        try {
            super.getConnection().prepareStatement(sqlQuery).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("user с id = %s удален из таблицы users /n", id);
    }

    public List<User> getAllUsers(){
        ArrayList<User> usersList = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = super.getConnection().createStatement().executeQuery( "SELECT * FROM users;");
            while (rs.next()) {
                User user = new User(rs.getString("name"), rs.getString("lastName"), rs.getByte("age"));
                user.setId(rs.getLong("id"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Все users возвращены ввиде списка:\n%s\n", usersList);
        return usersList;
    }

    public void cleanUsersTable(){
        String sqlQuery = "DELETE FROM users";
        try {
            super.getConnection().prepareStatement(sqlQuery).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("таблица users очищена");
    }
}
