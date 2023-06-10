package com.Fresh.ProyectoFormativo.Service;


import com.Fresh.ProyectoFormativo.Entity.Codigo_administrador;
import com.Fresh.ProyectoFormativo.Entity.Paciente;

import java.util.List;

public interface Codigo_administradorService {
    public List<Codigo_administrador> ConsultarCodigo();
    Codigo_administrador BuscarCodigo(int id);

    public Codigo_administrador ModificarCodigo(Codigo_administrador codigoAdministrador);
}
