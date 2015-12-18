package gov.alaska.escdataloader.core;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mhspellecacy
 */
@Entity
@Table(name = "OBSERVER", catalog = "", schema = "DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observer.findAll", query = "SELECT o FROM Observer o"),
    @NamedQuery(name = "Observer.findByObserverCode", query = "SELECT o FROM Observer o WHERE o.observerPK.observerCode = :observerCode"),
    @NamedQuery(name = "Observer.findByYear", query = "SELECT o FROM Observer o WHERE o.observerPK.year = :year"),
    @NamedQuery(name = "Observer.findBySManagementAreaCode", query = "SELECT o FROM Observer o WHERE o.sManagementAreaCode = :sManagementAreaCode"),
    @NamedQuery(name = "Observer.findByFirstName", query = "SELECT o FROM Observer o WHERE o.firstName = :firstName"),
    @NamedQuery(name = "Observer.findByMiddleInitial", query = "SELECT o FROM Observer o WHERE o.middleInitial = :middleInitial"),
    @NamedQuery(name = "Observer.findByLastName", query = "SELECT o FROM Observer o WHERE o.lastName = :lastName"),
    @NamedQuery(name = "Observer.findByComments", query = "SELECT o FROM Observer o WHERE o.comments = :comments")})
public class Observer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObserverPK observerPK;
    @Basic(optional = false)
    @Column(name = "S_MANAGEMENT_AREA_CODE")
    private Character sManagementAreaCode;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_INITIAL")
    private String middleInitial;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "COMMENTS")
    private String comments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observer")
    private Collection<SEscCount> sEscCountCollection;

    public Observer() {
    }

    public Observer(ObserverPK observerPK) {
        this.observerPK = observerPK;
    }

    public Observer(ObserverPK observerPK, Character sManagementAreaCode, String firstName, String lastName) {
        this.observerPK = observerPK;
        this.sManagementAreaCode = sManagementAreaCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Observer(String observerCode, BigInteger year) {
        this.observerPK = new ObserverPK(observerCode, year);
    }

    public ObserverPK getObserverPK() {
        return observerPK;
    }

    public void setObserverPK(ObserverPK observerPK) {
        this.observerPK = observerPK;
    }

    public Character getSManagementAreaCode() {
        return sManagementAreaCode;
    }

    public void setSManagementAreaCode(Character sManagementAreaCode) {
        this.sManagementAreaCode = sManagementAreaCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @XmlTransient
    public Collection<SEscCount> getSEscCountCollection() {
        return sEscCountCollection;
    }

    public void setSEscCountCollection(Collection<SEscCount> sEscCountCollection) {
        this.sEscCountCollection = sEscCountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observerPK != null ? observerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observer)) {
            return false;
        }
        Observer other = (Observer) object;
        if ((this.observerPK == null && other.observerPK != null) || (this.observerPK != null && !this.observerPK.equals(other.observerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.alaska.escdataloader.core.Observer[ observerPK=" + observerPK + " ]";
    }
    
}
