package ec.edu.espe.arquitectura.banquito.loan.model;


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
@Table(name = "TRANSACTION_CHANNEL")
public class TransactionChannel {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_CHANNEL_ID", nullable = false)
    private Integer id;

    // Attributes
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;

    @Column(name = "ACTIVATED", nullable = false)
    private Boolean activated;

    @Column(name = "LOAN_CONSTRAINS_USAGE", length = 3, nullable = false)
    private String loanConstrainsUsage;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    public TransactionChannel() {
    }

    public TransactionChannel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getLoanConstrainsUsage() {
        return loanConstrainsUsage;
    }

    public void setLoanConstrainsUsage(String loanConstrainsUsage) {
        this.loanConstrainsUsage = loanConstrainsUsage;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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
        TransactionChannel other = (TransactionChannel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TransactionChannel [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", activated="
                + activated + ", loanConstrainsUsage=" + loanConstrainsUsage + ", version=" + version + "]";
    }

}
