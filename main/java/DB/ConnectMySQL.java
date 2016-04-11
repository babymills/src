package DB;

import com.mysql.jdbc.JDBC4Connection;

import java.sql.*;
import java.util.Enumeration;

public class ConnectMySQL {
    public static final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/empty";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

//        Enumeration<Driver> drivers = DriverManager.getDrivers();
//        while(drivers.hasMoreElements()){
//            System.out.println(drivers.nextElement().toString());
//        }
        try(Connection conn = DriverManager.getConnection(JDBC_URL,LOGIN,PASSWORD)){
         Statement statement = conn.createStatement();
         statement.execute("DROP TABLE IF EXISTS tmp;");
         statement.execute("CREATE TABLE tmp(id INT, name VARCHAR(64));");
         statement.executeUpdate("INSERT INTO tmp (id, name)\n" + "VALUES ('0', 'Mark');");

         Statement stmt = conn.createStatement();
            stmt.executeQuery("select * from tmp;");
        }
    }
}

