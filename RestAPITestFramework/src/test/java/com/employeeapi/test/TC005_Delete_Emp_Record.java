package com.employeeapi.test;

import com.employeeapi.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC005_Delete_Emp_Record extends BaseTest {

    @BeforeClass
    void getAllEmployees() throws InterruptedException{

        logger.info("*****Started TC005_Delete_One_Employee *****");

        RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET,"/employees");

        //get the first record for deletion using JSONPath
        JsonPath jsonPathEvaluator = response.jsonPath();

        String empID = jsonPathEvaluator.get("data[0].id");
        response = httpRequest.request(Method.DELETE,"/delete/"+empID);

        Thread.sleep(3000);
    }

    @Test
    void checkResponseBody(){

        logger.info("--- Checking Response Body ---");

        String responsebody = response.getBody().asString();
        logger.info("Response Body is ==> " +responsebody);
        Assert.assertEquals(responsebody.contains("successfully! deleted Records"),true);
    }

}
