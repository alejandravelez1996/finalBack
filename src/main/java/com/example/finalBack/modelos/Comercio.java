package com.example.finalBack.modelos;

import com.example.finalBack.modelos.utils.Estados;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "comercio")
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String direccion;
    private String telefono;

   
    @Enumerated(EnumType.STRING)
    private Estados estado;

    // RELACION: un comercio tiene muchos gastos
    @OneToMany(mappedBy = "comercio")
    private List<Gasto> gastos;

    public Comercio() {}

    
    public Integer getId() { 
        return id; 
    }
    public void setId(Integer id) { 
        this.id = id; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getDireccion() { 
        return direccion; 
    }
    public void setDireccion(String direccion) { 
        this.direccion = direccion; 
    }

    public String getTelefono() { 
        return telefono; 
    }
    public void setTelefono(String telefono) { 
        this.telefono = telefono; 
    }

    public Estados getEstado() { 
        return estado; 
    }
    public void setEstado(Estados estado) { 
        this.estado = estado; 
    }

    public List<Gasto> getGastos() { 
        return gastos; 
    }
    public void setGastos(List<Gasto> gastos) { 
        this.gastos = gastos; 
    }
}

