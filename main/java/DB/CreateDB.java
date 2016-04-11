package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    private final static String createDatabaseQyery =
            "CREATE DATABASE bookstore CHARACTER SET utf8 COLLATE utf8_general_ci";

    public static void main(String[] args) throws Exception {

        //Загружаем драйвер
        Class.forName("com.mysql.jdbc.Driver");
        //Нужно создать подключение к БД. У MySQL обязательно есть системная база,
        //к ней и будем создавать соединение.
        String url = "jdbc:mysql://localhost/mysql";
        //По умолчанию пользователь - root, пароль - а нет его!
        Connection connection = DriverManager.getConnection(url, "root", "password");
        Statement statement = connection.createStatement();
        //Обратите внимание, что создаем базу с помощью executeUpdate(). Об этом мы поговорим немного позже.
        statement.executeUpdate(createDatabaseQyery);
    }
}