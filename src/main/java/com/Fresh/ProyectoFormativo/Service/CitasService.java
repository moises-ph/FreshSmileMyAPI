package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Citas;

import java.util.List;

public interface CitasService {
    public List<Citas> ConsultarCitas();
    public Citas CrearCita(Citas citas);
    public Citas ModificarCita(Citas citas);
    public Citas BuscarCita(int id);
    public void CancelarCita(int id);
}