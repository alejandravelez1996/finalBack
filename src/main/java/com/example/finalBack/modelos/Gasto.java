package com.example.finalBack.modelos;

import com.example.finalBack.modelos.utils.Estados;
import com.example.finalBack.modelos.utils.TipoGasto;
import com.example.finalBack.modelos.utils.MetodoPagoEnum;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "gasto")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;
    private double monto;
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private Estados estado;

    @Enumerated(EnumType.STRING)
    private TipoGasto tipo;

    @Enumerated(EnumType.STRING)
    private MetodoPagoEnum metodoPago;

    //RELACION: muchos gastos → 1 usuario
    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    // RELACION: muchos gastos → 1 categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // RELACION: muchos gastos → 1 comercio
    @ManyToOne
    @JoinColumn(name = "comercio_id")
    private Comercio comercio;

    public Gasto() {}

    // GETTERS Y SETTERS

    public Integer getId(){ 
        return id; 
    }

    public void setId(Integer id) { 
        this.id = id; 
    }

    public String getDescripcion() { 
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }

    public double getMonto() { 
        return monto; 
    }
    public void setMonto(double monto) { 
        this.monto = monto; 
    }

    public LocalDate getFecha() { 
        return fecha; 
    }
    public void setFecha(LocalDate fecha) { 
        this.fecha = fecha; 
    }

    public Estados getEstado() { 
        return estado; 
    }
    public void setEstado(Estados estado) { 
        this.estado = estado; 
    }

    public TipoGasto getTipo() { 
        return tipo; 
    }
    public void setTipo(TipoGasto tipo) { 
        this.tipo = tipo; 
    }

    public MetodoPagoEnum getMetodoPago() { 
        return metodoPago; 
    }
    public void setMetodoPago(MetodoPagoEnum metodoPago) { 
        this.metodoPago = metodoPago; 
    }

    public Usuario getUsuario() { 
        return usuario; 
    }
    public void setUsuario(Usuario usuario) { 
        this.usuario = usuario; 
    }

    public Categoria getCategoria() { 
        return categoria; 
    }
    public void setCategoria(Categoria categoria) { 
        this.categoria = categoria; 
    }

    public Comercio getComercio() { 
        return comercio; 
    }
    public void setComercio(Comercio comercio) { 
        this.comercio = comercio; 
    }
}
