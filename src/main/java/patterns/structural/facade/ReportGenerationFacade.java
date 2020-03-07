package patterns.structural.facade;

import java.sql.Connection;

public class ReportGenerationFacade {
    public enum DBType{
        MySQL,Oracle;
    }
    public enum ReportType{
        PDF,HTML;
    }

    public static void generateReport(DBType dbType,ReportType reportType, String table){
        Connection connection = null;
        switch (dbType){
            case MySQL:
                connection = MySQLReportGenerator.getMySQLDBConnection();
                MySQLReportGenerator mySQLReportGenerator = new MySQLReportGenerator();
                switch (reportType){
                    case PDF:
                        mySQLReportGenerator.generateMySQLReportPDF(table,connection);
                        break;
                    case HTML:
                        mySQLReportGenerator.generateMySQLReportHTML(table,connection);
                        break;
                }
                break;
            case Oracle:
                connection = OracleReportGenerator.getOracleDBConnection();
                OracleReportGenerator oracleReportGenerator = new OracleReportGenerator();
                switch (reportType){
                    case PDF:
                        oracleReportGenerator.generateOracleReportPDF(table,connection);
                        break;
                    case HTML:
                        oracleReportGenerator.generateOracleReportHTML(table,connection);
                        break;
                }
                break;
        }

    }
}
