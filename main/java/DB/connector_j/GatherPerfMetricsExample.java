package DB.connector_j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//todo: don't work now
public class GatherPerfMetricsExample {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/quiz_db?gatherPerfMetrics=true&reportMetricsIntervalMillis=1000";
    public static final String LOGIN = "username";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
        Statement stmt = conn.createStatement();
        stmt.execute("select * from quizes");
        Thread.sleep(1000);
    }
}
