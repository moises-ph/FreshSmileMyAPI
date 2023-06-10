package com.Fresh.ProyectoFormativo.Service.ProcedimientoServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Procedimiento;
import com.Fresh.ProyectoFormativo.Repository.ProcedimientoRepo;
import com.Fresh.ProyectoFormativo.Service.ProcedimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimientoServiceIMPL implements ProcedimientoService {
    @Autowired
    private ProcedimientoRepo repo;

    @Override
    public List<Procedimiento>ConsultarProcedimientos() {
        return (List<Procedimiento>) this.repo.findAll();
    }

    @Override
    public Procedimiento CrearProcedimiento(Procedimiento procedimiento) {
        procedimiento.setNombre(procedimiento.getNombre());
        return this.repo.save(procedimiento);
    }

    @Override
    public Procedimiento ModificarProcedimiento(Procedimiento procedimiento) {
        return this.repo.save(procedimiento);
    }

    @Override
    public Procedimiento BuscarProcedimiento(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarProcedimiento(int id) {
        this.repo.deleteById(id);
    }
}