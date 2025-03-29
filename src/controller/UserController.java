package controller;

import dto.LibraryMemberDTO;
import dto.LibraryStaffDTO;
import dto.LibraryAdminDTO;
import model.User;
import service.UserService;
import view.AdminHomeView;
import view.ChangePasswordView;
import view.HomeView;
import view.LoginView;
import view.RegisterView;
import view.StaffHomeView;
import view.UserProfileView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void showRegisterView() {
        RegisterView registerView = new RegisterView();
        registerView.getRegisterButton().addActionListener(_ -> {
            String firstName = registerView.getFirstNameField().getText();
            String lastName = registerView.getLastNameField().getText();
            String email = registerView.getEmailField().getText();
            String password = new String(registerView.getPasswordField().getPassword());
            String phoneNumber = registerView.getPhoneField().getText();
            if (validateRegistration(firstName, lastName, email, password, phoneNumber)) {
                if (userService.registerUser(firstName, lastName, email, password, phoneNumber)) {
                    JOptionPane.showMessageDialog(registerView, "Registration successful!");
                    registerView.dispose();
                    showLoginView();
                } else {
                    JOptionPane.showMessageDialog(registerView, "Registration failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(registerView, "Please fill in all fields correctly.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerView.getBackButton().addActionListener(_ -> {
            registerView.dispose();
            showLoginView();
        });

        registerView.setVisible(true);
    }

    private boolean validateRegistration(String firstName, String lastName, String email, String password, String phoneNumber) {
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
            return false;
        }
        if (!isValidEmail(email)) {
            return false;
        }
        return isValidPhoneNumber(phoneNumber);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^\\d{10,15}$";
        return phoneNumber.matches(phoneRegex);
    }

    public void showLoginView() {
        LoginView loginView = new LoginView();
        loginView.getLoginButton().addActionListener(_ -> {
            String email = loginView.getEmailField().getText();
            String password = new String(loginView.getPasswordField().getPassword());
            User user = convertToModel(userService.loginMember(email, password));
            if (user != null) {
                JOptionPane.showMessageDialog(loginView, "Login successful!");
                loginView.dispose();
                showHomeView(user);
            } else {
                LibraryStaffDTO staff = userService.loginStaff(email, password);
                if (staff != null) {
                    JOptionPane.showMessageDialog(loginView, "Login successful!");
                    loginView.dispose();
                    showStaffHomeView(staff);
                } else {
                    LibraryAdminDTO admin = userService.loginAdmin(email, password);
                    if (admin != null) {
                        JOptionPane.showMessageDialog(loginView, "Login successful!");
                        loginView.dispose();
                        showAdminHomeView(admin);
                    } else {
                        JOptionPane.showMessageDialog(loginView, "Invalid email or password!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        loginView.getForgotPasswordButton().addActionListener(_ -> {
            loginView.dispose();
            showChangePasswordView(null); // Truyền null vì không có thông tin người dùng ở đây
        });

        loginView.getRegisterButton().addActionListener(_ -> {
            loginView.dispose();
            showRegisterView();
        });

        loginView.setVisible(true);
    }

    public void showHomeView(User user) {
        HomeView homeView = new HomeView();
        homeView.getLogoutButton().addActionListener(_ -> {
            homeView.dispose();
            showLoginView();
        });
        homeView.setVisible(true);
    }

    public void showStaffHomeView(LibraryStaffDTO staff) {
        StaffHomeView staffHomeView = new StaffHomeView();
        staffHomeView.getLogoutButton().addActionListener(_ -> {
            staffHomeView.dispose();
            showLoginView();
        });
        staffHomeView.setVisible(true);
    }

    public void showAdminHomeView(LibraryAdminDTO admin) {
        AdminHomeView adminHomeView = new AdminHomeView();
        adminHomeView.getLogoutButton().addActionListener(_ -> {
            adminHomeView.dispose();
            showLoginView();
        });
        adminHomeView.setVisible(true);
    }

    public void showChangePasswordView(User user) {
        ChangePasswordView changePasswordView = new ChangePasswordView(convertToDTO(user));
        changePasswordView.getChangePasswordButton().addActionListener(_ -> {
            String email = changePasswordView.getEmailField().getText();
            String oldPassword = new String(changePasswordView.getOldPasswordField().getPassword());
            String newPassword = new String(changePasswordView.getNewPasswordField().getPassword());

            if (email.isEmpty() || oldPassword.isEmpty() || newPassword.isEmpty()) {
                JOptionPane.showMessageDialog(changePasswordView, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            LibraryMemberDTO member = userService.loginMember(email, oldPassword);
            if (member != null) {
                if (userService.changePassword(member, oldPassword, newPassword)) {
                    JOptionPane.showMessageDialog(changePasswordView, "Password changed successfully!");
                    changePasswordView.dispose();
                    showLoginView();
                } else {
                    JOptionPane.showMessageDialog(changePasswordView, "Password change failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(changePasswordView, "Invalid email or password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        changePasswordView.getBackButton().addActionListener(_ -> {
            changePasswordView.dispose();
            showLoginView();
        });

        changePasswordView.setVisible(true);
    }

    public void showUserProfileView(User user) {
        UserProfileView userProfileView = new UserProfileView(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber()
        );
        userProfileView.getChangePasswordButton().addActionListener(e -> {
            userProfileView.dispose();
            showChangePasswordView(user);
        });
        userProfileView.setVisible(true);
    }

    private User convertToModel(LibraryMemberDTO dto) {
        if (dto == null) {
            return null;
        }
        return new User(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPassword(), dto.getPhoneNumber());
    }

    private LibraryMemberDTO convertToDTO(User user) {
        if (user == null) {
            return null;
        }
        return new LibraryMemberDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPhoneNumber());
    }

    public void showAddBookView() {
        // Hiển thị form thêm sách
    }

    public void showUpdateBookView() {
        // Hiển thị form cập nhật sách
    }

    public void showDeleteBookView() {
        // Hiển thị form xóa sách
    }

    public void showAddBookHistoryView() {
        // Hiển thị form thêm lịch sử sách
    }

    public void showUpdateBookHistoryView() {
        // Hiển thị form cập nhật lịch sử sách
    }

    public void showDeleteBookHistoryView() {
        // Hiển thị form xóa lịch sử sách
    }

    public void showAddStaffView() {
        // Hiển thị form thêm nhân viên thư viện
    }

    public void showUpdateStaffView() {
        // Hiển thị form cập nhật nhân viên thư viện
    }

    public void showDeleteStaffView() {
        // Hiển thị form xóa nhân viên thư viện
    }
}