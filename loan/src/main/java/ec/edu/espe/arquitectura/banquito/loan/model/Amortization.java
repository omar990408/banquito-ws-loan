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
@Table(name = "AMORTIZATION")
@Data
@Builder
public class Amortization {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AMORTIZATION_ID", nullable = false)
    private Integer id;

    // Foreign Keys
    @Column(name = "LOAN_ID", nullable = false)
    private Integer loanId;

    // Attributes
    @Column(name = "TYPE", length = 3, nullable = false)
    private String type;

    @Column(name = "QUOTA_NUM", nullable = false)
    private Integer quotaNum;

    @Column(name = "REMAINING_BALANCE", precision = 18, scale = 2, nullable = false)
    private BigDecimal remainingBalance;

    @Column(name = "QUOTA_CAPITAL", precision = 18, scale = 2, nullable = false)
    private BigDecimal quotaCapital;

    @Column(name = "QUOTA_INTEREST", precision = 18, scale = 2, nullable = false)
    private BigDecimal quotaInterest;

    @Column(name = "QUOTA_AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal quotaAmount;

    @Column(name = "QUOTA_STATUS", precision = 18, scale = 2, nullable = false)
    private BigDecimal quotaStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    private Date lastModifiedDate;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "LOAN_ID", referencedColumnName = "LOAN_ID", insertable = false, updatable = false, nullable = false)
    private Loan loan;

}
