package com.example.estadisticas_service.controllers;

import com.example.estadisticas_service.models.InformeEstadistico;
import com.example.estadisticas_service.services.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasController {

    private final EstadisticasService estadisticasService;

    @Autowired
    public EstadisticasController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
    }

    @GetMapping("/ranking_clientes")
    public ResponseEntity<InformeEstadistico>  obtenerRankingClientes(
            @RequestParam("topN") int topN,
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String fin) {

        try {
            LocalDateTime fechaInicio = LocalDateTime.parse(inicio);
            LocalDateTime fechaFin = LocalDateTime.parse(fin);
            InformeEstadistico informe = estadisticasService.generarRankingClientes(topN, fechaInicio, fechaFin);
            return ResponseEntity.ok(informe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new InformeEstadistico("Error", "Hubo un problema procesando la solicitud.", LocalDateTime.now()));
        }
    }


    @GetMapping("/porcentaje-promociones")
    public InformeEstadistico obtenerPorcentajePromociones() {
        return this.estadisticasService.generarPorcentajePromociones();
    }

    @GetMapping("/ranking-vendedores")
    public InformeEstadistico obtenerRankingVendedores(@RequestParam int n) {
        return this.estadisticasService.generarRankingVendedores(n);
    }

    @GetMapping("/porcentaje-entregas")
    public InformeEstadistico obtenerPorcentajeEntregas(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String fin) {
        return this.estadisticasService.generarPorcentajeEntregas();
    }
}


