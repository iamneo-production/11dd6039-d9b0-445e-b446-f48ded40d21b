package net.striker.Admin.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.striker.Admin.Model.CartModel;
import net.striker.Admin.Model.OderModel;
import net.striker.Admin.Repository.OrderRepository;
import net.striker.Admin.Service.CartService;
import net.striker.Admin.Service.OrderService;
//import net.striker.Admin.Service.OderModel;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
    
	@Autowired
    public OrderService orderService;

	@Autowired
	private CartService cartservice;
	
	@GetMapping(value = "/admin/orders")
	public List<OderModel> getAllOrders() {
		return orderRepository.findAll();
	}
	
    @GetMapping("/orders/{userId}")
    public ResponseEntity<List<OderModel>> getUserProducts(@PathVariable String userId){
        List<OderModel>orderlist=orderService.getUserOrders(userId);
        return new ResponseEntity<List<OderModel>>(orderlist, HttpStatus.OK);
    }
    
    @PostMapping("/saveOrder/{uid}")
    public String saveProductString(@PathVariable String uid) {
    	List<CartModel> clist=cartservice.getitems(uid);
    	Iterator<CartModel> iterator=clist.iterator();
    	while(iterator.hasNext()) {
    	CartModel cm=iterator.next();
    	CartModel cartitem=cartservice.getCartProductByID(cm.getCartid());
    	OderModel orderitem=new OderModel();
    	orderitem.setPrice(cartitem.getPrice());
    	orderitem.setProductName(cartitem.getProductName());
    	orderitem.setQuantity(cartitem.getQuantity());
    	orderitem.setUserId(cartitem.getUserid());
    	int total=Integer.parseInt(cartitem.getPrice())*cartitem.getQuantity();
    	String totalprice=String.valueOf(total);
    	orderitem.setTotalPrice(totalprice);
    	String status="Order Placed";
    	orderitem.setStatus(status);
    	Random rd = new Random();
    	orderitem.setOrderId(String.valueOf(rd.nextInt()));
    	orderService.saveCartToOrder(orderitem);
    	}
    	return "Cart Item added to Order!!!";
    }
    
    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody OderModel ordermodel) {
    	orderService.placeOrder(ordermodel);
    	return "Order Placed!!!";
    }
    
    
}
