package com.example.finalBack.modelos;


import com.example.finalBack.modelos.utils.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private LocalDate fechaCreacion;
    private String responsable;
    private String justificacion;
    private String descripcion;
    private double presupuestoLimite;
    private double gastoActual;


    @Enumerated(EnumType.STRING)
    private Estados estado;

    private String tipo;

   
    //RELACION: una categoria tiene MUCHOS gastos
    @OneToMany(mappedBy = "categoria")
    private List<Gasto> gastos;

    public Categoria() {

    }


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

    public LocalDate getFechaCreacion() { 
        return fechaCreacion; 
    }
    public void setFechaCreacion(LocalDate fechaCreacion) { 
        this.fechaCreacion = fechaCreacion; 
    }

    public String getResponsable() { 
        return responsable; 
    }
    public void setResponsable(String responsable) { 
        this.responsable = responsable; 
    }

    public String getJustificacion() { 
        return justificacion; 
    }
    public void setJustificacion(String justificacion) { 
        this.justificacion = justificacion; 
    }

    public String getDescripcion() { 
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }

    public double getPresupuestoLimite() { 
        return presupuestoLimite; 
    }
    public void setPresupuestoLimite(double presupuestoLimite) { 
        this.presupuestoLimite = presupuestoLimite; 
    }

    public double getGastoActual() { 
        return gastoActual; 
    }
    public void setGastoActual(double gastoActual) { 
        this.gastoActual = gastoActual; 
    }

    public Estados getEstado() { 
        return estado; 
    }
    public void setEstado(Estados estado) { 
        this.estado = estado; 
    }

    public String getTipo() { 
        return tipo; 
    }
    public void setTipo(String tipo) { 
        this.tipo = tipo; 
    }

    public List<Gasto> getGastos() { 
        return gastos; 
    }
    public void setGastos(List<Gasto> gastos) { 
        this.gastos = gastos; 
    }
}
