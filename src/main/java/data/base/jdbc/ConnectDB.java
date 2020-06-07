package data.base.jdbc;

import java.sql.*;

public class ConnectDB {
    private static String URL_1 ="jdbc:mysql://localhost:3306/mydb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static String URL_2 ="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
    private static String URL_3 ="jdbc:mysql://localhost:3306/mydb?allowMultiQueries=true";
    private static String USER = "root";
    private static String PASSWORD = "admin";
    private Connection connection = null;

    public void startConnection() {
        try {
            this.connection = DriverManager.getConnection(URL_3,USER,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




    public void printPeopleAboveAgeWithGender(int age, String gender) {
        System.out.println("Print gender " + gender + " above " + age);
        String query = "select * from people where age>=? and gender=?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,age);
            preparedStatement.setString(2,gender);
            printResult(preparedStatement);
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void printPeopleWithId(int id) {
        System.out.println("Print id " + id );
        String query = "select * from people where id=?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,id);
            printResult(preparedStatement);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void changeSurname(String surnameOld , String surnameNew) {
        System.out.println("Change surname " + surnameOld + " to " + surnameNew );
        String query = "update people set last_name=? where last_name=?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,surnameNew);
            preparedStatement.setString(2,surnameOld);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void changeSurnameOnId(int id , String surnameNew) {
        System.out.println("Change surname in id " + id + " to " + surnameNew );
        String query = "update people set last_name=? where id=?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, surnameNew);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void printAll() {
        System.out.println("Print all" );
        String query = "select * from people order by id";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            printResult(preparedStatement);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void printAllWithPhone() {
        System.out.println("Print all With Phone" );
        String query = "select * from people join phones on people.id=phones.person_id order by people.id, phones.id;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            printResult(preparedStatement);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void printResult(PreparedStatement preparedStatement) throws SQLException {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            int numberColumns = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= numberColumns; i++) {
                System.out.print( String.format("%-" + 20 + "s", "|-="+resultSet.getMetaData().getColumnLabel(i)+"=-"));
            }
            System.out.println("|");
            while (resultSet.next()) {
                for (int i = 1; i <= numberColumns; i++) {
                    System.out.print( String.format("%-" + 20 + "s", "|"+"'" + resultSet.getObject(i) + "'"));
                }
                System.out.println("|");
            }
            System.out.println("");
        }
    }

    public void setAgePeopleWithPhoneNumber(String phoneNumber, int age) {
        System.out.println("Change age in phone number " + phoneNumber + " to " + age );
        String queryCreateTempTab = "CREATE TEMPORARY table temp (select people.id from people join phones on people.id=phones.person_id where number=?);";
        String queryUpdate =  "UPDATE people SET age=? WHERE id IN (SELECT * FROM temp);";
        String queryDropTempTab = "DROP TABLE temp;";
        try {
            connection.setAutoCommit(false);
            // create temp table with id
            PreparedStatement ps = connection.prepareStatement(queryCreateTempTab);
            ps.setString(1, phoneNumber);
            ps.execute();
            // update base on id in temp table
            ps = connection.prepareStatement(queryUpdate);
            ps.setInt(1, age);
            ps.execute();
            // drop temp table
            ps.executeUpdate(queryDropTempTab);
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void deletePersonById(int id) {
        System.out.println("Delete person on id " + id);
        String queryCreateTempTab = "CREATE TEMPORARY table temp (select phones.id from people join phones on people.id=phones.person_id where people.id=?);";
        String queryDeletePhones =  "DELETE FROM phones WHERE id IN (SELECT * FROM temp);";
        String queryDeletePeople =  "DELETE FROM people WHERE id=? ;";
        String queryDropTempTab = "DROP TABLE temp;";
        try {
            connection.setAutoCommit(false);
            // create temp table with id
            PreparedStatement ps = connection.prepareStatement(queryCreateTempTab);
            ps.setInt(1, id);
            ps.execute();
            // delete base on id in temp table phones
            ps.executeUpdate(queryDeletePhones);
            // delete people
            ps = connection.prepareStatement(queryDeletePeople);
            ps.setInt(1,id);
            ps.execute();
            // drop temp table
            ps.executeUpdate(queryDropTempTab);
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
