package com.Fresh.ProyectoFormativo.Repository;

import com.Fresh.ProyectoFormativo.Entity.Citas;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CitasRepo extends CrudRepository<Citas,Integer> {
    @Procedure("ConsultarCitaPorIdentificacion")
    Citas findCitasBy(int id);

    @Procedure("crear_cita")
    String createCita(Citas newCita);

    @Procedure("modificar_cita")
    void modifyCita(Citas newCita);

    @Procedure("ConsultarCitasFecha")
    List<Citas> findCitasByDate(Date date);

    @Procedure("ModificarEstadoCita")
    void changeCitasState(int id, String state);

    @Procedure("ConsultarCitasPaciente")
    List<Citas> findCitasByPacient(int id);

    @Procedure("ConsultarCitasRangoFecha")
    List<Citas> findCitasBetweenDates(Date start, Date end);

    @Procedure("EliminarCita")
    String deleteCita(int id);
}
