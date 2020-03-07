package patterns.structural.facade;

import org.apache.log4j.Logger;

import java.sql.Connection;

public class OracleReportGenerator {
    private static final Logger LOGGER = Logger.getLogger("OracleReportGenerator");
    public static Connection getOracleDBConnection(){
        LOGGER.info("Connection");
        return null;
    }
    public void generateOracleReportPDF(String table, Connection connection){
        LOGGER.info("printing from "+table+" to pdf");
    }
    public void generateOracleReportHTML(String table, Connection connection){
        LOGGER.info("printing from "+table+" to html");
    }
}
