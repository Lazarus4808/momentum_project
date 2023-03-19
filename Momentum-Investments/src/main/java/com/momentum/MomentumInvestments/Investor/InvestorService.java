package com.momentum.MomentumInvestments.Investor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestorService {
    private final InvestorRepository investorRepository;
    @Autowired
    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public Optional<Investor> getInvestor(Long id) {
        return investorRepository.findById(id);
    }
    public List<Investor> getInvestors() {
        return investorRepository.findAll();
    }

    public void addNewInvestor(Investor investor) {
        Optional<Investor> investorOptional = investorRepository.findInvestorBySsid(investor.getSsid());

        if (investorOptional.isPresent()) {
            throw new IllegalStateException("This ID already registered with momentum");
        }
        investorRepository.save(investor);
    }
}
