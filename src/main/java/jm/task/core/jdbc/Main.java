package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        //создание, очистка и удаление таблицы пользователей
        userDaoHibernate.createUsersTable();
        userDaoHibernate.dropUsersTable();
        userDaoHibernate.cleanUsersTable();

    }
}
