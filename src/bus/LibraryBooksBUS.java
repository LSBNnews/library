package bus;

import dao.LibraryBooksDAO;
import dto.LibraryBooksDTO;

import java.util.List;

public class LibraryBooksBUS {
    private final LibraryBooksDAO libraryBooksDAO;

    public LibraryBooksBUS() {
        this.libraryBooksDAO = new LibraryBooksDAO();
    }

    public boolean addBook(LibraryBooksDTO book) {
        return libraryBooksDAO.addBook(book);
    }

    public List<LibraryBooksDTO> getAllBooks() {
        return libraryBooksDAO.getAllBooks();
    }

    public boolean updateBook(LibraryBooksDTO book) {
        return libraryBooksDAO.updateBook(book);
    }

    public boolean deleteBook(String title) {
        return libraryBooksDAO.deleteBook(title);
    }
}