package patterns.structural.facade;

import org.apache.log4j.Logger;

import java.sql.Connection;

public class Test {
    private static final Logger LOGGER = Logger.getLogger("Facade");
    public static void main(String[] args) {
        String table = "Employee";

        Connection connectionMySQL= MySQLReportGenerator.getMySQLDBConnection();
        MySQLReportGenerator sqlReportGenerator= new MySQLReportGenerator();
        sqlReportGenerator.generateMySQLReportHTML(table,connectionMySQL);

        Connection connectionOracle= OracleReportGenerator.getOracleDBConnection();
        OracleReportGenerator oracleReportGenerator= new OracleReportGenerator();
        oracleReportGenerator.generateOracleReportHTML(table,connectionOracle);

        LOGGER.info("---====on=fasade===---");
        ReportGenerationFacade.generateReport(
                ReportGenerationFacade.DBType.MySQL,
                ReportGenerationFacade.ReportType.PDF,
                table);

        ReportGenerationFacade.generateReport(
                ReportGenerationFacade.DBType.Oracle,
                ReportGenerationFacade.ReportType.PDF,
                table);

    }
}
