package gov.alaska.escdataloader.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mhspellecacy
 */
@Entity
@Table(name = "S_ESC_COUNT", catalog = "", schema = "DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SEscCount.findAll", query = "SELECT s FROM SEscCount s"),
    @NamedQuery(name = "SEscCount.findByCountId", query = "SELECT s FROM SEscCount s WHERE s.countId = :countId"),
    @NamedQuery(name = "SEscCount.findByEscObsSiteCode", query = "SELECT s FROM SEscCount s WHERE s.escObsSiteCode = :escObsSiteCode"),
    @NamedQuery(name = "SEscCount.findByCountDate", query = "SELECT s FROM SEscCount s WHERE s.countDate = :countDate"),
    @NamedQuery(name = "SEscCount.findByWaterTempCelsius", query = "SELECT s FROM SEscCount s WHERE s.waterTempCelsius = :waterTempCelsius"),
    @NamedQuery(name = "SEscCount.findByWaterLevelMeters", query = "SELECT s FROM SEscCount s WHERE s.waterLevelMeters = :waterLevelMeters"),
    @NamedQuery(name = "SEscCount.findByComments", query = "SELECT s FROM SEscCount s WHERE s.comments = :comments")})
public class SEscCount implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "COUNT_ID")
    private BigDecimal countId;
    @Basic(optional = false)
    @Column(name = "ESC_OBS_SITE_CODE")
    private String escObsSiteCode;
    @Basic(optional = false)
    @Column(name = "COUNT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date countDate;
    @Column(name = "WATER_TEMP_CELSIUS")
    private BigDecimal waterTempCelsius;
    @Column(name = "WATER_LEVEL_METERS")
    private BigDecimal waterLevelMeters;
    @Column(name = "COMMENTS")
    private String comments;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countId")
    private Collection<SEscCountItem> sEscCountItemCollection;
    @JoinColumns({
        @JoinColumn(name = "OBSERVER_CODE", referencedColumnName = "OBSERVER_CODE"),
        @JoinColumn(name = "YEAR", referencedColumnName = "YEAR")})
    @ManyToOne(optional = false)
    private Observer observer;

    public SEscCount() {
    }

    public SEscCount(BigDecimal countId) {
        this.countId = countId;
    }

    public SEscCount(BigDecimal countId, String escObsSiteCode, Date countDate) {
        this.countId = countId;
        this.escObsSiteCode = escObsSiteCode;
        this.countDate = countDate;
    }

    public BigDecimal getCountId() {
        return countId;
    }

    public void setCountId(BigDecimal countId) {
        this.countId = countId;
    }

    public String getEscObsSiteCode() {
        return escObsSiteCode;
    }

    public void setEscObsSiteCode(String escObsSiteCode) {
        this.escObsSiteCode = escObsSiteCode;
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }

    public BigDecimal getWaterTempCelsius() {
        return waterTempCelsius;
    }

    public void setWaterTempCelsius(BigDecimal waterTempCelsius) {
        this.waterTempCelsius = waterTempCelsius;
    }

    public BigDecimal getWaterLevelMeters() {
        return waterLevelMeters;
    }

    public void setWaterLevelMeters(BigDecimal waterLevelMeters) {
        this.waterLevelMeters = waterLevelMeters;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @XmlTransient
    public Collection<SEscCountItem> getSEscCountItemCollection() {
        return sEscCountItemCollection;
    }

    public void setSEscCountItemCollection(Collection<SEscCountItem> sEscCountItemCollection) {
        this.sEscCountItemCollection = sEscCountItemCollection;
    }

    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countId != null ? countId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SEscCount)) {
            return false;
        }
        SEscCount other = (SEscCount) object;
        if ((this.countId == null && other.countId != null) || (this.countId != null && !this.countId.equals(other.countId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.alaska.escdataloader.core.SEscCount[ countId=" + countId + " ]";
    }
    
}
