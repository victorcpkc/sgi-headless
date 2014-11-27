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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "tipo_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t"),
    @NamedQuery(name = "TipoProducto.findByIdtipoProducto", query = "SELECT t FROM TipoProducto t WHERE t.idtipoProducto = :idtipoProducto"),
    @NamedQuery(name = "TipoProducto.findByNombreTipoProducto", query = "SELECT t FROM TipoProducto t WHERE t.nombreTipoProducto = :nombreTipoProducto"),
    @NamedQuery(name = "TipoProducto.findByPuntajeTipoProducto", query = "SELECT t FROM TipoProducto t WHERE t.puntajeTipoProducto = :puntajeTipoProducto")})
public class TipoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtipo_producto")
    private String idtipoProducto;
    @Basic(optional = false)
    @Column(name = "nombre_tipo_producto")
    private String nombreTipoProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "puntaje_tipo_producto")
    private Double puntajeTipoProducto;
    @Lob
    @Column(name = "configuracion_tipo_producto")
    private byte[] configuracionTipoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProductoProducto")
    private List<Producto> productoList;

    public TipoProducto() {
    }

    public TipoProducto(String idtipoProducto) {
        this.idtipoProducto = idtipoProducto;
    }

    public TipoProducto(String idtipoProducto, String nombreTipoProducto) {
        this.idtipoProducto = idtipoProducto;
        this.nombreTipoProducto = nombreTipoProducto;
    }

    public String getIdtipoProducto() {
        return idtipoProducto;
    }

    public void setIdtipoProducto(String idtipoProducto) {
        this.idtipoProducto = idtipoProducto;
    }

    public String getNombreTipoProducto() {
        return nombreTipoProducto;
    }

    public void setNombreTipoProducto(String nombreTipoProducto) {
        this.nombreTipoProducto = nombreTipoProducto;
    }

    public Double getPuntajeTipoProducto() {
        return puntajeTipoProducto;
    }

    public void setPuntajeTipoProducto(Double puntajeTipoProducto) {
        this.puntajeTipoProducto = puntajeTipoProducto;
    }

    public byte[] getConfiguracionTipoProducto() {
        return configuracionTipoProducto;
    }

    public void setConfiguracionTipoProducto(byte[] configuracionTipoProducto) {
        this.configuracionTipoProducto = configuracionTipoProducto;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoProducto != null ? idtipoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.idtipoProducto == null && other.idtipoProducto != null) || (this.idtipoProducto != null && !this.idtipoProducto.equals(other.idtipoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.TipoProducto[ idtipoProducto=" + idtipoProducto + " ]";
    }

}
