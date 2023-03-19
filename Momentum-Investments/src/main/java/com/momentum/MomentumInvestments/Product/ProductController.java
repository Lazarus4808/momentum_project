package com.momentum.MomentumInvestments.Product;

import com.momentum.MomentumInvestments.Investor.Investor;
import com.momentum.MomentumInvestments.Investor.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    InvestorService investorService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @GetMapping(path = "investor/{investorId}")
    public List<Product> getInvestorProducts(@RequestParam("investorId") Long investorId) {
        Investor investor = investorService.getInvestor(investorId).get();
        return productService.getInvestorProducts(investor.getId());
    }
}
