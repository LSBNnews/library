package bus;

import dao.LibraryBookHistoryDAO;
import dto.LibraryBookHistoryDTO;

import java.util.List;

public class LibraryBookHistoryBUS {
    private final LibraryBookHistoryDAO libraryBookHistoryDAO;

    public LibraryBookHistoryBUS() {
        this.libraryBookHistoryDAO = new LibraryBookHistoryDAO();
    }

    public boolean addBookHistory(LibraryBookHistoryDTO bookHistory) {
        return libraryBookHistoryDAO.addBookHistory(bookHistory);
    }

    public List<LibraryBookHistoryDTO> getAllBookHistories() {
        return libraryBookHistoryDAO.getAllBookHistories();
    }

    public boolean updateBookHistory(LibraryBookHistoryDTO bookHistory) {
        return libraryBookHistoryDAO.updateBookHistory(bookHistory);
    }

    public boolean deleteBookHistory(String title, String author, java.sql.Date date, java.sql.Time time) {
        return libraryBookHistoryDAO.deleteBookHistory(title, author, date, time);
    }
}