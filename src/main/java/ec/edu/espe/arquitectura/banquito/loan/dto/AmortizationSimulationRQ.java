package ec.edu.espe.arquitectura.banquito.loan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AmortizationSimulationRQ {
    private String type;
    private BigDecimal amount;
    private Integer repaymentInstallments;
}
