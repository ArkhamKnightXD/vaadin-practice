package knight.arkham.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


//Entidad usada para seguir el videotutorial vaadin webinar
@Entity
public class Comentario {
    @Id
    @GeneratedValue
    private Long id;

    private String contenido;
    private Date fecha;

    public Comentario() {
    }

    public Comentario(String contenido) {

        this();
        setContenido(contenido);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
