package DB.intro;

import java.sql.SQLException;
import java.util.Properties;

public class MySQLExample_12 {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/mydb?user=root&password=password";

    public static void main(String[] args) throws SQLException {
        java.sql.Driver driver = new com.mysql.jdbc.Driver();

        System.out.println(driver.acceptsURL("jdbc:SUPER_DB"));
        System.out.println(driver.acceptsURL(JDBC_URL));

        try (java.sql.Connection conn = driver.connect(JDBC_URL, new Properties())) {
            System.out.println("conn = " + conn);
        }
    }
}
