package Base;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;

	@SuppressWarnings("resource")
	public void driverSetup() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your preference(Chrome/Edge/Firefox) :");
		String string = scanner.next();

		if (string.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (string.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (string.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please write correctly !");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

	}

	public void closeBrowser() {
		driver.quit();
	}

}
