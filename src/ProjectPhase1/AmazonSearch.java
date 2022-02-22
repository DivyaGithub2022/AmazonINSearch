package ProjectPhase1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iPhone12");
		WebElement Gobutton = driver.findElement(By.xpath("//span[@aria-label='Go']"));
		Gobutton.click();
		List<WebElement> PhonePrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<WebElement> PhoneName = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
		System.out.println("Search Results " + PhoneName.size());
			
		for(int count=0;count<PhoneName.size();count++) {
			if(PhoneName.get(count).getText().toLowerCase().contains("iphone")) {
				int srNo = count + 1;
				System.out.println(srNo + ". Price for " + PhoneName.get(count).getText() + " is Rs." + PhonePrice.get(count).getText());
			}
		}
		driver.close();
	}
}
