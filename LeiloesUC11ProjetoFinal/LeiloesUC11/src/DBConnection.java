
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;




public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/uc11";
    private static final String USER = "root";
    private static final String PASSWORD = "81225573"; // Ajuste conforme necessário

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar ao banco de dados", e);
        }
    }
}
