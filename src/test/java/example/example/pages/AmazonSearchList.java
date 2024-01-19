package example.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * The Class represents Amazon.
 *
 * @author BalaVarada
 */
public class AmazonSearchList extends BasePage {
	
 	/** First Product. */
	//@FindBy(css = ".a-link-normal.s-underline-text.s-underline-link-text")
	@FindBy(css="[data-index='3'] a.a-text-normal")
	// a-price-whole
	private WebElement firstProd;
	/**
	 * Instantiates a new google page.
	 *
	 * @param driver the driver
	 */
	public AmazonSearchList(WebDriver driver) {
		super(driver);
	}

	/**
	 * Searches the given text.
	 *
	 * @param key the key
	 */
	public void gotoProductPage() {
//		firstProd.wait(E);
//		WebElement element = driver.findElement(By.xpath("//div[@class='footer']"));
//		System.out.println("prod url  === " + firstProd.getAttribute("href"));

		driver.navigate().to(firstProd.getAttribute("href"));
	}
	
 
		
}
