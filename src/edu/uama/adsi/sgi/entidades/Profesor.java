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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdprofesor", query = "SELECT p FROM Profesor p WHERE p.idprofesor = :idprofesor"),
    @NamedQuery(name = "Profesor.findByNombreProfesor", query = "SELECT p FROM Profesor p WHERE p.nombreProfesor = :nombreProfesor"),
    @NamedQuery(name = "Profesor.findByCategoriaProfesor", query = "SELECT p FROM Profesor p WHERE p.categoriaProfesor = :categoriaProfesor"),
    @NamedQuery(name = "Profesor.findByIdiomaProfesor", query = "SELECT p FROM Profesor p WHERE p.idiomaProfesor = :idiomaProfesor"),
    @NamedQuery(name = "Profesor.findByEmailProfesor", query = "SELECT p FROM Profesor p WHERE p.emailProfesor = :emailProfesor"),
    @NamedQuery(name = "Profesor.findByZonaHorariaProfesor", query = "SELECT p FROM Profesor p WHERE p.zonaHorariaProfesor = :zonaHorariaProfesor")})
public class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idprofesor")
    private Long idprofesor;
    @Basic(optional = false)
    @Column(name = "nombre_profesor")
    private String nombreProfesor;
    @Basic(optional = false)
    @Column(name = "categoria_profesor")
    private Character categoriaProfesor;
    @Basic(optional = false)
    @Column(name = "idioma_profesor")
    private String idiomaProfesor;
    @Column(name = "email_profesor")
    private String emailProfesor;
    @Column(name = "zona_horaria_profesor")
    private String zonaHorariaProfesor;
    @JoinColumn(name = "nivel_profesor", referencedColumnName = "idnivel")
    @ManyToOne(optional = false)
    private Nivel nivelProfesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesorUsuario")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesorEvento")
    private List<Evento> eventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesorProducto")
    private List<Producto> productoList;

    public Profesor() {
    }

    public Profesor(Long idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Profesor(Long idprofesor, String nombreProfesor, Character categoriaProfesor, String idiomaProfesor) {
        this.idprofesor = idprofesor;
        this.nombreProfesor = nombreProfesor;
        this.categoriaProfesor = categoriaProfesor;
        this.idiomaProfesor = idiomaProfesor;
    }

    public Long getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Long idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public Character getCategoriaProfesor() {
        return categoriaProfesor;
    }

    public void setCategoriaProfesor(Character categoriaProfesor) {
        this.categoriaProfesor = categoriaProfesor;
    }

    public String getIdiomaProfesor() {
        return idiomaProfesor;
    }

    public void setIdiomaProfesor(String idiomaProfesor) {
        this.idiomaProfesor = idiomaProfesor;
    }

    public String getEmailProfesor() {
        return emailProfesor;
    }

    public void setEmailProfesor(String emailProfesor) {
        this.emailProfesor = emailProfesor;
    }

    public String getZonaHorariaProfesor() {
        return zonaHorariaProfesor;
    }

    public void setZonaHorariaProfesor(String zonaHorariaProfesor) {
        this.zonaHorariaProfesor = zonaHorariaProfesor;
    }

    public Nivel getNivelProfesor() {
        return nivelProfesor;
    }

    public void setNivelProfesor(Nivel nivelProfesor) {
        this.nivelProfesor = nivelProfesor;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
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
        hash += (idprofesor != null ? idprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idprofesor == null && other.idprofesor != null) || (this.idprofesor != null && !this.idprofesor.equals(other.idprofesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Profesor[ idprofesor=" + idprofesor + " ]";
    }

}
