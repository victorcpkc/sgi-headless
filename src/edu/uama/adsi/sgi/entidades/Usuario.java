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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idusuario")
    private String idusuario;
    @Basic(optional = false)
    @Lob
    @Column(name = "pass_usuario")
    private byte[] passUsuario;
    @Basic(optional = false)
    @Column(name = "tipo_usuario")
    private short tipoUsuario;
    @Lob
    @Column(name = "meta_usuario")
    private byte[] metaUsuario;
    @JoinColumn(name = "profesor_usuario", referencedColumnName = "idprofesor")
    @ManyToOne(optional = false)
    private Profesor profesorUsuario;

    public Usuario() {
    }

    public Usuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(String idusuario, byte[] passUsuario, short tipoUsuario) {
        this.idusuario = idusuario;
        this.passUsuario = passUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public byte[] getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(byte[] passUsuario) {
        this.passUsuario = passUsuario;
    }

    public short getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(short tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public byte[] getMetaUsuario() {
        return metaUsuario;
    }

    public void setMetaUsuario(byte[] metaUsuario) {
        this.metaUsuario = metaUsuario;
    }

    public Profesor getProfesorUsuario() {
        return profesorUsuario;
    }

    public void setProfesorUsuario(Profesor profesorUsuario) {
        this.profesorUsuario = profesorUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Usuario[ idusuario=" + idusuario + " ]";
    }

}
