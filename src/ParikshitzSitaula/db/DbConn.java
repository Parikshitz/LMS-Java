package ParikshitzSitaula.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    DbConfig.URL,
                    DbConfig.USER,
                    DbConfig.PASSWORD
            );
        } catch (ClassNotFoundException ce) {
            throw new SQLException("MySQL JDBC Driver not found", ce);
        } catch (SQLException se) {
            throw new SQLException("Failed to connect to the database", se);
        } catch (Exception e) {
            throw new SQLException("An unexpected error occurred while connecting to the database", e);
        }
    }
}
