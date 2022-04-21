package net.striker.Admin.Service;

import net.striker.Admin.Model.ProductModel;

public interface ProductService {

	public ProductModel saveProduct(ProductModel data);

	public ProductModel getProductById(String id);

	public ProductModel updateProduct(ProductModel data);

	public String deleteProduct(String id);

}
