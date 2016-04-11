package DB.intro;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class MySQLExample_30 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("net.golovach.eshop.dao.demo_0.SuperDbDriver1");

        Enumeration<Driver> iter = DriverManager.getDrivers();
        while (iter.hasMoreElements()) {
            Driver driver = iter.nextElement();
            System.err.println("driver = " + driver);
        }
    }
}
