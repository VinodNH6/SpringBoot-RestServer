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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


public class StartUI {

	@Autowired
    ResourceLoader resourceLoader;
	
    Cart cart = new Cart();
    Products products = new Products();
    
	private JSONArray productsList = null;
    
	
    public StartUI () {
        fillStore();
        cart.cloneStore(products.getProducts());
        mockShopping();
    }
    
    
    public void fillStore() {
    	try {	
       		Resource resource = new ClassPathResource("config/products.json");
       		String execType = resource.getURL().getPath().startsWith("file:") ? "As-Executable-Jar" : "As-Spring-App";
       		
    		if(execType == "As-Spring-App") {
	    		File file = resource.getFile();
	    		Object obj = new JSONParser().parse(new FileReader(file));
	    		productsList = (JSONArray) obj;
    		}
    		
    		if(execType == "As-Executable-Jar") {       //Anyway it works in both.
	    		InputStream inputStream = resource.getInputStream();
			    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			    String contents = reader.lines()
			      .collect(Collectors.joining(System.lineSeparator()));
			    System.out.println(contents);
	    		Object objx = new JSONParser().parse(contents);
	    		productsList = (JSONArray) objx;
    		}
    		
    		products.populateProducts(productsList);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    public void mockShopping() {
    	displayStoreProducts();
    	
    	addProductToCart(1);
    	addProductToCart(2);
    	showCart();
    	
    	removeProductFromCart(2);
    	showCart();
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

    private void addProductToCart(int pid) {
        cart.addProductToCartByPID(pid);      
    }

    private void showCart() {
        cart.printCartItems();
    }

    private void removeProductFromCart(int pid) {
        cart.removeProductByPID(pid);
    }
}