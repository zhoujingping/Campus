package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String DBDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false";
    private static final String User = "root";
    private static final String Password = "13695932659";

    public static Connection getDBConnect() {
        Connection connection = null;
        try {
            Class.forName(DBDriver);
            connection = DriverManager.getConnection(DBURL, User, Password);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return connection;
    }
}
