package net.striker.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.striker.backend.model.product;


@Repository

public interface productRepository extends JpaRepository<product, Long>{



}
