package ec.edu.espe.arquitectura.banquito.loan.service;

import java.util.List;
import java.util.Optional;

import ec.edu.espe.arquitectura.banquito.loan.model.Loan;
import ec.edu.espe.arquitectura.banquito.loan.repository.LoanRepository;
import jakarta.transaction.Transactional;

public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> listByStateAndPattern(String state, String pattern) {
        if (state != null) {
            return this.loanRepository.findByAccountHolderCode(pattern);
        } 
        else {
            throw new RuntimeException("El Prestamo indicado " + pattern + " no existe");
        }

    }

    @Transactional  
    public Loan loanCreate(Loan loan) {
        Loan loanTmp = this.loanRepository.findByClientId(loan.getId());
        if (loanTmp == null) {


        }
    
    }






    
}
