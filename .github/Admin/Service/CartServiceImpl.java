package net.striker.Admin.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.striker.Admin.Model.CartModel;
import net.striker.Admin.Repository.CartRepository;
import net.striker.Admin.Repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartrepository;
	
	@Autowired
	ProductRepository productrepository;
	
	@Transactional
	public String deletecart(String id) {
       cartrepository.deleteById(id);
        return "cart removed !! ";
    }

	@Transactional
	public List<CartModel> getCartProducts1(String id) {
		// TODO Auto-generated method stub
		return cartrepository.getCartProducts(id);
	}

	public void addproduct1(CartModel cartmodel) {
		cartrepository.save(cartmodel);
		//return "Saved SuccessFully";
	}

	public CartModel getCartProductByID1(String id) {
		return cartrepository.getById(id);
	}
	@Override
	public List<CartModel> getitems1(String userId){
		List<CartModel> cartlist=cartrepository.getCartProducts(userId);
		return cartlist;
	}

	@Override
	public List<CartModel> getCartProducts(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addproduct(CartModel cartmodel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartModel getCartProductByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CartModel> getitems(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
