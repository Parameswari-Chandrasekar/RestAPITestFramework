package com.employeeapi.utilities;

import com.employeeapi.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DGListener extends BaseTest implements ITestListener {


    public void onTestStart(ITestResult iTestResult) {
        BaseTest.gTCCount=BaseTest.gTCCount+1;
    }

    public void onTestSuccess(ITestResult iTestResult) {

        if(BaseTest.gStepFailureCount!=0)
        {
            iTestResult.setStatus(ITestResult.FAILURE);
            onTestFailure(iTestResult);
        }
        else
        {
            BaseTest.gTCPass=BaseTest.gTCPass+1;
        }


    }

    public void onTestFailure(ITestResult iTestResult) {
        BaseTest.gTCFail=BaseTest.gTCFail+1;
        //DGAssertion.assertFalse(true, iTestResult.getMethod().getMethodName()+"  "+iTestResult.getThrowable().getMessage());
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
