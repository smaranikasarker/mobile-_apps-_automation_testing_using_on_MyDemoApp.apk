package appsautumationtesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.android.AndroidDriver;

public class MyDemoAppTest {
	
	public AndroidDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setDevice() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:deviceName", "Pixel");
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
		desiredCapabilities.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
		desiredCapabilities.setCapability("appium:udid", "emulator-5554");
		URL remoteUrl = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void test_app_one() throws InterruptedException {
		 // Open the shopping apps
		System.out.println("Enter the shopping apps");
		WebElement check = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Products\"]"));
		String title = check.getText();
		System.out.println("This Page title is" + title);
		Assertion hardAssertion = new Assertion();
		hardAssertion.assertEquals(title, "Products");
		System.out.println("This Page title is verfied by hard assertion");
		
		// Click on a product
		driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView")).click();
		System.out.println("Select first product");
		
		 // Increase product quantity
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView")).click();
		System.out.println("Increase product quantity");
		
		// Add product to cart
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add To Cart\"]")).click();
		System.out.println("Add to card one product");
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();
		System.out.println("click to card and stay my card");
		
		WebElement check1 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"My Cart\"]"));
		String checkone = check1.getText();
		System.out.println("This Page title is" + checkone);
		Assertion hardAssertion1 = new Assertion();
		hardAssertion1.assertEquals(checkone, "My Cart");
		System.out.println("This Page title is verfied by hard assertion");
		
		 // Go to Products page using hamburger menu
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")).click();
        driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
        System.out.println("Go to product page using hamburger menu");
        
        // Click on Product
        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[5]/android.view.ViewGroup/android.widget.ImageView")).click();
		System.out.println("Select Second product");
		
		//Add to cart Another Product
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add To Cart\"]")).click();
		System.out.println("Add to card Second product");
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();
		System.out.println("click to card and stay my card");
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]")).click();
		Assertion hardAssertion111 = new Assertion();
		hardAssertion111.assertEquals(checkone, "My Cart");
		System.out.println("This Page title is verfied by hard assertion");
				
		// Process to Login
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")).sendKeys("bob@example.com");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]")).sendKeys("10203040");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]")).click();
		System.out.println("Login Completed");
	
		WebElement check11 = driver.findElement(By.xpath("(//android.widget.TextView[@text=\"Login\"])[1]"));
		String title1 = check11.getText();
		Assertion hardAssertion11 = new Assertion();
		hardAssertion11.assertEquals(title1, "Login");
		System.out.println("This Page title is verfied by hard assertion");
		
		// Proceed to checkout
		WebElement check2 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Checkout\"]"));
		String tittle = check2.getText();
		Assertion hardAssertion2 = new Assertion();
		hardAssertion2.assertEquals(tittle, "Checkout");
		System.out.println("This Page title is verfied by hard assertion");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]")).sendKeys("Smaranika");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]")).sendKeys("Dhaka");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 2 input field\"]")).sendKeys("Mirpur");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]")).sendKeys("abc");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"State/Region input field\"]")).sendKeys("Rupnagar-R/A");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")).sendKeys("1216");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]")).sendKeys("Bangladesh");
	
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"To Payment\"]")).click();
		System.out.println("To payment Process");
		
		Thread.sleep(9000);
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]")).sendKeys("Smaranika");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Card Number* input field\"]")).sendKeys("1234 5678 9101 112");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]")).sendKeys("11/25");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Security Code* input field\"]")).sendKeys("123");

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Review Order\"]")).click();
		System.out.println("To Process Review Order");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Place Order\"]")).click();
		System.out.println("Continue with filling checkout information, placing order and verifying order confirmation as in the previous response");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Continue Shopping\"]")).click();
		System.out.println("To Process Continue Shopping");

		Thread.sleep(9000);
}
	@AfterTest
	public void closeApp() {
		driver.quit();
	}
}

