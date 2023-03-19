package com.momentum.MomentumInvestments.Investor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/investors")
public class InvesterController {
    private final InvestorService investorService;

    @Autowired
    public InvesterController(InvestorService investorService) {
        this.investorService = investorService;
    }
    @GetMapping
    public List<Investor> getInvestors() {
        return investorService.getInvestors();
    }
    @GetMapping(path= "{investorId}")
    public Optional<Investor> getInvestor(@PathVariable("investorId") Long investorId) {
        return investorService.getInvestor(investorId);
    }
    @PostMapping
    public void registerNewInvestor(@RequestBody Investor investor) {
        investorService.addNewInvestor(investor);
    }
}
