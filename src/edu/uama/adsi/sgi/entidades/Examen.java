
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
 * Clase entidad de examen.
 * Productos académicos con una estructura similar a examen.
 * @see Producto
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
@Entity
@Table(name = "examen")
@DiscriminatorValue(value="examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByInstitucionExamen", query = "SELECT e FROM Examen e WHERE e.institucionExamen = :institucionExamen"),
    @NamedQuery(name = "Examen.findByGradoExamen", query = "SELECT e FROM Examen e WHERE e.gradoExamen = :gradoExamen")})
public class Examen extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "institucion_examen")
    private String institucionExamen;
    @Basic(optional = false)
    @Column(name = "grado_examen")
    private short gradoExamen;

    public Examen() {
    }

    public Examen(Integer idproducto) {
        super(idproducto);
    }

    public Examen(Integer idproducto, String institucionExamen, short gradoExamen) {
        super(idproducto);
        this.institucionExamen = institucionExamen;
        this.gradoExamen = gradoExamen;
    }

    public String getInstitucionExamen() {
        return institucionExamen;
    }

    public void setInstitucionExamen(String institucionExamen) {
        this.institucionExamen = institucionExamen;
    }

    public short getGradoExamen() {
        return gradoExamen;
    }

    public void setGradoExamen(short gradoExamen) {
        this.gradoExamen = gradoExamen;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Examen[ productoExamen=" + getIdproducto() + " ]";
    }

}
