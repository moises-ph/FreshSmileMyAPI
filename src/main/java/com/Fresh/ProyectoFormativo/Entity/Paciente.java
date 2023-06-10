package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
@Table(name = "paciente")
public class Paciente {

    @Id
    @Column(name = "identificacion_paciente")
    private int identificacion_paciente;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "nombre_completo")
    private String nombre_completo;

    @Column(name = "telefono")
    private String  telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "fecha_registro")
    private LocalDateTime fecha_registro;

    @Column(name = "estado")
    private boolean Estado;

    public int getIdentificacion_paciente() {
        return identificacion_paciente;
    }

    public void setIdentificacion_paciente(int identificacion_paciente) {
        this.identificacion_paciente = identificacion_paciente;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }


    public Paciente() {
        this.fecha_registro= LocalDateTime.now();
        this.Estado = true;
    }

    public String getEstado() {
        if (Estado) {
            return "Activo";
        } else {
            return "Desactivo";
        }
    }
    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

}

