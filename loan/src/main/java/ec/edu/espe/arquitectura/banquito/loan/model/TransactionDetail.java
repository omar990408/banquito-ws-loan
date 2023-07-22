package ec.edu.espe.arquitectura.banquito.loan.model;


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
@Table(name = "TRANSACTION_DETAIL")
@Data
@Builder
public class TransactionDetail {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_DETAIL_ID", nullable = false)
    private Integer id;

    // Foreign Keys
    @Column(name = "LOAN_TRANSACTION_ID", nullable = false)
    private Integer loanTransactionId;

    // Attributes
    @Column(name = "TRANSACTION_CHANNEL_ID", length = 50, nullable = false)
    private String transactionChannelId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    private Date lastModifiedDate;

    @Column(name = "DESCRIPTION", length = 50, nullable = false)
    private String description;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "LOAN_TRANSACTION_ID", referencedColumnName = "LOAN_TRANSACTION_ID", insertable = false, updatable = false, nullable = false)
    private LoanTransaction loanTransaction;

}
