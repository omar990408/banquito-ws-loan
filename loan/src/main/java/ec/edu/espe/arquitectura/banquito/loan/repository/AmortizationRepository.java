package ec.edu.espe.arquitectura.banquito.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.arquitectura.banquito.loan.model.Amortization;

public interface AmortizationRepository extends JpaRepository<Amortization, Integer> {

}
