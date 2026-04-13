package com.example.finalBack.modelos;

import java.time.LocalDate;
import java.util.List;

import com.example.finalBack.modelos.utils.TipoDocumento;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="nombresCompletos", nullable=false, length=50)
    private String nombre;

    @Column(nullable=false, length=50)
    private String apellido;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_documento", nullable=false)
    private TipoDocumento tipodoc;

    @Column(name="documento", nullable=false, unique=true, length=15)
    private String documento;

    @Column(nullable=true)
    private Integer edad;

    @Column(name="email", nullable=false, unique=true, length=50)
    private String email;

    @Column(name="telefono", nullable=true)
    private String telefono;

    @Column(name="direccion", nullable=true)
    private String direccion;

    @Column(nullable=true)
    private double saldoDisponible;

    @Column(nullable=true)
    private LocalDate fechaRegistro;

    // RELACION: 1 usuario → muchos gastos
    @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;

    // RELACION: 1 usuario → muchos metodos de pago
    @OneToMany(mappedBy = "usuario")
    private List<MetodoPago> metodoPagos;

    public Usuario() {
    }

    // GETTERS Y SETTERS

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDocumento getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(TipoDocumento tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<MetodoPago> getMetodoPagos() {
        return metodoPagos;
    }

    public void setMetodoPagos(List<MetodoPago> metodoPagos) {
        this.metodoPagos = metodoPagos;
    }
}