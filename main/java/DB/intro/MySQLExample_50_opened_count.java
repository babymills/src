package DB.intro;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLExample_50_opened_count {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/mydb?user=root&password=password";

    public static void main(String[] args) throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        open(driver, 1);
    }

    public static void open(Driver driver, int count) throws SQLException {
        System.err.println(count);
        try (Connection conn = driver.connect(JDBC_URL, new Properties())) {
            open(driver, count + 1);
        }
    }
}
