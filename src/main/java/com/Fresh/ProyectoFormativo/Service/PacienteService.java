package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Paciente;

import java.util.List;

public interface PacienteService {
    Paciente ConsultarPacientePorEmail(String email);
    List<Paciente> ConsultarPaciente();
    Paciente CrearPaciente(Paciente paciente);
    Paciente ModificarPaciente(Paciente paciente);
    Paciente BuscarPaciente(int id);
    void EliminarPaciente(int id);
    void actualizarEstadoPaciente(Paciente paciente);
}
