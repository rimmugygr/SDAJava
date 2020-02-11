package programowanie1.jdbc_transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
/*        try {
            ResultSet resultSet = QueryExecutor.executeSelect("SELECT * FROM EMPLOYEE");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID") + " " +
                        resultSet.getString("FIRSTNAME")+" "+
                        resultSet.getString("LASTNAME"));
            }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }*/



        try {
            List<String> queres= new ArrayList<String>(Arrays.asList(new String[]{"SELECT * FROM EMPLOYEE WHERE ID='9'", "SELECT * FROM EMPLOYEE WHERE ID='2'"}));
            List<List<List<String>>> listsOfQueres = QueryExecutor.executeQueresInTransaction(queres);
            for (List<List<String>> listOfQuere : listsOfQueres) {
                for (List<String> records : listOfQuere) {
                    records.forEach(x->System.out.print(x));
                    System.out.println();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            List<String> queres= new ArrayList<String>(Arrays.asList(new String[]{"SELECT * FROM EMPLOYEE WHERE ID='9'", "SELECT * FROM EMPLOYEE WHERE ID='2'"}));
            List<List<List<String>>> listsOfQueres = QueryExecutor.executeQueres(queres);
            for (List<List<String>> listOfQuere : listsOfQueres) {
                for (List<String> records : listOfQuere) {
                    records.forEach(x->System.out.print(x));
                    System.out.println();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
