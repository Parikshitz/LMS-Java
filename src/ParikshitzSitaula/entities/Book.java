package ParikshitzSitaula.entities;

public class Book {
    private int id;
    private String title;
    private String author;
    private String issuedTo;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issuedTo = null;
        this.isIssued = false;
    }

    public Book(int id, String title, String author, boolean isIssued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public String getIssuedTo() { return issuedTo; }

    // Setters
    public void setIssued(boolean issued) { isIssued = issued; }
    public void setIssuedTo(String issuedTo) { this.issuedTo = issuedTo; }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " +
                (isIssued ? "Issued to: " + issuedTo : "Available");
    }
}
