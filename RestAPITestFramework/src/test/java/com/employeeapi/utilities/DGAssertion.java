package com.employeeapi.utilities;

import com.employeeapi.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Listeners;

@Listeners(DGListener.class)
public class DGAssertion extends BaseTest {

        public static void assertTrue(boolean args , String reportDesc)
        {
            if(args)
            {
                xTest.log(LogStatus.PASS, reportDesc);
                printReport(reportDesc);
            }
            else
            {
                xTest.log(LogStatus.FAIL, reportDesc);
                printReport(reportDesc);
                BaseTest.gStepFailureCount++;
            }
        }

        public static void assertInfo(String reportDesc)
        {
                xTest.log(LogStatus.INFO, reportDesc);
                printReport(reportDesc);
        }
        public static void assertFalse(boolean args , String reportDesc)
        {
            if(!args)
            {
                xTest.log(LogStatus.PASS, reportDesc);
                printReport(reportDesc);
            }
            else
            {
                xTest.log(LogStatus.FAIL, reportDesc);
                printReport(reportDesc);
                BaseTest.gStepFailureCount++;
            }
        }

        public static void assertEquals(String actual,String expected , String reportDesc)
        {
            if(actual.equals(expected))
            {
                xTest.log(LogStatus.PASS, reportDesc);
                printReport(reportDesc);
            }
            else
            {
                xTest.log(LogStatus.FAIL, reportDesc);
                printReport(reportDesc);
            }
        }

        public static void assertNotEquals(String actual,String expected , String reportDesc)
        {
            if(!(actual.equals(expected)))
            {
                xTest.log(LogStatus.PASS, reportDesc);
                printReport(reportDesc);
            }
            else
            {
                xTest.log(LogStatus.FAIL, reportDesc);
                printReport(reportDesc);
            }
        }

        public static void printReport(String Step)
        {
            System.out.println(Step);
        }


    }
