package DB.rowset;

import com.sun.rowset.WebRowSetImpl;

import javax.sql.rowset.WebRowSet;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import static java.lang.Math.random;

public class RowSetTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        // load RowSet from db
        WebRowSet rowSetWas = new WebRowSetImpl();
        populateFromDb(rowSetWas);
        // convert RowSet to XML
        String strPresentation = convertRowSetToXml(rowSetWas);
        // print XML to System.out
        System.out.println(strPresentation);

        // convert XML to RowSet
        WebRowSet rowSetNow = convertXmlToRowSet(strPresentation);
        rowSetNow = rowSetWas;
        // dump RowSet to System.out
        dumpToSystemOut(rowSetNow);
        // change RowSet
        rowSetNow.first();
        rowSetNow.updateString("caption", "ABC");
        // save changes to DB
        rowSetNow.updateRow();
//        rowSetNow.acceptChanges();
        // todo: some troubles with transactions
    }

    private static void populateFromDb(WebRowSet rowSet) throws SQLException {
        rowSet.setCommand("SELECT id, caption, description FROM quizes");
        rowSet.setUrl("jdbc:mysql://localhost:3306/quiz_db");
        rowSet.setUsername("username");
        rowSet.setPassword("password");
        rowSet.execute();
    }

    private static WebRowSet convertXmlToRowSet(String strPresentation) throws SQLException {
        WebRowSet rowSet_1 = new WebRowSetImpl();
        rowSet_1.readXml(new StringReader(strPresentation));
        return rowSet_1;
    }

    private static String convertRowSetToXml(WebRowSet rowSet) throws SQLException {
        StringWriter writer = new StringWriter();
        rowSet.writeXml(writer);
        return writer.toString();
    }

    private static void dumpToSystemOut(WebRowSet rowSet) throws SQLException {
        rowSet.beforeFirst();
        ResultSetMetaData meta = rowSet.getMetaData();
        int count = meta.getColumnCount();
        while (rowSet.next()) {
            System.out.print("[");
            for (int k = 1; k <= count; k++) {
                System.out.print(meta.getColumnLabel(k) + "=" + rowSet.getString(k) + ", ");
            }
            System.out.println("]");
        }
    }
}
