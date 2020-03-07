package patterns.structural.facade;

import org.apache.log4j.Logger;

import java.sql.Connection;

public class MySQLReportGenerator {
    private static final Logger LOGGER = Logger.getLogger("MySQLReportGenerator");
    public static Connection getMySQLDBConnection(){
        LOGGER.info("Connection");
        return null;
    }
    public void generateMySQLReportPDF(String table, Connection connection){
        LOGGER.info("printing from "+table+" to pdf");
    }
    public void generateMySQLReportHTML(String table, Connection connection){
        LOGGER.info("printing from "+table+" to html");
    }
}
