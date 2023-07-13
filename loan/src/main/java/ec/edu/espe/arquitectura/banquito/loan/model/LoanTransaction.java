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
@Table(name = "LOAN_TRANSACTION")
public class LoanTransaction {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_TRANSACTION_ID", nullable = false)
    private Integer id;

    // Foreign Keys
    @Column(name = "LOAN_ID", nullable = false)
    private Integer loanId;

    @Column(name = "LOAN_TRANSACTION_TYPE_ID", nullable = false)
    private Integer loanTransactionTypeId;

    @Column(name = "USER_ID")
    private Integer userId;

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

    @Column(name = "PRINCIPAL_AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal principalAmount;

    @Column(name = "INTEREST_AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal interestAmount;

    @Column(name = "FEES_AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal feesAmount;

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

    @ManyToOne
    @JoinColumn(name = "LOAN_TRANSACTION_TYPE_ID", referencedColumnName = "LOAN_TRANSACTION_TYPE_ID", insertable = false, updatable = false, nullable = false)
    private LoanTransactionType loanTransactionType;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "BRANCH_ID", referencedColumnName = "BRANCH_ID", insertable = false, updatable = false)
    private Branch branch;

    public LoanTransaction() {
    }

    public LoanTransaction(Integer id) {
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

    public Integer getLoanTransactionTypeId() {
        return loanTransactionTypeId;
    }

    public void setLoanTransactionTypeId(Integer loanTransactionTypeId) {
        this.loanTransactionTypeId = loanTransactionTypeId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalanceAfterTrs() {
        return balanceAfterTrs;
    }

    public void setBalanceAfterTrs(BigDecimal balanceAfterTrs) {
        this.balanceAfterTrs = balanceAfterTrs;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(BigDecimal principalAmount) {
        this.principalAmount = principalAmount;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public BigDecimal getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(BigDecimal feesAmount) {
        this.feesAmount = feesAmount;
    }

    public BigDecimal getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(BigDecimal penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public BigDecimal getPrincipalBalance() {
        return principalBalance;
    }

    public void setPrincipalBalance(BigDecimal principalBalance) {
        this.principalBalance = principalBalance;
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

    public LoanTransactionType getLoanTransactionType() {
        return loanTransactionType;
    }

    public void setLoanTransactionType(LoanTransactionType loanTransactionType) {
        this.loanTransactionType = loanTransactionType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
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
        LoanTransaction other = (LoanTransaction) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LoanTransaction [id=" + id + ", loanId=" + loanId + ", loanTransactionTypeId=" + loanTransactionTypeId
                + ", userId=" + userId + ", branchId=" + branchId + ", comment=" + comment + ", creationDate="
                + creationDate + ", amount=" + amount + ", balanceAfterTrs=" + balanceAfterTrs + ", entryDate="
                + entryDate + ", principalAmount=" + principalAmount + ", interestAmount=" + interestAmount
                + ", feesAmount=" + feesAmount + ", penaltyAmount=" + penaltyAmount + ", principalBalance="
                + principalBalance + ", version=" + version + ", loan=" + loan + ", loanTransactionType="
                + loanTransactionType + ", user=" + user + ", branch=" + branch + "]";
    }

}
