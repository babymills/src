package DB;

import java.sql.*;

public class ViewTableResults {
        private Connection con;

        public ViewTableResults() throws SQLException {
            String url = "jdbc:mysql://localhost/bookstore" +
                    "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
            String name = "root";
            String password = "password";

            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            String query = "select * from tmp";
            ResultSet rs = st.executeQuery(query);
            printResults(rs);
            System.out.println("Disconnected.");
            con.close();
        }

        private void printResults(ResultSet rs) throws SQLException {
            String name, id;
            double price;
            while (rs.next()) {
                id = String.valueOf(rs.getInt("id"));
                name = rs.getString("name");
                System.out.println("******************************");
                System.out.println("id: " + id);
                System.out.println("name: " + name);
                System.out.println("******************************");
            }
        }

        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
            ViewTableResults viewTableResults = new ViewTableResults();
        }
    }