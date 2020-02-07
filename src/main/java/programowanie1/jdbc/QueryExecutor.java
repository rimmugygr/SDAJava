package programowanie1.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor {
    public static ResultSet executeSelect(String selectQuery){
        try {
            Connection connection=DBConnector.connect();
            Statement statement =connection.createStatement();
            return statement.executeQuery(selectQuery);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void executeQuere(String Query){
        try {
            Connection connection=DBConnector.connect();
            Statement statement =connection.createStatement();
            statement.execute(Query);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
