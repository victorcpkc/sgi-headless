
package edu.uama.adsi.sgi.servicios;

import edu.uama.adsi.sgi.entidades.TipoComprobante;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase para probar el gestor ServicoTipoProducto.
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
public class TestServicioTipoComprobante {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGI-headlessPU");
        EntityManager em = emf.createEntityManager();
        
        // Prueba de inserción
//        List<Properties> lista = new ArrayList(5);
//        lista.add(new Properties());
//        lista.get(0).put(ServicioTipoComprobante.DESCRIPCION, "Diploma");
//        lista.add(new Properties());
//        lista.get(1).put(ServicioTipoComprobante.DESCRIPCION, "Resumen");
//        lista.add(new Properties());
//        lista.get(2).put(ServicioTipoComprobante.DESCRIPCION, "Certificado");
//        lista.add(new Properties());
//        lista.get(3).put(ServicioTipoComprobante.DESCRIPCION, "Forma PT");
//        lista.add(new Properties());
//        lista.get(4).put(ServicioTipoComprobante.DESCRIPCION, "Carátula de PT");
//        
//        ServicioTipoComprobante stp = new ServicioTipoComprobante(em);
//        stp.agregar((Collection)lista);
        
        // Prueba de actualización
//        List<Properties> lista = new ArrayList(5);
//        lista.add(new Properties());
//        lista.get(0).put(ServicioTipoComprobante.ID, 3);
//        lista.get(0).put(ServicioTipoComprobante.DESCRIPCION, "Diploma");
//        lista.add(new Properties());
//        lista.get(1).put(ServicioTipoComprobante.ID, 5);
//        lista.get(1).put(ServicioTipoComprobante.DESCRIPCION, "Resumen");
//        lista.add(new Properties());
//        lista.get(2).put(ServicioTipoComprobante.ID, 2);
//        lista.get(2).put(ServicioTipoComprobante.DESCRIPCION, "Certificado");
//        lista.add(new Properties());
//        lista.get(3).put(ServicioTipoComprobante.ID, 1);
//        lista.get(3).put(ServicioTipoComprobante.DESCRIPCION, "Forma PT2");
//        lista.add(new Properties());
//        lista.get(4).put(ServicioTipoComprobante.ID, 4);
//        lista.get(4).put(ServicioTipoComprobante.DESCRIPCION, "Carátula de PT");
//        
//        ServicioTipoComprobante stp = new ServicioTipoComprobante(em);
//        stp.modificar((Collection)lista);
        
        // Prueba de borrado
        List<Integer> lista = new ArrayList(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);
        ServicioTipoComprobante stp = new ServicioTipoComprobante(em);
        stp.eliminar(lista);
    }
}
