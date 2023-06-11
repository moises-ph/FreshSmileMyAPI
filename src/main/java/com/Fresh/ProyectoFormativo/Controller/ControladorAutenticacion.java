package com.Fresh.ProyectoFormativo.Controller;

import com.Fresh.ProyectoFormativo.Entity.Especialista;
import com.Fresh.ProyectoFormativo.Entity.Paciente;
import com.Fresh.ProyectoFormativo.Models.LoginModel;
import com.Fresh.ProyectoFormativo.Service.EspecialistaService;
import com.Fresh.ProyectoFormativo.Service.PacienteService;
import com.Fresh.ProyectoFormativo.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/login")
public class ControladorAutenticacion {
    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private EspecialistaService especialistaService;

    private final TokenService tokenService;

    public ControladorAutenticacion(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/paciente")
    public ResponseEntity<?> LoginPaciente(@RequestBody LoginModel user) throws UsernameNotFoundException {
        Paciente userAuth = this.pacienteService.ConsultarPacientePorEmail(user.getEmail());
        if(userAuth == null){
            throw new UsernameNotFoundException("El usuario no existe");
        }
        else{
            String token = tokenService.generateToken(userAuth.getCorreo(), userAuth.getIdentificacion_paciente());
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/especialista")
    public ResponseEntity<?> LoginEspecialista( @RequestBody LoginModel user) throws UsernameNotFoundException {
        Especialista userAuth = this.especialistaService.ConsultarEspecialistaPorEmail(user.getEmail());
        if(userAuth == null){
            throw new UsernameNotFoundException("El usuario no existe");
        }
        else{
            String token = tokenService.generateToken(userAuth.getCorreo(), userAuth.getIdentificacion_especialista());
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
    }
}
