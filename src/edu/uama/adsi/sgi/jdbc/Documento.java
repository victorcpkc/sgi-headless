
package edu.uama.adsi.sgi.jdbc;

import java.util.Objects;

/**
 * Clase entidad de la tabla sgi.documento
 * @author Víctor M. Campuzano Pineda, e-mail: victor_cp@vianca.mx
 */
public class Documento {
    
    private Integer iddocumento;
    
    private byte[] archivoDocumento;
    
    private Object comprobanteDocumento;

    public Integer getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Integer iddocumento) {
        this.iddocumento = iddocumento;
    }

    public byte[] getArchivoDocumento() {
        return archivoDocumento;
    }

    public void setArchivoDocumento(byte[] archivoDocumento) {
        this.archivoDocumento = archivoDocumento;
    }

    public Object getComprobanteDocumento() {
        return comprobanteDocumento;
    }

    public void setComprobanteDocumento(Object comprobanteDocumento) {
        this.comprobanteDocumento = comprobanteDocumento;
    }
    
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof edu.uama.adsi.sgi.jdbc.Documento)) {
            return false;
        }
        edu.uama.adsi.sgi.jdbc.Documento other = (edu.uama.adsi.sgi.jdbc.Documento) object;
        return (this.iddocumento != null || other.iddocumento == null) && (this.iddocumento == null || this.iddocumento.equals(other.iddocumento));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.iddocumento);
        return hash;
    }

    @Override
    public String toString() {
        return "edu.uama.adsi.sgi.jdbc.Documento[ iddocumento=" + iddocumento + " ]";
    }


}
