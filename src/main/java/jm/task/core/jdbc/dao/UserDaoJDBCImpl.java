package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
   

    public UserDaoJDBCImpl() throws SQLException {

    }

    public void createUsersTable() {
        String sqlCreate = "CREATE TABLE user_user ( Id INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(30) NOT NULL, LastName VARCHAR(20) NOT NULL, Age INT NOT NULL)";

        try(Connection connection = Util.getNewConnection();Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlCreate);
        } catch (SQLException e) {
            System.out.println("Table is already created");
        }

    }

    public void dropUsersTable() {
        String sqlDelete = "DROP TABLE user_user";

        try(Connection connection = Util.getNewConnection();Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            System.out.println("Table is not found");
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        String sqlDelete = "INSERT user_user(Name, LastName, Age) VALUES ('"+ name + "','" + lastName + "','" + age + "')";

        try(Connection connection = Util.getNewConnection();Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void removeUserById(long id) {
        String sqlRemove = "DELETE FROM user_user WHERE id = id";
        try(Connection connection = Util.getNewConnection();Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlRemove);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        try(Connection connection = Util.getNewConnection();Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users.user_user");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                //Assuming you have a user object

                list.add(user);
            }

        } catch (SQLException e) {
            System.out.println("Unable to display table");
        }
        return list;
    }

    public void cleanUsersTable() {
         String sqlClean = "TRUNCATE users.user_user";
        try(Connection connection = Util.getNewConnection();Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlClean);
        } catch (SQLException e) {
            System.out.println("Unable to drop table");
        }

    }
}
