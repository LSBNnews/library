package dao;

import dto.LibraryBooksDTO;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryBooksDAO {
    private final Connection connection;

    public LibraryBooksDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean addBook(LibraryBooksDTO book) {
        String sql = "INSERT INTO library_books (Title, Author, Category, Shelf_ID, Available) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getCategory());
            statement.setString(4, book.getShelfId());
            statement.setInt(5, book.getAvailable());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<LibraryBooksDTO> getAllBooks() {
        List<LibraryBooksDTO> books = new ArrayList<>();
        String sql = "SELECT * FROM library_books";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                books.add(new LibraryBooksDTO(
                        resultSet.getString("Title"),
                        resultSet.getString("Author"),
                        resultSet.getString("Category"),
                        resultSet.getString("Shelf_ID"),
                        resultSet.getInt("Available")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public boolean updateBook(LibraryBooksDTO book) {
        String sql = "UPDATE library_books SET Title = ?, Author = ?, Category = ?, Shelf_ID = ?, Available = ? WHERE Title = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getCategory());
            statement.setString(4, book.getShelfId());
            statement.setInt(5, book.getAvailable());
            statement.setString(6, book.getTitle());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(String title) {
        String sql = "DELETE FROM library_books WHERE Title = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}