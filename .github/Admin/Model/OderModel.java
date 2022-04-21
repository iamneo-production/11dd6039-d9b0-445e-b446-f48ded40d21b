package net.striker.Admin.Model;

//import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OderModel {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private String orderId;
	    private String userId;
	    private String productName;
	    private int quantity;
	    private String totalPrice;
	    private String status;
	    private String price;
	    public OderModel(){

	    }

	    public String getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(String orderId) {
	        this.orderId = orderId;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public String getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(String totalPrice) {
	        this.totalPrice = totalPrice;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getPrice() {
	        return price;
	    }

	    public void setPrice(String price) {
	        this.price = price;
	    }

		public OderModel(String orderId, String userId, String productName, int quantity, String totalPrice, String status,
				String price) {
			super();
			this.orderId = orderId;
			this.userId = userId;
			this.productName = productName;
			this.quantity = quantity;
			this.totalPrice = totalPrice;
			this.status = status;
			this.price = price;
		}
	    
	}
     

