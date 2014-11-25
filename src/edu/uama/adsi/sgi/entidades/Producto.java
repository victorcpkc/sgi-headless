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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto"),
    @NamedQuery(name = "Producto.findByTituloProducto", query = "SELECT p FROM Producto p WHERE p.tituloProducto = :tituloProducto"),
    @NamedQuery(name = "Producto.findByFechaProducto", query = "SELECT p FROM Producto p WHERE p.fechaProducto = :fechaProducto"),
    @NamedQuery(name = "Producto.findByDetalleProducto", query = "SELECT p FROM Producto p WHERE p.detalleProducto = :detalleProducto")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Basic(optional = false)
    @Column(name = "titulo_producto")
    private String tituloProducto;
    @Basic(optional = false)
    @Column(name = "fecha_producto")
    @Temporal(TemporalType.DATE)
    private Date fechaProducto;
    @Column(name = "detalle_producto")
    private Short detalleProducto;
    @Lob
    @Column(name = "notas_producto")
    private String notasProducto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto")
    private Taller taller;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto")
    private Articulo articulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoComprobante")
    private List<Comprobante> comprobanteList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto")
    private Libro libro;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto")
    private Software software;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto")
    private Curso curso;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto")
    private Examen examen;
    @JoinColumn(name = "tipo_producto_producto", referencedColumnName = "idtipo_producto")
    @ManyToOne(optional = false)
    private TipoProducto tipoProductoProducto;
    @JoinColumn(name = "profesor_producto", referencedColumnName = "idprofesor")
    @ManyToOne(optional = false)
    private Profesor profesorProducto;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(Integer idproducto, String tituloProducto, Date fechaProducto) {
        this.idproducto = idproducto;
        this.tituloProducto = tituloProducto;
        this.fechaProducto = fechaProducto;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getTituloProducto() {
        return tituloProducto;
    }

    public void setTituloProducto(String tituloProducto) {
        this.tituloProducto = tituloProducto;
    }

    public Date getFechaProducto() {
        return fechaProducto;
    }

    public void setFechaProducto(Date fechaProducto) {
        this.fechaProducto = fechaProducto;
    }

    public Short getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(Short detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public String getNotasProducto() {
        return notasProducto;
    }

    public void setNotasProducto(String notasProducto) {
        this.notasProducto = notasProducto;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @XmlTransient
    public List<Comprobante> getComprobanteList() {
        return comprobanteList;
    }

    public void setComprobanteList(List<Comprobante> comprobanteList) {
        this.comprobanteList = comprobanteList;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public TipoProducto getTipoProductoProducto() {
        return tipoProductoProducto;
    }

    public void setTipoProductoProducto(TipoProducto tipoProductoProducto) {
        this.tipoProductoProducto = tipoProductoProducto;
    }

    public Profesor getProfesorProducto() {
        return profesorProducto;
    }

    public void setProfesorProducto(Profesor profesorProducto) {
        this.profesorProducto = profesorProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Producto[ idproducto=" + idproducto + " ]";
    }

}
