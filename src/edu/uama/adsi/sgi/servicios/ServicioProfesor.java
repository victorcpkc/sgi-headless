package edu.uama.adsi.sgi.servicios;

import edu.uama.adsi.sgi.entidades.*;
import java.util.*;
import javax.persistence.EntityManager;

/**
 * Gestor de profesores.
 * Gestiona las operaciones realizadas sobre los objetos Profesor.
 * Proveé a la capa de presentación las listas y tablas de los profesores, además
 * de métodos para administrarlos en la base de datos desde la interfaz de linea
 * de comandos (headless).
 * @author Giovanni
 */
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
    
    /**
     * Listar todos los profesores.
     * Genera una lista de objetos (@code Profesor) con todos los
     * registros de la tabla profesor.
     * @return Una lista con los profesores encontrados, vacia si no
     * encuentra
     */
    public List<Profesor> listarTodos() {
        //Consulta a la base de datos
        return em.createNamedQuery("Profesor.findAll").getResultList();
    }
    
    /**
     * Tabla de todos los profesores.
     * Genera una lista con un arreglo formado por (ID, Nombre, Categoria, Idioma,
     * Email, Zona Horaria, Nivel), en otras palabras una tabla con las columnas
     * ID de tipo (@code Integer), Nombre de tipo (@code String), Categoria de
     * tipo (@code Character), Idioma de tipo (@code String), Email de tipo (@code
     * String), Zona horaria de tipo (@code String) y Nivel de tipo (@code Nivel)
     * y cada elemento de la lista es un renglón.
     * @return Una lista con la fila de los tipos de productos encontrados,
     * vacia si no encuentra.
     */
    public List<Object[]> tablaTodos() {
        //Crea una nueva lista
        List<Object[]> tabla = new LinkedList();
        //Recorre todos los elementos de la lista obtenida con el método: listarTodos()
        for(Profesor p: listarTodos()) {
            //Añade a la lista un nuevo renglón
            tabla.add(new Object[] {
                p.getIdprofesor(),
                p.getNombreProfesor(),
                p.getCategoriaProfesor(),
                p.getIdiomaProfesor(),
                p.getEmailProfesor(),
                p.getZonaHorariaProfesor(),
                p.getNivelProfesor()
            });
        }
        return tabla;
    }
    
    /**
     * Traduce los objetos de un mapa [atributo, valor] a un objeto concreto.
     * Si encuentra un ID entre las llaves busca el registro en la base de datos
     * y si no, crea un nuevo objeto. Sobreescribe el resto de los campos en el 
     * objeto profesor.
     * @param objeto
     */
    private Profesor parse(Dictionary objeto) {
        //Busca un ID en el mapa
        Object value = objeto.get(ID);
        //Declaramos el objeto Profesor
        Profesor p;
        //Si no se encuentra un ID en el mapa, crea un nuevo objeto, sino, busca
        //en la base de datos.
        if(value == null) p = new Profesor();
        else p = em.find(Profesor.class, value);
        //Busca el resto de los atributos y si se encuentran los sobreescribe
        value = objeto.get(NOMBRE);
        if(value!=null) p.setNombreProfesor((String) value);
        value = objeto.get(CATEGORIA);
        if(value!=null) p.setCategoriaProfesor((Character) value);
        value = objeto.get(IDIOMA);
        if(value!=null) p.setIdiomaProfesor((String) value);
        value = objeto.get(EMAIL);
        if(value!=null) p.setEmailProfesor((String) value);
        value = objeto.get(ZONAHORARIA);
        if(value!=null) p.setZonaHorariaProfesor((String) value);
        value = objeto.get(NIVEL);
        if(value!=null) p.setNivelProfesor(em.find(Nivel.class,value));
        return p;
    }

    /**
     * Agrega una lista de mapas [atributo, valor] de profesores en la base de datos.
     * Cada mapa u objeto Dictionary puede contener los siguientes atributos:
     * "id"=Integer, "nombre"=String, "categoria"=Character, "idioma"=String,
     * "email"=String, "zonahoraria"=String, "nivel"=Nivel. El resto serán ignorados.
     * @param objetos Lista de objetos {@code java.util.Dictionary} con los 
     * atributos de un objeto Profesor.
     */
    public void agregar(Collection<Dictionary> objetos) {
        //Inicia una transacción con la base de datos
        em.getTransaction().begin();
        //Recorre todos los objetos en la lista objetos
        for(Dictionary objeto: objetos) {
            //Hace el parse de tipo Dictionary y guarda el objeto Profesor en la BD.
            em.persist(parse(objeto));
        }
        //Termina la transacción con la base de datos
        em.getTransaction().commit();
    }
    
     /**
     * Agrega un nuevo registro Profesor a la base de datos.
     * @param nom Nombre del profesor (no puede ser null)
     */
    public void agregar(String nom) {
        // Crear un nuevo objeto Profesor
        Profesor nuevo = new Profesor();
        // Actualizamos el valor del atributo nombre
        nuevo.setNombreProfesor(nom);
        // Inicia una transacción con la base de datos
        em.getTransaction().begin();
        // Guarda el objeto nuevo en base de datos
        em.persist(nuevo);
        // Termina la transacción con la base de datos
        em.getTransaction().commit();
    }
    
    /**
     * Modifica una lista de mapas [atributo, valor] de profesores en la base de datos.
     * Cada mapa u objeto Dictionary puede contener los siguientes atributos:
     * "id"=Integer, "nombre"=String, "categoria"=Character, "idioma"=String,
     * "email"=String, "zonahoraria"=String, "nivel"=Nivel. El resto serán ignorados.
     * @param objetos Lista de objetos {@code java.util.Dictionary} con los 
     * atributos de un objeto Profesor.
     */
    public void modificar(Collection<Dictionary> objetos) {
        this.agregar(objetos);
    }
    
    /**
     * Modificar un nuevo registro Profesor a la base de datos.
     * @param id ID del profesor (no puede ser null)
     * @param nombre Nombre del profesor (no puede ser null)
     * @param categoria Categoria del profesor (no puede ser null)
     * @param idioma Idioma del profesor (no puede ser null)
     * @param email Email del profesor (no puede ser null)
     * @param zonahoraria Zona horaria del profesor (no puede ser null)
     * @param nivel Nivel del profesor (no puede ser null)
     */
    public void modificar(Integer id, String nombre, Character categoria, String idioma, String email, String zonahoraria, Nivel nivel) {
        //Crea un nuevo objeto Profesor
        Profesor p = em.find(Profesor.class, id);
        //Actualizamos el valor del atributo nombre
        p.setNombreProfesor(nombre);
        //Actualizamos el valor del atributo categoria
        p.setCategoriaProfesor(categoria);
        //Actualizamos el valor del atributo idioma
        p.setIdiomaProfesor(idioma);
        //Actualizamos el valor del atributo email
        p.setEmailProfesor(email);
        //Actualizamos el valor del atributo zona horaria
        p.setZonaHorariaProfesor(zonahoraria);
        //Actualizamos el valor del atributo nivel
        p.setNivelProfesor(nivel);
        //Inicia un transacción con la base de datos
        em.getTransaction().begin();
        //Guarda el objeto nuevo en base de datos
        em.persist(p);
        //Termina la transaccion con la base de datos
        em.getTransaction().commit();
    }

    /**
     * Elimina una lista de registros de la base de datos.
     * @param llaves Lista de Integer con las llaves de los registros
     * @return Regresa una lista de los objetos que se borraron
     */
    public List<Profesor> eliminar(Collection<Integer> llaves) {
        //Crear una lista nueva de objetos borrados 
        List<Profesor> borrados = new LinkedList();
        //Inicia una transaccion con la base de datos
        em.getTransaction().begin();
        //Recorre todas las llaves en la lista objetos
        for(Integer llave: llaves){
            //Busca en la base de datos el objeto Profesor
            Profesor p = em.find(Profesor.class, llave);
            //Elimina el registro de la base de datos
            em.remove(p);
            //Añade a la lista de borrados el objeto
            borrados.add(p);
        }
        //Termina la transaccion con la base de datos
        em.getTransaction().commit();
        return borrados;
    }
    
    /**
     * Elimina una lista de registros de la base de datos.
     * @param llaves Arreglo de Integer con las llaves de los registros
     * @return Regresa una lista de los objetos que se borraron
     */
    public List<Profesor> eliminar(Integer[] llaves) {
        //Crear una nueva lista de objetos borrados
        List<Profesor> borrados = new LinkedList();
        //Inicia una transaccion con la base de datos
        em.getTransaction().begin();
        //Recorre todas las llaves en la lista de objetos
        for(Integer llave: llaves) {
            //Busca en la base de datos el objeto TipoProducto
            Profesor p = em.find(Profesor.class, llave);
            //Elimina el registro de la base de datos
            em.remove(p);
            //Añade a lista de borrados el objeto
            borrados.add(p);
        }
        //Termina la transaccion con la base de datos 
        em.getTransaction().commit();
        return borrados;
    }
}