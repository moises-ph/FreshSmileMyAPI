package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Procedimiento;
import com.Fresh.ProyectoFormativo.Service.ProcedimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/FreshSmile")
public class ControladorProcedimientos {

        private final ProcedimientoService procedimientoService;

        @Autowired
        public  ControladorProcedimientos( ProcedimientoService procedimientoService) {
            this.procedimientoService = procedimientoService;
        }

        @GetMapping("/ConsultarProcedimientos")
        public ResponseEntity<List<Procedimiento>> consultarTipo() {
            List<Procedimiento> procedimiento = procedimientoService.ConsultarProcedimientos();
            return ResponseEntity.ok(procedimiento);
        }

        @PostMapping("/CrearProcedimiento")
        public ResponseEntity<String> crearProcedimiento(@RequestBody Procedimiento procedimiento) {
            Procedimiento nuevoProcedimiento = procedimientoService.CrearProcedimiento(procedimiento);
            String mensaje = "Procedimietno creado exitosamente";
            return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
        }

        @PutMapping("/ModificarProcedimiento/{id}")
        public ResponseEntity<Procedimiento> modificarProcedimiento(@PathVariable int id, @RequestBody Procedimiento procedimiento) {
            Procedimiento procedimientoExistente = procedimientoService.BuscarProcedimiento(id);
            procedimiento.setNombre(procedimiento.getNombre());
            Procedimiento procedimientoActualizado = procedimientoService.ModificarProcedimiento(procedimiento);
            return ResponseEntity.ok(procedimientoActualizado);
        }

        @DeleteMapping("/EliminarProcedimiento/{id}")
        public ResponseEntity<String> eliminarProcedimiento(@PathVariable int id) {
            procedimientoService.EliminarProcedimiento(id);
            String mensaje = "Procedimiento eliminado exitosamente";
            return ResponseEntity.noContent().header("Message", mensaje).build();
        }
    }

