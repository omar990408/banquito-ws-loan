package ec.edu.espe.arquitectura.banquito.loan.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "GUARANTY")
public class Guaranty {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GUARANTY_ID", nullable = false)
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

    // Attributes
    @Column(name = "AMOUNT", precision = 18, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "ASSET_NAME", length = 100, nullable = false)
    private String assetName;

    @Column(name = "TYPE", length = 3, nullable = false)
    private String type;

    @Column(name = "GUARANTOR_TYPE", length = 3, nullable = false)
    private String guarantorType;

    @Column(name = "STATE", length = 3, nullable = false)
    private String state;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID", insertable = false, updatable = false)
    private Client client;

    public Guaranty() {
    }

    public Guaranty(Integer id) {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGuarantorType() {
        return guarantorType;
    }

    public void setGuarantorType(String guarantorType) {
        this.guarantorType = guarantorType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        Guaranty other = (Guaranty) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Guaranty [id=" + id + ", clientId=" + clientId + ", groupCompanyId=" + groupCompanyId + ", groupRoleId="
                + groupRoleId + ", groClientId=" + groClientId + ", amount=" + amount + ", assetName=" + assetName
                + ", type=" + type + ", guarantorType=" + guarantorType + ", state=" + state + ", version=" + version
                + ", client=" + client + "]";
    } 
}
