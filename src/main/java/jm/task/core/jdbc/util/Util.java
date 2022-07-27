package jm.task.core.jdbc.util;
import java.sql.* ;



public class Util {
    public static Connection getNewConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String passwd = "1234";
        return DriverManager.getConnection(url, user, passwd);

    }

    // реализуйте настройку соеденения с БД
}
