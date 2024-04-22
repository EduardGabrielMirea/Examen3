package examen3.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Factura> facturas;

    public Cliente(Long id, String nombre, List<Factura> facturas) {
        this.id = id;
        this.nombre = nombre;
        this.facturas = new ArrayList<>();
    }

    public Cliente(String nombre){
        this.nombre = nombre;
    }
    public Cliente() {
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString(){
        return " - "+id+" - "+nombre;
    }
}
