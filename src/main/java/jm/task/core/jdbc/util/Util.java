package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    public static SessionFactory sessionFactory = new Configuration()
            .addProperties(getPropertiesSessionFactory())
            .addAnnotatedClass(User.class)
            .buildSessionFactory();
    private static Properties getPropertiesSessionFactory() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url", dbUrlConnection);
        properties.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.connection.username", dbUserName);
        properties.setProperty("hibernate.connection.password", dbUserPassword);
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        return properties;
    }

    public static final String dbName = "kata_preproject";
    public static final String dbTableName = "users";
    private static final String dbUrlConnection = "jdbc:mysql://localhost:3306/kata_preproject";

    private static final String dbUserName = "kir";
    private static final String dbUserPassword = "123";

    public static Connection connection;
    public static Connection connectionJDBC = getConnectionJDBC();

        private static Connection getConnectionJDBC() {
            try {
                Connection connection = DriverManager.getConnection(dbUrlConnection, dbUserName, dbUserPassword);
           connection.setAutoCommit(false);
                return connection;
            } catch (SQLException e) {
                System.out.println("Error connect with database");
                throw new RuntimeException(e);
            }
        }

}
