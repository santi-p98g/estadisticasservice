package com.example.estadisticas_service.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class InformeEstadistico {

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("informe")
    private String informe;

    @JsonProperty("fechaGeneracion")
    private LocalDateTime fechaGeneracion;

    public InformeEstadistico() {}


    public InformeEstadistico(String descripcion, String informe, LocalDateTime fechaGeneracion) {
        this.descripcion = descripcion;
        this.informe = informe;
        this.fechaGeneracion = fechaGeneracion;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    @Override
    public String toString() {
        return "InformeEstadistico{" +
                "descripcion='" + descripcion + '\'' +
                ", informe='" + informe + '\'' +
                ", fechaGeneracion=" + fechaGeneracion +
                '}';
    }

}
