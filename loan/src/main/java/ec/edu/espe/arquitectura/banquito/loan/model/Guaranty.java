package ec.edu.espe.arquitectura.banquito.loan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "GUARANTY")
@Data
@Builder
public class Guaranty {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GUARANTY_ID", nullable = false)
    private Integer id;

    // Foreign Keys
    @Column(name = "CLIENT_ID", length = 50)
    private String clientId;

    @Column(name = "GROUP_COMPANY_ID", length = 50)
    private String groupCompanyId;

    // Attributes
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
}
