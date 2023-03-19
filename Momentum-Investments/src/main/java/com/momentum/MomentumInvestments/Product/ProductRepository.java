package com.momentum.MomentumInvestments.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM product p WHERE p.investor_id = ?1")
    List<Product> findProductsForInvestor(Long investor_id);
}
