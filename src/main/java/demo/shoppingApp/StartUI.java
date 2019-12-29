package demo.shoppingApp;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class StartUI {

    Cart cart = new Cart();
    Products products = new Products();
    
    private int ch = 0;
    
    public StartUI () {
        fillStore();
        cart.cloneStore(products.getProducts());
       
        mockShopping();
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