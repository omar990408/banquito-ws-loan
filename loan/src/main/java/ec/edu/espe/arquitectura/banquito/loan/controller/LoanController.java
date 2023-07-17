package ec.edu.espe.arquitectura.banquito.loan.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.espe.arquitectura.banquito.loan.model.Loan;
import ec.edu.espe.arquitectura.banquito.loan.service.LoanService;

@RestController
@RequestMapping
public class LoanController {

    @Autowired
    private final LoanService loanService;


    public LoanController(LoanService loanService) {

        this.loanService = loanService;
    }

    @PostMapping("/loan")
    @ResponseBody
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan createdLoan = loanService.loanCreate(loan);
        return new ResponseEntity<>(createdLoan, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> obtainById(@PathVariable(name = "id") Integer id) {
        Optional<Loan> loan = this.loanService.obtainById(id);
        if (loan.isPresent()) {
            return ResponseEntity.ok(loan.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    


    @PutMapping
    public ResponseEntity <Loan>update(@RequestBody Loan loan) {
        try {
            this.loanService.updateLoan(loan);
            return ResponseEntity.ok(loan);
        } catch (RuntimeException rte) {
            throw new NoSuchElementException("Prestamo: " + loan.getId() + " No existe");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Loan> delete(@PathVariable(name = "id") Integer id) {

        try {
            this.loanService.delete(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException rte) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
