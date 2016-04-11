package DB.metadata;

import java.sql.*;

import static java.sql.Connection.*;
import static java.sql.ResultSet.*;

public class MetadataExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();

        DatabaseMetaData metaData = conn.getMetaData();
        dumpDbGeneralInfo(metaData);
        dumpDbSqlInfo(metaData);
        dumpDbConstraints(metaData);
        dumpX(metaData);
        dump("Catalogs", metaData.getCatalogs());
        dump("Schemas", metaData.getSchemas());
        dump("Tables", metaData.getTables(null, null, null, null));
        dump("Primary Keys", metaData.getPrimaryKeys(null, null, "user"));
        dump("TypeInfo", metaData.getTypeInfo());
        dump("TableTypes", metaData.getTableTypes());
        dump("Procedures", metaData.getProcedures(null, null, null));
        dump("Functions", metaData.getFunctions(null, null, null));

        System.out.println("SQLStateType = " + ((metaData.getSQLStateType() == DatabaseMetaData.sqlStateXOpen) ? "X/Open SQL CLI SQLSTATE" : "SQL 99 STATE SQL"));
    }

    private static void dumpDbConstraints(DatabaseMetaData metaData) throws SQLException {
        System.out.println("Db constraints:");
        System.out.println("    MaxStatements = " + metaData.getMaxStatements());
        System.out.println("    MaxColumnsInGroupBy = " + metaData.getMaxColumnsInGroupBy());
        System.out.println("    MaxColumnsInIndex = " + metaData.getMaxColumnsInIndex());
        System.out.println("    MaxColumnsInSelect = " + metaData.getMaxColumnsInSelect());
        System.out.println("    MaxColumnsInTable = " + metaData.getMaxColumnsInTable());
        System.out.println("    MaxConnections = " + metaData.getMaxConnections());
        System.out.println("    MaxStatementLength = " + metaData.getMaxStatementLength());
        System.out.println("    MaxTablesInSelect = " + metaData.getMaxTablesInSelect());
    }

    private static void dumpDbGeneralInfo(DatabaseMetaData metaData) throws SQLException {
        System.out.println("Db info:");
        System.out.println("    DatabaseProductName = " + metaData.getDatabaseProductName());
        System.out.println("    DatabaseProductVersion = " + metaData.getDatabaseProductVersion());
        System.out.println("    DriverName = " + metaData.getDriverName());
        System.out.println("    DriverVersion = " + metaData.getDriverVersion());
        System.out.println("    JDBCMinorVersion = " + metaData.getJDBCMinorVersion());
        System.out.println("    JDBCMajorVersion = " + metaData.getJDBCMajorVersion());
    }

    private static void dumpDbSqlInfo(DatabaseMetaData metaData) throws SQLException {
        System.out.println("Db/SQL info:");
        System.out.println("    NumericFunctions = " + metaData.getNumericFunctions());
        System.out.println("    TimeDateFunctions = " + metaData.getTimeDateFunctions());
        System.out.println("    StringFunctions = " + metaData.getStringFunctions());
        System.out.println("    SystemFunctions = " + metaData.getSystemFunctions());
        System.out.println("    SQLKeywords = " + metaData.getSQLKeywords());
    }

    private static void dumpX(DatabaseMetaData metaData) throws SQLException {
        System.out.println("???");
        System.out.println("    autoCommitFailureClosesAllResultSets = " + metaData.autoCommitFailureClosesAllResultSets());
        System.out.println("    dataDefinitionCausesTransactionCommit = " + metaData.dataDefinitionCausesTransactionCommit());
        System.out.println("    dataDefinitionIgnoredInTransactions = " + metaData.dataDefinitionIgnoredInTransactions());
        // todo:
//        System.out.println("    generatedKeyAlwaysReturned = " + metaData.generatedKeyAlwaysReturned());
        System.out.println("    nullsAreSortedAtEnd = " + metaData.nullsAreSortedAtEnd());
        System.out.println("    nullsAreSortedAtStart = " + metaData.nullsAreSortedAtStart());
        System.out.println("    nullsAreSortedHigh = " + metaData.nullsAreSortedHigh());
        System.out.println("    nullsAreSortedLow = " + metaData.nullsAreSortedLow());

        System.out.println("    usesLocalFiles = " + metaData.usesLocalFiles());
        System.out.println("    usesLocalFilePerTable = " + metaData.usesLocalFilePerTable());

        System.out.println("    insertsAreDetected(TYPE_FORWARD_ONLY) = " + metaData.insertsAreDetected(TYPE_FORWARD_ONLY));
        System.out.println("    insertsAreDetected(TYPE_SCROLL_INSENSITIVE) = " + metaData.insertsAreDetected(TYPE_SCROLL_INSENSITIVE));
        System.out.println("    insertsAreDetected(TYPE_SCROLL_SENSITIVE) = " + metaData.insertsAreDetected(TYPE_SCROLL_SENSITIVE));
        System.out.println("    updatesAreDetected(TYPE_FORWARD_ONLY) = " + metaData.updatesAreDetected(TYPE_FORWARD_ONLY));
        System.out.println("    updatesAreDetected(TYPE_SCROLL_INSENSITIVE) = " + metaData.updatesAreDetected(TYPE_SCROLL_INSENSITIVE));
        System.out.println("    updatesAreDetected(TYPE_SCROLL_SENSITIVE) = " + metaData.updatesAreDetected(TYPE_SCROLL_SENSITIVE));
        System.out.println("    deletesAreDetected(TYPE_FORWARD_ONLY) = " + metaData.deletesAreDetected(TYPE_FORWARD_ONLY));
        System.out.println("    deletesAreDetected(TYPE_SCROLL_INSENSITIVE) = " + metaData.deletesAreDetected(TYPE_SCROLL_INSENSITIVE));
        System.out.println("    deletesAreDetected(TYPE_SCROLL_SENSITIVE) = " + metaData.deletesAreDetected(TYPE_SCROLL_SENSITIVE));

        System.out.println("    supportsUnionAll = " + metaData.supportsUnionAll());
        System.out.println("    supportsUnion = " + metaData.supportsUnion());

        System.out.println("    supportsStatementPooling = " + metaData.supportsStatementPooling());

        System.out.println("    supportsTransactionIsolationLevel(TRANSACTION_NONE) = " + metaData.supportsTransactionIsolationLevel(TRANSACTION_NONE));
        System.out.println("    supportsTransactionIsolationLevel(TRANSACTION_READ_UNCOMMITTED) = " + metaData.supportsTransactionIsolationLevel(TRANSACTION_READ_UNCOMMITTED));
        System.out.println("    supportsTransactionIsolationLevel(TRANSACTION_READ_COMMITTED) = " + metaData.supportsTransactionIsolationLevel(TRANSACTION_READ_COMMITTED));
        System.out.println("    supportsTransactionIsolationLevel(TRANSACTION_REPEATABLE_READ) = " + metaData.supportsTransactionIsolationLevel(TRANSACTION_REPEATABLE_READ));
        System.out.println("    supportsTransactionIsolationLevel(TRANSACTION_SERIALIZABLE) = " + metaData.supportsTransactionIsolationLevel(TRANSACTION_SERIALIZABLE));
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/production_eshop", "username", "password");
    }

    public static void dump(String name, ResultSet rs) throws SQLException {
        System.out.println(name);
        if (!rs.next()) {
            System.out.println("    []");
            return;
        }

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        do {
            System.out.print("    [");
            for (int k = 1; k <= columnCount; k++) {
                System.out.print(metaData.getColumnLabel(k) + ":" + rs.getString(k) + ", ");
            }
            System.out.print(']');
            System.out.println();
//            rs.getConcurrency();
//            rs.getCursorName();
//            rs.getFetchSize();
//            rs.getRef(1);
//            rs.getRow();
//            rs.getRowId(1);
//            rs.getStatement();
//            rs.getType();
//            rs.getURL(1);
        } while (rs.next());
    }
}
