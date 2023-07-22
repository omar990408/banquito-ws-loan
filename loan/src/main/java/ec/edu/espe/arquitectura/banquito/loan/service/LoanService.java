package ec.edu.espe.arquitectura.banquito.loan.service;

import ec.edu.espe.arquitectura.banquito.loan.repository.LoanRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    
    }


