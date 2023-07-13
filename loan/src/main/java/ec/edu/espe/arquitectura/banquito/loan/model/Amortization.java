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

@Entity
@Table(name = "AMORTIZATION")
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

    public Amortization() {
    }

    public Amortization(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getQuotaNum() {
        return quotaNum;
    }

    public void setQuotaNum(Integer quotaNum) {
        this.quotaNum = quotaNum;
    }

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(BigDecimal remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public BigDecimal getQuotaCapital() {
        return quotaCapital;
    }

    public void setQuotaCapital(BigDecimal quotaCapital) {
        this.quotaCapital = quotaCapital;
    }

    public BigDecimal getQuotaInterest() {
        return quotaInterest;
    }

    public void setQuotaInterest(BigDecimal quotaInterest) {
        this.quotaInterest = quotaInterest;
    }

    public BigDecimal getQuotaAmount() {
        return quotaAmount;
    }

    public void setQuotaAmount(BigDecimal quotaAmount) {
        this.quotaAmount = quotaAmount;
    }

    public BigDecimal getQuotaStatus() {
        return quotaStatus;
    }

    public void setQuotaStatus(BigDecimal quotaStatus) {
        this.quotaStatus = quotaStatus;
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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Amortization other = (Amortization) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Amortization [id=" + id + ", loanId=" + loanId + ", quotaNum=" + quotaNum + ", remainingBalance="
                + remainingBalance + ", quotaCapital=" + quotaCapital + ", quotaInterest=" + quotaInterest
                + ", quotaAmount=" + quotaAmount + ", quotaStatus=" + quotaStatus + ", creationDate=" + creationDate
                + ", lastModifiedDate=" + lastModifiedDate + ", version=" + version + ", loan=" + loan + "]";
    }
}
