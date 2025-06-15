package ParikshitzSitaula.Services;

import ParikshitzSitaula.db.*;
import ParikshitzSitaula.entities.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {

    public static void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
        try (Connection conn = DbConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.executeUpdate();
        }
    }

    public static void addUser(Users user) throws SQLException {
        String sql = "INSERT INTO Users (name) VALUES (?)";
        try (Connection conn = DbConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.executeUpdate();
        }
    }

    public static List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = DbConn.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("is_issued")
                ));
            }
        }
        return books;
    }

    public static List<Users> getAllUsers() throws SQLException {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Connection conn = DbConn.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(new Users(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
        }
        return users;
    }

    public static void issueBook(int bookId, int userId) throws SQLException {
        String checkSql = "SELECT is_issued FROM books WHERE id = ?";
        String issueSql = "INSERT INTO issued_books (book_id, Users_id, issue_date) VALUES (?, ?, ?)";
        String updateSql = "UPDATE books SET is_issued = true WHERE id = ?";

        try (Connection conn = DbConn.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setInt(1, bookId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getBoolean("is_issued")) {
                    throw new SQLException("Book already issued.");
                }
            }

            try (PreparedStatement issueStmt = conn.prepareStatement(issueSql);
                 PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

                issueStmt.setInt(1, bookId);
                issueStmt.setInt(2, userId);
                issueStmt.setDate(3, Date.valueOf(LocalDate.now()));
                issueStmt.executeUpdate();

                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    public static void returnBook(int bookId) throws SQLException {
        String returnSql = "UPDATE issued_books SET return_date = ? WHERE book_id = ? AND return_date IS NULL";
        String updateSql = "UPDATE books SET is_issued = false WHERE id = ?";

        try (Connection conn = DbConn.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement returnStmt = conn.prepareStatement(returnSql);
                 PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

                returnStmt.setDate(1, Date.valueOf(LocalDate.now()));
                returnStmt.setInt(2, bookId);
                returnStmt.executeUpdate();

                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }
}
