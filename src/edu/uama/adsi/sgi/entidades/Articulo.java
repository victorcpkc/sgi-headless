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
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByProductoArticulo", query = "SELECT a FROM Articulo a WHERE a.productoArticulo = :productoArticulo"),
    @NamedQuery(name = "Articulo.findBySubtituloArticulo", query = "SELECT a FROM Articulo a WHERE a.subtituloArticulo = :subtituloArticulo"),
    @NamedQuery(name = "Articulo.findByRevistaArticulo", query = "SELECT a FROM Articulo a WHERE a.revistaArticulo = :revistaArticulo"),
    @NamedQuery(name = "Articulo.findByCapituloArticulo", query = "SELECT a FROM Articulo a WHERE a.capituloArticulo = :capituloArticulo"),
    @NamedQuery(name = "Articulo.findByPaisArticulo", query = "SELECT a FROM Articulo a WHERE a.paisArticulo = :paisArticulo"),
    @NamedQuery(name = "Articulo.findByCiudadArticulo", query = "SELECT a FROM Articulo a WHERE a.ciudadArticulo = :ciudadArticulo"),
    @NamedQuery(name = "Articulo.findByIdiomaArticulo", query = "SELECT a FROM Articulo a WHERE a.idiomaArticulo = :idiomaArticulo"),
    @NamedQuery(name = "Articulo.findByVolumenArticulo", query = "SELECT a FROM Articulo a WHERE a.volumenArticulo = :volumenArticulo"),
    @NamedQuery(name = "Articulo.findByNumeroArticulo", query = "SELECT a FROM Articulo a WHERE a.numeroArticulo = :numeroArticulo"),
    @NamedQuery(name = "Articulo.findByPaginaInicialArticulo", query = "SELECT a FROM Articulo a WHERE a.paginaInicialArticulo = :paginaInicialArticulo"),
    @NamedQuery(name = "Articulo.findByPaginaFinalArticulo", query = "SELECT a FROM Articulo a WHERE a.paginaFinalArticulo = :paginaFinalArticulo"),
    @NamedQuery(name = "Articulo.findByFechaPublicacionArticulo", query = "SELECT a FROM Articulo a WHERE a.fechaPublicacionArticulo = :fechaPublicacionArticulo"),
    @NamedQuery(name = "Articulo.findByFechaAceptacionArticulo", query = "SELECT a FROM Articulo a WHERE a.fechaAceptacionArticulo = :fechaAceptacionArticulo")})
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "producto_articulo")
    private Integer productoArticulo;
    @Column(name = "subtitulo_articulo")
    private String subtituloArticulo;
    @Basic(optional = false)
    @Column(name = "revista_articulo")
    private String revistaArticulo;
    @Column(name = "capitulo_articulo")
    private String capituloArticulo;
    @Column(name = "pais_articulo")
    private String paisArticulo;
    @Column(name = "ciudad_articulo")
    private String ciudadArticulo;
    @Basic(optional = false)
    @Column(name = "idioma_articulo")
    private String idiomaArticulo;
    @Column(name = "volumen_articulo")
    private String volumenArticulo;
    @Column(name = "numero_articulo")
    private Integer numeroArticulo;
    @Basic(optional = false)
    @Column(name = "pagina_inicial_articulo")
    private int paginaInicialArticulo;
    @Basic(optional = false)
    @Column(name = "pagina_final_articulo")
    private int paginaFinalArticulo;
    @Basic(optional = false)
    @Column(name = "fecha_publicacion_articulo")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacionArticulo;
    @Basic(optional = false)
    @Column(name = "fecha_aceptacion_articulo")
    @Temporal(TemporalType.DATE)
    private Date fechaAceptacionArticulo;
    @Lob
    @Column(name = "coautores_articulo")
    private String coautoresArticulo;
    @JoinColumn(name = "producto_articulo", referencedColumnName = "idproducto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Producto producto;

    public Articulo() {
    }

    public Articulo(Integer productoArticulo) {
        this.productoArticulo = productoArticulo;
    }

    public Articulo(Integer productoArticulo, String revistaArticulo, String idiomaArticulo, int paginaInicialArticulo, int paginaFinalArticulo, Date fechaPublicacionArticulo, Date fechaAceptacionArticulo) {
        this.productoArticulo = productoArticulo;
        this.revistaArticulo = revistaArticulo;
        this.idiomaArticulo = idiomaArticulo;
        this.paginaInicialArticulo = paginaInicialArticulo;
        this.paginaFinalArticulo = paginaFinalArticulo;
        this.fechaPublicacionArticulo = fechaPublicacionArticulo;
        this.fechaAceptacionArticulo = fechaAceptacionArticulo;
    }

    public Integer getProductoArticulo() {
        return productoArticulo;
    }

    public void setProductoArticulo(Integer productoArticulo) {
        this.productoArticulo = productoArticulo;
    }

    public String getSubtituloArticulo() {
        return subtituloArticulo;
    }

    public void setSubtituloArticulo(String subtituloArticulo) {
        this.subtituloArticulo = subtituloArticulo;
    }

    public String getRevistaArticulo() {
        return revistaArticulo;
    }

    public void setRevistaArticulo(String revistaArticulo) {
        this.revistaArticulo = revistaArticulo;
    }

    public String getCapituloArticulo() {
        return capituloArticulo;
    }

    public void setCapituloArticulo(String capituloArticulo) {
        this.capituloArticulo = capituloArticulo;
    }

    public String getPaisArticulo() {
        return paisArticulo;
    }

    public void setPaisArticulo(String paisArticulo) {
        this.paisArticulo = paisArticulo;
    }

    public String getCiudadArticulo() {
        return ciudadArticulo;
    }

    public void setCiudadArticulo(String ciudadArticulo) {
        this.ciudadArticulo = ciudadArticulo;
    }

    public String getIdiomaArticulo() {
        return idiomaArticulo;
    }

    public void setIdiomaArticulo(String idiomaArticulo) {
        this.idiomaArticulo = idiomaArticulo;
    }

    public String getVolumenArticulo() {
        return volumenArticulo;
    }

    public void setVolumenArticulo(String volumenArticulo) {
        this.volumenArticulo = volumenArticulo;
    }

    public Integer getNumeroArticulo() {
        return numeroArticulo;
    }

    public void setNumeroArticulo(Integer numeroArticulo) {
        this.numeroArticulo = numeroArticulo;
    }

    public int getPaginaInicialArticulo() {
        return paginaInicialArticulo;
    }

    public void setPaginaInicialArticulo(int paginaInicialArticulo) {
        this.paginaInicialArticulo = paginaInicialArticulo;
    }

    public int getPaginaFinalArticulo() {
        return paginaFinalArticulo;
    }

    public void setPaginaFinalArticulo(int paginaFinalArticulo) {
        this.paginaFinalArticulo = paginaFinalArticulo;
    }

    public Date getFechaPublicacionArticulo() {
        return fechaPublicacionArticulo;
    }

    public void setFechaPublicacionArticulo(Date fechaPublicacionArticulo) {
        this.fechaPublicacionArticulo = fechaPublicacionArticulo;
    }

    public Date getFechaAceptacionArticulo() {
        return fechaAceptacionArticulo;
    }

    public void setFechaAceptacionArticulo(Date fechaAceptacionArticulo) {
        this.fechaAceptacionArticulo = fechaAceptacionArticulo;
    }

    public String getCoautoresArticulo() {
        return coautoresArticulo;
    }

    public void setCoautoresArticulo(String coautoresArticulo) {
        this.coautoresArticulo = coautoresArticulo;
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
        hash += (productoArticulo != null ? productoArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.productoArticulo == null && other.productoArticulo != null) || (this.productoArticulo != null && !this.productoArticulo.equals(other.productoArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Articulo[ productoArticulo=" + productoArticulo + " ]";
    }

}
