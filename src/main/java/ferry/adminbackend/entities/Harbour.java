/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ferry.adminbackend.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kasper
 */
@Entity
@Table(name = "HARBOUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Harbour.findAll", query = "SELECT h FROM Harbour h"),
    @NamedQuery(name = "Harbour.findById", query = "SELECT h FROM Harbour h WHERE h.id = :id"),
    @NamedQuery(name = "Harbour.findByName", query = "SELECT h FROM Harbour h WHERE h.name = :name")})
public class Harbour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 60)
    @Column(name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "harbourCollection")
    private Collection<Ferry> ferryCollection;
    @OneToMany(mappedBy = "idOrigin")
    private Collection<Route> routeCollection;
    @OneToMany(mappedBy = "idDestination")
    private Collection<Route> routeCollection1;

    public Harbour() {
    }

    public Harbour(Integer id) {
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

    @XmlTransient
    public Collection<Ferry> getFerryCollection() {
        return ferryCollection;
    }

    public void setFerryCollection(Collection<Ferry> ferryCollection) {
        this.ferryCollection = ferryCollection;
    }

    @XmlTransient
    public Collection<Route> getRouteCollection() {
        return routeCollection;
    }

    public void setRouteCollection(Collection<Route> routeCollection) {
        this.routeCollection = routeCollection;
    }

    @XmlTransient
    public Collection<Route> getRouteCollection1() {
        return routeCollection1;
    }

    public void setRouteCollection1(Collection<Route> routeCollection1) {
        this.routeCollection1 = routeCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Harbour)) {
            return false;
        }
        Harbour other = (Harbour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferry.adminbackend.entities.Harbour[ id=" + id + " ]";
    }
    
}
