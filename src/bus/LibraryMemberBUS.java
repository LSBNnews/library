package bus;

import dao.LibraryMemberDAO;
import dto.LibraryMemberDTO;

public class LibraryMemberBUS {
    private final LibraryMemberDAO libraryMemberDAO;

    public LibraryMemberBUS() {
        this.libraryMemberDAO = new LibraryMemberDAO();
    }

    public boolean registerUser(LibraryMemberDTO member) {
        return libraryMemberDAO.registerUser(member);
    }

    public LibraryMemberDTO login(String email, String password) {
        return libraryMemberDAO.login(email, password);
    }

    public boolean changePassword(LibraryMemberDTO member, String oldPassword, String newPassword) {
        if (!member.getPassword().equals(oldPassword)) {
            return false;
        }
        return libraryMemberDAO.changePassword(member, newPassword);
    }

    public boolean updateUserProfile(LibraryMemberDTO member) {
        return libraryMemberDAO.updateUserProfile(member);
    }
}