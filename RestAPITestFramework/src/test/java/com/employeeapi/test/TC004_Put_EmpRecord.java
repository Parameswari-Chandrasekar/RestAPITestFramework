package com.employeeapi.test;

import com.employeeapi.base.BaseTest;
import com.employeeapi.utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.kohsuke.rngom.parse.host.Base;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC004_Put_EmpRecord extends BaseTest {

    String empName = RestUtils.empName();
    String empSal = RestUtils.empSal();
    String empAge = RestUtils.empAge();

    @BeforeClass
    void updateEmployees() throws InterruptedException{

        logger.info("*****Started TC004_Post_One_Employee*****");

        RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();

        //JSONObject is the class that represents a simple JSON.
        // We can add the Key-Value pairs using put method
        JSONObject reqParams = new JSONObject();
        reqParams.put("name",empName);
        reqParams.put("salary",empSal);
        reqParams.put("age",empAge);

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(reqParams.toJSONString());

        response = httpRequest.request(Method.PUT,"/update/"+empID);

        Thread.sleep(5000);
    }

    @Test
    void checkResponseBody(){

        logger.info("--- Checking Response Body ---");

        String responsebody = response.getBody().asString();
        logger.info("Response Body is ==> " +responsebody);
        Assert.assertEquals(responsebody.contains(empName),true);
        Assert.assertEquals(responsebody.contains(empAge),true);
        Assert.assertEquals(responsebody.contains(empSal),true);
    }

    @Test
    void checkStatusCode(){

        logger.info("--- Checking Status Code ---");

        int statuscode = response.getStatusCode();
        logger.info("Status code is ==> " +statuscode);
        Assert.assertEquals(statuscode,200);
    }

    @AfterClass
    public void teardown(){
        logger.info("*** TC004 completed ***");
    }

}
