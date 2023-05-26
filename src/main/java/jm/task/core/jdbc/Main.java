package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        // ���������� �������� �����
        UserServiceImpl dao = new UserServiceImpl();
// �������� �������
        dao.dropUsersTable();
// �������� �������
        dao.createUsersTable();
// ���������� users
        dao.saveUser("Harry", "Poter", (byte) 21);
        dao.saveUser("Larry", "Loter", (byte) 12);
        dao.saveUser("Jarry", "Soter", (byte) 127);
        dao.saveUser("Barry", "Koter", (byte) 55);
// ������� users � ������
        dao.getAllUsers();
        //System.out.println("\n������� �� �������� users:");
        //System.out.println(dao.getAllUsers());
// �������� user �� id
        dao.removeUserById(1L);
        //System.out.println("\n������� ����� �������� ������� users:");
        //System.out.println(dao.getAllUsers());
// �������� �������
        dao.cleanUsersTable();
        //System.out.println("\n������� ����� �������� users:");
        //System.out.println(dao.getAllUsers());
        Util.getConnection().close();
    }
}
