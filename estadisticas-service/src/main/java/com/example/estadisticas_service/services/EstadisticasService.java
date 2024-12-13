package com.example.estadisticas_service.services;

import com.example.estadisticas_service.externals.VentaDTO;
import com.example.estadisticas_service.externals.VentaService;
import com.example.estadisticas_service.models.InformeEstadistico;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstadisticasService {
    private final VentaService ventaService;

    @Autowired
    public EstadisticasService(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    public InformeEstadistico generarRankingClientes(int topN, LocalDateTime inicio, LocalDateTime fin) {
        List<VentaDTO> ventas = ventaService.obtenerVentas();

        List<VentaDTO> ventasFiltradas = ventas.stream()
                .filter(venta -> !venta.getFecha().isBefore(inicio) && !venta.getFecha().isAfter(fin))
                .toList();

        List<ClienteEstadistica> clientesEstadistica = new ArrayList<>();

        for (VentaDTO venta : ventasFiltradas) {
            ClienteEstadistica cliente = clientesEstadistica.stream()
                    .filter(c -> c.getClienteId().equals(venta.getClienteId()))
                    .findFirst()
                    .orElse(null);

            if (cliente != null) {
                cliente.incrementarCompras();
                cliente.agregarMonto(cliente.getMontoTotal() + venta.getMontoTotal());
            } else {
                clientesEstadistica.add(new ClienteEstadistica(venta.getClienteId(), 1, venta.getMontoTotal()));
            }
        }

        List<ClienteEstadistica> ranking = clientesEstadistica.stream()
                .sorted((c1, c2) -> Long.compare(c2.getCompras(), c1.getCompras()))
                .limit(topN)
                .toList();

        StringBuilder informeTexto = new StringBuilder("Ranking de Clientes (Top " + topN + "): " + " | ");
        for (ClienteEstadistica cliente : ranking) {
            informeTexto.append("Cliente: ").append(cliente.getClienteId())
                    .append(", Compras: ").append(cliente.getCompras())
                    .append(", Monto Total: $").append(String.format("%.2f", cliente.getMontoTotal()))
                    .append(" | ");
        }

        return new InformeEstadistico("Ranking de Clientes", informeTexto.toString(), LocalDateTime.now());
    }

    public InformeEstadistico generarPorcentajePromociones() {
        return null;
    }

    public InformeEstadistico generarRankingVendedores(int n) {
        return null;
    }

    public InformeEstadistico generarPorcentajeEntregas() {
        return null;
    }

    // Clase auxiliar para manejar estadísticas por cliente
    private static class ClienteEstadistica {
        @JsonProperty("clienteId")
        private final String clienteId;
        @JsonProperty("compras")
        private long compras;
        @JsonProperty("montoTotal")
        private double montoTotal;

        public ClienteEstadistica(String clienteId, long compras, double montoTotal) {
            this.clienteId = clienteId;
            this.compras = compras;
            this.montoTotal = montoTotal;
        }

        public String getClienteId() {
            return clienteId;
        }

        public long getCompras() {
            return compras;
        }

        public double getMontoTotal() {
            return montoTotal;
        }

        public void incrementarCompras() {
            this.compras++;
        }

        public void agregarMonto(double monto) {
            this.montoTotal += monto;
        }
    }
}
