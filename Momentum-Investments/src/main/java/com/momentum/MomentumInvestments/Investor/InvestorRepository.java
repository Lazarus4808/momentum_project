package com.momentum.MomentumInvestments.Investor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    // @Query("SELECT i FROM Investor i WHERE s.ssid = ?1")
    Optional <Investor> findInvestorBySsid(String ssid);
}
