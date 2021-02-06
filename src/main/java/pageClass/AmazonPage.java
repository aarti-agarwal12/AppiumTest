package pageClass;

public class AmazonPage {
	public final String ID_SEARCH_BOX = "twotabsearchtextbox";
	public final String ID_SEARCH_ICON = "nav-search-submit-button";
	public final String ID_ADD_TO_CART = "add-to-cart-button";
	public final String ID_CART = "nav-cart";
	
	public String getXpathOfProduct(String searchResultNo){
		return ".//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-cel-widget='search_result_"+searchResultNo+"']";
	}
	
	public String getXpathOfProductName(String searchResultNo){
		return getXpathOfProduct(searchResultNo)+"//h2/a";
	}
	
	public String getXpathOfProductOnCart(String productID) {
		return ".//*[@id='activeCartViewForm']//div[@data-asin='"+productID+"']//span[@class='a-list-item']/a/span[1]";
	}

}
