package example.example.tests;

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
public class AmazonSubtotalTest1 extends BaseTest {

	@Test
	public void AmazonSubtotalTest1() throws Exception {
		String pCost;
		String cCost;
	 
		
		driver.get("https://www.amazon.in/ref=nav_logosss");
		driver.manage().deleteAllCookies();
		//open amazon
		AmazonSearch amazonPage = PageinstancesFactory.getInstance(AmazonSearch.class);
		amazonPage.searchText("Laptop");
 
		//land on product page
	    AmazonSearchList amazonSearchList = PageinstancesFactory.getInstance(AmazonSearchList.class);
	    amazonSearchList.gotoProductPage("2");
  	
		// get product cost and add to cart
		AmazonProduct amazonProduct = PageinstancesFactory.getInstance(AmazonProduct.class);
		pCost = amazonProduct.getProductCost();
		pCost = pCost.replaceAll(",", "").replaceAll(".00", "");
		 
		int validProductAmount = Integer.parseInt(pCost);

		System.out.println("Laptop price === " + pCost);
 
		amazonProduct.AddToCart();

		
		cCost = amazonProduct.goToCart();
		cCost = cCost.replaceAll(",", "").replaceAll(".00", "");
		int validCartAmount = Integer.parseInt(cCost);
		System.out.println("Cart price === " + validCartAmount);
		
		System.out.println("Test case=== " + amazonProduct.isPcostequalCcost(validProductAmount, validCartAmount));
	
		Assert.assertTrue((amazonProduct.isPcostequalCcost(validProductAmount, validCartAmount)), "Product Cost not matching cart cost : Test Failed");
 

		Thread.sleep(2000);


		
	}
}
