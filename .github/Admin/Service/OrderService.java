package net.striker.Admin.Service;

import java.util.List;

import net.striker.Admin.Model.OderModel;

public interface OrderService {
    
	public List<OderModel> getUserOrders(String userId);
    
	public OderModel getItemonCart(String cartItemId);

	public void saveCartToOrder(OderModel orderitem);

	public void placeOrder(OderModel ordermodel);

	List<OderModel> getUserOrders1(String userId);

	OderModel getItemonCart1(String cartItemId);

	void saveCartToOrder1(OderModel orderitem);

	void placeOrder1(OderModel ordermodel);


}
