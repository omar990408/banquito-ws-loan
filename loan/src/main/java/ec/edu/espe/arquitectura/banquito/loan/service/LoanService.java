package ec.edu.espe.arquitectura.banquito.loan.service;

import ec.edu.espe.arquitectura.banquito.loan.dto.LoanRQ;
import ec.edu.espe.arquitectura.banquito.loan.model.Loan;
import ec.edu.espe.arquitectura.banquito.loan.repository.LoanRepository;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Transactional
    public Loan createLoan(LoanRQ loanRQ) {
        Loan loan = this.transformLoanRQ(loanRQ);
        Loan loanTmp = this.loanRepository.findByName(loan.getName());
        if (loanTmp == null) {
            loan.setCreationDate(new Date());
            loan.setApprovedDate(new Date());
            loan.setLastModifiedDate(new Date());
            loan.setUuid(UUID.randomUUID().toString());
            loan.setState("ACT");
            loan.setPrincipalPaid(new BigDecimal(0));
            loan.setInterestPaid(new BigDecimal(0));
            if (loan.getLoanProductId().equals("1")) { // prestamo personal
                //añadir validación de valor minimo y maximo 
                loan.setInterestDue(new BigDecimal(0));//Próximo parcial
                loan.setPrincipalDue(loan.getAmount());
                loan.setPenalityDue(new BigDecimal(0));
                loan.setRepaymentInstallments(loan.getRepaymentPeriodCount());
                loan.setInterestRate(new BigDecimal(0.15));
            }
            return this.loanRepository.save(loan);
        } else {
            throw new RuntimeException("No puede existir otro prestamo con el mismo nombre");
        }
    }

    private Loan transformLoanRQ(LoanRQ rq) {
        Loan loan = Loan.builder().accountId(rq.getAccountId()).guarantyId(rq.getGuarantyId())
                .branchId(rq.getBranchId()).loanProductId(rq.getLoanProductId())
                .accountHolderType(rq.getAccountHolderType())
                .state(rq.getState()).name(rq.getName()).amount(rq.getAmount())
                .principalPaid(rq.getPrincipalPaid()).interestPaid(rq.getInterestPaid())
                .penalityPaid(rq.getPenalityPaid()).repaymentPeriodCount(rq.getRepaymentPeriodCount())
                .repaymentPeriodUnit(rq.getRepaymentPeriodUnit()).build();
        return loan;
    }

}
