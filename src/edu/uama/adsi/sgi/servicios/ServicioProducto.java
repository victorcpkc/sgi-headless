
package edu.uama.adsi.sgi.servicios;

import edu.uama.adsi.sgi.entidades.Producto;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author leonardi
 */
public class ServicioProducto {
    
    private EntityManager em;
    
    public ServicioProducto() {
    }

    public ServicioProducto(EntityManager em) {
        this.em = em;
    }
    
    public EntityManager getEntityManager(){
        return em;
    }
    
    public List<Producto> listarTodos(){
        return em.createNamedQuery("Producto.findAll").getResultList();
    }
    
}
