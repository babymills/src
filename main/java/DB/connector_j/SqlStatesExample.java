package DB.connector_j;

import com.mysql.jdbc.SQLError;

public class SqlStatesExample {
    public static void main(String[] args) throws Exception {
        SQLError.dumpSqlStatesMappingsAsXml();
    }
}
