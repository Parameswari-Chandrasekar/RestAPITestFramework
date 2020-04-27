package com.employeeapi.test;


import com.employeeapi.base.BaseTest;
import com.employeeapi.utilities.DGListener;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(DGListener.class)
public class TC001_GetRequest extends BaseTest {

    @BeforeClass
    void getAllEmployees() throws InterruptedException{

        logger.info("*****Started TC001_Get_All_Employees*****");

        RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET,"/employees");

        Thread.sleep(3000);

    }

    @Test
    void checkResponseBody(){

        logger.info("--- Checking Response Body ---");

        xTest = xReport.startTest("TC1_chkResponseBody");
        xTest.setDescription("TC1_chkResponseBody");
        //ln.test = ln.extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName().toString());

        String responsebody = response.getBody().asString();
        logger.info("Response Body is ==> " +responsebody);
        Assert.assertTrue(responsebody != null);
        xTest.log(LogStatus.PASS,"Response Body is not null");
        //ln.test.log(Status.PASS, "Test check response body has passed");
    }

    @Test
    void checkResponseTime(){

        logger.info("--- Checking Response Time ---");
        //test=extent.createTest("TC001_checkResponseTime");

        long responseTime = response.getTime();
        logger.info("Response Time is ==> "+responseTime);
        Assert.assertTrue(responseTime<6000);

        if (responseTime>2000)
                logger.warn("Response time is > 2000");
    }

    @Test
    void checkStatusLine(){
        logger.info("--- Checking Status Line ---");
        //test=extent.createTest("TC001_checkStatusLine");

        String statusline = response.getStatusLine();
        logger.info("Status Line is ==> "+statusline);
        Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
    }

    @Test
    void checkContentLength(){

        logger.info("--- Checking Content Length ---");
        //test=extent.createTest("TC001_checkContentLength");

        String contentlen = response.header("Content-Length");
        logger.info("Content Length is ==> "+contentlen);

        if (Integer.parseInt(contentlen)<100)
            logger.warn("Content Length is < 100");

        Assert.assertTrue(Integer.parseInt(contentlen)>100);
    }

    @AfterMethod
    public void afterMethod()
    {

        xReport.endTest(xTest);
        System.out.println("****TestCase : "+gTCCount+"****Total Steps Failed : "+gStepFailureCount+" ****");
        BaseTest.gStepFailureCount=0;
    }

    @AfterSuite
    public void afterSuite()
    {
        xReport.flush();

        System.out.println("************************************Test Completed**************************************");
        System.out.println("****Total TestCase : "+gTCCount+"****Total Passed TestCase : "+gTCPass+"****Total Failed TestCase : "+gTCFail+"****");
        System.out.println("****Report Path : "+reportPath+" ******");
        System.out.println("************************************Test Completed**************************************");
    }

}
