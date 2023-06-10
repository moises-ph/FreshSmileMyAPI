package com.Fresh.ProyectoFormativo.Documents;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("EspecialistaValoracionComentarios")
public class EspecialistaVC {
    @Id
    private String id;
    private int identificacion_especialista;
    private Double Valoracion = 0.0;
    private List<Number> votos = new ArrayList<Number>();
    private List<Comentarios> Comentarios = new ArrayList<Comentarios>();

    public EspecialistaVC(int identificacion_especialista){
        this.identificacion_especialista = identificacion_especialista;
    }
    public EspecialistaVC(){  }

    public EspecialistaVC(String id, int identificacion_especialista, Double valoracion, List<Number> votos, List<Comentarios> comentarios){
        this.identificacion_especialista = identificacion_especialista;
        this.Valoracion = valoracion;
        this.votos = votos;
        this.Comentarios = comentarios;
    }
}
