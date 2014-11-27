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
@Table(name = "tipo_comprobante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoComprobante.findAll", query = "SELECT t FROM TipoComprobante t"),
    @NamedQuery(name = "TipoComprobante.findByIdtipoComprobante", query = "SELECT t FROM TipoComprobante t WHERE t.idtipoComprobante = :idtipoComprobante"),
    @NamedQuery(name = "TipoComprobante.findByDescripcionTipoComprobante", query = "SELECT t FROM TipoComprobante t WHERE t.descripcionTipoComprobante = :descripcionTipoComprobante")})
public class TipoComprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_comprobante")
    private Integer idtipoComprobante;
    @Basic(optional = false)
    @Column(name = "descripcion_tipo_comprobante")
    private String descripcionTipoComprobante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoComprobanteComprobante")
    private List<Comprobante> comprobanteList;

    public TipoComprobante() {
    }

    public TipoComprobante(Integer idtipoComprobante) {
        this.idtipoComprobante = idtipoComprobante;
    }

    public TipoComprobante(Integer idtipoComprobante, String descripcionTipoComprobante) {
        this.idtipoComprobante = idtipoComprobante;
        this.descripcionTipoComprobante = descripcionTipoComprobante;
    }

    public Integer getIdtipoComprobante() {
        return idtipoComprobante;
    }

    public void setIdtipoComprobante(Integer idtipoComprobante) {
        this.idtipoComprobante = idtipoComprobante;
    }

    public String getDescripcionTipoComprobante() {
        return descripcionTipoComprobante;
    }

    public void setDescripcionTipoComprobante(String descripcionTipoComprobante) {
        this.descripcionTipoComprobante = descripcionTipoComprobante;
    }

    @XmlTransient
    public List<Comprobante> getComprobanteList() {
        return comprobanteList;
    }

    public void setComprobanteList(List<Comprobante> comprobanteList) {
        this.comprobanteList = comprobanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoComprobante != null ? idtipoComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoComprobante)) {
            return false;
        }
        TipoComprobante other = (TipoComprobante) object;
        if ((this.idtipoComprobante == null && other.idtipoComprobante != null) || (this.idtipoComprobante != null && !this.idtipoComprobante.equals(other.idtipoComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.TipoComprobante[ idtipoComprobante=" + idtipoComprobante + " ]";
    }

}
