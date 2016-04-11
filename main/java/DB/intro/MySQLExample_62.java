package DB.intro;

import java.sql.*;

public class MySQLExample_62 {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/bookstore?user=root&password=password";

    public static void main(String[] args) throws SQLException {        
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {

            Statement stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS tmp;");
            stmt.execute("CREATE TABLE tmp (id INT, name VARCHAR(64));");

            stmt.execute("INSERT INTO tmp (id, name) VALUES (1, 'Mike')");
            stmt.execute("INSERT INTO tmp (id, name) VALUES (2, 'Sara')");
            stmt.execute("INSERT INTO tmp (id, name) VALUES (3, 'Anna')");

            ResultSet rs = stmt.executeQuery("SELECT id, name FROM tmp");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.printf("%d, %s\n", id, name);
            }

            stmt.execute("DROP TABLE tmp;");
        }
    }
}


