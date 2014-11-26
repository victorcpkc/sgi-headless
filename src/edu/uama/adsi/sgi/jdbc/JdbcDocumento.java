
package edu.uama.adsi.sgi.jdbc;

import edu.uama.adsi.sgi.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador JDBC para la clase entidad Documento
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
public class JdbcDocumento {
    
    private final Connection conexion;
    
    private Documento documento;

    /**
     * Crea un ejemplar de JdbcDocumento
     * @param conexion Conexión activa a la bases de datos.
     */
    public JdbcDocumento(Connection conexion) {
        this.conexion = conexion;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public Documento getDocumento(){
        return documento;
    }
    
    /**
     * Crea un nuevo Documento gestionado
     * @return Un nuevo documento gestionado
     */
    public Documento nuevoDocumento(){
       return documento = new Documento();
    }
    
    /**
     * Carga un nuevo documento en el gestor.
     * Recupera un registro de la tabla documento en la base de datos filtrado
     * por la llave primaria (iddocumento).
     * @param iddocumento Llave primria del documento a recuperar
     * @return Un objeto documento con la información recuperada ó null si no
     * es encontrado.
     * @throws java.sql.SQLException
     */
    public Documento cargar(Integer iddocumento) throws SQLException {
        // Crear una nueva transacción con la base de datos
        Statement stmt = conexion.createStatement();
        // Ejecutar una consulta a la tabla documento
        ResultSet result = stmt.executeQuery("select * form documento where iddocumento = "+iddocumento);
        // Si el ResultSet contiene un registro (no está vacío)
        if(result.next()) try {
            // Crear un nuevo documento y llenarlo;
            documento = new Documento();
            documento.setIddocumento(result.getInt("iddcumento"));
            documento.setArchivoDocumento(result.getBytes("archivo_documento"));
            documento.setComprobanteDocumento(result.getInt("comprobante_documento"));
            return documento;
        }finally {
            // Cerrar transación con la base de datos
            stmt.close();
        }
        return null;
    }
    
    /**
     * Guarda el documento actual.
     * Persiste el objeto entidad, si el registro no existe inserta uno nuevo, 
     * de lo contrario actualiza el registro.
     * @return Verdadero si se actualiza o falso si no.
     * @throws java.sql.SQLException
     */
    public boolean guardar() throws SQLException{
        // Si el documento no tiene un ID es un registro nuevo
        if(documento.getIddocumento() == null){
            // Crear una transacción para ejecutar el insert. Este tipo de transacción intercambia los símbolos ? por un valor ya perparado para SQL
            PreparedStatement ps = conexion.prepareStatement("insert into documento "
                    + "(archivo_documento, comprobante_documento) values (?, ?)");
            ps.setBytes(1, documento.getArchivoDocumento());
            ps.setInt(2, (Integer) documento.getComprobanteDocumento());
            return ps.executeUpdate()>0;
        } else {
            // Crear una transacción para ejecutar el update.
            PreparedStatement ps = conexion.prepareStatement("update documento "
                    + "set archivo_documento=?, comprobante_documento=? "
                    + "where iddocumento=?");
            ps.setBytes(1, documento.getArchivoDocumento());
            ps.setInt(2, (Integer) documento.getComprobanteDocumento());
            ps.setInt(3, documento.getIddocumento());
            return ps.executeUpdate()>0;
        }
    }
    
    /**
     * Borra el documento actual.
     * Actualiza el objeto acutal y lo borra.
     * @return El documento que se borró o null si no logró borrarlo.
     * @throws SQLException 
     */
    public Documento borrar() throws SQLException{
        if(cargar(documento.getIddocumento())!=null){
            PreparedStatement ps = conexion.prepareStatement("delete from "
                    + "documento where iddocumento=?");
            ps.setInt(1, documento.getIddocumento());
            if(ps.executeUpdate()>0) return documento;
        }
        return null;
    }
    
    /**
     * Método para la prueba del gestor.
     * Este método tiene la finalidad de crear una conexión a la base de datos
     * mediante JDBC y crear un ejemplar de JdbcDocumento para probar los
     * los métodos de este gestor.
     * 
     * *************** NOTA IMPORTANTE ****************
     * Se supone que elegimos entidades que no tuvieran relaciones porque
     * se tendrían que insertar primero los registros de las relaciones.
     * Cuando elegí esta clase no me fijé que tenía una relación con la clase
     * Comprobante, así que no van a funcionar mis pruebas (la base de datos 
     * regresará una excepción de Non-valid Forgein Key), pero las suyas 
     * deberían verse muy similar.
     * ************************************************
     * @param args Cualquier valor es ignorado.
     */
    public static void main(String[] args){
        try {
            // Crear la conexión a la base de datos;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sgi",
                    "sgiuser", "shrek");
            // Nuevo ejemplar del gestor de documento
            JdbcDocumento jdoc = new JdbcDocumento(conn);
            
//            // ++++++++++ Prueba de inserción ++++++++++
//            jdoc.nuevoDocumento();
//            jdoc.getDocumento().setArchivoDocumento("Hola mundo!".getBytes());
//            jdoc.getDocumento().setComprobanteDocumento(1);
//            jdoc.guardar();
            
            // ++++++++++ Prueba de consulta ++++++++++
            jdoc.cargar(1);
            System.out.println(jdoc.getDocumento());
            
            // ++++++++++ Prueba de modificación ++++++++++
            jdoc.getDocumento().setArchivoDocumento("Adios mundo cruel!".getBytes());
            jdoc.guardar();
            
            // ++++++++++ Prueba de borrado ++++++++++
            jdoc.borrar();
            
        } catch (InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
