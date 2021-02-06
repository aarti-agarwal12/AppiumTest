package serviceClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseHelper;
import pageClass.AmazonPage;

public class AmazonServiceClass {
	private WebDriver webDriver;
	private AmazonPage amazonPage;
	private BaseHelper baseHelper;
	
	public AmazonServiceClass(WebDriver webDriver) {
		this.webDriver 			= webDriver;
		this.amazonPage			= new AmazonPage();
		this.baseHelper			= new BaseHelper();
	}
	
	public void searchProduct(String productName) {
		baseHelper.fillTextFields(webDriver, By.id(amazonPage.ID_SEARCH_BOX), productName, "Search Text Box", webDriver.getTitle());
		baseHelper.getField(webDriver, By.id(amazonPage.ID_SEARCH_ICON), "Search icon is not present").click();
	}
	
	public String getSearchProductID(String searchIndex) {
		WebElement searchProduct = baseHelper.getField(webDriver, By.xpath(amazonPage.getXpathOfProduct(searchIndex)), "Product is not available");
		String dataID = searchProduct.getAttribute("data-asin");
		return dataID;
	}
	
	public String getSearchProductName(String searchIndex) {
		WebElement searchProduct = baseHelper.getField(webDriver, By.xpath(amazonPage.getXpathOfProductName(searchIndex)), "Product is not available");
		String productName = searchProduct.getText();
		return productName;
	}
	
	public void clickAddToCart() {
		baseHelper.getField(webDriver, By.id(amazonPage.ID_ADD_TO_CART), "Add to Cart button is not displayed").click();
	}
	
	public void clickOnCart() {
		baseHelper.getField(webDriver, By.id(amazonPage.ID_CART), "Cart button is not displayed").click();
	}
	
	public String getProductNmeOnCart(String productID) {
		return baseHelper.getField(webDriver, By.xpath(amazonPage.getXpathOfProductOnCart(productID)), "Product is missing").getText();
	}
}
