package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl ud = new UserDaoJDBCImpl();
    UserDaoHibernateImpl udh = new UserDaoHibernateImpl();


    public UserServiceImpl() throws SQLException {
    }

    public void createUsersTable() {
        udh.createUsersTable();
    }

    public void dropUsersTable() {
        udh.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        udh.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        udh.removeUserById(id);

    }

    public List<User> getAllUsers() {
        return udh.getAllUsers();
    }

    public void cleanUsersTable() {
        udh.cleanUsersTable();

    }
}
