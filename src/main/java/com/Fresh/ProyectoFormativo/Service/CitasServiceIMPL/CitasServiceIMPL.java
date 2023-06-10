package com.Fresh.ProyectoFormativo.Service.CitasServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Citas;
import com.Fresh.ProyectoFormativo.Repository.CitasRepo;
import com.Fresh.ProyectoFormativo.Service.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasServiceIMPL implements CitasService {
    @Autowired
    private CitasRepo repo;

    @Override
    public List<Citas> ConsultarCitas() {
        return (List<Citas>) this.repo.findAll();
    }

    @Override
    public Citas CrearCita(Citas citas) {
        citas.setEstado_cita(citas.getEstado_cita());
        return this.repo.save(citas);
    }

    @Override
    public Citas ModificarCita(Citas citas) {
        return this.repo.save(citas);
    }

    @Override
    public Citas BuscarCita(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void CancelarCita(int id) {
        this.repo.deleteById(id);
    }
}