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
@Table(name = "REQUIREMENT_VALUE")
public class RequirementValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REQUIREMENT_VALUE_ID", nullable = false)
    private Integer id;
    @Column(name = "NUMBER_FIELD", precision = 18, scale = 2, nullable = false)
    private BigDecimal numberField;
    @Column(name = "FREE_TEXT_FIELD", length = 100, nullable = false)
    private String freeTextField;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_FIELD", nullable = false)
    private Date dateField;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATATIME_FIELD", insertable = false, updatable = false,nullable = false)
    private Date datetimeField;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @ManyToOne
    @JoinColumn(name = "LOAN_REQUIREMENT_ID", referencedColumnName = "LOAN_REQUIREMENT_ID", insertable = false, updatable = false, nullable = false)
    private LoanRequirement loanRequirement;
    @ManyToOne
    @JoinColumn(name = "LOAN_PRODUCT_ID", referencedColumnName = "LOAN_PRODUCT_ID", insertable = false, updatable = false, nullable = false)
    private LoanProduct loanProducto;
    public RequirementValue() {
    }
    public RequirementValue(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public BigDecimal getNumberField() {
        return numberField;
    }
    public void setNumberField(BigDecimal numberField) {
        this.numberField = numberField;
    }
    public String getFreeTextField() {
        return freeTextField;
    }
    public void setFreeTextField(String freeTextField) {
        this.freeTextField = freeTextField;
    }
    public Date getDateField() {
        return dateField;
    }
    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }
    public Date getDatetimeField() {
        return datetimeField;
    }
    public void setDatetimeField(Date datetimeField) {
        this.datetimeField = datetimeField;
    }
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }
    public LoanRequirement getLoanRequirement() {
        return loanRequirement;
    }
    public void setLoanRequirement(LoanRequirement loanRequirement) {
        this.loanRequirement = loanRequirement;
    }
    public LoanProduct getLoanProducto() {
        return loanProducto;
    }
    public void setLoanProducto(LoanProduct loanProducto) {
        this.loanProducto = loanProducto;
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
        RequirementValue other = (RequirementValue) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "RequirementValue [id=" + id + ", numberField=" + numberField + ", freeTextField=" + freeTextField
                + ", dateField=" + dateField + ", datetimeField=" + datetimeField + ", version=" + version
                + ", loanRequirement=" + loanRequirement + ", loanProducto=" + loanProducto + "]";
    }

    
}
