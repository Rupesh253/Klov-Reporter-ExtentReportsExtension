package package2;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Class1 extends CommonClass {

	
	@Test(groups = { "Group1_in_package2","Y" },description = "Rupesh",priority=1)
	public void method1_in_Class1_in_package2(Method method) throws IOException {
		System.out.println("\t \t \t \t method1_in_Class1_in_package2()");
		childThread.get().assignAuthor(method.getAnnotation(Test.class).description());
		childThread.get().assignCategory(method.getAnnotation(Test.class).groups());
		childThread.get().pass("Step 1 in "+method.getName() +" executed successfully!",MediaEntityBuilder.createScreenCaptureFromPath(someScreenshotPath, "Sample Screenshot attached.").build());
		childThread.get().pass("Step 2 in "+method.getName() +" executed successfully!",MediaEntityBuilder.createScreenCaptureFromPath(someScreenshotPath, "Sample Screenshot attached.").build());
		childThread.get().pass("Step 3 in "+method.getName() +" executed successfully!",MediaEntityBuilder.createScreenCaptureFromPath(someScreenshotPath, "Sample Screenshot attached.").build());
	throw new ArithmeticException();
	}

	@Test(groups = { "Group2_in_package2", "Y" }, description = "Rupesh", priority = 2)
	public void method2_in_Class1_in_package2(Method method) throws IOException {
		System.out.println("\t \t \t \t method2_in_Class1_in_package2()");
		childThread.get().assignAuthor(method.getAnnotation(Test.class).description());
		childThread.get().assignCategory(method.getAnnotation(Test.class).groups());
		childThread.get().pass("Step 1 in " + method.getName() + " executed successfully!", MediaEntityBuilder
				.createScreenCaptureFromPath(someScreenshotPath, "Sample Screenshot attached.").build());
		childThread.get().pass("Step 2 in " + method.getName() + " executed successfully!", MediaEntityBuilder
				.createScreenCaptureFromPath(someScreenshotPath, "Sample Screenshot attached.").build());
		childThread.get().pass("Step 3 in " + method.getName() + " executed successfully!", MediaEntityBuilder
				.createScreenCaptureFromPath(someScreenshotPath, "Sample Screenshot attached.").build());
	}

	@Test(groups = { "Group3_in_package2", "Y" }, description = "Kiran", priority = 3)
	public void method3_in_Class1_in_package2(Method method) throws IOException {
		System.out.println("\t \t \t \t method3_in_Class1_in_package2()");
		childThread.get().assignAuthor(method.getAnnotation(Test.class).description());
		childThread.get().assignCategory(method.getAnnotation(Test.class).groups());
		childThread.get().pass("Step 1 in " + method.getName() + " executed successfully!", MediaEntityBuilder
				.createScreenCaptureFromPath(someScreenshotPath, "Sample Screenshot attached.").build());
		childThread.get().pass("Step 2 in " + method.getName() + " executed successfully!", MediaEntityBuilder
				.createScreenCaptureFromPath(someScreenshotPath, "Sample Screenshot attached.").build());
		childThread.get().pass("Step 3 in " + method.getName() + " executed successfully!", MediaEntityBuilder
				.createScreenCaptureFromPath(someScreenshotPath, "Sample Screenshot attached.").build());
	}

}
