package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;


public class JDBC {
    final private static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static String url;
    final private static String server = "localhost";
    final private static String port = "1521";
    final private static String sid = "xe";
    final private static String username = "system";
    final private static String password = "Boss617f208";



    public Connection getConnection() {
        Connection connection = null;
        try {
            Locale.setDefault(new Locale("es","ES"));
            url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connecting: " + url);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");

        } catch (SQLException e) {
            System.out.println("SQLException\n" + e.getMessage());
            System.out.println("ERROR");
        }
        return connection;
    }
}


