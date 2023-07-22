package ec.edu.espe.arquitectura.banquito.loan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.banquito.loan.service.LoanService;

@RestController
@RequestMapping
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {

        this.loanService = loanService;
    }

}
