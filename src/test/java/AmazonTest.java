import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import base.TestBaseClass;
import serviceClass.AmazonServiceClass;

public class AmazonTest extends TestBaseClass{
	
	private AmazonServiceClass amazonServiceClass;

	@Before
	public void actionTestBefore(){
		try{
			initialize(); 
			amazonServiceClass = new AmazonServiceClass(webDriver);
		}catch (Exception e) {
			fail("Error In actionTestBefore() For Script : " + this.getClass().getSimpleName() + " : " + e.getMessage());
		}
	}
	
	/**
	 * This test method is used to test the product end to end flow
	 * Search the product
	 * Add to cart
	 * validate the product
	 */
	@Test
	public void testAddToProduct(){
		try{
			amazonServiceClass.searchProduct("65 LED TV");
			String productID = amazonServiceClass.getSearchProductID("3");
			String productName = amazonServiceClass.getSearchProductName("3");
			amazonServiceClass.clickAddToCart();
			amazonServiceClass.clickOnCart();
			String productOnCart = amazonServiceClass.getProductNmeOnCart(productID);
			assertEquals("Product is not same which added in cart", productName, productOnCart);
		}catch (Exception e) 
		{
			fail("Error In () For Script : " + this.getClass().getSimpleName() + " : " + e.getMessage());
		}
	}
}
