package com.Fresh.ProyectoFormativo.Service.Codigo_administradorServiceIMPL;

import com.Fresh.ProyectoFormativo.Entity.Codigo_administrador;
import com.Fresh.ProyectoFormativo.Repository.Codigo_administradorRepo;
import com.Fresh.ProyectoFormativo.Service.Codigo_administradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Codigo_administradorServiceIMPL implements Codigo_administradorService {
    @Autowired
    private Codigo_administradorRepo repo;

    @Override
    public List<Codigo_administrador> ConsultarCodigo() {
        return (List<Codigo_administrador>) this.repo.findAll();
    }

    @Override
    public Codigo_administrador BuscarCodigo(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public Codigo_administrador ModificarCodigo(Codigo_administrador codigoAdministrador) {
        return this.repo.save(codigoAdministrador);
    }

}