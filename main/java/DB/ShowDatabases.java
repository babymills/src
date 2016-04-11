package DB;
//todo show it
import java.lang.annotation.Annotation;
import java.sql.*;
import java.util.Arrays;

public class ShowDatabases {
    public static final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/bookstore";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        try(Connection conn = DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD)){
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery("show databases;");

        }

    }
}