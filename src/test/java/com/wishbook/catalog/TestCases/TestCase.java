package com.wishbook.catalog.TestCases;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;

/**
 * Created by wishbook on 14/3/18.
 */

public abstract class TestCase{

    protected final BaseTest test;
    protected final TestCaseOptions testCaseOptions;
    public BaseTest getTest(){
        return test;
    }
    public TestCaseOptions getTestCaseOptions(){
        return testCaseOptions;
    }
    public TestCase(BaseTest test,TestCaseOptions testCaseOptions){
        this.test=test;
        this.testCaseOptions=testCaseOptions;
        System.out.println("Running test case : "+getClass().getCanonicalName());
    }

    public final void execute() throws Exception{
        Exception exception = null;
        String testCaseName = getClass().getSimpleName();
        System.out.println("Executing test case : " + testCaseName);
        long start = System.currentTimeMillis();
        boolean ok = false;
        try {
            LoginHelper.login(this);
            run();
            ok = true;
        }catch (Exception e){
            exception=e;
            e.printStackTrace();
        }
        long elapsedTimeMills = System.currentTimeMillis()-start;
        System.out.println("Test case " + testCaseName+ (ok?"PASSED":"FAILED"));
        System.out.println("Time taken : " + Float.toString(elapsedTimeMills/(60*1000F))+ " mins");
        if(exception!=null) {
            throw exception;
        }
    }
    protected abstract void run() throws Exception;
}
