package dao;

import dto.LibraryBookHistoryDTO;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryBookHistoryDAO {
    private final Connection connection;

    public LibraryBookHistoryDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean addBookHistory(LibraryBookHistoryDTO bookHistory) {
        String sql = "INSERT INTO library_bookhistory (Title, Author, Date, Time, Action, Acted_By, Amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bookHistory.getTitle());
            statement.setString(2, bookHistory.getAuthor());
            statement.setDate(3, new java.sql.Date(bookHistory.getDate().getTime()));
            statement.setTime(4, bookHistory.getTime());
            statement.setString(5, bookHistory.getAction());
            statement.setObject(6, bookHistory.getActedBy());
            statement.setInt(7, bookHistory.getAmount());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<LibraryBookHistoryDTO> getAllBookHistories() {
        List<LibraryBookHistoryDTO> bookHistories = new ArrayList<>();
        String sql = "SELECT * FROM library_bookhistory";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                bookHistories.add(new LibraryBookHistoryDTO(
                        resultSet.getString("Title"),
                        resultSet.getString("Author"),
                        resultSet.getDate("Date"),
                        resultSet.getTime("Time"),
                        resultSet.getString("Action"),
                        resultSet.getObject("Acted_By", Integer.class),
                        resultSet.getInt("Amount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookHistories;
    }

    public boolean updateBookHistory(LibraryBookHistoryDTO bookHistory) {
        String sql = "UPDATE library_bookhistory SET Title = ?, Author = ?, Date = ?, Time = ?, Action = ?, Acted_By = ?, Amount = ? WHERE Title = ? AND Author = ? AND Date = ? AND Time = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bookHistory.getTitle());
            statement.setString(2, bookHistory.getAuthor());
            statement.setDate(3, new java.sql.Date(bookHistory.getDate().getTime()));
            statement.setTime(4, bookHistory.getTime());
            statement.setString(5, bookHistory.getAction());
            statement.setObject(6, bookHistory.getActedBy());
            statement.setInt(7, bookHistory.getAmount());
            statement.setString(8, bookHistory.getTitle());
            statement.setString(9, bookHistory.getAuthor());
            statement.setDate(10, new java.sql.Date(bookHistory.getDate().getTime()));
            statement.setTime(11, bookHistory.getTime());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBookHistory(String title, String author, java.sql.Date date, java.sql.Time time) {
        String sql = "DELETE FROM library_bookhistory WHERE Title = ? AND Author = ? AND Date = ? AND Time = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setDate(3, date);
            statement.setTime(4, time);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}