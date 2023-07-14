package ec.edu.espe.arquitectura.banquito.loan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import ec.edu.espe.arquitectura.banquito.loan.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    Loan findById(Integer id);
    Loan findByClientId(Integer id);


    List<Loan> findAll();

}
    
