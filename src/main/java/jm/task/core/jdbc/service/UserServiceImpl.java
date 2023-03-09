package jm.task.core.jdbc.service;

import com.mysql.cj.xdevapi.Statement;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.connection;

public class UserServiceImpl implements UserService {
    //private UserDaoJDBCImpl daoJDBC;
    private UserDaoHibernateImpl daoHibernate;
    public UserServiceImpl() {
       // this.daoJDBC = new UserDaoJDBCImpl();
        this.daoHibernate = new UserDaoHibernateImpl();
    }
    public void createUsersTable() {
        daoHibernate.createUsersTable();
        //daoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        daoHibernate.dropUsersTable();
        //daoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        daoHibernate.saveUser(name, lastName, age);
        //daoJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        daoHibernate.removeUserById(id);
        //daoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
       // return daoJDBC.getAllUsers();
       return daoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        daoHibernate.cleanUsersTable();
        //daoJDBC.cleanUsersTable();
    }
}
