package ec.edu.espe.arquitectura.banquito.loan.service;

import ec.edu.espe.arquitectura.banquito.loan.dto.AmortizationRQ;
import ec.edu.espe.arquitectura.banquito.loan.dto.AmortizationRS;
import ec.edu.espe.arquitectura.banquito.loan.model.Amortization;
import ec.edu.espe.arquitectura.banquito.loan.model.Loan;
import ec.edu.espe.arquitectura.banquito.loan.repository.AmortizationRepository;
import ec.edu.espe.arquitectura.banquito.loan.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class AmortizationService {
    private final AmortizationRepository amortizationRepository;
    private final LoanRepository loanRepository;


    public AmortizationService(AmortizationRepository amortizationRepository, LoanRepository loanRepository) {
        this.amortizationRepository = amortizationRepository;
        this.loanRepository = loanRepository;
    }

    @Transactional
    public List<Amortization> generateAmortization(AmortizationRQ amortizationRQ) {
        Loan loan = loanRepository.findById(amortizationRQ.getLoanId()).orElseThrow(() -> new RuntimeException("Loan not found"));

        BigDecimal tasaInteresMensual =  BigDecimal.valueOf(loan.getInterestRate().doubleValue() / 12.0);
        BigDecimal cuotaMensual = calcularCuotaMensual(
                loan.getAmount(),
                tasaInteresMensual,
                loan.getRepaymentInstallments());

        List<Amortization> amortizationList = new ArrayList<>();
        BigDecimal remainingBalance = loan.getAmount();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(loan.getApprovedDate());
        // Fixed day of month
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int year = calendar.get(Calendar.YEAR);
//        int dayOfMonth = loan.getFixedDaysOfMonth();
//        calendar.set(year, month, dayOfMonth);

        for (int i = 0; i < loan.getRepaymentInstallments(); i++) {
            BigDecimal quotaInterest = remainingBalance.multiply(tasaInteresMensual);
            BigDecimal quotaCapital = cuotaMensual.subtract(quotaInterest);
            remainingBalance = remainingBalance.subtract(quotaCapital);
            Amortization amortization = Amortization.builder()
                    .type(amortizationRQ.getType())
                    .loanId(loan.getId())
                    .quotaNum(i + 1)
                    .quotaCapital(quotaCapital)
                    .quotaInterest(quotaInterest)
                    .quotaAmount(cuotaMensual)
                    .remainingBalance(remainingBalance)
                    .quotaStatus("CUR")
                    .dueDate(calendar.getTime())
                    .build();
            calendar.add(Calendar.MONTH, 1);
            amortizationList.add(amortization);
        }
        return amortizationRepository.saveAll(amortizationList);
    }

    private BigDecimal calcularCuotaMensual(BigDecimal amount, BigDecimal tasaInteresMensual, Integer repaymentInstallments) {
        double factor = Math.pow(1 + tasaInteresMensual.doubleValue(), repaymentInstallments);
        double quota = amount.doubleValue() * tasaInteresMensual.doubleValue() * factor / (factor - 1);
        return BigDecimal.valueOf(quota);
    }

    public List<AmortizationRS> findByLoanUuid(String uuid) {
        List<Amortization> amortizationList = getByLoanUuid(uuid);
        return toAmortizationRSList(amortizationList);
    }

    private List<Amortization> getByLoanUuid(String uuid) {
        List<Amortization> amortizationList = amortizationRepository.findByLoan_Uuid(uuid);
        if (amortizationList.isEmpty()) {
            throw new RuntimeException("Amortization not found");
        }
        return amortizationList;
    }

    private List<AmortizationRS> toAmortizationRSList(List<Amortization> amortizationList) {
        List<AmortizationRS> amortizationRSList = new ArrayList<>();
        for (Amortization amortization : amortizationList) {
            AmortizationRS amortizationRS = new AmortizationRS();
            amortizationRS.setId(amortization.getId());
            amortizationRS.setUuid(amortization.getUuid());
            amortizationRS.setType(amortization.getType());
            amortizationRS.setQuotaNum(amortization.getQuotaNum());
            amortizationRS.setDueDate(amortization.getDueDate());
            amortizationRS.setQuotaCapital(amortization.getQuotaCapital());
            amortizationRS.setQuotaInterest(amortization.getQuotaInterest());
            amortizationRS.setQuotaAmount(amortization.getQuotaAmount());
            amortizationRS.setRemainingBalance(amortization.getRemainingBalance());
            amortizationRS.setQuotaStatus(amortization.getQuotaStatus());
            amortizationRSList.add(amortizationRS);
        }
        return amortizationRSList;
    }

}
