package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Citas;
import com.Fresh.ProyectoFormativo.Entity.Codigo_administrador;
import com.Fresh.ProyectoFormativo.Service.Codigo_administradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FreshSmile")
public class ControladorCodigo_administrador {
    private final Codigo_administradorService codigoAdministradorService;

    @Autowired
    public ControladorCodigo_administrador(Codigo_administradorService codigoAdministradorService) {
        this.codigoAdministradorService = codigoAdministradorService;
    }

    @GetMapping("/ConsultarCodigo")
    public ResponseEntity<List<Codigo_administrador>> ConsultarCodigo() {
        List<Codigo_administrador> codigoAdministrador = codigoAdministradorService.ConsultarCodigo();
        return ResponseEntity.ok(codigoAdministrador);
    }

    @PutMapping("/ModificarCodigo/{id}")
    public ResponseEntity<Codigo_administrador> modificarCodigo(@PathVariable int id, @RequestBody Codigo_administrador codigoAdministrador) {
        Codigo_administrador codigoExistente = codigoAdministradorService.BuscarCodigo(id);
        // Update the fields of the appointment as necessary
        codigoExistente.setCodigo(codigoAdministrador.getCodigo());
        // Update other fields of the appointment as necessary
        Codigo_administrador codigoActualizada = codigoAdministradorService.ModificarCodigo(codigoExistente);
        return ResponseEntity.ok(codigoActualizada);
    }

}