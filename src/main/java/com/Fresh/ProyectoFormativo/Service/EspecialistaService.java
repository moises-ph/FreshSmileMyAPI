package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Especialista;

import java.util.List;

public interface EspecialistaService {
    public Especialista ConsultarEspecialistaPorEmail(String email);
    public List<Especialista> ConsultarEspecialistas();
    public Especialista CrearEspecialista(Especialista especialista);
    public Especialista ModificarEspecialista(Especialista especialista);
    public Especialista BuscarEspecialista(int id);
    public void EliminarEspecialista(int id);

}
