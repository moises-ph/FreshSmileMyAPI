package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Documents.Comentarios;
import com.Fresh.ProyectoFormativo.Documents.EspecialistaVC;
import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import com.Fresh.ProyectoFormativo.Service.EspecialistaServiceIMPL.EspecialistaServiceIMPL;
import com.Fresh.ProyectoFormativo.Service.EspecialistaVCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("FreshSmile/Especialistas")
public class ControladorEspecialista {
    private EspecialistaService especialistaService;

    private EspecialistaVCService especialistaVCService;

    @Autowired
    public ControladorEspecialista(EspecialistaVCService especialistaVCService, EspecialistaService especialistaService) {
        this.especialistaVCService = especialistaVCService;
        this.especialistaService = especialistaService;
    }

    //Especialista principal//
    @GetMapping("/ConsultarEspecialista")
    public ResponseEntity<List<Especialista>> consultarEspecialista() {
        List<Especialista> especialista = especialistaService.ConsultarEspecialistas();
        return ResponseEntity.ok(especialista);
    }

    @PostMapping("/CrearEspecialista")
    public ResponseEntity<?> crearEspecialista(@RequestBody Especialista especialista) {
        Especialista especialistaCreado = this.especialistaService.CrearEspecialista(especialista);
        EspecialistaVC createdEspecialistaVC = this.especialistaVCService.createEspecialst(new EspecialistaVC(especialistaCreado.getIdentificacion_especialista()));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Especialista creado con éxito");

        Map<String, Object> data = new HashMap<>();
        data.put("especialista", especialistaCreado);
        data.put("rating", createdEspecialistaVC);

        response.put("especialistaCreado", data);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    @RequestMapping(value = "/ModificarEspecialista",method = RequestMethod.PUT)
    public ResponseEntity<?>ModificarEspecialista(@RequestBody Especialista especialista){
        Especialista EspecialistaModificado=this.especialistaService.ModificarEspecialista(especialista);
        String message = "Administrador modificado con éxito.";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("especialista", EspecialistaModificado);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/BuscarEspecialista/{id}")
    public ResponseEntity<?> buscarEspecialista ( @PathVariable int id){
        Especialista especialista = especialistaService.BuscarEspecialista(id);
        return ResponseEntity.ok(especialista);
    }

    @DeleteMapping("/EliminarEspecialista/{id}")
    public ResponseEntity<String> eliminarEspecialista(@PathVariable int id) {
        especialistaService.EliminarEspecialista(id);
        String mensaje = "Especialista eliminado exitosamente"; // Mensaje de éxito
        return ResponseEntity.noContent().header("Message", mensaje).build();
    }

}

