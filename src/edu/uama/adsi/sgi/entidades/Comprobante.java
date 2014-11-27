/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uama.adsi.sgi.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
@Entity
@Table(name = "comprobante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprobante.findAll", query = "SELECT c FROM Comprobante c"),
    @NamedQuery(name = "Comprobante.findByIdcomprobante", query = "SELECT c FROM Comprobante c WHERE c.idcomprobante = :idcomprobante"),
    @NamedQuery(name = "Comprobante.findByDescripci\u00f3nComprobante", query = "SELECT c FROM Comprobante c WHERE c.descripci\u00f3nComprobante = :descripci\u00f3nComprobante"),
    @NamedQuery(name = "Comprobante.findByFechaComprobante", query = "SELECT c FROM Comprobante c WHERE c.fechaComprobante = :fechaComprobante")})
public class Comprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomprobante")
    private Integer idcomprobante;
    @Basic(optional = false)
    @Column(name = "descripci\u00f3n_comprobante")
    private String descripciónComprobante;
    @Basic(optional = false)
    @Column(name = "fecha_comprobante")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComprobante;
    @JoinColumn(name = "tipo_comprobante_comprobante", referencedColumnName = "idtipo_comprobante")
    @ManyToOne(optional = false)
    private TipoComprobante tipoComprobanteComprobante;
    @JoinColumn(name = "producto_comprobante", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto productoComprobante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprobanteDocumento")
    private List<Documento> documentoList;

    public Comprobante() {
    }

    public Comprobante(Integer idcomprobante) {
        this.idcomprobante = idcomprobante;
    }

    public Comprobante(Integer idcomprobante, String descripciónComprobante, Date fechaComprobante) {
        this.idcomprobante = idcomprobante;
        this.descripciónComprobante = descripciónComprobante;
        this.fechaComprobante = fechaComprobante;
    }

    public Integer getIdcomprobante() {
        return idcomprobante;
    }

    public void setIdcomprobante(Integer idcomprobante) {
        this.idcomprobante = idcomprobante;
    }

    public String getDescripciónComprobante() {
        return descripciónComprobante;
    }

    public void setDescripciónComprobante(String descripciónComprobante) {
        this.descripciónComprobante = descripciónComprobante;
    }

    public Date getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(Date fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public TipoComprobante getTipoComprobanteComprobante() {
        return tipoComprobanteComprobante;
    }

    public void setTipoComprobanteComprobante(TipoComprobante tipoComprobanteComprobante) {
        this.tipoComprobanteComprobante = tipoComprobanteComprobante;
    }

    public Producto getProductoComprobante() {
        return productoComprobante;
    }

    public void setProductoComprobante(Producto productoComprobante) {
        this.productoComprobante = productoComprobante;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomprobante != null ? idcomprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprobante)) {
            return false;
        }
        Comprobante other = (Comprobante) object;
        if ((this.idcomprobante == null && other.idcomprobante != null) || (this.idcomprobante != null && !this.idcomprobante.equals(other.idcomprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Comprobante[ idcomprobante=" + idcomprobante + " ]";
    }

}
