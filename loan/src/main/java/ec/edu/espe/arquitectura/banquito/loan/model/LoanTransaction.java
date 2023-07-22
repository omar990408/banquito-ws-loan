package ec.edu.espe.arquitectura.banquito.loan.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "LOAN_TRANSACTION")
@Data
@Builder
public class LoanTransaction {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_TRANSACTION_ID", nullable = false)
    private Integer id;

    // Foreign Keys
    @Column(name = "LOAN_ID", nullable = false)
    private Integer loanId;

    @Column(name = "LOAN_TRANSACTION_TYPE_ID", length = 20, nullable = false)
    private String loanTransactionTypeId;

    @Column(name = "BRANCH_ID")
    private Integer branchId;

    // Attributes
    @Column(name = "COMMENT", length = 1000)
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;

    @Column(name = "AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "BALANCE_AFTER_TRS", precision = 18, scale = 2, nullable = false)
    private BigDecimal balanceAfterTrs;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENTRY_DATE", nullable = false)
    private Date entryDate;

    @Column(name = "INTEREST_AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal interestAmount;

    @Column(name = "PENALTY_AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal penaltyAmount;

    @Column(name = "PRINCIPAL_BALANCE", precision = 18, scale = 2, nullable = false)
    private BigDecimal principalBalance;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "LOAN_ID", referencedColumnName = "LOAN_ID", insertable = false, updatable = false, nullable = false)
    private Loan loan;

}
