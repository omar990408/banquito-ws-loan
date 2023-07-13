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
@Table(name = "LOAN_PRODUCT_BRANCH")
public class LoanProductBranch {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_PRODUCT_BRANCH_ID", nullable = false)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    private Date lastModifiedDate;
    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;
    
    @ManyToOne
    @JoinColumn(name = "BRANCH_ID", referencedColumnName = "BRANCH_ID", insertable = false, updatable = false, nullable = false)
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "LOAN_PRODUCT_ID", referencedColumnName = "LOAN_PRODUCT_ID", insertable = false, updatable = false, nullable = false)
    private LoanProduct loanProducto;
    public LoanProductBranch() {
    }
    public LoanProductBranch(Integer id) {
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }
    public Branch getBranch() {
        return branch;
    }
    public void setBranch(Branch branch) {
        this.branch = branch;
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
        LoanProductBranch other = (LoanProductBranch) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "LoanProductBranch [id=" + id + ", creationDate=" + creationDate + ", lastModifiedDate="
                + lastModifiedDate + ", status=" + status + ", version=" + version + ", branch=" + branch
                + ", loanProducto=" + loanProducto + "]";
    }

    

}
