package com.Fresh.ProyectoFormativo.Repository.PacienteCustomRepoIMPL;

import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Repository.PacienteCustomRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

public class PacienteRepoIMPL implements PacienteCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Paciente getPacienteByCorreo(String correo) {
        StoredProcedureQuery findByEmail = em.createNamedStoredProcedureQuery("ConsultarEspecialistaPorEmail").setParameter("p_correo", correo);
        return (Paciente) findByEmail.getResultList().get(0);
    }
    
}
