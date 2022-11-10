package browserstack;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	 
	
	class TestClass1 implements Runnable {
	public void run() {
	Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
	capsHashtable.put("browser", "chrome");
	capsHashtable.put("browser_version", "92.0");
	capsHashtable.put("os", "Windows");
	capsHashtable.put("os_version", "10");
	capsHashtable.put("Name", "Gudexams");
	capsHashtable.put("Build", "CrossBrowser");
	paralal_test r1 = new paralal_test();
	r1.executeTest(capsHashtable);
	    }
	}
	
	class TestClass2 implements Runnable {
	public void run() {
	Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
	capsHashtable.put("browser", "firefox");
	capsHashtable.put("browser_version", "latest");
	capsHashtable.put("os", "Windows");
	capsHashtable.put("os_version", "10");
	capsHashtable.put("Name", "Gudexams");
	capsHashtable.put("Build", "CrossBrowser");
	paralal_test r2 = new paralal_test();
	    r2.executeTest(capsHashtable);
	  }
	}
	
	
	
	class TestClass3 implements Runnable {
	public void run() {
	Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
	capsHashtable.put("browser", "safari");
	capsHashtable.put("browser_version", "latest");
	capsHashtable.put("os", "OS X");
	capsHashtable.put("os_version", "Big Sur");
	capsHashtable.put("Name", "Gudexams");
	capsHashtable.put("Build", "CrossBrowser");
	paralal_test r3 = new paralal_test();
	    r3.executeTest(capsHashtable);
	  }
	}
	
	
	class TestClass4 implements Runnable {
		public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "10");
		capsHashtable.put("browser_version", "90.0");
		capsHashtable.put("browser", "Chrome");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("Name", "Gudexams");
		capsHashtable.put("Build", "CrossBrowser");
		paralal_test r4 = new paralal_test();
		    r4.executeTest(capsHashtable);
		  }
		}
	
	class TestClass5 implements Runnable {
		public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "Android");
		capsHashtable.put("device", "Xiaomi Redmi Note 7");
		capsHashtable.put("realMobile", "true");
		capsHashtable.put("os_version", "9 .0");
		capsHashtable.put("Name", "Gudexams");
		capsHashtable.put("Build", "CrossBrowser");
		paralal_test r5 = new paralal_test();
		    r5.executeTest(capsHashtable);
		  }
		}
	
	class TestClass6 implements Runnable {
		public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "chrome");
		capsHashtable.put("browser_version", "85");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
		capsHashtable.put("Name", "Gudexams");
		capsHashtable.put("Build", "CrossBrowser");
		paralal_test r6 = new paralal_test();
		r6.executeTest(capsHashtable);
		    }
		}
	
	
	
	
	
	      public class paralal_test {
		  public static final String AUTOMATE_USERNAME = "digvijaytikka1";
		  public static final String AUTOMATE_ACCESS_KEY = "jABRev44RzfGZxWkFwTt";
		  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
		  
		  
		  
	public static void main(String[] args) throws Exception {
	Thread object1 = new Thread(new TestClass1());
	object1.start();
	
	Thread object2 = new Thread(new TestClass2());
	object2.start();
	
	Thread object3 = new Thread(new TestClass3());
	object3.start();
	
	Thread object4 = new Thread(new TestClass4());
	object4.start();
	
	Thread object5 = new Thread(new TestClass5());
	object5.start();
	
	Thread object6 = new Thread(new TestClass6());
	object6.start();
	
	
	  }
	public void executeTest(Hashtable<String, String> capsHashtable) {
	String key;
	DesiredCapabilities caps = new DesiredCapabilities();
	// Iterate over the hashtable and set the capabilities
	Set<String> keys = capsHashtable.keySet();
	Iterator<String> itr = keys.iterator();
	while (itr.hasNext()) {
	        key = itr.next();
	        caps.setCapability(key, capsHashtable.get(key));
	    }
	    WebDriver driver;
	try {
	driver = new RemoteWebDriver(new URL(URL), caps);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	driver.get("https://sgu.gudexams.com");
	
	
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	//WebDriverWait wait = new WebDriverWait(driver, 20);
	    try {
	   driver.findElement(By.partialLinkText("Exam Instructions")).isDisplayed();
	jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
	System.out.println("Passed");
	    }
	    catch(Exception e) {
	    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
	    System.out.println("Failed");
	    }
	   // System.out.println(driver.getTitle());
	    driver.quit();
	} catch (MalformedURLException e) {
	e.printStackTrace();
	}
	}
	}