
package edu.uama.adsi.sgi.servicios;

import edu.uama.adsi.sgi.entidades.TipoComprobante;
import java.util.Collection;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Gestor de tipos de comprobantes (catálogo de comprobantes).
 * Gestiona las operaciones realizadas sobre los objetos TipoComprobante.
 * Proveé a la capa de presentación las listas y tablas de los tipos de 
 * comprobantes, además de métodos para administrarlos en la base de datos 
 * desde la interfaz de linea de comandos (headless).
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
public class ServicioTipoComprobante {

    public static final String ID = "id";
    public static final String DESCRIPCION = "desc";
    
    private EntityManager em;
    
    public ServicioTipoComprobante(){
    }
    
    public ServicioTipoComprobante(EntityManager em){
        this.em = em;
    }

    public EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * Listar todos los tipos de comprobantes.
     * Genera una lista de objetos {@code TipoComprobante} con todos los 
     * registros de la tabla tipo_comprobante.
     * @return Una lista con los tipos de comprobantes encontrados, vacia si no 
     * encuentra.
     */
    public List<TipoComprobante> listarTodos(){
        // Consultar a la base de datos
        return em.createNamedQuery("TipoComprobante.findAll").getResultList();
    }
    
    /**
     * Tabla de todos los tipos de comprobantes.
     * Genera una lista con un arreglo formado por [ID, Descripción], en otras 
     * palabras una tabla con las columnas ID de tipo {@code Integer} y 
     * Descripción de tipo {@code String} y cada elemento de la lista es un 
     * renglón.
     * @return Una lista con la la fila de los tipos de comprobantes 
     * encontrados, vacia si no encuentra.
     */
    public List<Object[]> tablaTodos(){
        // Crear una nueva lista
        List<Object[]> tabla = new LinkedList();
        // Recorrer todos los elementos de la lista obtenida con el método: listarTodos()
        for(TipoComprobante tp: listarTodos()){
            // Añadir a la lista un nuevo renglon 
            tabla.add(new Object[]{tp.getIdtipoComprobante()
                    ,tp.getDescripcionTipoComprobante()});
        }
        return tabla;
    }
    
    /**
     * Traduce los objetos de un mapa [atributo, valor] a un objeto concreto.
     * Si encuentra un ID entre las llaves busca el registro en la base de datos
     * y si no, crea un nuevo objeto. Sobreescribe el resto de los campos en el 
     * objeto tipo comprobante.
     * @param objeto
     * @return 
     */
    private TipoComprobante parse(Dictionary objeto){
        // Busca un ID en el mapa
        Object value = objeto.get(ID);
        // Declaramos el objeto TipoComprobante
        TipoComprobante tc;
        // Si no encuentró un ID en el mapa, crea un nuevo objeto, sino, busca en la base de datos
        if(value == null) tc = new TipoComprobante();
        else tc = em.find(TipoComprobante.class, value);
        
        // Busca el resto de los atributos y si se encuentran los sobreescribe
        value = objeto.get(DESCRIPCION);
        if(value!=null) tc.setDescripcionTipoComprobante((String)value); // Si value no es de tipo String va a mandar una excepción
        
        return tc;
    }
    
    /**
     * Agrega una lista de mapas [atributo, valor] de tipos de comprobantes en 
     * la base de datos.
     * Cada mapa u objeto Dictionary puede contener los siguientes atributos:
     * "id"=Integer, "desc"=String. El resto serán ignorados.
     * @param objetos Lista de objetos {@code java.util.Dictionary} con los 
     * atributos de un objeto TipoComprobante.
     */
    public void agregar(Collection<Dictionary> objetos){
        // Inicia una transacción con la base de datos
        em.getTransaction().begin();
        // Recorre todos los objetos en la lista objetos
        for(Dictionary objeto: objetos){
            // hace el parse de tipo Dictionary y guarda el objeto TipoComprobante en base de datos
            em.persist(parse(objeto));
        }
        // Termina la transacción con la base de datos
        em.getTransaction().commit();
    }
    
    /**
     * Agrega un nuevo registro TipoComprobante a la base de datos.
     * @param desc Descripción del tipo de comprobante (no puede ser null)
     */
    public void agregar(String desc){
        // Crear un nuevo objeto TipoComprobante
        TipoComprobante nuevo = new TipoComprobante();
        // Actualizamos el valor del atributo descripción
        nuevo.setDescripcionTipoComprobante(desc);
        // Inicia una transacción con la base de datos
        em.getTransaction().begin();
        // Guarda el objeto nuevo en base de datos
        em.persist(nuevo);
        // Termina la transacción con la base de datos
        em.getTransaction().commit();
    }
    
    /**
     * Modifíca una lista de mapas [atributo, valor] de tipos de comprobantes en 
     * la base de datos.
     * Cada mapa u objeto Dictionary puede contener los siguientes atributos:
     * "id"=Integer, "desc"=String. El resto serán ignorados.
     * @param objetos Lista de objetos {@code java.util.Dictionary} con los 
     * atributos de un objeto TipoComprobante.
     */
    public void modificar(Collection<Dictionary> objetos){
        // Hace lo mismo ya que el método parse hace la mágia.
        this.agregar(objetos);
    }
    
    /**
     * Modificar un nuevo registro TipoComprobante a la base de datos.
     * @param id Integer con el ID del registro
     * @param desc Descripción del tipo de comprobante (no puede ser null)
     */
    public void modificar(Integer id, String desc){
        // Crear un nuevo objeto TipoComprobante
        TipoComprobante tc = em.find(TipoComprobante.class, id);
        // Actualizamos el valor del atributo descripción
        tc.setDescripcionTipoComprobante(desc);
        // Inicia una transacción con la base de datos
        em.getTransaction().begin();
        // Guarda el objeto nuevo en base de datos
        em.persist(tc);
        // Termina la transacción con la base de datos
        em.getTransaction().commit();
    }
    
    /**
     * Elimina una lista de registros de la base de datos.
     * @param llaves Lista de Integer con las llaves de los registros
     * @return Regresa una lista de los objetos que se borraron
     */
    public List<TipoComprobante> eliminar(Collection<Integer> llaves){
        // Crear una nueva lista de objetos borrados
        List<TipoComprobante> borrados = new LinkedList();
        // Inicia una transacción con la base de datos
        em.getTransaction().begin();
        // Recorre todos las llaves en la lista objetos
        for(Integer llave: llaves){
            // Busca en la base de datos el objeto TipoComprobante
            TipoComprobante tc = em.find(TipoComprobante.class, llave);
            // Elimina el registro de la base de datos
            em.remove(tc);
            // Añade a la lista de borrados el objeto
            borrados.add(tc);
        }
        // Termina la transacción con la base de datos
        em.getTransaction().commit();
        return borrados; 
    }
    
    /**
     * Elimina una lista de registros de la base de datos.
     * @param llaves Arreglo de Integer con las llaves de los registros
     * @return Regresa una lista de los objetos que se borraron
     */
    public List<TipoComprobante> eliminar(Integer[] llaves){
        // Crear una nueva lista de objetos borrados
        List<TipoComprobante> borrados = new LinkedList();
        // Inicia una transacción con la base de datos
        em.getTransaction().begin();
        // Recorre todos las llaves en la lista objetos
        for(Integer llave: llaves){
            // Busca en la base de datos el objeto TipoComprobante
            TipoComprobante tc = em.find(TipoComprobante.class, llave);
            // Elimina el registro de la base de datos
            em.remove(tc);
            // Añade a la lista de borrados el objeto
            borrados.add(tc);
        }
        // Termina la transacción con la base de datos
        em.getTransaction().commit();
        return borrados; 
    }
}
