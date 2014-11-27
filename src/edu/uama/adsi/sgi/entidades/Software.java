
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
 * Clase entidad de software.
 * Productos académicos con una estructura similar a software.
 * @see Producto
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
@Entity
@Table(name = "software")
@DiscriminatorValue(value="software")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Software.findAll", query = "SELECT s FROM Software s"),
    @NamedQuery(name = "Software.findByLenguajeSoftware", query = "SELECT s FROM Software s WHERE s.lenguajeSoftware = :lenguajeSoftware"),
    @NamedQuery(name = "Software.findByVinculadoSoftware", query = "SELECT s FROM Software s WHERE s.vinculadoSoftware = :vinculadoSoftware")})
public class Software extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "lenguaje_software")
    private String lenguajeSoftware;
    @Column(name = "vinculado_software")
    private String vinculadoSoftware;

    public Software() {
    }

    public Software(Integer idproducto) {
        super(idproducto);
    }

    public Software(Integer idproducto, String lenguajeSoftware) {
        super(idproducto);
        this.lenguajeSoftware = lenguajeSoftware;
    }

    public String getLenguajeSoftware() {
        return lenguajeSoftware;
    }

    public void setLenguajeSoftware(String lenguajeSoftware) {
        this.lenguajeSoftware = lenguajeSoftware;
    }

    public String getVinculadoSoftware() {
        return vinculadoSoftware;
    }

    public void setVinculadoSoftware(String vinculadoSoftware) {
        this.vinculadoSoftware = vinculadoSoftware;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.entidades.Software[ productoSoftware=" + getIdproducto() + " ]";
    }

}
