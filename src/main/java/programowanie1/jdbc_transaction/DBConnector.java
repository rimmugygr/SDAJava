package programowanie1.jdbc_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String URL ="jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static String USER = "root";
    private static String PASSWORD = "admin";

    public static Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Udane połaczenie");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

}
