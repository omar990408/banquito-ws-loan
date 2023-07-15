package ec.edu.espe.arquitectura.banquito.loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.espe.arquitectura.banquito.loan.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    List<Loan> findByStateAndPattern(String state, String pattern);

}
    
