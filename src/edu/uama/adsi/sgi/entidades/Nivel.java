/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uama.adsi.sgi.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
@Entity
@Table(name = "nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n"),
    @NamedQuery(name = "Nivel.findByIdnivel", query = "SELECT n FROM Nivel n WHERE n.idnivel = :idnivel"),
    @NamedQuery(name = "Nivel.findByDescripcionNivel", query = "SELECT n FROM Nivel n WHERE n.descripcionNivel = :descripcionNivel")})
public class Nivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivel")
    private Integer idnivel;
    @Basic(optional = false)
    @Column(name = "descripcion_nivel")
    private String descripcionNivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelProfesor")
    private List<Profesor> profesorList;

    public Nivel() {
    }

    public Nivel(Integer idnivel) {
        this.idnivel = idnivel;
    }

    public Nivel(Integer idnivel, String descripcionNivel) {
        this.idnivel = idnivel;
        this.descripcionNivel = descripcionNivel;
    }

    public Integer getIdnivel() {
        return idnivel;
    }

    public void setIdnivel(Integer idnivel) {
        this.idnivel = idnivel;
    }

    public String getDescripcionNivel() {
        return descripcionNivel;
    }

    public void setDescripcionNivel(String descripcionNivel) {
        this.descripcionNivel = descripcionNivel;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivel != null ? idnivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.idnivel == null && other.idnivel != null) || (this.idnivel != null && !this.idnivel.equals(other.idnivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Nivel[ idnivel=" + idnivel + " ]";
    }

}
