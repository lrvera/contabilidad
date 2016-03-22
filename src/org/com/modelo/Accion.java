package org.com.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author lrvera
 */
@Entity
@TableGenerator(name = "AccionGenerator", table = "IdentityGenerator",
        pkColumnName = "name", valueColumnName = "value",
        pkColumnValue = "Accion", initialValue = 1, allocationSize = 1)
public class Accion implements Serializable {

//    ATRIBUTOS
    @Id
    @GeneratedValue(generator = "AccionGenerator", strategy = GenerationType.TABLE)
    private Long id;
    private String icono;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = true)
    private String url;
    @Column(nullable = false)
    private Integer prioridad;

    @OrderBy("priority ASC")
    @OneToMany(mappedBy = "pariente")
    private List<Accion> acciones;

    @Transient
    private Map<String, String> parametros;

    @ManyToOne
    private Accion pariente;

//    CONSTRUCTOR
    public Accion(Long id, String icono, String nombre, String url, Integer prioridad, List<Accion> acciones, Map<String, String> parametros, Accion pariente) {
        this.id = id;
        this.icono = icono;
        this.nombre = nombre;
        this.url = url;
        this.prioridad = prioridad;
        this.acciones = acciones;
        this.parametros = parametros;
        this.pariente = pariente;
    }

    public Accion() {
    }

//    GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public List<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String> parametros) {
        this.parametros = parametros;
    }

    public Accion getPariente() {
        return pariente;
    }

    public void setPariente(Accion pariente) {
        this.pariente = pariente;
    }

//    METODOS
    
    public void addAccion(Accion accion){
        if(accion!=null && !acciones.contains(accion)){
            acciones.add(accion);
        }
    }
    
    public void deleteAccion(Accion accion){
        if(accion!=null && acciones.contains(accion)){
            acciones.remove(accion);
        }
    }

            
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.icono);
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.url);
        hash = 31 * hash + Objects.hashCode(this.prioridad);
        hash = 31 * hash + Objects.hashCode(this.acciones);
        hash = 31 * hash + Objects.hashCode(this.parametros);
        hash = 31 * hash + Objects.hashCode(this.pariente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Accion other = (Accion) obj;
        if (!Objects.equals(this.icono, other.icono)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.prioridad, other.prioridad)) {
            return false;
        }
        if (!Objects.equals(this.acciones, other.acciones)) {
            return false;
        }
        if (!Objects.equals(this.parametros, other.parametros)) {
            return false;
        }
        if (!Objects.equals(this.pariente, other.pariente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Accion{" + "id=" + id + ", icono=" + icono + ", nombre="
                + nombre + ", url=" + url + ", prioridad=" + prioridad
                + ", acciones=" + acciones + ", parametros=" + parametros
                + ", pariente=" + pariente + '}';
    }
}
