package example.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Class represents Amazon.
 *
 * @author BalaVarada
 */
public class AmazonSearch extends BasePage {
	
	/** The searchinput. */
	@FindBy(name = "field-keywords")
	private WebElement searchinput;
	 
	/**
	 * Instantiates a new google page.
	 *
	 * @param driver the driver
	 */
	public AmazonSearch(WebDriver driver) {
		super(driver);
	}

	/**
	 * Searches the given text.
	 *
	 * @param key the key
	 */
	public void searchText(String key) {
		searchinput.sendKeys(key + Keys.ENTER);
	}
	 
}
