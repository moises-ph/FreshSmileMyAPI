package com.Fresh.ProyectoFormativo.Controller;


import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Repository.PacienteRepo;
import com.Fresh.ProyectoFormativo.Service.PacienteService;
import com.Fresh.ProyectoFormativo.Service.PacienteServiceIMPL.PacienteServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorPaciente {

    PacienteService pacienteService = new PacienteServiceIMPL(); // Crea una instancia de PacienteService
    @Autowired
    private PacienteRepo pacienteRepo;

    @Autowired
    private PacienteServiceIMPL impl;
    @GetMapping("/ConsultarPacientes")
    public ResponseEntity<List<Paciente>> consultarPacientesActivos() {
        List<Paciente> pacientesActivos = this.impl.ConsultarPaciente()
                .stream()
                .filter(paciente -> "Activo".equalsIgnoreCase(paciente.getEstado()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(pacientesActivos);
    }



    @PostMapping("/CrearPacientes")
    public ResponseEntity<?> crearPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteCreado = this.impl.CrearPaciente(paciente);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Paciente creado con éxito");
        response.put("pacienteCreado", pacienteCreado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping
    @RequestMapping(value = "/ModificarPacientes",method = RequestMethod.PUT)
    public ResponseEntity<?>ModificarPacientes(@RequestBody Paciente paciente){
        Paciente PacienteModificado=this.impl.ModificarPaciente(paciente);
        String message = "Paciente modificado con éxito.";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("paciente", PacienteModificado);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/ConsultarPacientesOff")
    public ResponseEntity<List<Paciente>> listarPacientesDesactivados() {
        List<Paciente> pacientesDesactivados = impl.ConsultarPaciente().stream()
                .filter(paciente -> paciente.getEstado().equalsIgnoreCase("Desactivo"))
                .collect(Collectors.toList());
        return ResponseEntity.ok                                                                                                                                                              (pacientesDesactivados);
    }


    @GetMapping("/BuscarPacientes/{id}")
    public ResponseEntity<?> buscarPaciente(@PathVariable int id) {
        Paciente paciente = impl.BuscarPaciente(id);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }
        if (!paciente.getEstado().equalsIgnoreCase("Activo")) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Este paciente se encuentra innactivo");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(paciente);
    }


    @DeleteMapping("/EliminarPacientes/{id}")
    public ResponseEntity<Map<String, Object>> desactivarPaciente(@PathVariable int id) {
        Paciente pacienteDesactivado = impl.BuscarPaciente(id);
        pacienteDesactivado.setEstado(false); // Establecer el estado del paciente como inactivo
        impl.ModificarPaciente(pacienteDesactivado); // Actualizar el registro del paciente en la base de datos

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Paciente desactivado con éxito");
        response.put("pacienteDesactivado", pacienteDesactivado);

        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/ActivarPaciente/{id}")
    public ResponseEntity<Map<String, Object>> activarPaciente(@PathVariable int id) {
        Paciente pacienteActivado = impl.BuscarPaciente(id);
        pacienteActivado.setEstado(true); // Establecer el estado del paciente como activo
        impl.actualizarEstadoPaciente(pacienteActivado); // Actualizar el registro del paciente en la base de datos

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Paciente activado con éxito");
        response.put("pacienteActivado", pacienteActivado);

        return ResponseEntity.ok().body(response);
    }



}


