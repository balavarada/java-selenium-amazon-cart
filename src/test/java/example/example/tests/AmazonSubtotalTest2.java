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
public class AmazonSubtotalTest2 extends BaseTest {

	@Test
	public void AmazonSubtotalTest2() throws Exception {
		String pCost;
		String cCost;
	 
		
		//open amazon
		driver.get("https://www.amazon.in/ref=nav_loh");
		driver.manage().deleteAllCookies();
		
		// Search Headphones
		AmazonSearch amazonPage = PageinstancesFactory.getInstance(AmazonSearch.class);
		amazonPage.searchText("Headphones");
 
		//land on product page
	    AmazonSearchList amazonSearchList = PageinstancesFactory.getInstance(AmazonSearchList.class);
	    amazonSearchList.gotoProductPage("1");
  	
		// get product cost and add to cart
		AmazonProduct amazonProduct = PageinstancesFactory.getInstance(AmazonProduct.class);
		pCost = amazonProduct.getProductCost();
		pCost = pCost.replaceAll(",", "").replaceAll(".00", "");
		 
		int validProductAmountHphones = Integer.parseInt(pCost);

		System.out.println("Headphones price === " + validProductAmountHphones);
 
		amazonProduct.AddToCart();
		cCost = amazonProduct.goToCart();
		cCost = cCost.replaceAll(",", "").replaceAll(".00", "");
		int validCartAmount = Integer.parseInt(cCost);
		System.out.println("Cart price after adding headphone === " + validCartAmount);
		
 
		// Search Keyboard
 		amazonPage.searchText("Keyboard");
 
		//land on product page
 	    amazonSearchList.gotoProductPage("1");
  	
		// get product cost and add to cart
 		pCost = amazonProduct.getProductCost();
		pCost = pCost.replaceAll(",", "").replaceAll(".00", "");
		 
		int validProductAmountKboard = Integer.parseInt(pCost);

		System.out.println("Keyboard price === " + validProductAmountKboard);
 
		amazonProduct.AddToCart();
		cCost = amazonProduct.goToCart();
		cCost = cCost.replaceAll(",", "").replaceAll(".00", "");
		validCartAmount = Integer.parseInt(cCost);
		System.out.println("Cart price after adding keyboard === " + validCartAmount);
		
		int validProductAmount = validProductAmountHphones + validProductAmountKboard;
		
		System.out.println("Test case === " + amazonProduct.isPcostequalCcost(validProductAmount, validCartAmount));

				
		Assert.assertTrue((amazonProduct.isPcostequalCcost(validProductAmount, validCartAmount)), "Product Costs not matching cart cost : Test Failed");

 		Thread.sleep(2000);


		
	}
}
