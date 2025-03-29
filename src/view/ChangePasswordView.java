package view;

import dto.LibraryMemberDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordView extends JFrame {
    private JTextField emailField;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JButton changePasswordButton;
    private JButton backButton;
    private boolean isFromUserProfile;

    public ChangePasswordView(LibraryMemberDTO member) {
        setTitle("Change Password");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Sử dụng DISPOSE_ON_CLOSE
        setLocationRelativeTo(null);

        // Thiết lập GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Thêm tiêu đề
        JLabel titleLabel = new JLabel("Change Password");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        // Thêm trường nhập liệu email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(emailField, gbc);

        // Thêm trường nhập liệu old password
        JLabel oldPasswordLabel = new JLabel("Old Password:");
        oldPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(oldPasswordLabel, gbc);

        oldPasswordField = new JPasswordField(20);
        oldPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(oldPasswordField, gbc);

        // Thêm trường nhập liệu new password
        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(newPasswordLabel, gbc);

        newPasswordField = new JPasswordField(20);
        newPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(newPasswordField, gbc);

        // Thêm nút thay đổi mật khẩu và nút back ngang hàng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

        changePasswordButton = new JButton("Change Password");
        changePasswordButton.setFont(new Font("Arial", Font.BOLD, 16));
        changePasswordButton.setBackground(new Color(255, 152, 0)); // Màu cam đậm
        changePasswordButton.setForeground(Color.WHITE);
        changePasswordButton.setFocusPainted(false);
        changePasswordButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding
        buttonPanel.add(changePasswordButton);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(220, 220, 220)); // Màu xám nhạt
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);

        // Nếu có người dùng, tự động điền email và khóa trường nhập liệu
        if (member != null) {
            emailField.setText(member.getEmail());
            emailField.setEditable(false);
            isFromUserProfile = true;
        } else {
            isFromUserProfile = false;
        }

        add(panel);
    }

    // Getter methods for fields and button
    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getOldPasswordField() {
        return oldPasswordField;
    }

    public JPasswordField getNewPasswordField() {
        return newPasswordField;
    }

    public JButton getChangePasswordButton() {
        return changePasswordButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public boolean isFromUserProfile() {
        return isFromUserProfile;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChangePasswordView(null).setVisible(true);
        });
    }
}