package ec.edu.espe.arquitectura.banquito.loan.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import ec.edu.espe.arquitectura.banquito.loan.model.Loan;
import ec.edu.espe.arquitectura.banquito.loan.repository.AmortizationRepository;
import ec.edu.espe.arquitectura.banquito.loan.repository.LoanRepository;
import ec.edu.espe.arquitectura.banquito.loan.repository.LoanTransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanTransactionRepository loanTransactionRepository;
    private final AmortizationRepository amortizationRepository;


    public LoanService(LoanRepository loanRepository, LoanTransactionRepository loanTransactionRepository, AmortizationRepository amortizationRepository) {
        this.loanRepository = loanRepository;
        this.loanTransactionRepository = loanTransactionRepository;
        this.amortizationRepository = amortizationRepository;
    }



    public Optional<Loan> obtainById(Integer id) {
        Optional<Loan> loanOpt = this.loanRepository.findById(id);
        if (loanOpt.isPresent()) {
            return loanOpt;
        } else {
            throw new RuntimeException("Prestamo con ID: " + id + " no encontrado");
        }
    }


   /* @Transactional
    public Loan createLoan(Loan loan) {
        BigDecimal interestRate = loan.getAmount().compareTo(new BigDecimal(1000)) == 0 ? new BigDecimal("0.05") : new BigDecimal("0.03");
        BigDecimal interestAmount = loan.getAmount().multiply(interestRate);
        loan.setInterestDue(interestAmount);
        return loanRepository.save(loan);
    }*/
   @Transactional
    public Loan loanCreate(Loan loan) {

       //Loan loanTmp = this.loanRepository.findByLoanClientIdAndProductId(loan, loan.getLoanProductId());
       Optional<Loan> loanTmp = loanRepository.findById(loan.getLoanProductId());
      if(loanTmp!=null){
       loan.setCreationDate(new Date());
       loan.setLastModifiedDate(new Date());
       loan.setApprovedDate(new Date());
       loan.setInterestCalculationMethod("FLA");
       loan.setState("ACT");

           return this.loanRepository.save(loan);
       } else {
           throw new RuntimeException("Prestamo con ID " + loan.getId() + " ya existe");
       }

   }
    public Loan updateLoan(Loan loan) {
        
        return loanRepository.save(loan);
    }





    @Transactional
    public Loan delete(Integer loanId) {
        try {
            Optional<Loan> loanOpt = this.loanRepository.findById(loanId);
            if (loanOpt.isPresent()) {
                Loan loanTmp = loanOpt.get();
                loanTmp.setState("INA");
                loanTmp.setLastModifiedDate(new Date());
                return this.loanRepository.save(loanTmp);
            } else {throw new RuntimeException("El prestamo: " + loanId+"no existe");
            }} catch (RuntimeException rte)
        {
            throw new RuntimeException("No se puede eliminar el prestamo: " + loanId, rte);
        }
    }





    public String  loanSimulation(Integer mountSimulation, Integer mounths) {
        double calcutation, total;
        double interesRate = 0.156;
        double pagoMensual = 0;
        if (mountSimulation != null && mounths != null) {
            calcutation = mountSimulation * interesRate;
            total = mountSimulation + interesRate;
            pagoMensual = total / mounths;

        }
        return "Retornar valores simulados o hacer en el front";


    }
    
    }


