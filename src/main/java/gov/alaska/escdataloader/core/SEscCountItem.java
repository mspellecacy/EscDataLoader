package gov.alaska.escdataloader.core;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mhspellecacy
 */
@Entity
@Table(name = "S_ESC_COUNT_ITEM", catalog = "", schema = "DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SEscCountItem.findAll", query = "SELECT s FROM SEscCountItem s"),
    @NamedQuery(name = "SEscCountItem.findByCountItemId", query = "SELECT s FROM SEscCountItem s WHERE s.countItemId = :countItemId"),
    @NamedQuery(name = "SEscCountItem.findBySpeciesCode", query = "SELECT s FROM SEscCountItem s WHERE s.speciesCode = :speciesCode"),
    @NamedQuery(name = "SEscCountItem.findByAgeAtMaturityCode", query = "SELECT s FROM SEscCountItem s WHERE s.ageAtMaturityCode = :ageAtMaturityCode"),
    @NamedQuery(name = "SEscCountItem.findByEscCountTypeCode", query = "SELECT s FROM SEscCountItem s WHERE s.escCountTypeCode = :escCountTypeCode"),
    @NamedQuery(name = "SEscCountItem.findByCount0600", query = "SELECT s FROM SEscCountItem s WHERE s.count0600 = :count0600"),
    @NamedQuery(name = "SEscCountItem.findByCountDaily", query = "SELECT s FROM SEscCountItem s WHERE s.countDaily = :countDaily")})
public class SEscCountItem implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "COUNT_ITEM_ID")
    private BigDecimal countItemId;
    @Basic(optional = false)
    @Column(name = "SPECIES_CODE")
    private String speciesCode;
    @Basic(optional = false)
    @Column(name = "AGE_AT_MATURITY_CODE")
    private String ageAtMaturityCode;
    @Basic(optional = false)
    @Column(name = "ESC_COUNT_TYPE_CODE")
    private String escCountTypeCode;
    @Column(name = "COUNT_0600")
    private Integer count0600;
    @Column(name = "COUNT_DAILY")
    private Integer countDaily;
    @JoinColumn(name = "COUNT_ID", referencedColumnName = "COUNT_ID")
    @ManyToOne(optional = false)
    private SEscCount countId;

    public SEscCountItem() {
    }

    public SEscCountItem(BigDecimal countItemId) {
        this.countItemId = countItemId;
    }

    public SEscCountItem(BigDecimal countItemId, String speciesCode, String ageAtMaturityCode, String escCountTypeCode) {
        this.countItemId = countItemId;
        this.speciesCode = speciesCode;
        this.ageAtMaturityCode = ageAtMaturityCode;
        this.escCountTypeCode = escCountTypeCode;
    }

    public BigDecimal getCountItemId() {
        return countItemId;
    }

    public void setCountItemId(BigDecimal countItemId) {
        this.countItemId = countItemId;
    }

    public String getSpeciesCode() {
        return speciesCode;
    }

    public void setSpeciesCode(String speciesCode) {
        this.speciesCode = speciesCode;
    }

    public String getAgeAtMaturityCode() {
        return ageAtMaturityCode;
    }

    public void setAgeAtMaturityCode(String ageAtMaturityCode) {
        this.ageAtMaturityCode = ageAtMaturityCode;
    }

    public String getEscCountTypeCode() {
        return escCountTypeCode;
    }

    public void setEscCountTypeCode(String escCountTypeCode) {
        this.escCountTypeCode = escCountTypeCode;
    }

    public Integer getCount0600() {
        return count0600;
    }

    public void setCount0600(Integer count0600) {
        this.count0600 = count0600;
    }

    public Integer getCountDaily() {
        return countDaily;
    }

    public void setCountDaily(Integer countDaily) {
        this.countDaily = countDaily;
    }

    public SEscCount getCountId() {
        return countId;
    }

    public void setCountId(SEscCount countId) {
        this.countId = countId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countItemId != null ? countItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SEscCountItem)) {
            return false;
        }
        SEscCountItem other = (SEscCountItem) object;
        if ((this.countItemId == null && other.countItemId != null) || (this.countItemId != null && !this.countItemId.equals(other.countItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.alaska.escdataloader.core.SEscCountItem[ countItemId=" + countItemId + " ]";
    }
    
}
