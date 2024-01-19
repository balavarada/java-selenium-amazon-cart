package example.example.tests;

 import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import example.example.factory.PageinstancesFactory;
import example.example.pages.AmazonSearch;
import example.example.pages.AmazonSearchList;
import example.example.pages.AmazonProduct;
 
/**
 * The Class AmazonSubtotalTest.
 *
 * @author BalaVarada
 */
@Test(testName = "Amazon search", description = "Search an item in amazon")
public class AmazonSubtotalTest extends BaseTest {

	@Test
	public void AmazonSubtotalTest() throws Exception {
		String pCost;
		String cCost;
	 
		
		driver.get("https://www.amazon.in/ref=nav_logos");
		driver.manage().deleteAllCookies();
		//open amazon
		AmazonSearch amazonPage = PageinstancesFactory.getInstance(AmazonSearch.class);
		amazonPage.searchText("Monitor");
//		Assert.assertTrue(driver.getTitle().contains("Monitor"), "Title doesn't contain Monitor : Test Failed");

		//land on product page
	    AmazonSearchList amazonSearchList = PageinstancesFactory.getInstance(AmazonSearchList.class);
	    amazonSearchList.gotoProductPage();
  	
		// get product cost and add to cart
		AmazonProduct amazonProduct = PageinstancesFactory.getInstance(AmazonProduct.class);
		pCost = amazonProduct.getProductCost();
		pCost = pCost.replaceAll(",", "");
		int validProductAmount = Integer.parseInt(pCost);

		System.out.println("Monitor price === " + pCost);
 
		amazonProduct.AddToCart();

		
		cCost = amazonProduct.goToCart();
		cCost = cCost.replaceAll(",", "").replaceAll(".00", "");
		int validCartAmount = Integer.parseInt(cCost);
		System.out.println("Cart price === " + validCartAmount);
		
		System.out.println("test case=== " + amazonProduct.isPcostequalCcost(validProductAmount, validCartAmount));

		
		
		Assert.assertTrue((amazonProduct.isPcostequalCcost(validProductAmount, validCartAmount)), "Product Cost not matching cart cost : Test Failed");


		if(pCost == cCost) {
			
		}

		Thread.sleep(2000);


		
	}
}
