package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Procedimiento;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface ProcedimientoRepo extends CrudRepository<Procedimiento,Integer> {
    @Procedure("ConsultarProcedimientoPorIdentificacion")
    Procedimiento findProcedureBy(int id);

    @Procedure("CrearProcedimiento")
    String createProcedure(Procedimiento newProcedure);

    @Procedure("ModificarProcedimiento")
    String modifyProcedure(Procedimiento newProcedure);

    @Procedure("EliminarProcedimiento")
    String deleteProcedure(int id);

}
