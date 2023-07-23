package ec.edu.espe.arquitectura.banquito.loan.controller;

import ec.edu.espe.arquitectura.banquito.loan.dto.AmortizationRQ;
import ec.edu.espe.arquitectura.banquito.loan.dto.AmortizationRS;
import ec.edu.espe.arquitectura.banquito.loan.model.Amortization;
import ec.edu.espe.arquitectura.banquito.loan.service.AmortizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/amortization")
public class AmortizationController {

    private final AmortizationService amortizationService;
    public AmortizationController(AmortizationService amortizationService) {
        this.amortizationService = amortizationService;
    }
    @PostMapping("/generate")
    public ResponseEntity<List<AmortizationRS>> generateAmortization(@RequestBody AmortizationRQ amortizationRQ) {
        return ResponseEntity.ok(amortizationService.generateAmortization(amortizationRQ));
    }

}
