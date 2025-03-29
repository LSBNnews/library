package bus;

import dao.LibraryAdminDAO;
import dto.LibraryAdminDTO;

public class LibraryAdminBUS {
    private final LibraryAdminDAO libraryAdminDAO;

    public LibraryAdminBUS() {
        this.libraryAdminDAO = new LibraryAdminDAO();
    }

    public boolean registerAdmin(LibraryAdminDTO admin) {
        return libraryAdminDAO.registerAdmin(admin);
    }

    public LibraryAdminDTO login(String email, String password) {
        return libraryAdminDAO.login(email, password);
    }

    public boolean updateAdminProfile(LibraryAdminDTO admin) {
        return libraryAdminDAO.updateAdminProfile(admin);
    }

    public boolean deleteAdmin(int id) {
        return libraryAdminDAO.deleteAdmin(id);
    }
}