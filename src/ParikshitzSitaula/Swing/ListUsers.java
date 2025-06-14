package ParikshitzSitaula.Swing;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;
import ParikshitzSitaula.Services.Library;
import ParikshitzSitaula.entities.Users;

public class ListUsers extends JFrame {
    public ListUsers() {
        setTitle("List of Users");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        List<Users> users;

        try {
            users = Library.getAllUsers();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to load users: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            return;  // stop further processing
        }

        for (Users u : users) {
            textArea.append("ID: " + u.getId() + ", Name: " + u.getName() + "\n");
        }

        add(new JScrollPane(textArea));
        setVisible(true);
    }
}
