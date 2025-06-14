package ParikshitzSitaula.Swing;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;
import ParikshitzSitaula.Services.Library;
import ParikshitzSitaula.entities.Book;

public class ListBooks extends JFrame {
    public ListBooks() {
        setTitle("List of Books");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        List<Book> books;
        try {
            books = Library.getAllBooks();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to load books: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Book b : books) {
            textArea.append("ID: " + b.getId() + ", Title: " + b.getTitle() + ", Author: " + b.getAuthor() + "\n");
        }

        add(new JScrollPane(textArea));
        setVisible(true);
    }

}