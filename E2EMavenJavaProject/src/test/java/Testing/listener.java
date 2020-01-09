package Testing;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Resources.Baseclass;

public class listener implements ITestListener {
Baseclass b = new Baseclass();
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println(" Test Successful");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Failed at "+result.getName());
			b.getscreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
	}


}
