package ec.edu.espe.arquitectura.banquito.loan.model;


import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

@Entity
@Table(name = "LOAN PRODUCT")
public class LoanProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_PRODUCT_ID", nullable = false)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", insertable = false, updatable = false,nullable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFIED_DATE", insertable = false, updatable = false,nullable = false)
    private Date lastModifiedDate;

    @Column(name = "CAPPING_PERCENTAGE", precision = 18, scale = 2, nullable = false)
    private BigDecimal cappingPercentage;

    @Column(name = "CAPPING_METHOD", length = 3, nullable = false)
    private String cappingMethod;

    @Column(name = "INTEREST_TYPE", length = 3, nullable = false)
    private String interestType;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", length = 100, nullable = false)
    private String description;

    @Column(name = "DEFAUL_LOAN_AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal defaulLoanAmount;

    @Column(name = "MIN_LOAN_AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal minLoanAmount;

    @Column(name = "MAX_LOAN_AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal maxLoanAmount;

    @Column(name = "DEFAULT_NUM_INSTALLMENTS", nullable = false)
    private Integer defaulNumInstallments;

    @Column(name = "MIN_NUM_INSTALLMENTS", nullable = false)
    private Integer minNumInstallments;

    @Column(name = "MAX_NUM_INSTALLMENTS", nullable = false)
    private Integer maxNumInstallments;

    @Column(name = "DEFAULT_GRACE_PERIOD", nullable = false)
    private Integer defaultGracePeriod;

    @Column(name = "MIN_GRACE_PERIOD", nullable = false)
    private Integer minGracePeriod;

    @Column(name = "MAX_GRACE_PERIOD", nullable = false)
    private Integer maxGracePeriod;

    @Column(name = "GRACE_PERIOD_TYPE", length = 3, nullable = false)
    private String gracePeriodType;

    @Column(name = "DEFAULT_REAYMENT_PERIOD_COUNT", nullable = false)
    private Integer defaultReaymentPeriodCount;

    @Column(name = "REPAYMENT_PERIOD_UNIT", length = 3, nullable = false)
    private String repaymentPeriodUnit;

    @Column(name = "DEFAULT_PENALTY_RATE", precision = 3, scale = 2, nullable = false)
    private BigDecimal defaultPenaltyRate;

    @Column(name = "MIN_PENALTY_RATE", precision = 3, scale = 2, nullable = false)
    private BigDecimal minPenaltyRate;

    @Column(name = "MAX_PENALTY_RATE", precision = 3, scale = 2, nullable = false)
    private BigDecimal maxPenaltyRate;

    @Column(name = "INTEREST_CALCULATION_METHOD", length = 3, nullable = false)
    private String interestCalculationMethod;

    @Column(name = "LOAN_PENALTY_CALCULATION_METHOD", length = 3, nullable = false)
    private String loanPenaltyCalculationMethod;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ARREARS_SETTINGS_ID", referencedColumnName = "PRODUCT_ARREARS_SETTING_ID", insertable = false, updatable = false, nullable = false)
    private ProductArrearsSetting producArrearsSetting;

    public LoanProduct() {
    }

    public LoanProduct(Integer id) {
        this.id = id;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getCappingPercentage() {
        return cappingPercentage;
    }

    public void setCappingPercentage(BigDecimal cappingPercentage) {
        this.cappingPercentage = cappingPercentage;
    }

    public String getCappingMethod() {
        return cappingMethod;
    }

    public void setCappingMethod(String cappingMethod) {
        this.cappingMethod = cappingMethod;
    }

    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDefaulLoanAmount() {
        return defaulLoanAmount;
    }

    public void setDefaulLoanAmount(BigDecimal defaulLoanAmount) {
        this.defaulLoanAmount = defaulLoanAmount;
    }

    public BigDecimal getMinLoanAmount() {
        return minLoanAmount;
    }

    public void setMinLoanAmount(BigDecimal minLoanAmount) {
        this.minLoanAmount = minLoanAmount;
    }

    public BigDecimal getMaxLoanAmount() {
        return maxLoanAmount;
    }

    public void setMaxLoanAmount(BigDecimal maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
    }

    public Integer getDefaulNumInstallments() {
        return defaulNumInstallments;
    }

    public void setDefaulNumInstallments(Integer defaulNumInstallments) {
        this.defaulNumInstallments = defaulNumInstallments;
    }

    public Integer getMinNumInstallments() {
        return minNumInstallments;
    }

    public void setMinNumInstallments(Integer minNumInstallments) {
        this.minNumInstallments = minNumInstallments;
    }

    public Integer getMaxNumInstallments() {
        return maxNumInstallments;
    }

    public void setMaxNumInstallments(Integer maxNumInstallments) {
        this.maxNumInstallments = maxNumInstallments;
    }

    public Integer getDefaultGracePeriod() {
        return defaultGracePeriod;
    }

    public void setDefaultGracePeriod(Integer defaultGracePeriod) {
        this.defaultGracePeriod = defaultGracePeriod;
    }

    public Integer getMinGracePeriod() {
        return minGracePeriod;
    }

    public void setMinGracePeriod(Integer minGracePeriod) {
        this.minGracePeriod = minGracePeriod;
    }

    public Integer getMaxGracePeriod() {
        return maxGracePeriod;
    }

    public void setMaxGracePeriod(Integer maxGracePeriod) {
        this.maxGracePeriod = maxGracePeriod;
    }

    public String getGracePeriodType() {
        return gracePeriodType;
    }

    public void setGracePeriodType(String gracePeriodType) {
        this.gracePeriodType = gracePeriodType;
    }

    public Integer getDefaultReaymentPeriodCount() {
        return defaultReaymentPeriodCount;
    }

    public void setDefaultReaymentPeriodCount(Integer defaultReaymentPeriodCount) {
        this.defaultReaymentPeriodCount = defaultReaymentPeriodCount;
    }

    public String getRepaymentPeriodUnit() {
        return repaymentPeriodUnit;
    }

    public void setRepaymentPeriodUnit(String repaymentPeriodUnit) {
        this.repaymentPeriodUnit = repaymentPeriodUnit;
    }

    public BigDecimal getDefaultPenaltyRate() {
        return defaultPenaltyRate;
    }

    public void setDefaultPenaltyRate(BigDecimal defaultPenaltyRate) {
        this.defaultPenaltyRate = defaultPenaltyRate;
    }

    public BigDecimal getMinPenaltyRate() {
        return minPenaltyRate;
    }

    public void setMinPenaltyRate(BigDecimal minPenaltyRate) {
        this.minPenaltyRate = minPenaltyRate;
    }

    public BigDecimal getMaxPenaltyRate() {
        return maxPenaltyRate;
    }

    public void setMaxPenaltyRate(BigDecimal maxPenaltyRate) {
        this.maxPenaltyRate = maxPenaltyRate;
    }

    public String getInterestCalculationMethod() {
        return interestCalculationMethod;
    }

    public void setInterestCalculationMethod(String interestCalculationMethod) {
        this.interestCalculationMethod = interestCalculationMethod;
    }

    public String getLoanPenaltyCalculationMethod() {
        return loanPenaltyCalculationMethod;
    }

    public void setLoanPenaltyCalculationMethod(String loanPenaltyCalculationMethod) {
        this.loanPenaltyCalculationMethod = loanPenaltyCalculationMethod;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public ProductArrearsSetting getProducArrearsSetting() {
        return producArrearsSetting;
    }

    public void setProducArrearsSetting(ProductArrearsSetting producArrearsSetting) {
        this.producArrearsSetting = producArrearsSetting;
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
        LoanProduct other = (LoanProduct) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    
    @Override
    public String toString() {
        return "LoanProduct [id=" + id + ", creationDate=" + creationDate + ", lastModifiedDate=" + lastModifiedDate
                + ", cappingPercentage=" + cappingPercentage + ", cappingMethod=" + cappingMethod + ", interestType="
                + interestType + ", name=" + name + ", description=" + description + ", defaulLoanAmount="
                + defaulLoanAmount + ", minLoanAmount=" + minLoanAmount + ", maxLoanAmount=" + maxLoanAmount
                + ", defaulNumInstallments=" + defaulNumInstallments + ", minNumInstallments=" + minNumInstallments
                + ", maxNumInstallments=" + maxNumInstallments + ", defaultGracePeriod=" + defaultGracePeriod
                + ", minGracePeriod=" + minGracePeriod + ", maxGracePeriod=" + maxGracePeriod + ", gracePeriodType="
                + gracePeriodType + ", defaultReaymentPeriodCount=" + defaultReaymentPeriodCount
                + ", repaymentPeriodUnit=" + repaymentPeriodUnit + ", defaultPenaltyRate=" + defaultPenaltyRate
                + ", minPenaltyRate=" + minPenaltyRate + ", maxPenaltyRate=" + maxPenaltyRate
                + ", interestCalculationMethod=" + interestCalculationMethod + ", loanPenaltyCalculationMethod="
                + loanPenaltyCalculationMethod + ", version=" + version + ", producArrearsSetting="
                + producArrearsSetting + "]";
    }

     
}
