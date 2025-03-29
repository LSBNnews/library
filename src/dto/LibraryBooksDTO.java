package dto;

public class LibraryBooksDTO {
    private String title;
    private String author;
    private String category;
    private String shelfId;
    private int available;

    public LibraryBooksDTO() {}

    public LibraryBooksDTO(String title, String author, String category, String shelfId, int available) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.shelfId = shelfId;
        this.available = available;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShelfId() {
        return shelfId;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}