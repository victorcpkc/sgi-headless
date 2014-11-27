
package edu.uama.adsi.sgi.entidades;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase para probar el modelo de calses entidad.
 * En JPA cuando se hacen modificaciones en las entidades, el controlador
 * actualiza las tablas en la base de datos. Esta clase tiene la finalidad
 * de ejecutar las clases entidad para que el controlador reprodusca las
 * modificaciones en la base de datos.
 * 
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
public class TestEntities {
    
    /**
     * Método de inicio.
     * Como es este proyecto se está trabanado con bases de datos locales, hay que 
     * estar corriendo este método para que se hagan las actualizaciones en las 
     * bases de datos locales.
     * @param args No recibe argumentos.
     */
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGI-headlessPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.getTransaction().commit();
        
        List resultado = em.createNamedQuery("Curso.findAll").getResultList();
    }
}
