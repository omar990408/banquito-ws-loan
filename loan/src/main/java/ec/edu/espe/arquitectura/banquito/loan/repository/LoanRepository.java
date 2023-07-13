package ec.edu.espe.arquitectura.banquito.loan.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
    
