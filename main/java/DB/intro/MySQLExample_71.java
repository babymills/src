package DB.intro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExample_71 {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/quiz_db?user=username&password=password";

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(JDBC_URL);
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO tmp (id, name) VALUES (1, 'Mike')");
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        }
    }
}



