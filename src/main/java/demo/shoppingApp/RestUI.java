package demo.shoppingApp;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class RestUI {

    Cart cart = new Cart();
    Products products = new Products();
        
    public RestUI () {
        fillStore();
        cart.cloneStore(products.getProducts());
    }
    
    
    public void fillStore() {
    	try {
    		File f = new File("/");
    		Object obj = new JSONParser().parse(new FileReader("./src/main/resources/products.json"));
    		
    		JSONArray productsList = (JSONArray) obj;
    		products.populateProducts(productsList);
    	} catch(Exception e) {
    		
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