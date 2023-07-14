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

@Entity
@Table(name = "TRANSACTION_DETAIL")
public class TransactionDetail {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_DETAIL_ID", nullable = false)
    private Integer id;

    // Foreign Keys
    @Column(name = "LOAN_TRANSACTION_ID", nullable = false)
    private Integer loanTransactionId;

    @Column(name = "TRANSACTION_CHANNEL_ID", nullable = false)
    private Integer transactionChannelId;

    // Attributes
    @Column(name = "INTERNAL_TRANSFER")
    private Boolean internalTransfer;

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
    @JoinColumn(name = "LOAN_TRANSACTION_ID", referencedColumnName = "LOAN_TRANSACTION_ID", insertable = false, updatable = false, nullable = false)
    private LoanTransaction loanTransaction;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_CHANNEL_ID", referencedColumnName = "TRANSACTION_CHANNEL_ID", insertable = false, updatable = false, nullable = false)
    private TransactionChannel transactionChannel;

    public TransactionDetail() {
    }

    public TransactionDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanTransactionId() {
        return loanTransactionId;
    }

    public void setLoanTransactionId(Integer loanTransactionId) {
        this.loanTransactionId = loanTransactionId;
    }

    public Integer getTransactionChannelId() {
        return transactionChannelId;
    }

    public void setTransactionChannelId(Integer transactionChannelId) {
        this.transactionChannelId = transactionChannelId;
    }

    public Boolean getInternalTransfer() {
        return internalTransfer;
    }

    public void setInternalTransfer(Boolean internalTransfer) {
        this.internalTransfer = internalTransfer;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LoanTransaction getLoanTransaction() {
        return loanTransaction;
    }

    public void setLoanTransaction(LoanTransaction loanTransaction) {
        this.loanTransaction = loanTransaction;
    }

    public TransactionChannel getTransactionChannel() {
        return transactionChannel;
    }

    public void setTransactionChannel(TransactionChannel transactionChannel) {
        this.transactionChannel = transactionChannel;
    }

    @Override
    public String toString() {
        return "TransactionDetail [id=" + id + ", loanTransactionId=" + loanTransactionId + ", transactionChannelId="
                + transactionChannelId + ", internalTransfer=" + internalTransfer + ", creationDate=" + creationDate
                + ", lastModifiedDate=" + lastModifiedDate + ", version=" + version + ", loanTransaction="
                + loanTransaction + ", transactionChannel=" + transactionChannel + "]";
    }

}
