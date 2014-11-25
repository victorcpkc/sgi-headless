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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
@Entity
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByIddocumento", query = "SELECT d FROM Documento d WHERE d.iddocumento = :iddocumento")})
public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddocumento")
    private Integer iddocumento;
    @Basic(optional = false)
    @Lob
    @Column(name = "archivo_documento")
    private byte[] archivoDocumento;
    @JoinColumn(name = "comprobante_documento", referencedColumnName = "idcomprobante")
    @ManyToOne(optional = false)
    private Comprobante comprobanteDocumento;

    public Documento() {
    }

    public Documento(Integer iddocumento) {
        this.iddocumento = iddocumento;
    }

    public Documento(Integer iddocumento, byte[] archivoDocumento) {
        this.iddocumento = iddocumento;
        this.archivoDocumento = archivoDocumento;
    }

    public Integer getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Integer iddocumento) {
        this.iddocumento = iddocumento;
    }

    public byte[] getArchivoDocumento() {
        return archivoDocumento;
    }

    public void setArchivoDocumento(byte[] archivoDocumento) {
        this.archivoDocumento = archivoDocumento;
    }

    public Comprobante getComprobanteDocumento() {
        return comprobanteDocumento;
    }

    public void setComprobanteDocumento(Comprobante comprobanteDocumento) {
        this.comprobanteDocumento = comprobanteDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocumento != null ? iddocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.iddocumento == null && other.iddocumento != null) || (this.iddocumento != null && !this.iddocumento.equals(other.iddocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Documento[ iddocumento=" + iddocumento + " ]";
    }

}
