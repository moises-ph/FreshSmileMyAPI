package com.Fresh.ProyectoFormativo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "citas")
@Data
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificacion_citas")
    private int identificacion_citas;

    @Column(name = "numero_documento")
    private int numero_documento;

    @Column(name = "nombre_completo")
    private String nombre_completo;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private Time hora;

    @Column(name = "id_especialista")
    private int id_especialista;

    @Column(name = "id_paciente")
    private int id_paciente;

    @Column(name = "id_procedimiento")
    private int  id_procedimiento;

    @Column(name = "estado_cita")
    private String estado_cita;

    @Column(name = "estado")
    private boolean Estado;

    @Column(name = "fecha_de_creacion")
    private LocalDateTime fecha_de_creacion;

    public int getIdentificacion_citas() {
        return identificacion_citas;
    }

    public void setIdentificacion_citas(int identificacion_citas) {
        this.identificacion_citas = identificacion_citas;
    }

    public int getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getId_especialista() {
        return id_especialista;
    }

    public void setId_especialista(int id_especialista) {
        this.id_especialista = id_especialista;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_procedimiento() {
        return id_procedimiento;
    }

    public void setId_procedimiento(int id_procedimiento) {
        this.id_procedimiento = id_procedimiento;
    }

    public String getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(String estado_cita) {
        this.estado_cita = estado_cita;
    }

    public Citas() {
        this.fecha_de_creacion= LocalDateTime.now();
        this.Estado = true;
    }

    public String getEstado() {
        if (Estado) {
            return "Activa";
        } else {
            return "Cancelada";
        }
    }
    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public LocalDateTime getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    public void setFecha_de_creacion(LocalDateTime fecha_de_creacion) {
        this.fecha_de_creacion = fecha_de_creacion;
    }
}
