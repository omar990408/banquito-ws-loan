package ec.edu.espe.arquitectura.banquito.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.arquitectura.banquito.loan.model.Amortization;

import java.util.List;

public interface AmortizationRepository extends JpaRepository<Amortization, Integer> {

    List<Amortization> findByLoan_Uuid(String uuid);

}
