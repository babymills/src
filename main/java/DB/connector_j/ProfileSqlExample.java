package DB.connector_j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ProfileSqlExample {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/quiz_db?profileSQL=true";
    public static final String LOGIN = "username";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
        Statement stmt = conn.createStatement();
        stmt.execute("select * from quizes");
    }
}
