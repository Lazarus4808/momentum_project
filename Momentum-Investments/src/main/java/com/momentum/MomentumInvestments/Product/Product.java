package com.momentum.MomentumInvestments.Product;

import com.momentum.MomentumInvestments.Investor.Investor;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long product_id;
    private String name;
    private String product_type;
    private Double balance;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="investor_id", referencedColumnName = "id")
    private Investor investor;

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public Double getBalance() {
        return balance;
    }

    public Investor getInvestor() {
        return investor;
    }
}
