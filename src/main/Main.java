package main;

import controller.UserController;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        UserController userController = new UserController(userService);

        // Show màn hình đăng nhập
        userController.showLoginView();
    }
}