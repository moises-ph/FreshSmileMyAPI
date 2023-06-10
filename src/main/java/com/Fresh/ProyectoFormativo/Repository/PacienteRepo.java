package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepo extends CrudRepository<Paciente, Integer> {

    @Query("SELECT e.identificacion_especialista FROM especialista e where correo = ?1")
    Paciente findPacienteByCorreo(String p_correo);

    @Procedure("ConsultarPacientePorIdentificacion")
    Paciente findByPacientId(int Id);

    @Procedure("CrearPaciente")
    String createPacient(Paciente newPacient);

    @Procedure("ModificarPaciente")
    String modifyPacient(Paciente newPacient);

    @Procedure("EliminarPaciente")
    String deletePacient(int Id);

    @Procedure("CambiarEstadoPaciente")
    String changePacientStatus(int Id, boolean estatus);
}
