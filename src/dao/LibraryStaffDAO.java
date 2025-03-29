package dao;

import dto.LibraryStaffDTO;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryStaffDAO {
    private final Connection connection;

    public LibraryStaffDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean registerStaff(LibraryStaffDTO staff) {
        String sql = "INSERT INTO library_staff (First_Name, Last_Name, Email, Password, Salary, Phone_Number) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staff.getFirstName());
            statement.setString(2, staff.getLastName());
            statement.setString(3, staff.getEmail());
            statement.setString(4, staff.getPassword());
            statement.setInt(5, staff.getSalary());
            statement.setString(6, staff.getPhoneNumber());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public LibraryStaffDTO login(String email, String password) {
        String sql = "SELECT * FROM library_staff WHERE Email = ? AND Password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new LibraryStaffDTO(
                        resultSet.getInt("ID"),
                        resultSet.getString("First_Name"),
                        resultSet.getString("Last_Name"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getInt("Salary"),
                        resultSet.getString("Phone_Number")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateStaffProfile(LibraryStaffDTO staff) {
        String sql = "UPDATE library_staff SET First_Name = ?, Last_Name = ?, Email = ?, Password = ?, Salary = ?, Phone_Number = ? WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, staff.getFirstName());
            statement.setString(2, staff.getLastName());
            statement.setString(3, staff.getEmail());
            statement.setString(4, staff.getPassword());
            statement.setInt(5, staff.getSalary());
            statement.setString(6, staff.getPhoneNumber());
            statement.setInt(7, staff.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStaff(int id) {
        String sql = "DELETE FROM library_staff WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}