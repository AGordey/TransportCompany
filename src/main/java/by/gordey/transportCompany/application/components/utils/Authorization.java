package by.gordey.transportCompany.application.components.utils;

import by.gordey.transportCompany.controller.LogisticControllerImpl;
import by.gordey.transportCompany.entity.User;
import by.gordey.transportCompany.exceptions.NotExistUserExeption;

import java.util.List;

public class Authorization {


    public static String getRole(String login, String password) {
        String role = "user";
        try {
        User userAuth = new User();
        List<User> users = new LogisticControllerImpl().getUsers();
//        for (User user : users) {
//            if (user.getLogin().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(password)) {
//                userAuth = user;
//                break;
//            }
//        }
        userAuth = users.stream()
                .filter(user -> user.getLogin().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(password))
                .findFirst()
                .orElse(new User());
            if (userAuth.getLogin() == null) {
                throw new NotExistUserExeption();
            }
        if (userAuth.getRole().equalsIgnoreCase("admin")) {
            role = "admin";
        }} catch (NotExistUserExeption e) {
            role = "NotExist";

        }

        return role;
    }
}
