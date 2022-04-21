package net.striker.Admin.Service;

import java.util.List;

import net.striker.Admin.Model.CartModel;

public interface CartService {

	public String deletecart(String id);

	public List<CartModel> getCartProducts(String id);

	public void addproduct(CartModel cartmodel);

	public CartModel getCartProductByID(String id);

	public List<CartModel> getitems(String uid);

	List<CartModel> getitems1(String uid);

	//List<CartModel> getitems1(String id);

}
