package net.striker.Admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.striker.Admin.Model.ProductModel;
import net.striker.Admin.Repository.ProductRepository;
import net.striker.Admin.Service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService service;
	
	
	@GetMapping("/admin")
	public List<ProductModel> getProduct() {
		return productRepository.findAll();
	}
	
	
	@GetMapping("/home")
	public List<ProductModel> getHomeProduct() {
		return productRepository.findAll();
	}
	
	@PostMapping("/admin/addProduct")
    public ProductModel productSave(@RequestBody ProductModel data) {
        return service.saveProduct(data);
    }
 
	@GetMapping("/admin/productEdit/{id}")
    public ProductModel productEditData(@PathVariable String id) {
        return service.getProductById(id);
    }
 
	@PostMapping("/admin/productEdit/{id}")
	public ProductModel productEditSave(@RequestBody ProductModel data) {
        return service.updateProduct(data);
    }
 
 
  @GetMapping("/admin/delete/{id}")
    public String productDelete(@PathVariable String id) {
        return service.deleteProduct(id);
    }

}
	
