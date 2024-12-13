package com.example.estadisticas_service.externals;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ventas", url = "https://1737b19e-0701-4450-8c08-27a198dc1648.mock.pstmn.io/ventas")
public interface VentaClient {

    @GetMapping
    List<VentaDTO> obtenerVentas();

}
