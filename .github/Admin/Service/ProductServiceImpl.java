package net.striker.Admin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.striker.Admin.Model.ProductModel;
import net.striker.Admin.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productrepository;
	
	public ProductModel saveProduct1(ProductModel product) {
        return productrepository.save(product);
    }

	    public ProductModel getProductById1(String id) {
	        return productrepository.findById(id).orElse(null);
	    }
	    
	   public String deleteProduct(String id) {
	    	//ProductModel product
	       productrepository.deleteById(id);
	        return "product removed !! " + id;
	    }

	    public ProductModel updateProduct1(ProductModel data) {
	        ProductModel productmodel = productrepository.findById(data.getProductId()).orElse(null);
	        productmodel.setProductId(data.getProductId());
	        productmodel.setImageUrl(data.getImageUrl());
		      productmodel.setProductName(data.getProductName());
		      productmodel.setPrice(data.getPrice());
		      productmodel.setDescription(data.getDescription());
		      productmodel.setQuantity(data.getQuantity());
	        return productrepository.save(productmodel);
	    }

		@Override
		public ProductModel saveProduct(ProductModel data) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ProductModel getProductById(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ProductModel updateProduct(ProductModel data) {
			// TODO Auto-generated method stub
			return null;
		}
}
