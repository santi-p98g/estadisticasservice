package com.example.estadisticas_service.externals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VentaDTO {

    private Long ventaId;

    private String clienteId;

    private LocalDateTime fecha;

    private Double montoTotal;


    public VentaDTO(Long ventaId, String clienteId, LocalDateTime fecha, Double montoTotal) {
        this.ventaId = ventaId;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }


    public Long getVentaId() {
        return ventaId;
    }

    public void setVentaId(Long ventaId) {
        this.ventaId = ventaId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "VentaDTO{" +
                "ventaId=" + ventaId +
                ", clienteId='" + clienteId + '\'' +
                ", fecha=" + fecha +
                ", montoTotal=" + montoTotal +
                '}';
    }

}
