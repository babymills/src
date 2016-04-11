package DB.intro;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class MySQLExample_21 {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/mydb?user=root&password=password";

    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new SuperDbDriver0());

        Enumeration<Driver> iter = DriverManager.getDrivers();
        while (iter.hasMoreElements()) {
            Driver driver = iter.nextElement();
            System.err.println("driver = " + driver);
        }

        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            System.err.println("conn = " + conn.getClass());
        }

        try (Connection conn = DriverManager.getConnection("jdbc:SUPER_DB")) {
            System.err.println("conn = " + conn.getClass());
        }
    }
}
