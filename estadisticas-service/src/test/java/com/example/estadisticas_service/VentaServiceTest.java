/*
package com.example.estadisticas_service;

import com.example.estadisticas_service.externals.VentaClient;
import com.example.estadisticas_service.externals.VentaDTO;
import com.example.estadisticas_service.externals.VentaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class VentaServiceTest {

    @Mock
    private VentaClient ventaClient;

    @InjectMocks
    private VentaService ventaService;

    @Test
    void obtenerVentas_debeDevolverVentas() {

        List<VentaDTO> ventasMock = List.of(
                new VentaDTO(1L, "Cliente A", LocalDateTime.now(), 100.0),
                new VentaDTO(2L, "Cliente B", LocalDateTime.now(), 200.0)
        );

        //Mockito.when(ventaClient.obtenerVentas()).thenReturn(ventasMock);

        //List<VentaDTO> resultado = ventaService.obtenerVentas();

        //Assertions.assertEquals(2, resultado.size());
    }
}
*/