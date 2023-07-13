package ec.edu.espe.arquitectura.banquito.loan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "PRODUCT_ARREARS_SETTING")
public class ProductArrearsSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ARREARS_SETTING_ID", nullable = false)
    private Integer id;

    @Column(name = "DEFAULT_TOLERANCE_PERIOD", nullable = false)
    private Integer defaultTolerancePeriod;
    @Column(name = "MIN_TOLERANCE_PERIOD", nullable = false)
    private Integer minTolerancePeriod;
    @Column(name = "MAX_TOLERANCE_PERIOD", nullable = false)
    private Integer maxTolerancePeriod;
    @Column(name = "MONTHLY_TOLERANCE_DAY", nullable = false)
    private Integer monthlyToleranceDay;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    public ProductArrearsSetting() {
    }

    public ProductArrearsSetting(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDefaultTolerancePeriod() {
        return defaultTolerancePeriod;
    }

    public void setDefaultTolerancePeriod(Integer defaultTolerancePeriod) {
        this.defaultTolerancePeriod = defaultTolerancePeriod;
    }

    public Integer getMinTolerancePeriod() {
        return minTolerancePeriod;
    }

    public void setMinTolerancePeriod(Integer minTolerancePeriod) {
        this.minTolerancePeriod = minTolerancePeriod;
    }

    public Integer getMaxTolerancePeriod() {
        return maxTolerancePeriod;
    }

    public void setMaxTolerancePeriod(Integer maxTolerancePeriod) {
        this.maxTolerancePeriod = maxTolerancePeriod;
    }

    public Integer getMonthlyToleranceDay() {
        return monthlyToleranceDay;
    }

    public void setMonthlyToleranceDay(Integer monthlyToleranceDay) {
        this.monthlyToleranceDay = monthlyToleranceDay;
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
        ProductArrearsSetting other = (ProductArrearsSetting) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductArrearsSetting [id=" + id + ", defaultTolerancePeriod=" + defaultTolerancePeriod
                + ", minTolerancePeriod=" + minTolerancePeriod + ", maxTolerancePeriod=" + maxTolerancePeriod
                + ", monthlyToleranceDay=" + monthlyToleranceDay + ", version=" + version + "]";
    }
}
