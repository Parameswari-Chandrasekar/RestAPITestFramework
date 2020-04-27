package com.employeeapi.test;

import com.employeeapi.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002_Get_OneEmp_Record extends BaseTest{

    @BeforeClass
    void getAllEmployees() throws InterruptedException{

        logger.info("*****Started TC002_Get_One_Employee*****");

        RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET,"/employees/"+empID);

        Thread.sleep(3000);
    }

    @Test
    void checkResponseBody(){

        logger.info("--- Checking Response Body ---");

        String responsebody = response.getBody().asString();
        logger.info("Response Body is ==> " +responsebody);
        Assert.assertEquals(responsebody.contains(empID),true);
    }

    @Test
    void checkStatusCode(){

        logger.info("--- Checking Status Code ---");

        int statuscode = response.getStatusCode();
        logger.info("Status code is ==> " +statuscode);
        Assert.assertEquals(statuscode,200);
    }


}
