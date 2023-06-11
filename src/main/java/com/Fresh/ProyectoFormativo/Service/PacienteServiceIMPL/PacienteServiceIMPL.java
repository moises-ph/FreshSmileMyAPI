package com.Fresh.ProyectoFormativo.Service.PacienteServiceIMPL;
import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Repository.PacienteRepo;
import com.Fresh.ProyectoFormativo.Service.PacienteService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceIMPL implements PacienteService {

    @Autowired
    private PacienteRepo repo;

    @Override
    public Paciente ConsultarPacientePorEmail(String email) {
        return this.repo.getPacienteByCorreo(email);
    }

    @Override
    public List<Paciente> ConsultarPaciente() {
        return (List<Paciente>)this.repo.findAll();
    }

    @Override
    public Paciente CrearPaciente(Paciente paciente) {
        return this.repo.save(paciente);
    }

    @Override
    public Paciente ModificarPaciente(Paciente paciente) {
        return this.repo.save(paciente);
    }

    @Override
    public Paciente BuscarPaciente(int id) {
        Optional<Paciente> optional = this.repo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Paciente no encontrado con id: " + id);
        }
    }

    @Override
    public void EliminarPaciente(int id) {
        this.repo.deleteById(id);
    }
    @Autowired
    private EntityManager entityManager;
    @Transactional
    public void actualizarEstadoPaciente(Paciente paciente) {
        entityManager.merge(paciente);
    }



}