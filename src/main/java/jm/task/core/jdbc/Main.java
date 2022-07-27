package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Util con = new Util();
        con.getNewConnection();
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();

        user.createUsersTable();
        user.saveUser("dasha", "shon", (byte) 22);
        System.out.println("User c именем dasha дообавлен в базу данных");
        user.saveUser("masha", "shon", (byte) 23);
        System.out.println("User c именем masha дообавлен в базу данных");
        user.saveUser("sasha", "shon", (byte) 24);
        System.out.println("User c именем sasha дообавлен в базу данных");
        System.out.printf(user.getAllUsers().toString());

        user.cleanUsersTable();

        user.dropUsersTable();







        // реализуйте алгоритм здесь
    }
}
