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
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByProductoCurso", query = "SELECT c FROM Curso c WHERE c.productoCurso = :productoCurso"),
    @NamedQuery(name = "Curso.findByTrimestreCurso", query = "SELECT c FROM Curso c WHERE c.trimestreCurso = :trimestreCurso"),
    @NamedQuery(name = "Curso.findByCoeficienteCurso", query = "SELECT c FROM Curso c WHERE c.coeficienteCurso = :coeficienteCurso"),
    @NamedQuery(name = "Curso.findByGradoCurso", query = "SELECT c FROM Curso c WHERE c.gradoCurso = :gradoCurso")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "producto_curso")
    private Integer productoCurso;
    @Basic(optional = false)
    @Column(name = "trimestre_curso")
    private String trimestreCurso;
    @Basic(optional = false)
    @Column(name = "coeficiente_curso")
    private double coeficienteCurso;
    @Column(name = "grado_curso")
    private Short gradoCurso;
    @JoinColumn(name = "producto_curso", referencedColumnName = "idproducto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Producto producto;

    public Curso() {
    }

    public Curso(Integer productoCurso) {
        this.productoCurso = productoCurso;
    }

    public Curso(Integer productoCurso, String trimestreCurso, double coeficienteCurso) {
        this.productoCurso = productoCurso;
        this.trimestreCurso = trimestreCurso;
        this.coeficienteCurso = coeficienteCurso;
    }

    public Integer getProductoCurso() {
        return productoCurso;
    }

    public void setProductoCurso(Integer productoCurso) {
        this.productoCurso = productoCurso;
    }

    public String getTrimestreCurso() {
        return trimestreCurso;
    }

    public void setTrimestreCurso(String trimestreCurso) {
        this.trimestreCurso = trimestreCurso;
    }

    public double getCoeficienteCurso() {
        return coeficienteCurso;
    }

    public void setCoeficienteCurso(double coeficienteCurso) {
        this.coeficienteCurso = coeficienteCurso;
    }

    public Short getGradoCurso() {
        return gradoCurso;
    }

    public void setGradoCurso(Short gradoCurso) {
        this.gradoCurso = gradoCurso;
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
        hash += (productoCurso != null ? productoCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.productoCurso == null && other.productoCurso != null) || (this.productoCurso != null && !this.productoCurso.equals(other.productoCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Curso[ productoCurso=" + productoCurso + " ]";
    }

}
