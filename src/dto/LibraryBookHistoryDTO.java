package dto;

import java.util.Date;

public class LibraryBookHistoryDTO {
    private String title;
    private String author;
    private Date date;
    private java.sql.Time time;
    private String action;
    private Integer actedBy;
    private int amount;

    public LibraryBookHistoryDTO() {}

    public LibraryBookHistoryDTO(String title, String author, Date date, java.sql.Time time, String action, Integer actedBy, int amount) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.time = time;
        this.action = action;
        this.actedBy = actedBy;
        this.amount = amount;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public java.sql.Time getTime() {
        return time;
    }

    public void setTime(java.sql.Time time) {
        this.time = time;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getActedBy() {
        return actedBy;
    }

    public void setActedBy(Integer actedBy) {
        this.actedBy = actedBy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}