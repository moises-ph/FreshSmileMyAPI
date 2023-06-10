package com.Fresh.ProyectoFormativo.Service.EspecialistaServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Repository.EspecialistaRepo;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EspecialistaServiceIMPL implements EspecialistaService {
    @Autowired
    private EspecialistaRepo repo;

    @Override
    public Especialista ConsultarEspecialistaPorEmail(String email) {
        return this.repo.findEspecialistByCorreo(email);
    }

    @Override
    public List<Especialista> ConsultarEspecialistas() {
        return (List<Especialista>) this.repo.findAll();
    }

    @Override
    public Especialista CrearEspecialista(Especialista especialista) {
        return this.repo.save(especialista);
    }

    @Override
    public Especialista ModificarEspecialista(Especialista especialista) {
        return this.repo.save(especialista);
    }

    @Override
    public Especialista BuscarEspecialista(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarEspecialista(int id) {
        this.repo.deleteById(id);
    }


}