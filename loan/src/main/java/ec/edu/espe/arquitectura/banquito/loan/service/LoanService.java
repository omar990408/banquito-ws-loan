package ec.edu.espe.arquitectura.banquito.loan.service;

import ec.edu.espe.arquitectura.banquito.loan.dto.LoanRQ;
import ec.edu.espe.arquitectura.banquito.loan.dto.LoanRS;
import ec.edu.espe.arquitectura.banquito.loan.model.Loan;
import ec.edu.espe.arquitectura.banquito.loan.repository.LoanRepository;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public LoanRS listById(Integer id) {
        Optional<Loan> loanOpt = this.loanRepository.findById(id);
        Loan loan = loanOpt.get();
        LoanRS loanTmp = this.transformLoanRS(loan);
        if (loanTmp == null) {
            throw new RuntimeException("Parametros de búsqueda incorrectos");
        } else {
            return loanTmp;
        }
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
            loan.setState("APP");
            loan.setPrincipalPaid(new BigDecimal(0));
            loan.setInterestPaid(new BigDecimal(0));
            if (loan.getLoanProductId().equals("1")) { // reemplazar po UUID de prestamo personal
                if (loan.getAmount().compareTo(new BigDecimal(40000)) > 0) {
                    throw new RuntimeException("El monto no puede exceder los $40.000 en este préstamo");
                }
                if (loan.getAmount().compareTo(new BigDecimal(300)) < 0) {
                    throw new RuntimeException("El monto no puede ser menor de $300 en este préstamo");
                }
                loan.setInterestDue(new BigDecimal(100));// Próximo parcial
                loan.setPrincipalDue(loan.getAmount().add(new BigDecimal(100)));
                loan.setPenalityDue(new BigDecimal(0));
                if (loan.getRepaymentPeriodCount() < 3 && loan.getRepaymentPeriodUnit().equals("MON")) {
                    throw new RuntimeException("El periodo mínimo para este prestamo es de 3 meses");
                }
                if ((loan.getRepaymentPeriodCount() > 60 && loan.getRepaymentPeriodUnit().equals("MON"))
                        || (loan.getRepaymentPeriodCount() > 5 && loan.getRepaymentPeriodUnit().equals("YEA"))) {
                    throw new RuntimeException("El periodo máximo para este préstamo es de 5 años");
                }
                loan.setRepaymentInstallments(loan.getRepaymentPeriodCount());
                loan.setInterestRate(new BigDecimal(0.15));
            }

            if (loan.getLoanProductId().equals("2")) { // reemplazar por UUID de prestamo hipotecario cliente
                if (loan.getAmount().compareTo(new BigDecimal(3000)) < 0) {
                    throw new RuntimeException("El monto no puede ser menor de $3.000 en este préstamo");
                }
                if (!loan.getAccountHolderType().equals("CLI")) {
                    throw new RuntimeException("Este préstamo únicamente es para clientes naturales");
                }
                loan.setInterestDue(new BigDecimal(200));// Próximo parcial
                loan.setPrincipalDue(loan.getAmount().add(new BigDecimal(200)));
                loan.setPenalityDue(new BigDecimal(0));
                if ((loan.getRepaymentPeriodCount() < 36 && loan.getRepaymentPeriodUnit().equals("MON"))
                        || (loan.getRepaymentPeriodCount() < 3 && loan.getRepaymentPeriodUnit().equals("YEA"))) {
                    throw new RuntimeException("El periodo mínimo para este prestamo es de 3 años");
                }
                if ((loan.getRepaymentPeriodCount() > 240 && loan.getRepaymentPeriodUnit().equals("MON"))
                        || (loan.getRepaymentPeriodCount() > 20 && loan.getRepaymentPeriodUnit().equals("YEA"))) {
                    throw new RuntimeException("El periodo máximo para este préstamo es de 20 años");
                }
                loan.setRepaymentInstallments(loan.getRepaymentPeriodCount());
                loan.setInterestRate(new BigDecimal(0.10));
            }
            if (loan.getLoanProductId().equals("3")) { // reemplazar por UUID de prestamo hipotecario empresa
                if (loan.getAmount().compareTo(new BigDecimal(25000)) < 0) {
                    throw new RuntimeException("El monto no puede ser menor de $25.000 en este préstamo");
                }
                if (loan.getAccountHolderType().equals("CLI")) {
                    throw new RuntimeException("Este préstamo únicamente es para empresas o grupos");
                }
                loan.setInterestDue(new BigDecimal(100));// Próximo parcial
                loan.setPrincipalDue(loan.getAmount().add(new BigDecimal(100)));
                loan.setPenalityDue(new BigDecimal(0));
                if ((loan.getRepaymentPeriodCount() < 240 && loan.getRepaymentPeriodUnit().equals("MON"))
                        || (loan.getRepaymentPeriodCount() < 20 && loan.getRepaymentPeriodUnit().equals("YEA"))) {
                    throw new RuntimeException("El periodo mínimo para este prestamo es de 20 años");
                }
                if ((loan.getRepaymentPeriodCount() > 300 && loan.getRepaymentPeriodUnit().equals("MON"))
                        || (loan.getRepaymentPeriodCount() > 25 && loan.getRepaymentPeriodUnit().equals("YEA"))) {
                    throw new RuntimeException("El periodo máximo para este préstamo es de 25 años");
                }
                loan.setRepaymentInstallments(loan.getRepaymentPeriodCount());
                loan.setInterestRate(new BigDecimal(0.05));
            }
            if (loan.getLoanProductId().equals("4")) { // reemplazar por UUID de prestamo vehicular
                if (loan.getAmount().compareTo(new BigDecimal(150000)) > 0) {
                    throw new RuntimeException("El monto no puede exceder los $150.000 en este préstamo");
                }
                if (loan.getAmount().compareTo(new BigDecimal(3000)) < 0) {
                    throw new RuntimeException("El monto no puede ser menor de $3.000 en este préstamo");
                }
                loan.setInterestDue(new BigDecimal(150));// Próximo parcial
                loan.setPrincipalDue(loan.getAmount().add(new BigDecimal(150)));
                loan.setPenalityDue(new BigDecimal(0));
                if ((loan.getRepaymentPeriodCount() < 3 && loan.getRepaymentPeriodUnit().equals("MON"))) {
                    throw new RuntimeException("El periodo mínimo para este prestamo es de 3 meses");
                }
                if ((loan.getRepaymentPeriodCount() > 72 && loan.getRepaymentPeriodUnit().equals("MON"))
                        || (loan.getRepaymentPeriodCount() > 6 && loan.getRepaymentPeriodUnit().equals("YEA"))) {
                    throw new RuntimeException("El periodo máximo para este préstamo es de 6 años");
                }
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

    private LoanRS transformLoanRS(Loan loan) {
        LoanRS rs = LoanRS.builder().accountId(loan.getAccountId()).guarantyId(loan.getGuarantyId())
                .branchId(loan.getBranchId()).loanProductId(loan.getLoanProductId())
                .accountHolderType(loan.getAccountHolderType())
                .state(loan.getState()).name(loan.getName()).amount(loan.getAmount())
                .principalPaid(loan.getPrincipalPaid()).interestPaid(loan.getInterestPaid())
                .penalityPaid(loan.getPenalityPaid()).repaymentPeriodCount(loan.getRepaymentPeriodCount())
                .repaymentPeriodUnit(loan.getRepaymentPeriodUnit()).creationDate(loan.getCreationDate())
                .approvedDate(loan.getApprovedDate()).lastModifiedDate(loan.getLastModifiedDate())
                .principalDue(loan.getPrincipalDue()).interestDue(loan.getInterestDue())
                .penalityDue(loan.getPenalityDue())
                .repaymentInstallments(loan.getRepaymentInstallments()).interestRate(loan.getInterestRate()).build();
        return rs;

    }
}
