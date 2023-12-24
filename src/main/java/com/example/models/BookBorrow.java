package com.example.models;

public class BookBorrow {
    private String bookTitle; 
    private String kodeBuku;
    private String borrowedAt;
    private String borrowId; 
    private String description; 
    private String bookId; 


    public BookBorrow(String bookTitle, String kodeBuku, String borrowedAt, String borrowId, String description, String bookId) {
        this.bookTitle = bookTitle;
        this.kodeBuku = kodeBuku;
        this.borrowedAt = borrowedAt;
        this.borrowId = borrowId;
        this.description = description;
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getKodeBuku() {
        return kodeBuku;
    }
    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }
    public String getBorrowedAt() {
        return borrowedAt;
    }
    public void setBorrowedAt(String borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    } 
}
