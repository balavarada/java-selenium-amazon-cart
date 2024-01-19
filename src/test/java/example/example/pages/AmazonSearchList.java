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
 	@FindBy(css="[data-index='3'] a.a-text-normal")
	// a-price-whole
	private WebElement firstProd;
 	
 	/** Second Product. */
 	@FindBy(css="[data-index='4'] a.a-text-normal")
	// a-price-whole
	private WebElement secondProd;
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
	public void gotoProductPage(String pos) { 
		if(pos == "1") {
			driver.navigate().to(firstProd.getAttribute("href"));
		} else {
			driver.navigate().to(secondProd.getAttribute("href"));
		}
	}
	
 
		
}
