package com.momentum.MomentumInvestments.Investor;

import com.momentum.MomentumInvestments.Product.Product;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Investor {
    @Id
    @SequenceGenerator(
            name = "investor_sequence",
            sequenceName = "investor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "investor_sequence"
    )
    private Long id;
    private String ssid; // Citizenship identification number
    private String firstname;
    private String lastname;
    private LocalDate dob;
    @Transient
    private Integer age;
    private String email;
    private String cellNo;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "investor")
    private Set<Product> products = new HashSet<>();

    public Investor() {
    }

    public Investor(String ssid) {
        this.ssid = ssid;
    }

    public Investor(Long id, String ssid, String firstname, String lastname, LocalDate dob) {
        this.id = id;
        this.ssid = ssid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
    }

    public Investor(String ssid, String firstname, String lastname, LocalDate dob, String email, String cellNo, String address) {
        this.ssid = ssid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.cellNo = cellNo;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getSsid() {
        return ssid;
    }

    public String getEmail() {
        return email;
    }

    public String getCellNo() {
        return cellNo;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public Set<Product> getProducts() {
        return products;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

}
