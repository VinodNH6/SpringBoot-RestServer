package demo.modal;

import java.util.Collection;

public interface ProductServiceInterface {
	   public abstract void createProduct(Product product);
	   public abstract void updateProduct(String id, Product product);
	   public abstract void deleteProduct(String id);
	   public abstract Collection<Product> getProducts();
}