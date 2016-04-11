package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
        private final static String createTableQuery = "CREATE TABLE tmp(id INT, name VARCHAR(64));";

        public static void main(String[] args) throws SQLException, Exception {
            Connection connection = null;
            Statement statement = null;
            Class.forName("com.mysql.jdbc.Driver");
            //Подключаемся к новосозданной базе. Значение параметров после "?"
            //ясно из их имен.
            String url = "jdbc:mysql://localhost/bookstore" +
                    "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
            connection = DriverManager.getConnection(url, "root", "password");
            statement = connection.createStatement();
            statement.executeUpdate(createTableQuery);
            statement.executeUpdate("INSERT INTO tmp (id, name)\n" + "VALUES ('0', 'Mark');");

        }
    }