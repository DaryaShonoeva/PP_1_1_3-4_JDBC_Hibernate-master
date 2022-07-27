package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Util con = new Util();
        System.out.println(con.getNewConnection());
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();

        user.createUsersTable();
        user.saveUser("dasha", "shon", (byte) 22);
        System.out.printf(user.getAllUsers().toString());

        for(User us:user.getAllUsers()) {
            System.out.println(us);
        }







        // реализуйте алгоритм здесь
    }
}
