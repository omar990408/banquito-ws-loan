package ec.edu.espe.arquitectura.banquito.loan.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

@Entity
@Table(name = "LOAN")
public class Loan {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_ID", nullable = false)
    private Integer id;

    // Foreign Keys
    @Column(name = "CLIENT_ID")
    private Integer clientId;

    @Column(name = "GROUP_COMPANY_ID")
    private Integer groupCompanyId;

    @Column(name = "GROUP_ROLE_ID", length = 3)
    private String groupRoleId;

    @Column(name = "GRO_CLIENT_ID")
    private Integer groClientId;

    @Column(name = "BRANCH_ID")
    private Integer branchId;

    @Column(name = "USER_ID")
    private Integer userId;


    @Column(name = "LOAN_PRODUCT_ID", nullable = false)
    private Integer loanProductId;

    @Column(name = "GUARANTY_ID")
    private Integer guarantyId;


    // Attributes
    @Column(name = "ACCOUNT_HOLDER_TYPE", length = 3, nullable = false)
    private String accountHolderType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APPROVED_DATE")
    private Date approvedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    private Date lastModifiedDate;

    @Column(name = "STATE", length = 3, nullable = false)
    private String state;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "PRINCIPAL_DUE", precision = 18, scale = 2, nullable = false)
    private BigDecimal principalDue;

    @Column(name = "INTEREST_DUE", precision = 18, scale = 2, nullable = false)
    private BigDecimal interestDue;

    @Column(name = "INTEREST_PAID", precision = 18, scale = 2, nullable = false)
    private BigDecimal interestPaid;

    @Column(name = "FEES_DUE", precision = 18, scale = 2, nullable = false)
    private BigDecimal feesDue;

    @Column(name = "FEES_PAID", precision = 18, scale = 2, nullable = false)
    private BigDecimal feesPaid;

    @Column(name = "PENALTY_DUE", precision = 18, scale = 2, nullable = false)
    private BigDecimal penalityDue;

    @Column(name = "PENALTY_PAID", precision = 18, scale = 2, nullable = false)
    private BigDecimal penalityPaid;

    @Column(name = "REPAYMENT_PERIOD_COUNT", nullable = false)
    private Integer repaymentPeriodCount;

    @Column(name = "REPAYMENT_PERIOD_UNIT", length = 3, nullable = false)
    private String repaymentPeriodUnit;

    @Column(name = "REPAYMENT_INSTALLMENTS", nullable = false)
    private Integer repaymentInstallments;

    @Column(name = "GRACE_PERIOD_TYPE", length = 3)
    private String gracePeriodType;

    @Column(name = "GRACE_PERIOD")
    private Integer gracePeriod;

    @Column(name = "INTEREST_RATE", precision = 3, scale = 2, nullable = false)
    private BigDecimal interestRate;

    @Column(name = "INTEREST_CHARGE_FREQUENCE", length = 3, nullable = false)
    private String interestChargeFrequence;

    @Column(name = "INTEREST_CALCULATION_METHOD", length = 3, nullable = false)
    private String interestCalculationMethod;


    @Column(name = "NOTES", length = 1000)
    private String notes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_ACCOUNT_APPRAISAL_DATE")
    private Date lastAccountAppraisalDate;

    @Column(name = "SCHEDULE_DUE_DATES_METHOD", length = 3, nullable = false)
    private String scheduleDueDatesMethod;

    @Column(name = "FIXED_DAYS_OF_MONTH", nullable = false)
    private Integer fixedDaysOfMonth;

    @Column(name = "TAX_RATE", precision = 3, scale = 2, nullable = false)
    private BigDecimal taxRate;

    @Column(name = "PENALTY_RATE", precision = 3, scale = 2, nullable = false)
    private BigDecimal penaltyRate;

    @Column(name = "PRINCIPAL_PAID", precision = 18, scale = 2, nullable = false)
    private BigDecimal principalPaid;


    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @ManyToOne
    @JoinColumn(name = "GUARANTY_ID", referencedColumnName = "GUARANTY_ID", insertable = false, updatable = false)
    private Guaranty guaranty;

    @OneToMany(mappedBy = "parentLoan", cascade = CascadeType.ALL)
    private List<Loan> childrenLoan;

    public Loan() {
    }

    public Loan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getGroupCompanyId() {
        return groupCompanyId;
    }

    public void setGroupCompanyId(Integer groupCompanyId) {
        this.groupCompanyId = groupCompanyId;
    }

    public String getGroupRoleId() {
        return groupRoleId;
    }

    public void setGroupRoleId(String groupRoleId) {
        this.groupRoleId = groupRoleId;
    }

    public Integer getGroClientId() {
        return groClientId;
    }

    public void setGroClientId(Integer groClientId) {
        this.groClientId = groClientId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLoanProductId() {
        return loanProductId;
    }

    public void setLoanProductId(Integer loanProductId) {
        this.loanProductId = loanProductId;
    }

    public Integer getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(Integer guarantyId) {
        this.guarantyId = guarantyId;
    }

    public String getAccountHolderType() {
        return accountHolderType;
    }

    public void setAccountHolderType(String accountHolderType) {
        this.accountHolderType = accountHolderType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrincipalDue() {
        return principalDue;
    }

    public void setPrincipalDue(BigDecimal principalDue) {
        this.principalDue = principalDue;
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

    public BigDecimal getPenalityDue() {
        return penalityDue;
    }

    public void setPenalityDue(BigDecimal penalityDue) {
        this.penalityDue = penalityDue;
    }

    public BigDecimal getPenalityPaid() {
        return penalityPaid;
    }

    public void setPenalityPaid(BigDecimal penalityPaid) {
        this.penalityPaid = penalityPaid;
    }

    public Integer getRepaymentPeriodCount() {
        return repaymentPeriodCount;
    }

    public void setRepaymentPeriodCount(Integer repaymentPeriodCount) {
        this.repaymentPeriodCount = repaymentPeriodCount;
    }

    public String getRepaymentPeriodUnit() {
        return repaymentPeriodUnit;
    }

    public void setRepaymentPeriodUnit(String repaymentPeriodUnit) {
        this.repaymentPeriodUnit = repaymentPeriodUnit;
    }

    public Integer getRepaymentInstallments() {
        return repaymentInstallments;
    }

    public void setRepaymentInstallments(Integer repaymentInstallments) {
        this.repaymentInstallments = repaymentInstallments;
    }

    public String getGracePeriodType() {
        return gracePeriodType;
    }

    public void setGracePeriodType(String gracePeriodType) {
        this.gracePeriodType = gracePeriodType;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getInterestChargeFrequence() {
        return interestChargeFrequence;
    }

    public void setInterestChargeFrequence(String interestChargeFrequence) {
        this.interestChargeFrequence = interestChargeFrequence;
    }

    public String getInterestCalculationMethod() {
        return interestCalculationMethod;
    }

    public void setInterestCalculationMethod(String interestCalculationMethod) {
        this.interestCalculationMethod = interestCalculationMethod;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getLastAccountAppraisalDate() {
        return lastAccountAppraisalDate;
    }

    public void setLastAccountAppraisalDate(Date lastAccountAppraisalDate) {
        this.lastAccountAppraisalDate = lastAccountAppraisalDate;
    }

    public String getScheduleDueDatesMethod() {
        return scheduleDueDatesMethod;
    }

    public void setScheduleDueDatesMethod(String scheduleDueDatesMethod) {
        this.scheduleDueDatesMethod = scheduleDueDatesMethod;
    }

    public Integer getFixedDaysOfMonth() {
        return fixedDaysOfMonth;
    }

    public void setFixedDaysOfMonth(Integer fixedDaysOfMonth) {
        this.fixedDaysOfMonth = fixedDaysOfMonth;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(BigDecimal penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    public BigDecimal getPrincipalPaid() {
        return principalPaid;
    }

    public void setPrincipalPaid(BigDecimal principalPaid) {
        this.principalPaid = principalPaid;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Guaranty getGuaranty() {
        return guaranty;
    }

    public void setGuaranty(Guaranty guaranty) {
        this.guaranty = guaranty;
    }

    public List<Loan> getChildrenLoan() {
        return childrenLoan;
    }

    public void setChildrenLoan(List<Loan> childrenLoan) {
        this.childrenLoan = childrenLoan;
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
        Loan other = (Loan) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Loan [id=" + id + ", clientId=" + clientId + ", groupCompanyId=" + groupCompanyId + ", groupRoleId="
                + groupRoleId + ", groClientId=" + groClientId + ", branchId=" + branchId + ", userId=" + userId
                + ", loanProductId=" + loanProductId + ", guarantyId=" + guarantyId + ", accountHolderType="
                + accountHolderType + ", creationDate=" + creationDate + ", approvedDate=" + approvedDate
                + ", lastModifiedDate=" + lastModifiedDate + ", state=" + state + ", name=" + name + ", amount="
                + amount + ", principalDue=" + principalDue + ", interestDue=" + interestDue + ", interestPaid="
                + interestPaid + ", feesDue=" + feesDue + ", feesPaid=" + feesPaid + ", penalityDue=" + penalityDue
                + ", penalityPaid=" + penalityPaid + ", repaymentPeriodCount=" + repaymentPeriodCount
                + ", repaymentPeriodUnit=" + repaymentPeriodUnit + ", repaymentInstallments=" + repaymentInstallments
                + ", gracePeriodType=" + gracePeriodType + ", gracePeriod=" + gracePeriod + ", interestRate="
                + interestRate + ", interestChargeFrequence=" + interestChargeFrequence + ", interestCalculationMethod="
                + interestCalculationMethod + ", notes=" + notes + ", lastAccountAppraisalDate="
                + lastAccountAppraisalDate + ", scheduleDueDatesMethod=" + scheduleDueDatesMethod
                + ", fixedDaysOfMonth=" + fixedDaysOfMonth + ", taxRate=" + taxRate + ", penaltyRate=" + penaltyRate
                + ", principalPaid=" + principalPaid + ", version=" + version + ", guaranty=" + guaranty
                + ", childrenLoan=" + childrenLoan + "]";
    }

   


    
}
