
package edu.uama.adsi.sgi.servicios;

import edu.uama.adsi.sgi.entidades.TipoProducto;
import java.io.InputStream;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Gestor de Tipos de produtos (Catálog de productos).
 * @author 
 */
public class ServicioTipoProducto {
    
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String PUNTAJE = "puntaje";
    public static final String CONFIGURACION = "config";
    
    
    private EntityManager em;

    public ServicioTipoProducto() {
    }

    public ServicioTipoProducto(EntityManager em) {
        this.em = em;
    }
    
    public EntityManager getEntityManager(){
        return em;
    }
    
    /**
     * 
     * @return 
     */
    public List<TipoProducto> listarTodos(){
        return em.createNamedQuery("TipoProducto.findAll").getResultList();
    }
    
    /**
     * 
     * @return 
     */
    public List<String[]> tablaTodos(){
        List<String []> lista = new LinkedList();
        for (Iterator it = em.createNamedQuery("TipoProducto.findAll").getResultList().iterator(); it.hasNext();) {
            TipoProducto tp = (TipoProducto) it.next();
            lista.add(new String[]{tp.getIdtipoProducto(), tp.getNombreTipoProducto()});
        }
        return lista;
    }
    
    private TipoProducto parse(Dictionary datos){
        TipoProducto tp = new TipoProducto();
        Object value;
        value = datos.get(ID);
        if(value!=null) tp.setIdtipoProducto((String) value);
        value = datos.get(NOMBRE);
        if(value!=null) tp.setNombreTipoProducto((String) value);
        value = datos.get(PUNTAJE);
        if(value!=null) tp.setPuntajeTipoProducto((Double) value);
        value = datos.get(CONFIGURACION);
        if(value!=null) tp.setConfiguracionTipoProducto(null);
        return tp;
    }
    
    public TipoProducto agregar(String nombre, Double puntaje, InputStream conf){
        TipoProducto nuevo = new TipoProducto();
        nuevo.setNombreTipoProducto(nombre);
        nuevo.setPuntajeTipoProducto(puntaje);
        nuevo.setConfiguracionTipoProducto(null);
        em.getTransaction().begin();
        em.persist(nuevo);
        em.getTransaction().commit();
        return nuevo;
    }
    
    public List<TipoProducto> agregar(Collection<Object[]> array){
        List<TipoProducto> l = new LinkedList();
        em.getTransaction().begin();
        for(Object[] p: array){
            TipoProducto nuevo = new TipoProducto();
            nuevo.setNombreTipoProducto((String)p[0]);
            nuevo.setPuntajeTipoProducto((Double)p[1]);
            nuevo.setConfiguracionTipoProducto(null);
            em.persist(nuevo);
        }
        em.getTransaction().commit();
        return l;
    }
    
//    public List<TipoProducto> agregar(Collection<Dictionary> array){
//        List<TipoProducto> l = new LinkedList();
//        em.getTransaction().begin();
//        for(Properties p: array){
//            TipoProducto tp = parse(p);
//            em.persist(tp);
//            l.add(tp);
//        }
//        em.getTransaction().commit();
//        return l;
//    }
    
    public void modificar(Integer id, String nombre, Double puntaje, InputStream conf){
        TipoProducto tp = (TipoProducto) em.createNamedQuery("TipoProducto.findByIdtipoProducto").setParameter("idtipoProducto", id).getSingleResult();
        tp.setNombreTipoProducto(nombre);
        tp.setPuntajeTipoProducto(puntaje);
        tp.setConfiguracionTipoProducto(null);
        em.getTransaction().begin();
        em.persist(tp);
        em.getTransaction().commit();
    }
    
    public void modificar(TipoProducto tp){
        em.getTransaction().begin();
        em.persist(tp);
        em.getTransaction().commit();
    }
    
    public List<TipoProducto> eliminar(String[] ids){
        List<TipoProducto> l = new LinkedList();
        em.getTransaction().begin();
        for(String id: ids){
            TipoProducto tp = (TipoProducto) em.createNamedQuery("TipoProducto.findByIdtipoProducto").setParameter("idtipoProducto", id).getSingleResult();
            em.remove(tp);
            l.add(tp);
        }
        em.getTransaction().commit();
        return l;
    }
    
    public void cerrar(){
        
    }
}
