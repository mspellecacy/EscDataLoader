package gov.alaska.escdataloader.core;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author mhspellecacy
 */
@Embeddable
public class ObserverPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "OBSERVER_CODE")
    private String observerCode;
    @Basic(optional = false)
    @Column(name = "YEAR")
    private BigInteger year;

    public ObserverPK() {
    }

    public ObserverPK(String observerCode, BigInteger year) {
        this.observerCode = observerCode;
        this.year = year;
    }

    public String getObserverCode() {
        return observerCode;
    }

    public void setObserverCode(String observerCode) {
        this.observerCode = observerCode;
    }

    public BigInteger getYear() {
        return year;
    }

    public void setYear(BigInteger year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observerCode != null ? observerCode.hashCode() : 0);
        hash += (year != null ? year.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObserverPK)) {
            return false;
        }
        ObserverPK other = (ObserverPK) object;
        if ((this.observerCode == null && other.observerCode != null) || (this.observerCode != null && !this.observerCode.equals(other.observerCode))) {
            return false;
        }
        if ((this.year == null && other.year != null) || (this.year != null && !this.year.equals(other.year))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.alaska.escdataloader.core.ObserverPK[ observerCode=" + observerCode + ", year=" + year + " ]";
    }
    
}
