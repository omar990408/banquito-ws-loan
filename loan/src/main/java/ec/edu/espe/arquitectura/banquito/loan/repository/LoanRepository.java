package ec.edu.espe.arquitectura.banquito.loan.repository;

import org.springframework.stereotype.Repository;
import ec.edu.espe.arquitectura.banquito.loan.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
    
