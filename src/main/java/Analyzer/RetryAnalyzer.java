package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	
	int counter =0;
	int retryLimit = 3; // Set the limit for failed test cases that how many time it executes after failed 1st time
	public boolean retry(ITestResult result)
	{
		if(counter <retryLimit )
		{
			counter ++;
			return true;
		}
		return false;
	}
	

}
