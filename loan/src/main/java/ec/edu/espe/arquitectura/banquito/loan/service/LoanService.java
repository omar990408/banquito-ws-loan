package ec.edu.espe.arquitectura.banquito.loan.service;

import java.util.List;
import java.util.Optional;

import ec.edu.espe.arquitectura.banquito.loan.model.Loan;
import ec.edu.espe.arquitectura.banquito.loan.repository.LoanRepository;

public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Optional<Loan> obtainById(Integer id) {
        Optional<Loan> loanOpt = this.loanRepository.findById(id);
        if (loanOpt.isPresent()) {
            return loanOpt;
        } else {
            throw new RuntimeException("Prestamo con ID: " + id + " no encontrado");
        }
        return this.loanRepository.findById(id);
    }


    public List<Loan> listByStateAndPattern(String state, String pattern) {
        if (state != null) {
            return this.loanRepository.findByAccountHolderCode(pattern);
        } 
        else {
            throw new RuntimeException("El Loan " + pattern + " no existe");
        }

    }

    @Transactional
    public Loan loanCreate(Loan loan) {
        Loan loanTmp = this.loanRepository.findById(loan.getId());
        if (loanTmp == null) {
            
            loan.setCreationDate(new Date());
            loan.setLastModifiedDate(new Date());
            loan.setActivationDate(new Date());
            loan.setState("ACT");

            return this.loanRepository.save(loan);
        } else {
            throw new RuntimeException("Prestamo con ID " + loan.getId() + " ya existe");
        }

    }


    @Transactional
    public Loan updateLoan(Loan loan) {
        Optional<Loan> loanOpt = this.loanRepository.findById(loan.getId());
        if (loanOpt.isPresent()) {
            Loan loanTmp = loanOpt.get();
            if ("ACT".equals(loan.getState())) {
                loanTmp.setActivationDate(new Date());
                loanTmp.setClosedDate(null);
            } else {
                loanTmp.setActivationDate(null);
                loanTmp.setClosedDate(new Date());
            }
            loanTmp.setLastModifiedDate(new Date());
            loanTmp.setState(loan.getState());
            return this.loanRepository.save(loanTmp);

        } else {
            throw new RuntimeException("El prestamo que se desea modificar no está registrado");
        }

    }

    @Transactional
    public void deleteloan(Integer loanId) {
        try {
            Optional<Loan> loanOpt = this.loanRepository.findById(loanId);
            if (loanOpt.isPresent()) {
                this.loanRepository.delete(loanOpt.get());
            } else {
                throw new RuntimeException("El prestamo no esta registrado: ");
            }
        } catch (RuntimeException rte) {
            throw new RuntimeException("No esta permitido eliminar el prestamo con Codigo: " + loanId, rte);
        }
    }












    
}
