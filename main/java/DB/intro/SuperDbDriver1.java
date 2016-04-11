package DB.intro;

import java.sql.SQLException;

public class SuperDbDriver1 extends SuperDbDriver0 {
    static {
        try {
            java.sql.DriverManager.registerDriver(new SuperDbDriver1());
        } catch (SQLException E) {
            throw new RuntimeException("Can't register driver!");
        }
    }
}
