package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Paciente;

public interface PacienteCustomRepository {
    Paciente getPacienteByCorreo(String correo);
}
