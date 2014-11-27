/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uama.adsi.sgi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase entidad de cursos.
 * Productos académicos con una estructura similar a cursos.
 * @see Producto
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
@Entity
@Table(name = "curso")
@DiscriminatorValue(value="curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByTrimestreCurso", query = "SELECT c FROM Curso c WHERE c.trimestreCurso = :trimestreCurso"),
    @NamedQuery(name = "Curso.findByCoeficienteCurso", query = "SELECT c FROM Curso c WHERE c.coeficienteCurso = :coeficienteCurso"),
    @NamedQuery(name = "Curso.findByGradoCurso", query = "SELECT c FROM Curso c WHERE c.gradoCurso = :gradoCurso")})
public class Curso extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "trimestre_curso")
    private String trimestreCurso;
    @Basic(optional = false)
    @Column(name = "coeficiente_curso")
    private double coeficienteCurso;
    @Column(name = "grado_curso")
    private Short gradoCurso;

    public Curso() {
    }

    public Curso(Integer idproducto) {
        super(idproducto);
    }

    public Curso(Integer idproducto, String trimestreCurso, double coeficienteCurso) {
        super(idproducto);
        this.trimestreCurso = trimestreCurso;
        this.coeficienteCurso = coeficienteCurso;
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

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Curso[ productoCurso=" + getIdproducto() + " ]";
    }

}
