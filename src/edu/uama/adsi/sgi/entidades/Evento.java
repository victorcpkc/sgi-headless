
package edu.uama.adsi.sgi.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase entidad de Eventos o Alertas.
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
@Entity
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdevento", query = "SELECT e FROM Evento e WHERE e.idevento = :idevento"),
    @NamedQuery(name = "Evento.findByNombreEvento", query = "SELECT e FROM Evento e WHERE e.nombreEvento = :nombreEvento")
})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevento")
    private Integer idevento;
    @Basic(optional = false)
    @Column(name = "nombre_evento")
    private String nombreEvento;
    @Basic(optional = false)
    @Column(name = "inicio_evento")
    @Temporal(TemporalType.DATE)
    private Date inicioEvento;
    @Basic(optional = false)
    @Column(name = "fin_evento")
    @Temporal(TemporalType.DATE)
    private Date finEvento;
    @Lob
    @Column(name = "descripcion_evento")
    private String descripcionEvento;
    @JoinColumn(name = "profesor_evento", referencedColumnName = "idprofesor")
    @ManyToOne(optional = false)
    private Profesor profesorEvento;

    public Evento() {
    }

    public Evento(Integer idevento) {
        this.idevento = idevento;
    }

    public Evento(Integer idevento, String nombreEvento) {
        this.idevento = idevento;
        this.nombreEvento = nombreEvento;
    }

    public Evento(Integer idevento, String nombreEvento, Date inicioEvento, Date finEvento) {
        this.idevento = idevento;
        this.nombreEvento = nombreEvento;
        this.inicioEvento = inicioEvento;
        this.finEvento = finEvento;
    }

    public Integer getIdevento() {
        return idevento;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Date getInicioEvento() {
        return inicioEvento;
    }

    public void setInicioEvento(Date inicioEvento) {
        this.inicioEvento = inicioEvento;
    }

    public Date getFinEvento() {
        return finEvento;
    }

    public void setFinEvento(Date finEvento) {
        this.finEvento = finEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public Profesor getProfesorEvento() {
        return profesorEvento;
    }

    public void setProfesorEvento(Profesor profesorEvento) {
        this.profesorEvento = profesorEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevento != null ? idevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        return (this.idevento != null || other.idevento == null) && (this.idevento == null || this.idevento.equals(other.idevento));
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Evento[ idevento=" + idevento + " ]";
    }

}
