package DB.intro;

import java.sql.*;

public class MySQLExample_61 {
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/bookstore?user=root&password=password";

    public static final String SQL = "DELETE FROM bookstore.tmp WHERE `name`= ? OR `name`= ?;";

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {

            Statement stmt = conn.createStatement();
            //   stmt.execute("DROP TABLE IF EXISTS tmp;");
            //    stmt.execute("CREATE TABLE tmp (id INT, name VARCHAR(64));");

            stmt.execute("INSERT INTO tmp (id, name) VALUES (1, 'Mike')");
            stmt.execute("INSERT INTO tmp (id, name) VALUES (2, 'Sara')");
            stmt.execute("INSERT INTO tmp (id, name) VALUES (3, 'Anna')");

/*            PreparedStatement prepStmt = conn.prepareStatement(SQL);
            prepStmt.setString(1,"Sara");
            prepStmt.setString(2,"Anna");
            prepStmt.execute();*/

            ResultSet rs = stmt.executeQuery("SELECT id, name FROM tmp");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.printf("%d, %s\n", id, name);
            }
           // NOW PRINT COLUMN NAMES FROME THE TABLE tmp IN DATABASE bookstore
            System.out.println("Table: " + rs.getMetaData().getTableName(1));
            for  (int i = 1; i<= rs.getMetaData().getColumnCount(); i++){
                System.out.println("Column " +i  + " "+ rs.getMetaData().getColumnName(i));
            }
        }
    }
}


