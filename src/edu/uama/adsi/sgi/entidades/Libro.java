/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uama.adsi.sgi.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
@Entity
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByProductoLibro", query = "SELECT l FROM Libro l WHERE l.productoLibro = :productoLibro"),
    @NamedQuery(name = "Libro.findBySubtitiloLibro", query = "SELECT l FROM Libro l WHERE l.subtitiloLibro = :subtitiloLibro"),
    @NamedQuery(name = "Libro.findByColeccionLibro", query = "SELECT l FROM Libro l WHERE l.coleccionLibro = :coleccionLibro"),
    @NamedQuery(name = "Libro.findByEditorialLibro", query = "SELECT l FROM Libro l WHERE l.editorialLibro = :editorialLibro"),
    @NamedQuery(name = "Libro.findByPaisLibro", query = "SELECT l FROM Libro l WHERE l.paisLibro = :paisLibro"),
    @NamedQuery(name = "Libro.findByIdiomaLibro", query = "SELECT l FROM Libro l WHERE l.idiomaLibro = :idiomaLibro"),
    @NamedQuery(name = "Libro.findByEdicionLibro", query = "SELECT l FROM Libro l WHERE l.edicionLibro = :edicionLibro"),
    @NamedQuery(name = "Libro.findByIsbnLibro", query = "SELECT l FROM Libro l WHERE l.isbnLibro = :isbnLibro"),
    @NamedQuery(name = "Libro.findByPaginasLibro", query = "SELECT l FROM Libro l WHERE l.paginasLibro = :paginasLibro"),
    @NamedQuery(name = "Libro.findByTirajeLibro", query = "SELECT l FROM Libro l WHERE l.tirajeLibro = :tirajeLibro"),
    @NamedQuery(name = "Libro.findByFechaAceptacionLibro", query = "SELECT l FROM Libro l WHERE l.fechaAceptacionLibro = :fechaAceptacionLibro"),
    @NamedQuery(name = "Libro.findByFechaPublicacionLibro", query = "SELECT l FROM Libro l WHERE l.fechaPublicacionLibro = :fechaPublicacionLibro")})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "producto_libro")
    private Integer productoLibro;
    @Column(name = "subtitilo_libro")
    private String subtitiloLibro;
    @Column(name = "coleccion_libro")
    private String coleccionLibro;
    @Basic(optional = false)
    @Column(name = "editorial_libro")
    private String editorialLibro;
    @Basic(optional = false)
    @Column(name = "pais_libro")
    private String paisLibro;
    @Basic(optional = false)
    @Column(name = "idioma_libro")
    private String idiomaLibro;
    @Column(name = "edicion_libro")
    private String edicionLibro;
    @Basic(optional = false)
    @Column(name = "isbn_libro")
    private String isbnLibro;
    @Column(name = "paginas_libro")
    private Integer paginasLibro;
    @Column(name = "tiraje_libro")
    private Integer tirajeLibro;
    @Column(name = "fecha_aceptacion_libro")
    @Temporal(TemporalType.DATE)
    private Date fechaAceptacionLibro;
    @Column(name = "fecha_publicacion_libro")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacionLibro;
    @Lob
    @Column(name = "coautores_libro")
    private String coautoresLibro;
    @JoinColumn(name = "producto_libro", referencedColumnName = "idproducto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Producto producto;

    public Libro() {
    }

    public Libro(Integer productoLibro) {
        this.productoLibro = productoLibro;
    }

    public Libro(Integer productoLibro, String editorialLibro, String paisLibro, String idiomaLibro, String isbnLibro) {
        this.productoLibro = productoLibro;
        this.editorialLibro = editorialLibro;
        this.paisLibro = paisLibro;
        this.idiomaLibro = idiomaLibro;
        this.isbnLibro = isbnLibro;
    }

    public Integer getProductoLibro() {
        return productoLibro;
    }

    public void setProductoLibro(Integer productoLibro) {
        this.productoLibro = productoLibro;
    }

    public String getSubtitiloLibro() {
        return subtitiloLibro;
    }

    public void setSubtitiloLibro(String subtitiloLibro) {
        this.subtitiloLibro = subtitiloLibro;
    }

    public String getColeccionLibro() {
        return coleccionLibro;
    }

    public void setColeccionLibro(String coleccionLibro) {
        this.coleccionLibro = coleccionLibro;
    }

    public String getEditorialLibro() {
        return editorialLibro;
    }

    public void setEditorialLibro(String editorialLibro) {
        this.editorialLibro = editorialLibro;
    }

    public String getPaisLibro() {
        return paisLibro;
    }

    public void setPaisLibro(String paisLibro) {
        this.paisLibro = paisLibro;
    }

    public String getIdiomaLibro() {
        return idiomaLibro;
    }

    public void setIdiomaLibro(String idiomaLibro) {
        this.idiomaLibro = idiomaLibro;
    }

    public String getEdicionLibro() {
        return edicionLibro;
    }

    public void setEdicionLibro(String edicionLibro) {
        this.edicionLibro = edicionLibro;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public Integer getPaginasLibro() {
        return paginasLibro;
    }

    public void setPaginasLibro(Integer paginasLibro) {
        this.paginasLibro = paginasLibro;
    }

    public Integer getTirajeLibro() {
        return tirajeLibro;
    }

    public void setTirajeLibro(Integer tirajeLibro) {
        this.tirajeLibro = tirajeLibro;
    }

    public Date getFechaAceptacionLibro() {
        return fechaAceptacionLibro;
    }

    public void setFechaAceptacionLibro(Date fechaAceptacionLibro) {
        this.fechaAceptacionLibro = fechaAceptacionLibro;
    }

    public Date getFechaPublicacionLibro() {
        return fechaPublicacionLibro;
    }

    public void setFechaPublicacionLibro(Date fechaPublicacionLibro) {
        this.fechaPublicacionLibro = fechaPublicacionLibro;
    }

    public String getCoautoresLibro() {
        return coautoresLibro;
    }

    public void setCoautoresLibro(String coautoresLibro) {
        this.coautoresLibro = coautoresLibro;
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
        hash += (productoLibro != null ? productoLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.productoLibro == null && other.productoLibro != null) || (this.productoLibro != null && !this.productoLibro.equals(other.productoLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Libro[ productoLibro=" + productoLibro + " ]";
    }

}
