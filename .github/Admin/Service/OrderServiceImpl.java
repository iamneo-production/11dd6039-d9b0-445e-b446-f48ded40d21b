package net.striker.Admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.striker.Admin.Model.OderModel;
//import net.striker.Admin.Repository.CartRepository;
import net.striker.Admin.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    //private CartRepository CartRepository;
    public List<OderModel>getUserOrders1(String userId){
        List<OderModel> orderlist=orderRepository.findUserId(userId);
        return orderlist;
    }

    @Override
    public OderModel getItemonCart1(String cartItemId) {
        return null;
    }

	@Override
	public void saveCartToOrder1(OderModel orderitem) {
		orderRepository.save(orderitem);
	}

	@Override
	public void placeOrder1(OderModel ordermodel) {
		orderRepository.save(ordermodel);
		
	}

	@Override
	public List<OderModel> getUserOrders(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OderModel getItemonCart(String cartItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveCartToOrder(OderModel orderitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void placeOrder(OderModel ordermodel) {
		// TODO Auto-generated method stub
		
	}
}
