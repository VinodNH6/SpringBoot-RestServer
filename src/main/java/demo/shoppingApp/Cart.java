package demo.shoppingApp;

import java.util.ArrayList;
import java.util.List;

class Cart {

    List<Product> cartItems = new ArrayList<Product>();
    List<Product> storeProducts = new ArrayList<Product>();
    
    public void cloneStore(List<Product> products) {
    	this.storeProducts = products;
    }
   
    private Product getProductByProductID(int pid) {
        Product product = null;       
        for (Product prod: this.storeProducts) {
            if (prod.getPid() == pid) {
                product = prod;
                break;
            }
        }
        return product;
    }

    public void addProductToCartByPID(int pid) {
    	System.out.println("Adding..."+pid);
        Product product = getProductByProductID(pid);
        cartItems.add(product);
    }

    public void removeProductByPID(int pid) {
    	System.out.println("Removing..."+pid);
        Product prod = getProductByProductID(pid);
        cartItems.remove(prod);
    }

    public List<Product> getCartItems() {
    	return this.cartItems;
    }
    
    void printCartItems() {
    	System.out.println("## CART ##");
        for (Product prod: cartItems) {
            System.out.println(prod.getName());
        }
    }
    
}