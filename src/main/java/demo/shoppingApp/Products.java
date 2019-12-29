package demo.shoppingApp;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Products {
	
    private final List<Product> products = new ArrayList<Product>();

    public Products () {
    }
    
    public void populateProducts(JSONArray productsList) {
    	productsList.forEach(prod -> {
    		JSONObject prodObj = (JSONObject) prod;
    		this.products.add(new Product(
	    				Integer.valueOf(prodObj.get("id").toString()),
	    				(String) prodObj.get("name"),
	    				Integer.valueOf(prodObj.get("price").toString()),
	    				Integer.valueOf(prodObj.get("stock").toString()) 
    		));
    	});
    	
    	System.out.println("## PRODUCTS ##");
    	List<Product> products = this.products;
    	for (Product prod: products) {
    		System.out.println( prod.getPid() + "- " + prod.getName() + " " +
                           prod.getPrice() + " " + prod.getStock() );
    	}
    	
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
}