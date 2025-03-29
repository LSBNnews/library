package bus;

import dao.LibraryStaffDAO;
import dto.LibraryStaffDTO;

public class LibraryStaffBUS {
    private final LibraryStaffDAO libraryStaffDAO;

    public LibraryStaffBUS() {
        this.libraryStaffDAO = new LibraryStaffDAO();
    }

    public boolean registerStaff(LibraryStaffDTO staff) {
        return libraryStaffDAO.registerStaff(staff);
    }

    public LibraryStaffDTO login(String email, String password) {
        return libraryStaffDAO.login(email, password);
    }

    public boolean updateStaffProfile(LibraryStaffDTO staff) {
        return libraryStaffDAO.updateStaffProfile(staff);
    }

    public boolean deleteStaff(int id) {
        return libraryStaffDAO.deleteStaff(id);
    }
}