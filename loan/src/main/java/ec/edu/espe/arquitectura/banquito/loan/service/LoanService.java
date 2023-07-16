package ec.edu.espe.arquitectura.banquito.loan.service;

import java.math.BigDecimal;
import java.util.List;


import ec.edu.espe.arquitectura.banquito.loan.model.Loan;
import ec.edu.espe.arquitectura.banquito.loan.repository.AmortizationRepository;
import ec.edu.espe.arquitectura.banquito.loan.repository.LoanRepository;
import ec.edu.espe.arquitectura.banquito.loan.repository.LoanTransactionRepository;
import jakarta.transaction.Transactional;

public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanTransactionRepository loanTransactionRepository;
    private final AmortizationRepository amortizationRepository;


    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
        this.loanTransactionRepository = loanTransactionRepository;
        this.amortizationRepository = amortizationRepository;
    }

    public List<Loan> obtainfindByClientId(Integer clientId) {
        return loanRepository.findByClientId(clientId);
    }

    public Loan getLoanById(Integer id) {
        return loanRepository.findById(id).orElse(null);
    }

    public Loan createLoan(Loan loan) {
        BigDecimal interestRate = loan.getAmount().compareTo(new BigDecimal(1000)) == 0 ? new BigDecimal("0.05") : new BigDecimal("0.03");
        BigDecimal interestAmount = loan.getAmount().multiply(interestRate);
        loan.setInterestDue(interestAmount);
        return loanRepository.save(loan);
    }

    public Loan updateLoan(Loan loan) {
        
        return loanRepository.save(loan);
    }

    public void deleteLoan(Integer id) {
        loanRepository.deleteById(id);
    }
    
    }

