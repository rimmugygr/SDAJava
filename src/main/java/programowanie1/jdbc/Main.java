package programowanie1.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        try {
            ResultSet resultSet = QueryExecutor.executeSelect("SELECT * FROM EMPLOYEE");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID") + " " +
                        resultSet.getString("FIRSTNAME")+" "+
                        resultSet.getString("LASTNAME"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
