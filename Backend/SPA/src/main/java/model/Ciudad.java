package model;

import jakarta.persistence.*;


@Entity
@Table(name = "ciudad", schema = "data")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String descripcion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ciudad() {
        super();
    }

    public Ciudad(String name, String descripcion) {
        super();
        this.name = name;
        this.descripcion = descripcion;
    }

    public Ciudad(long id, String name, String descripcion) {
        super();
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
    }
}