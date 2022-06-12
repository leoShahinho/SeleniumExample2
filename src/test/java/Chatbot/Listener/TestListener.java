package Chatbot.Listener;

import Chatbot.ExtentReport.ExtentManager;
import Chatbot.ExtentReport.ExtentTestManager;
import Chatbot.logs.Log;
import SetupsAndPages.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener{
	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onStart(ITestContext iTestContext) {
		/*
		 * Log.info("I am in onStart method " + iTestContext.getName());
		 * iTestContext.setAttribute("WebDriver", this.driver);
		 */
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
       // Log.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        ExtentManager.extentReports.flush();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is starting.");
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is succeed.");
        //ExtentReports log operation for passed tests.
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is failed.");
        //Get driver from BaseTest and assign to local webdriver variable.
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed : "+ iTestResult.getThrowable());
		/*
		 * Object testClass = iTestResult.getInstance(); WebDriver driver = ((BaseTest)
		 * testClass).getDriver(); //Take base64Screenshot screenshot for extent reports
		 * String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)
		 * Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
		 * //ExtentReports log and screenshot operations for failed tests.
		 * getTest().log(Status.FAIL, "Test Failed",
		 * getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().
		 * getMedia().get(0));
		 */
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped : "+ iTestResult.getThrowable());
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
