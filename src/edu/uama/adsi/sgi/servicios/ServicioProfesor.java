package edu.uama.adsi.sgi.servicios;

import edu.uama.adsi.sgi.entidades.Nivel;
import edu.uama.adsi.sgi.entidades.Profesor;
import java.util.*;
import javax.persistence.EntityManager;

public class ServicioProfesor {
    
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String CATEGORIA = "categoria";
    public static final String IDIOMA = "idioma";
    public static final String EMAIL = "email";
    public static final String ZONAHORARIA = "zonahoraria";
    public static final String NIVEL = "nivel";
    
    private EntityManager em;
    
    public ServicioProfesor() {
    }
    
    public ServicioProfesor(EntityManager em) {
        this.em = em;
    }
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    public List<Profesor> listarTodos() {
        return em.createNamedQuery("Profesor.findAll").getResultList();
    }
    
    public List<Object[]> tablaTodos() {
        List<Object[]> lista = new LinkedList();
        for (Iterator it = em.createNamedQuery("Profesor.findAll").getResultList().iterator(); it.hasNext();) {
            Profesor p = (Profesor) it.next();
            lista.add(new Object[]{p.getIdprofesor(), p.getNombreProfesor()});
        }
        return lista;
    }
    
    private Profesor parse(Dictionary datos) {
        Profesor p = new Profesor();
        Object value;
        value = datos.get(ID);
        if(value!=null) p.setIdprofesor((Long) value);
        value = datos.get(NOMBRE);
        if(value!=null) p.setNombreProfesor((String) value);
        value = datos.get(CATEGORIA);
        if(value!=null) p.setCategoriaProfesor((Character) value);
        value = datos.get(IDIOMA);
        if(value!=null) p.setIdiomaProfesor((String) value);
        value = datos.get(EMAIL);
        if(value!=null) p.setEmailProfesor((String) value);
        value = datos.get(ZONAHORARIA);
        if(value!=null) p.setZonaHorariaProfesor((String) value);
        value = datos.get(NIVEL);
        if(value!=null) p.setNivelProfesor(em.find(Nivel.class,value));
        return p;
    }
    
}
