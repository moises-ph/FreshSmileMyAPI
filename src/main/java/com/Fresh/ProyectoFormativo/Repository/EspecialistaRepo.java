package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EspecialistaRepo extends CrudRepository<Especialista,Integer> {

    @Transactional(readOnly = true )
    @Procedure("ConsultarEspecialistaPorEmail")
    Especialista findEspecialistByCorreo(String p_correo);
    @Procedure("ConsultarEspecialistaPorIdentificacion")
    Especialista findEspecialistById(int id);
    @Procedure("CrearEspecialista")
    String newEspecialist(Especialista newEspecialist);
    @Procedure("ModificarEspecialista")
    String modifyEspecialist(Especialista especialista);

    @Procedure("EliminarEspecialista")
    String deleteEspecialist(int id);


}
