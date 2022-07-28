package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        jdbc();
        hibernate();
    }
    public static void jdbc() {
        UserDaoJDBCImpl user = null;
        try {
            user = new UserDaoJDBCImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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

    }
    public static void hibernate() {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.saveUser("dasha", "shon", (byte) 22);
        System.out.println("User c именем dasha дообавлен в базу данных");
        userDaoHibernate.saveUser("sasha", "shon", (byte) 23);
        System.out.println("User c именем sasha дообавлен в базу данных");
        userDaoHibernate.saveUser("masha", "shon", (byte) 24);
        System.out.println("User c именем masha дообавлен в базу данных");

        System.out.printf(userDaoHibernate.getAllUsers().toString());

        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();


    }
}
