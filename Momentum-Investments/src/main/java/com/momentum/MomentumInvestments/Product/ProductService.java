package com.momentum.MomentumInvestments.Product;

import com.momentum.MomentumInvestments.Investor.Investor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProduct(Long id) {
        return this.productRepository.findById(id);
    }
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    public List<Product> getInvestorProducts(Long investor_id) {
        return this.productRepository.findProductsForInvestor(investor_id);
    }
}
