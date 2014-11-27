
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
 * Clase entidad de taller.
 * Productos académicos con una estructura similar a taller.
 * @see Producto
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
@Entity
@Table(name = "taller")
@DiscriminatorValue(value="taller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taller.findAll", query = "SELECT t FROM Taller t"),
    @NamedQuery(name = "Taller.findByTrimestreTaller", query = "SELECT t FROM Taller t WHERE t.trimestreTaller = :trimestreTaller"),
    @NamedQuery(name = "Taller.findByHorasTaller", query = "SELECT t FROM Taller t WHERE t.horasTaller = :horasTaller"),
    @NamedQuery(name = "Taller.findByGrupoTaller", query = "SELECT t FROM Taller t WHERE t.grupoTaller = :grupoTaller")})
public class Taller extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "trimestre_taller")
    private String trimestreTaller;
    @Basic(optional = false)
    @Column(name = "horas_taller")
    private double horasTaller;
    @Column(name = "grupo_taller")
    private String grupoTaller;

    public Taller() {
    }

    public Taller(Integer idproducto) {
        super(idproducto);
    }

    public Taller(Integer idproducto, String trimestreTaller, double horasTaller) {
        super(idproducto);
        this.trimestreTaller = trimestreTaller;
        this.horasTaller = horasTaller;
    }

    public String getTrimestreTaller() {
        return trimestreTaller;
    }

    public void setTrimestreTaller(String trimestreTaller) {
        this.trimestreTaller = trimestreTaller;
    }

    public double getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(double horasTaller) {
        this.horasTaller = horasTaller;
    }

    public String getGrupoTaller() {
        return grupoTaller;
    }

    public void setGrupoTaller(String grupoTaller) {
        this.grupoTaller = grupoTaller;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Taller[ productoTaller=" + getIdproducto() + " ]";
    }

}
