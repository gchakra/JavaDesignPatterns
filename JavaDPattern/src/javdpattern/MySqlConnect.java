package javdpattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 *
 * @author gopalchakravarthy
 */
public class MySqlConnect {

    // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Demo_Schema";
    private static final String USERNAME = "gchakravarthy";
    private static final String PASSWORD = "radha123";
    private static final String MAX_POOL = "250";

    // init mysqlConn object
    private Connection mysqlConn;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect database
    public Connection connect() {
        System.out.println("Connecting database...");
        if (mysqlConn == null) {
            try {
                Class.forName(DATABASE_DRIVER);

                mysqlConn = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return mysqlConn;
    }

    // disconnect database
    public void disconnect() {
        if (mysqlConn != null) {
            try {
                mysqlConn.close();
                mysqlConn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
