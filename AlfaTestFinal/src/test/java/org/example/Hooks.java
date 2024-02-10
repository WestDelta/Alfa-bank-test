package org.example;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Hooks
{
	 private static int resultPassed = 0;
	 private static int resultFailed = 0;
	 
	 @After
	 public void getScenarioInfo(Scenario scenario)
	 {
			if (scenario.getStatus() == Status.PASSED)
			{
				 resultPassed++;
			}
			else if (scenario.getStatus() == Status.FAILED)
			{
				 resultFailed++;
			}

//      Варианты отчетности
//			System.out.println(scenario.getId());
//			System.out.println(scenario.getName());
//			System.out.println(scenario.getStatus());
//			System.out.println(scenario.isFailed());
//			System.out.println(scenario.getSourceTagNames());
	 }
	 
	 public static int getResultPassed()
	 {
			return resultPassed;
	 }
	 
	 public static int getResultFailed()
	 {
			return resultFailed;
	 }
}