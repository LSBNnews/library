package service;

import bus.*;
import dto.LibraryMemberDTO;
import dto.LibraryStaffDTO;
import dto.LibraryAdminDTO;
import dto.LibraryBooksDTO;
import dto.LibraryBookHistoryDTO;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class UserService {
    private LibraryMemberBUS libraryMemberBUS;
    private LibraryStaffBUS libraryStaffBUS;
    private LibraryAdminBUS libraryAdminBUS;
    private LibraryBooksBUS libraryBooksBUS;
    private LibraryBookHistoryBUS libraryBookHistoryBUS;

    public UserService() {
        this.libraryMemberBUS = new LibraryMemberBUS();
        this.libraryStaffBUS = new LibraryStaffBUS();
        this.libraryAdminBUS = new LibraryAdminBUS();
        this.libraryBooksBUS = new LibraryBooksBUS();
        this.libraryBookHistoryBUS = new LibraryBookHistoryBUS();
    }

    public boolean registerUser(String firstName, String lastName, String email, String password, String phoneNumber) {
        LibraryMemberDTO member = new LibraryMemberDTO(0, firstName, lastName, email, password, phoneNumber);
        return libraryMemberBUS.registerUser(member);
    }

    public LibraryMemberDTO loginMember(String email, String password) {
        return libraryMemberBUS.login(email, password);
    }

    public boolean changePassword(LibraryMemberDTO user, String oldPassword, String newPassword) {
        return libraryMemberBUS.changePassword(user, oldPassword, newPassword);
    }

    public boolean updateUserProfile(LibraryMemberDTO user) {
        return libraryMemberBUS.updateUserProfile(user);
    }

    public boolean registerStaff(String firstName, String lastName, String email, String password, int salary, String phoneNumber) {
        LibraryStaffDTO staff = new LibraryStaffDTO(0, firstName, lastName, email, password, salary, phoneNumber);
        return libraryStaffBUS.registerStaff(staff);
    }

    public LibraryStaffDTO loginStaff(String email, String password) {
        return libraryStaffBUS.login(email, password);
    }

    public boolean updateStaffProfile(LibraryStaffDTO staff) {
        return libraryStaffBUS.updateStaffProfile(staff);
    }

    public boolean deleteStaff(int id) {
        return libraryStaffBUS.deleteStaff(id);
    }

    public boolean registerAdmin(String firstName, String lastName, String email, String password, String phoneNumber) {
        LibraryAdminDTO admin = new LibraryAdminDTO(0, firstName, lastName, email, password, phoneNumber);
        return libraryAdminBUS.registerAdmin(admin);
    }

    public LibraryAdminDTO loginAdmin(String email, String password) {
        return libraryAdminBUS.login(email, password);
    }

    public boolean addBook(String title, String author, String category, String shelfId, int available) {
        LibraryBooksDTO book = new LibraryBooksDTO(title, author, category, shelfId, available);
        return libraryBooksBUS.addBook(book);
    }

    public List<LibraryBooksDTO> getAllBooks() {
        return libraryBooksBUS.getAllBooks();
    }

    public boolean updateBook(LibraryBooksDTO book) {
        return libraryBooksBUS.updateBook(book);
    }

    public boolean deleteBook(String title) {
        return libraryBooksBUS.deleteBook(title);
    }

    public boolean addBookHistory(String title, String author, Date date, Time time, String action, Integer actedBy, int amount) {
        LibraryBookHistoryDTO bookHistory = new LibraryBookHistoryDTO(title, author, date, time, action, actedBy, amount);
        return libraryBookHistoryBUS.addBookHistory(bookHistory);
    }

    public List<LibraryBookHistoryDTO> getAllBookHistories() {
        return libraryBookHistoryBUS.getAllBookHistories();
    }

    public boolean updateBookHistory(LibraryBookHistoryDTO bookHistory) {
        return libraryBookHistoryBUS.updateBookHistory(bookHistory);
    }

    public boolean deleteBookHistory(String title, String author, java.sql.Date date, Time time) {
        return libraryBookHistoryBUS.deleteBookHistory(title, author, date, time);
    }
}