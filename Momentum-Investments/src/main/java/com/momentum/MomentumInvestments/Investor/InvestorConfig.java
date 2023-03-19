package com.momentum.MomentumInvestments.Investor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class InvestorConfig {
    @Bean
    CommandLineRunner commandLineRunner(InvestorRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new Investor(
                            "9409185752080",
                            "Lesego",
                            "Ramatsuii",
                            LocalDate.of(1994, SEPTEMBER, 18),
                            "moabielesego77@gmail.com",
                            "0606613491",
                            "133 10th Road, Kew, Johannesburg"
                    ),
                    new Investor(
                            "9902045037080",
                            "Bothlale",
                            "Mphai",
                            LocalDate.of(1999, FEBRUARY, 04),
                            "tumie.mphai@gmail.com",
                            "0760925964",
                            "253 Alexandrea Road, Bramley, Johannesburg"
                    )
            ));
        };
    }
}
