package com.Fresh.ProyectoFormativo.Service;

import com.Fresh.ProyectoFormativo.Entity.Procedimiento;

import java.util.List;

public interface ProcedimientoService {
    List<Procedimiento> ConsultarProcedimientos();
    Procedimiento CrearProcedimiento(Procedimiento procedimiento);
    Procedimiento ModificarProcedimiento(Procedimiento procedimiento);
    Procedimiento BuscarProcedimiento(int id);
    void EliminarProcedimiento(int id);
}
