package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь

        UserServiceImpl dao = new UserServiceImpl();

// удаление таблицы
        dao.dropUsersTable();

// создание таблицы
        dao.createUsersTable();

// добавление users
        dao.saveUser("Harry", "Poter", (byte) 21);
        dao.saveUser("Larry", "Loter", (byte) 12);
        dao.saveUser("Jarry", "Soter", (byte) 127);
        dao.saveUser("Barry", "Koter", (byte) 55);

// таблица users в список
        //System.out.println("\nТаблица до очищения users:");
        dao.getAllUsers();

// удаление user по id
        dao.removeUserById(1L);

// очищение таблицы
        dao.cleanUsersTable();

        //System.out.println("\nТаблица после очищения users:");
        //System.out.println(dao.getAllUsers());

    }
}
