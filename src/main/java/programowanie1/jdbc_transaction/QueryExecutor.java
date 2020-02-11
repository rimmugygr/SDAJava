package programowanie1.jdbc_transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryExecutor {
    /**
     * pojedyncze zapytanie do bazy ktore zwraca wynik zapytania
     * @param selectQuery zapytanie sql
     * @return ResultSet
     */
    public static ResultSet executeSelect(String selectQuery){
        try {
            Connection connection=DBConnector.connect();
            Statement statement =connection.createStatement();
            return statement.executeQuery(selectQuery);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * pojedyncze apytanie do bazy
     * @param query zapytanie sql
     */
    public static void executeQuere(String query){
        try {
            Connection connection=DBConnector.connect();
            Statement statement =connection.createStatement();
            statement.execute(query);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * wywołanie zapytań sql z wynikami w jednej tranzakcji
     * @param queres lista zapytań sql
     * @return wyników zapytań sql
     * @throws SQLException
     */
    public static List<List<List<String>>> executeQueresInTransaction(List<String> queres) throws SQLException{
        List<List<List<String>>> listOfQueresRecords=new ArrayList<>();
        Connection connection=DBConnector.connect();
        connection.setAutoCommit(false);   //pocztek tranzakcji
        Statement statement=connection.createStatement();
        for (String quere : queres) {
            List<List<String>> records = new ArrayList<>();//lista z rekordami z
            ResultSet resultSet = statement.executeQuery(quere);//wyniki z zapytania
            ResultSetMetaData metaData = resultSet.getMetaData();//obiekt przechowywujacy opis wynikow
            int columns = metaData.getColumnCount();//pobieramy ilosc kolumn z wyniku
            while (resultSet.next()) {
                List<String> record= new ArrayList<String>();//lista reprezentujaca rekord
                for (int i = 1; i <= columns ; i++) {//interacja od 1 do ostatniego elementu//w bazach zaczynamy od 1
                    record.add(resultSet.getString(i));//od 1 do max kolumn
                }
                records.add(record);
            }
            listOfQueresRecords.add(records);
        }
        connection.commit();//koniec tranzakcji
        connection.close();
        return listOfQueresRecords;
    }

    /**
     * wywołanie zapytań sql z wynikami w jednej tranzakcji
     * @param queres lista zapytań sql
     * @return wyników zapytań sql
     * @throws SQLException
     */
    public static List<List<List<String>>> executeQueres(List<String> queres) throws SQLException{
        List<List<List<String>>> listOfQueres=new ArrayList<>();
        Connection connection=DBConnector.connect();
        Statement statement=connection.createStatement();
        for (String quere : queres) {
            List<List<String>> listOfQuere = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(quere);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            while (resultSet.next()) {
                List<String> listOfRecords= new ArrayList<String>();
                for (int i = 1; i <= columns ; i++) {
                    listOfRecords.add(resultSet.getString(i));
                }
                listOfQuere.add(listOfRecords);
            }
            listOfQueres.add(listOfQuere);
        }
        return listOfQueres;
    }
}
