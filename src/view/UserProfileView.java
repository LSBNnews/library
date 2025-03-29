    package view;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class UserProfileView extends JFrame {
        private JLabel firstNameLabel;
        private JLabel lastNameLabel;
        private JLabel emailLabel;
        private JLabel phoneLabel;
        private JButton changePasswordButton;

        public UserProfileView(String firstName, String lastName, String email, String phone) {
            setTitle("User Profile");
            setSize(1600, 900);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Sử dụng DISPOSE_ON_CLOSE
            setLocationRelativeTo(null);

            // Thiết lập GridBagLayout
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);

            // Thêm tiêu đề
            JLabel titleLabel = new JLabel("User Profile");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(titleLabel, gbc);

            // Thêm nhãn tên
            firstNameLabel = new JLabel("First Name: " + firstName);
            firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(firstNameLabel, gbc);

            // Thêm nhãn họ
            lastNameLabel = new JLabel("Last Name: " + lastName);
            lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(lastNameLabel, gbc);

            // Thêm nhãn email
            emailLabel = new JLabel("Email: " + email);
            emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(emailLabel, gbc);

            // Thêm nhãn số điện thoại
            phoneLabel = new JLabel("Phone Number: " + phone);
            phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(phoneLabel, gbc);

            // Thêm nút thay đổi mật khẩu
            changePasswordButton = new JButton("Change Password");
            changePasswordButton.setFont(new Font("Arial", Font.BOLD, 16));
            changePasswordButton.setBackground(new Color(255, 152, 0)); // Màu cam đậm
            changePasswordButton.setForeground(Color.WHITE);
            changePasswordButton.setFocusPainted(false);
            changePasswordButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(changePasswordButton, gbc);

            add(panel);
        }

        // Getter method for change password button
        public JButton getChangePasswordButton() {
            return changePasswordButton;
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new UserProfileView("John", "Doe", "john.doe@example.com", "1234567890").setVisible(true);
            });
        }
    }