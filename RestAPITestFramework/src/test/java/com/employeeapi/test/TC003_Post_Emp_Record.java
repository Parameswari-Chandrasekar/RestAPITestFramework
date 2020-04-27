package com.employeeapi.test;

import com.employeeapi.base.BaseTest;
import com.employeeapi.utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.response.Response;

public class TC003_Post_Emp_Record extends BaseTest {

    //RequestSpecification httpRequest;
    //Response response;

    String empName = RestUtils.empName();
    String empSal = RestUtils.empSal();
    String empAge = RestUtils.empAge();

    @BeforeClass
    void createEmployees() throws InterruptedException{

        logger.info("*****Started TC003_Post_One_Employee*****");

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

        response = httpRequest.request(Method.POST,"/create");

        Thread.sleep(5000);
    }

    @Test
    void checkResponseBody(){

        logger.info("--- Checking Response Body ---");

        String responsebody = response.getBody().asString();
        logger.info("Response Body is ==> " +responsebody);
        Assert.assertEquals(responsebody.contains(empName),true);
    }

    @Test
    void checkStatusCode(){

        logger.info("--- Checking Status Code ---");

        int statuscode = response.getStatusCode();
        logger.info("Status code is ==> " +statuscode);
        Assert.assertEquals(statuscode,200);
    }


}
