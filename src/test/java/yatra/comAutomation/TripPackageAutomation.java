package yatra.comAutomation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.google.common.io.Files;
import Base.Base;

public class TripPackageAutomation extends Base {
	public void openUrl() {
		driver.get("https://www.yatra.com/");
	}

	public void offers() {
		driver.findElement(By.xpath("//a[@title='Offers']")).click();
	}

	public void verifyTitle() {
		String expTitle = "Domestic Flights Offers | Deals on Domestic Flight Booking | Yatra.com";
		String actTitle = driver.getTitle();

		if (expTitle.equals(actTitle)) {
			System.out.println("Title is correct.");
		} else {
			System.out.println("Title is wrong");
		}
	}

	public void verifyBanner() {
		String expBanner = driver.findElement(By.xpath("//h2[normalize-space()='Great Offers & Amazing Deals']"))
				.getText();
		String actBanner = "Great Offers & Amazing Deals";

		if (expBanner.equals(actBanner)) {
			System.out.println("Banner contains \"Great Offers & Amazing Deals\". ");
		} else {
			System.out.println("Banner doesn't contain \"Great Offers & Amazing Deals\". ");
		}
	}

	public void screenshot() {
		File ssFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(ssFile, new File(System.getProperty("user.dir") + "/Screenshot/Trip.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Screenshot successfully taken.");
	}

	public void holidays() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='https://www.yatra.com/offer/dom/listing/holiday-deals']")).click();
		Thread.sleep(2000);
	}

	public void printPackages() throws InterruptedException {
		List<WebElement> listElement = driver.findElements(By.xpath("//span[@class='minHTitle inlineBlock']"));
		for (int i = 0; i < listElement.size(); i++) {
			String elementText = listElement.get(i).getText();
			System.out.println(elementText);
		}
		Thread.sleep(3000);
	}

	public void homePage() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='https://www.yatra.com']//i[@class='ico-newHeaderLogo']")).click();
		Thread.sleep(2000);
	}

	public void bookTickets() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='Round Trip']")).click();
		WebElement element = driver.findElement(By.id("BE_flight_origin_city"));
		element.click();
		Thread.sleep(2000);
		element.sendKeys("Bhubaneswar");
		Thread.sleep(1000);
		element.sendKeys(Keys.ENTER);
		WebElement element2 = driver.findElement(By.id("BE_flight_arrival_city"));
		Thread.sleep(2000);
		element2.sendKeys("Kolkata");
		Thread.sleep(1000);
		element2.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BE_flight_origin_date")).click();
		driver.findElement(By.xpath("(//td[@id='22/09/2023'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@id='28/09/2023'])")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BE_flight_paxInfoBox")).click();
		for (int i = 1; i <= 3; i++) {
			driver.findElement(By.xpath("//div[@class='iePasenger dflex']/div[1]/div//span[2]")).click();
		}
		for (int j = 1; j <= 3; j++) {
			driver.findElement(By.xpath("//div[@class='iePasenger dflex']/div[2]/div//span[2]")).click();
		}
		for (int k = 1; k <= 3; k++) {
			driver.findElement(By.xpath("//div[@class='iePasenger dflex']/div[3]/div//span[2]")).click();
		}
		driver.findElement(By.xpath("//span[normalize-space()='Premium Economy']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Non Stop Flights']")).click();
		driver.findElement(By.id("BE_flight_flsearch_btn")).click();
	}

	public void confirmTicket() {
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'hide-ycp')]")).getText());
	}

	public static void main(String[] args) throws InterruptedException {
		TripPackageAutomation yatra = new TripPackageAutomation();
		yatra.driverSetup();
		yatra.openUrl();
		yatra.offers();
		yatra.verifyTitle();
		yatra.verifyBanner();
		yatra.screenshot();
		yatra.holidays();
		yatra.printPackages();
		yatra.homePage();
		yatra.bookTickets();
		yatra.confirmTicket();
		yatra.closeBrowser();
	}
}