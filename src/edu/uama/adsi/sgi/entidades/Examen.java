/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uama.adsi.sgi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
@Entity
@Table(name = "examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByProductoExamen", query = "SELECT e FROM Examen e WHERE e.productoExamen = :productoExamen"),
    @NamedQuery(name = "Examen.findByInstitucionExamen", query = "SELECT e FROM Examen e WHERE e.institucionExamen = :institucionExamen"),
    @NamedQuery(name = "Examen.findByGradoExamen", query = "SELECT e FROM Examen e WHERE e.gradoExamen = :gradoExamen")})
public class Examen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "producto_examen")
    private Integer productoExamen;
    @Basic(optional = false)
    @Column(name = "institucion_examen")
    private String institucionExamen;
    @Basic(optional = false)
    @Column(name = "grado_examen")
    private short gradoExamen;
    @JoinColumn(name = "producto_examen", referencedColumnName = "idproducto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Producto producto;

    public Examen() {
    }

    public Examen(Integer productoExamen) {
        this.productoExamen = productoExamen;
    }

    public Examen(Integer productoExamen, String institucionExamen, short gradoExamen) {
        this.productoExamen = productoExamen;
        this.institucionExamen = institucionExamen;
        this.gradoExamen = gradoExamen;
    }

    public Integer getProductoExamen() {
        return productoExamen;
    }

    public void setProductoExamen(Integer productoExamen) {
        this.productoExamen = productoExamen;
    }

    public String getInstitucionExamen() {
        return institucionExamen;
    }

    public void setInstitucionExamen(String institucionExamen) {
        this.institucionExamen = institucionExamen;
    }

    public short getGradoExamen() {
        return gradoExamen;
    }

    public void setGradoExamen(short gradoExamen) {
        this.gradoExamen = gradoExamen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoExamen != null ? productoExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.productoExamen == null && other.productoExamen != null) || (this.productoExamen != null && !this.productoExamen.equals(other.productoExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Examen[ productoExamen=" + productoExamen + " ]";
    }

}
