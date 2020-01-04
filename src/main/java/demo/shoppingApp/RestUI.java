package demo.shoppingApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class RestUI {

    Cart cart = new Cart();
    Products products = new Products();
        
    public RestUI () {
        fillStore();
        cart.cloneStore(products.getProducts());
    }
    
    
    public void fillStore() {
    	try {
    		Resource resource = new ClassPathResource("config/products.json");    		
    		InputStream inputStream = resource.getInputStream();
		    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		    String contents = reader.lines()
		      .collect(Collectors.joining(System.lineSeparator()));

    		Object obj = new JSONParser().parse(contents);
    		JSONArray productsList = (JSONArray) obj;
    		products.populateProducts(productsList);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    public void addProductToCart(int pid) {
        cart.addProductToCartByPID(pid);      
    }

    public void removeProductFromCart(int pid) {
        cart.removeProductByPID(pid);
    }
    
    public List<Product> getProducts() {
    	return this.products.getProducts();
    }
    
    public List<Product> getCartItems() {
    	return this.cart.getCartItems();
    }
    
    
    private void displayStoreProducts() {
        List<Product> products = new Products().getProducts();
        for (Product prod: products) {
            System.out.println(
                    prod.getPid() + "- " +
                            prod.getName() + " " +
                            prod.getPrice() + " " +
                            prod.getStock()
            );
        }
    }
    
}