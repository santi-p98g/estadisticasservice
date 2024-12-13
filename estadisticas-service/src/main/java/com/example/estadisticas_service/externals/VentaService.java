package com.example.estadisticas_service.externals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private final VentaClient ventasClient;

    public VentaService(VentaClient ventaClient) {

        this.ventasClient = ventaClient;
    }



    public List<VentaDTO> obtenerVentas() {
        //return this.ventasClient.obtenerVentas();

        //MOCK
        return Arrays.asList(
                new VentaDTO(1L, "Cliente A", LocalDateTime.parse("2024-12-01T00:00:00"), 150.50),
                new VentaDTO(2L, "Cliente B", LocalDateTime.parse("2024-12-02T00:00:00"), 200.75),
                new VentaDTO(3L, "Cliente A", LocalDateTime.parse("2024-12-03T00:00:00"), 300.00),
                new VentaDTO(4L, "Cliente C", LocalDateTime.parse("2024-12-02T00:00:00"), 50.00),
                new VentaDTO(5L, "Cliente D", LocalDateTime.parse("2024-12-01T00:00:00"), 400.00),
                new VentaDTO(6L, "Cliente E", LocalDateTime.parse("2024-12-01T00:00:00"), 120.00),
                new VentaDTO(7L, "Cliente A", LocalDateTime.parse("2024-12-03T00:00:00"), 250.00),
                new VentaDTO(8L, "Cliente B", LocalDateTime.parse("2024-12-03T00:00:00"), 300.50),
                new VentaDTO(9L, "Cliente F", LocalDateTime.parse("2024-12-02T00:00:00"), 75.00),
                new VentaDTO(10L, "Cliente G", LocalDateTime.parse("2024-12-01T00:00:00"), 180.00)
        );

    }


}