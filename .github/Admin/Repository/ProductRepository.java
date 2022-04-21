package net.striker.Admin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.striker.Admin.Model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel ,String> {

	void save(Optional<ProductModel> productmodel);
	
}
