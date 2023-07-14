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
@Table(name = "REPAYMENT")
public class Repayment {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPAYMENT_ID", nullable = false)
    private Integer id;

    // Foreign Keys
    @Column(name = "LOAN_ID", nullable = false)
    private Integer loanId;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "BRANCH_ID")
    private Integer branchId;

    @Column(name = "ACCOUNT_TRANSACTION_ID", nullable = false)
    private Integer accountTransactionId;

    // Attributes
    @Column(name = "STATE", length = 3, nullable = false)
    private String state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DUE_DATE", nullable = false)
    private Date dueDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REPAID_DATE", nullable = false)
    private Date repaidDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_PAID_DATE", nullable = false)
    private Date lastPaidDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_PENALTY_APPLIED_DATE", nullable = false)
    private Date lastPenaltyAppliedDate;

    @Column(name = "PRINCIPAL_DUE", precision = 18, scale = 2, nullable = false)
    private BigDecimal principalDue;

    @Column(name = "PRINCIPAL_PAID", precision = 18, scale = 2, nullable = false)
    private BigDecimal principalPaid;

    @Column(name = "INTEREST_DUE", precision = 18, scale = 2, nullable = false)
    private BigDecimal interestDue;

    @Column(name = "INTEREST_PAID", precision = 18, scale = 2, nullable = false)
    private BigDecimal interestPaid;

    @Column(name = "FEES_DUE", precision = 18, scale = 2)
    private BigDecimal feesDue;

    @Column(name = "FEES_PAID", precision = 18, scale = 2)
    private BigDecimal feesPaid;

    @Column(name = "PENALTY_DUE", precision = 18, scale = 2)
    private BigDecimal penaltyDue;

    @Column(name = "PENALTY_PAID", precision = 18, scale = 2)
    private BigDecimal penaltyPaid;

    @Column(name = "NOTES", length = 1000)
    private String notes;

    @Column(name = "TAX_INTEREST_DUE", precision = 18, scale = 2)
    private BigDecimal taxInterestDue;

    @Column(name = "TAX_INTEREST_PAID", precision = 18, scale = 2)
    private BigDecimal taxInterestPaid;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "LOAN_ID", referencedColumnName = "LOAN_ID", insertable = false, updatable = false, nullable = false)
    private Loan loan;



    public Repayment() {
    }

    public Repayment(Integer id) {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getAccountTransactionId() {
        return accountTransactionId;
    }

    public void setAccountTransactionId(Integer accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getRepaidDate() {
        return repaidDate;
    }

    public void setRepaidDate(Date repaidDate) {
        this.repaidDate = repaidDate;
    }

    public Date getLastPaidDate() {
        return lastPaidDate;
    }

    public void setLastPaidDate(Date lastPaidDate) {
        this.lastPaidDate = lastPaidDate;
    }

    public Date getLastPenaltyAppliedDate() {
        return lastPenaltyAppliedDate;
    }

    public void setLastPenaltyAppliedDate(Date lastPenaltyAppliedDate) {
        this.lastPenaltyAppliedDate = lastPenaltyAppliedDate;
    }

    public BigDecimal getPrincipalDue() {
        return principalDue;
    }

    public void setPrincipalDue(BigDecimal principalDue) {
        this.principalDue = principalDue;
    }

    public BigDecimal getPrincipalPaid() {
        return principalPaid;
    }

    public void setPrincipalPaid(BigDecimal principalPaid) {
        this.principalPaid = principalPaid;
    }

    public BigDecimal getInterestDue() {
        return interestDue;
    }

    public void setInterestDue(BigDecimal interestDue) {
        this.interestDue = interestDue;
    }

    public BigDecimal getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(BigDecimal interestPaid) {
        this.interestPaid = interestPaid;
    }

    public BigDecimal getFeesDue() {
        return feesDue;
    }

    public void setFeesDue(BigDecimal feesDue) {
        this.feesDue = feesDue;
    }

    public BigDecimal getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(BigDecimal feesPaid) {
        this.feesPaid = feesPaid;
    }

    public BigDecimal getPenaltyDue() {
        return penaltyDue;
    }

    public void setPenaltyDue(BigDecimal penaltyDue) {
        this.penaltyDue = penaltyDue;
    }

    public BigDecimal getPenaltyPaid() {
        return penaltyPaid;
    }

    public void setPenaltyPaid(BigDecimal penaltyPaid) {
        this.penaltyPaid = penaltyPaid;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getTaxInterestDue() {
        return taxInterestDue;
    }

    public void setTaxInterestDue(BigDecimal taxInterestDue) {
        this.taxInterestDue = taxInterestDue;
    }

    public BigDecimal getTaxInterestPaid() {
        return taxInterestPaid;
    }

    public void setTaxInterestPaid(BigDecimal taxInterestPaid) {
        this.taxInterestPaid = taxInterestPaid;
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
        Repayment other = (Repayment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Repayment [id=" + id + ", loanId=" + loanId + ", userId=" + userId + ", branchId=" + branchId
                + ", accountTransactionId=" + accountTransactionId + ", state=" + state + ", dueDate=" + dueDate
                + ", repaidDate=" + repaidDate + ", lastPaidDate=" + lastPaidDate + ", lastPenaltyAppliedDate="
                + lastPenaltyAppliedDate + ", principalDue=" + principalDue + ", principalPaid=" + principalPaid
                + ", interestDue=" + interestDue + ", interestPaid=" + interestPaid + ", feesDue=" + feesDue
                + ", feesPaid=" + feesPaid + ", penaltyDue=" + penaltyDue + ", penaltyPaid=" + penaltyPaid + ", notes="
                + notes + ", taxInterestDue=" + taxInterestDue + ", taxInterestPaid=" + taxInterestPaid + ", version="
                + version + ", loan=" + loan + "]";
    }

}
