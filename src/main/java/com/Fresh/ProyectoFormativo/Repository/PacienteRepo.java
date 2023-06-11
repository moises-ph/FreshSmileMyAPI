package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Paciente;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepo extends CrudRepository<Paciente, Integer>, PacienteCustomRepository {

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
