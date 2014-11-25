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
@Table(name = "software")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Software.findAll", query = "SELECT s FROM Software s"),
    @NamedQuery(name = "Software.findByProductoSoftware", query = "SELECT s FROM Software s WHERE s.productoSoftware = :productoSoftware"),
    @NamedQuery(name = "Software.findByLenguajeSoftware", query = "SELECT s FROM Software s WHERE s.lenguajeSoftware = :lenguajeSoftware"),
    @NamedQuery(name = "Software.findByVinculadoSoftware", query = "SELECT s FROM Software s WHERE s.vinculadoSoftware = :vinculadoSoftware")})
public class Software implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "producto_software")
    private Integer productoSoftware;
    @Basic(optional = false)
    @Column(name = "lenguaje_software")
    private String lenguajeSoftware;
    @Column(name = "vinculado_software")
    private String vinculadoSoftware;
    @JoinColumn(name = "producto_software", referencedColumnName = "idproducto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Producto producto;

    public Software() {
    }

    public Software(Integer productoSoftware) {
        this.productoSoftware = productoSoftware;
    }

    public Software(Integer productoSoftware, String lenguajeSoftware) {
        this.productoSoftware = productoSoftware;
        this.lenguajeSoftware = lenguajeSoftware;
    }

    public Integer getProductoSoftware() {
        return productoSoftware;
    }

    public void setProductoSoftware(Integer productoSoftware) {
        this.productoSoftware = productoSoftware;
    }

    public String getLenguajeSoftware() {
        return lenguajeSoftware;
    }

    public void setLenguajeSoftware(String lenguajeSoftware) {
        this.lenguajeSoftware = lenguajeSoftware;
    }

    public String getVinculadoSoftware() {
        return vinculadoSoftware;
    }

    public void setVinculadoSoftware(String vinculadoSoftware) {
        this.vinculadoSoftware = vinculadoSoftware;
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
        hash += (productoSoftware != null ? productoSoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Software)) {
            return false;
        }
        Software other = (Software) object;
        if ((this.productoSoftware == null && other.productoSoftware != null) || (this.productoSoftware != null && !this.productoSoftware.equals(other.productoSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Software[ productoSoftware=" + productoSoftware + " ]";
    }

}
