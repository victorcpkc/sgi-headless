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
@Table(name = "taller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taller.findAll", query = "SELECT t FROM Taller t"),
    @NamedQuery(name = "Taller.findByProductoTaller", query = "SELECT t FROM Taller t WHERE t.productoTaller = :productoTaller"),
    @NamedQuery(name = "Taller.findByTrimestreTaller", query = "SELECT t FROM Taller t WHERE t.trimestreTaller = :trimestreTaller"),
    @NamedQuery(name = "Taller.findByHorasTaller", query = "SELECT t FROM Taller t WHERE t.horasTaller = :horasTaller"),
    @NamedQuery(name = "Taller.findByGrupoTaller", query = "SELECT t FROM Taller t WHERE t.grupoTaller = :grupoTaller")})
public class Taller implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "producto_taller")
    private Integer productoTaller;
    @Basic(optional = false)
    @Column(name = "trimestre_taller")
    private String trimestreTaller;
    @Basic(optional = false)
    @Column(name = "horas_taller")
    private double horasTaller;
    @Column(name = "grupo_taller")
    private String grupoTaller;
    @JoinColumn(name = "producto_taller", referencedColumnName = "idproducto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Producto producto;

    public Taller() {
    }

    public Taller(Integer productoTaller) {
        this.productoTaller = productoTaller;
    }

    public Taller(Integer productoTaller, String trimestreTaller, double horasTaller) {
        this.productoTaller = productoTaller;
        this.trimestreTaller = trimestreTaller;
        this.horasTaller = horasTaller;
    }

    public Integer getProductoTaller() {
        return productoTaller;
    }

    public void setProductoTaller(Integer productoTaller) {
        this.productoTaller = productoTaller;
    }

    public String getTrimestreTaller() {
        return trimestreTaller;
    }

    public void setTrimestreTaller(String trimestreTaller) {
        this.trimestreTaller = trimestreTaller;
    }

    public double getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(double horasTaller) {
        this.horasTaller = horasTaller;
    }

    public String getGrupoTaller() {
        return grupoTaller;
    }

    public void setGrupoTaller(String grupoTaller) {
        this.grupoTaller = grupoTaller;
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
        hash += (productoTaller != null ? productoTaller.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taller)) {
            return false;
        }
        Taller other = (Taller) object;
        if ((this.productoTaller == null && other.productoTaller != null) || (this.productoTaller != null && !this.productoTaller.equals(other.productoTaller))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Taller[ productoTaller=" + productoTaller + " ]";
    }

}
