
package edu.uama.adsi.sgi.servicios;

import edu.uama.adsi.sgi.entidades.TipoProducto;
import java.io.InputStream;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/*
 * Gestor de tipos de productos (catálogo de productos).
 * Gestiona las operaciones realizadas sobre los objetos TipoProducto.
 * Proveé a la capa de presentación las listas y tablas de los tipos de 
 * productos, además de métodos para administrarlos en la base de datos 
 * desde la interfaz de linea de comandos (headless).
 * @author Leonardi
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
     * Listar todos los tipos de productos.
     * Genera una lista de objetos {@code TipoProducto} con todos los 
     * registros de la tabla tipo_producto.
     * @return Una lista con los tipos de productos encontrados, vacia si no 
     * encuentra.
     */
    public List<TipoProducto> listarTodos(){
        //consultar a la base de datos 
        return em.createNamedQuery("TipoProducto.findAll").getResultList();
    }
    
    /**
     * Tabla de todos los tipos de productos.
     * Genera una lista con un arreglo formado por [ID, Nombre, Puntaje], en otras 
     * palabras una tabla con las columnas ID de tipo {@code Integer},
     * Nombre de tipo {@code String} y Puntaje de tipo {@code String} y cada 
     * elemento de la lista es un renglón.
     * @return Una lista con la la fila de los tipos de productos 
     * encontrados, vacia si no encuentra.
     */
    public List<Object[]> tablaTodos(){
        //Crear una nueva lista
        List<Object []> tabla = new LinkedList();
        //Recorrer todos los elementos de la lista obtenida con el método: listartodos()
        for(TipoProducto tp: listarTodos()){
            // Añadir a la lista un nuevo renglon 
            tabla.add(new Object[]{
                tp.getIdtipoProducto(),
                tp.getNombreTipoProducto(),
                tp.getPuntajeTipoProducto()
            });
        }
        return tabla;
    }
    
    /**
     * Traduce los objetos de un mapa [atributo,valor] a un objeto concreto.
     * Si encuentra un ID entre las llaves busca el registro en la base de datos 
     * y si no, crea un nuevo objeto. Sobreescribe el resto de los campos en el
     * objeto tipo producto.
     * @param objeto
     * @return 
     */
    private TipoProducto parse(Dictionary objeto){
        // Busca un ID en el mapa
        Object value = objeto.get(ID);
        // Declaramos el objeto TipoProducto
        TipoProducto tp;
        // Si no encuentró un ID en el mapa, crea un nuevo objeto, sino, busca en la base de datos
        if(value == null) tp = new TipoProducto();
        else tp = em.find(TipoProducto.class, value);
        
        // Busca el resto de los atributos y si se encuentran los sobreescribe
        value = objeto.get(NOMBRE);
        if(value!=null) tp.setNombreTipoProducto((String)value); // Si value no es de tipo String va a mandar una excepción
        
        value = objeto.get(PUNTAJE);
        if(value!=null) tp.setPuntajeTipoProducto((Double)value); //si value no es de tipo Double va a mandar una excepción
        
        return tp;
    }
    
     /**
     * Agrega una lista de mapas [atributo, valor] de tipos de productos en 
     * la base de datos.
     * Cada mapa u objeto Dictionary puede contener los siguientes atributos:
     * "id"=String, "nombre"=String, "puntaje"=String. El resto serán ignorados.
     * @param objetos Lista de objetos {@code java.util.Dictionary} con los 
     * atributos de un objeto TipoProducto.
     */
    public void agregar(Collection<Dictionary> objetos){
        // Inicia una transacción con la base de datos
        em.getTransaction().begin();
        // Recorre todos los objetos en la lista objetos
        for(Dictionary objeto: objetos){
            // hace el parse de tipo Dictionary y guarda el objeto TipoProducto en base de datos
            em.persist(parse(objeto));
        }
        // Termina la transacción con la base de datos
        em.getTransaction().commit();
    }
    
     /**
     * Agrega un nuevo registro TipoProducto a la base de datos.
     * @param nom Nombre del tipo de producto (no puede ser null)
     */
    public void agregar(String nom){
        // Crear un nuevo objeto TipoProducto
        TipoProducto nuevo = new TipoProducto();
        // Actualizamos el valor del atributo descripción
        nuevo.setNombreTipoProducto(nom);
        // Inicia una transacción con la base de datos
        em.getTransaction().begin();
        // Guarda el objeto nuevo en base de datos
        em.persist(nuevo);
        // Termina la transacción con la base de datos
        em.getTransaction().commit();
    }
    
    /**
     * Modifíca una lista de mapas [atributo, valor] de tipos de productos en 
     * la base de datos.
     * Cada mapa u objeto Dictionary puede contener los siguientes atributos:
     * "id"=String, "nombre"=String, "puntaje"=String. El resto serán ignorados.
     * @param objetos Lista de objetos {@code java.util.Dictionary} con los 
     * atributos de un objeto TipoProducto.
     */
    public void modificar(Collection<Dictionary> objetos){
        this.agregar(objetos);
    }
    
    /**
     * Modificar un nuevo registro TipoProducto a la base de datos.
     * @param id ID del tipo de producto (no puede ser null)
     * @param nombre Nombre del tipo de producto (no puede ser null)
     * @param puntaje Puntaje del tipo de producto (no puede ser null)
     */
    public void modificar(String id, String nombre, String puntaje){
        //Crea un nuevo objeto TipoProducto
        TipoProducto tp = em.find(TipoProducto.class, id);
        //Actualizamos el valor del atributo nombre
        tp.setNombreTipoProducto(nombre);
        //Actualizamos el valor del atributo puntaje
        tp.setPuntajeTipoProducto(puntaje);//no supe como arreglar este error
        //Inicia un transacción con la base de datos
        em.getTransaction().begin();
        //Guarda el objeto nuevo en base de datos
        em.persist(tp);
        //Termina la transaccion con la base de datos
        em.getTransaction().commit();
    }
        
    /**
     * Elimina una lista de registros de la base de datos.
     * @param llaves Lista de Integer con las llaves de los registros
     * @return Regresa una lista de los objetos que se borraron
     */
    public List<TipoProducto> eliminar(Collection<Integer> llaves){
        //Crear una lista nueva de objetos borrados 
        List<TipoProducto> borrados = new LinkedList();
        //Inicia una transaccion con la base de datos
        em.getTransaction().begin();
        //Recorre todas las llaves en la lista objetos 
        for(Integer llave: llaves){
            //Busca en la base de datos el objeto TipoProducto 
            TipoProducto tp = em.find(TipoProducto.class, llave);
            //Elimina el registro de la base de datos
            em.remove(tp);
            //Añade a la lista de borrados el objeto
            borrados.add(tp);
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
    public List<TipoProducto> eliminar(Integer[] llaves){
        //Crear una nueva lista de objetos borrados
        List<TipoProducto> borrados = new LinkedList();
        //Inicia una transaccion con la base de datos
        em.getTransaction().begin();
        //Recorre todas las llaves en la lista de objetos
        for(Integer llave: llaves){
            //Busca en la base de datos el objeto TipoProducto
            TipoProducto tp = em.find(TipoProducto.class, llave);
            //Elimina el registro de la base de datos
            em.remove(tp);
            //Añade a lista de borrados el objeto
            borrados.add(tp);
        }
        //Termina la transaccion con la base de datos 
        em.getTransaction().commit();
        return borrados;
    }
}
