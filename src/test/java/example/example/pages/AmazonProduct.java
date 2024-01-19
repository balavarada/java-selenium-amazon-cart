package example.example.pages;

import java.math.BigDecimal;

import org.openqa.selenium.By;
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
public class AmazonProduct extends BasePage {
	
	/** The get cost. */
	@FindBy(css = "#corePriceDisplay_desktop_feature_div .a-price-whole")
	private WebElement cost;
	
	/** add to cart button on product page. */
	@FindBy(id = "add-to-cart-button")
	// a-price-whole
	private WebElement addToCart;
	
	/** Global cart icon on header. */
	@FindBy(id = "nav-cart")
	// a-price-whole
	private WebElement cartGlobal;
	
	/**
	 * Instantiates a new google page.
	 *
	 * @param driver the driver
	 */
	public AmazonProduct(WebDriver driver) {
		super(driver);
	}
 	
	/**
	 * Get product Cost
	 */
	public String getProductCost() {
		return cost.getText();
	}
	
	/**
	 * Add the product to Cart
	 * @throws Exception 
	 */	
	public void AddToCart() throws Exception {
		Actions actions = new Actions(driver);
 		actions.moveToElement(addToCart).click().build().perform();
		WebElement aC = driver.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]"));
		aC.click();
		Thread.sleep(2000);

	}
	
	/**
	 * Go to Cart and evaluate both costs
	 * @throws Exception 
	 */	
	public String goToCart() throws Exception {
		Actions actions = new Actions(driver);
		actions.moveToElement(cartGlobal).click().build().perform();
		Thread.sleep(2000);
		WebElement aC = driver.findElement(By.cssSelector("#sc-subtotal-amount-buybox span"));
		WebElement cT = driver.findElement(By.cssSelector("#sc-subtotal-amount-buybox span .currencyINR"));

		String fulltext = aC.getText();
		String output = fulltext.replace(cT.getText(), "");
		return output;
 	}
	
	/**
	 * Go to Cart and evaluate both costs
	 * @throws Exception 
	 */	
	public Boolean isPcostequalCcost(int pC, int cC) throws Exception {
		if(pC == cC) {	
			System.out.println("TT pc  == " + pC + "cC == " + cC); 
			return true;
 
		} else {			
			System.out.println("FF pc  == " + pC + "cC == " + cC);	
			return false; 			
		}	
	}		
}
