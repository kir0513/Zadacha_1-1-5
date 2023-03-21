package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.util.List;



public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }
    @Override
    public void createUsersTable() {
      /*  try (Session session = Util.sessionFactory.openSession()) {
            session.beginTransaction();
            String sqlQuery = "create table if not exists " + Util.dbName + "." + Util.dbTableName +
                    "(id bigint auto_increment, name text, last_name text, age integer, " +
                    "constraint table1_pk primary key (id))";
            session.createSQLQuery(sqlQuery).executeUpdate();
            session.getTransaction().commit();
        }
       */
        Session session = Util.sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sqlQuery = "create table if not exists " + Util.dbName + "." + Util.dbTableName +
                    "(id bigint auto_increment, name text, last_name text, age integer, " +
                    "constraint table1_pk primary key (id))";
            session.createSQLQuery(sqlQuery).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
    /*
        try (Session session = Util.sessionFactory.openSession()) {
            session.beginTransaction();
            String sqlQuery = "drop table if exists " + Util.dbName + "." + Util.dbTableName;;
            session.createSQLQuery(sqlQuery).executeUpdate();
            session.getTransaction().commit();
        }
    */
        Session session = Util.sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sqlQuery = "drop table if exists " + Util.dbName + "." + Util.dbTableName;
            session.createSQLQuery(sqlQuery).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
     /*
        try (Session session = Util.sessionFactory.openSession()) {
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            session.getTransaction().commit();
        }
     */
        Session session = Util.sessionFactory.openSession();
        try {
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
    /*
        try (Session session = Util.sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete User where id = " + id).executeUpdate();
            session.getTransaction().commit();
        }
     */
        Session session = Util.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.createQuery("delete User where id = " + id).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
    /*
        try (Session session = Util.sessionFactory.openSession()) {
            session.beginTransaction();
            List<User> list = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
            return list;
        }
         List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
     */
        Session session = Util.sessionFactory.openSession();
         List<User> list = null;

        try {
            session.beginTransaction();

            list = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;

    }



    @Override
    public void cleanUsersTable() {
    /*
        try (Session session = Util.sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
        }
     */
        Session session = Util.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

