package ec.edu.espe.arquitectura.banquito.loan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "LOAN_REQUIREMENT")
public class LoanRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_REQUIREMENT_ID", nullable = false)
    private Integer id;
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
    @Column(name = "DESCRIPTION", length = 1000, nullable = false)
    private String description;
    @Column(name = "TYPE", length = 3, nullable = false)
    private String type;
    @Column(name = "DOCUMENTATION", length = 300, nullable = false)
    private String documentation;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;
    public LoanRequirement() {
    }
    public LoanRequirement(Integer id) {
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDocumentation() {
        return documentation;
    }
    public void setDocumentation(String documentation) {
        this.documentation = documentation;
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
        LoanRequirement other = (LoanRequirement) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "LoanRequirement [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type
                + ", documentation=" + documentation + ", version=" + version + "]";
    }

    
}
