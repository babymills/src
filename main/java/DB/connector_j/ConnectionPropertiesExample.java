package DB.connector_j;

import com.mysql.jdbc.ConnectionProperties;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPropertiesExample {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/quiz_db";
    public static final String LOGIN = "username";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
        ConnectionProperties p = (ConnectionProperties) conn;
        System.out.println(p.exposeAsXml());
    }
}
