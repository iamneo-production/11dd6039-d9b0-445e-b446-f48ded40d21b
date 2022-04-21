package net.striker.Admin.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.striker.Admin.Model.CartModel;
import net.striker.Admin.Model.ProductModel;
import net.striker.Admin.Service.CartService;
import net.striker.Admin.Service.ProductService;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private ProductService productservice;
	
	@DeleteMapping("/cart/delete/{id}")
	public String  deleteCartItem(@PathVariable String id) {
	        return cartservice.deletecart(id);
	}
	 
	@GetMapping("/cart/{id}")
	public List<CartModel> showCart(@PathVariable String id){
		 List<CartModel> cartproducts=cartservice.getCartProducts(id);
		 return cartproducts;
	}
	
	 @PostMapping("/home/{uid}")
	 public String addToCart(@RequestBody Map<String,String> data,@PathVariable String uid){	
		 CartModel cartmodel=new CartModel();
		 ProductModel pm=productservice.getProductById(data.get("id"));
		 cartmodel.setPrice(pm.getPrice());
		 cartmodel.setProductName(pm.getProductName());
		 cartmodel.setQuantity(Integer.parseInt(data.get("quantity")));
		// Random rd=new Random();
		// cartmodel.setCartid(String.valueOf(rd.nextInt()));
		 cartmodel.setUserid(uid);
		 cartservice.addproduct(cartmodel);
		 return "product added!!";
	 }	

}
