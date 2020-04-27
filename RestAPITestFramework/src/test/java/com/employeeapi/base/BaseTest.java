package com.employeeapi.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    public static RequestSpecification httpRequest;
    public static Response response;
    public String empID="97";
    public static ExtentReports xReport=null;
    public static ExtentTest xTest=null;
    public static String reportPath= "";
    public static int gTCCount = 0;
    public static int gTCPass = 0;
    public static int gTCFail = 0;
    public static int gStepFailureCount = 0;
    public final String REPORT_PATH="";

    public Logger logger;

    @BeforeSuite
    public void beforeSuite()
    {
        String FILE_PATH = System.getProperty("user.dir")+"\\reports";
        String FILE_EXTENSION = ".html";
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd_hhmmss"); // add S if you need milliseconds
        String filename = FILE_PATH + "\\Report_"+df.format(new Date()) + "." + FILE_EXTENSION;
        xReport = new ExtentReports(filename);

    }

    @BeforeClass
    public void setup(){

        logger= Logger.getLogger("EmployeeRestAPI");
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);
    }


}
