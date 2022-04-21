package net.striker.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.striker.Admin.Model.CartModel;

public interface CartRepository extends JpaRepository<CartModel,String> {

	public static final String cartdetails="Select * from cart where userid=?1";
	@Query(value=cartdetails , nativeQuery=true)
	public List<CartModel> getCartProducts(String id);
}
