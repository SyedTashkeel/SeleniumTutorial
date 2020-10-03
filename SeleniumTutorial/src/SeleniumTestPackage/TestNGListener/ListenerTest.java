package SeleniumTestPackage.TestNGListener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;


public class ListenerTest implements ITestListener
{
	// Using ITestContext for onStart & onFinish Test
	@Override
	public void onFinish(ITestContext Result) {
		
	}
	@Override
	public void onStart(ITestContext Result) {
		
	}
	
	// Using ITestResult for test results
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
	}
	@Override
	public void onTestFailure(ITestResult Result) {
		
		System.out.println("The name is test case failed:"+Result.getName());
	}
	@Override
	public void onTestSkipped(ITestResult Result) {
		
		System.out.println("The name is test case skipped:"+Result.getName());
	}
	@Override
	public void onTestStart(ITestResult Result) {
		
		System.out.println(Result.getName()+" Test Started");
	}
	@Override
	public void onTestSuccess(ITestResult Result) {
		
		System.out.println(Result.getName()+" Test Was Successful! PASSED");
	}
}
