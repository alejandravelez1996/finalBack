package com.example.finalBack.modelos;



import com.example.finalBack.modelos.utils.Estados;
import com.example.finalBack.modelos.utils.MetodoPagoEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private MetodoPagoEnum tipo;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Estados estado;

    // RELACION: muchos metodos → 1 usuario
    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    public MetodoPago() {}


    public Integer getId() { 
        return id; 
    }
    public void setId(Integer id) { 
        this.id = id; 
    }

    public MetodoPagoEnum getTipo() { 
        return tipo; 
    }
    public void setTipo(MetodoPagoEnum tipo) { 
        this.tipo = tipo; 
    }

    public String getDescripcion() { 
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }

    public Estados getEstado() { 
        return estado; 
    }
    public void setEstado(Estados estado) { 
        this.estado = estado; 
    }

    public Usuario getUsuario() { 
        return usuario; 
    }
    public void setUsuario(Usuario usuario) { 
        this.usuario = usuario; 
    }
}
