package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();
        User user1 = new User("Kirill1", "Semin1", (byte) 41);
        User user2 = new User("Kirill2", "Semin2", (byte) 42);
        User user3 = new User("Kirill3", "Semin3", (byte) 43);
        User user4 = new User("Kirill4", "Semin4", (byte) 44);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        for (User elem : userList) {
            service.saveUser(elem.getName(), elem.getLastName(), elem.getAge());
            System.out.println("User с именем - " + elem.getName() + " добавлен в базу данных");
        }
        List<User> select = service.getAllUsers();
        select.stream().forEach(System.out::println);

        service.cleanUsersTable();

        service.dropUsersTable();

        Util.sessionFactory.close();
    }
}

