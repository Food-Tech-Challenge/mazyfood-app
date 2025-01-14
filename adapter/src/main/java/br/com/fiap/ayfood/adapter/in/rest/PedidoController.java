package br.com.fiap.ayfood.adapter.in.rest;

import br.com.fiap.ayfood.model.cliente.Cliente;
import br.com.fiap.ayfood.adapter.in.rest.dto.PedidoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.ayfood.adapter.out.inmemory.InMemoryPedidoRepository;
import br.com.fiap.ayfood.application.port.in.CriarPedidoUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.PedidoRepository;
import br.com.fiap.ayfood.application.service.CriarPedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    private final CriarPedidoUseCase criarPedidoUseCase;

    public PedidoController() {
        PedidoRepository pedidoRepository = new InMemoryPedidoRepository();
        this.criarPedidoUseCase = new CriarPedidoService(pedidoRepository);
    }

    @GetMapping("/test")
    ResponseEntity<PedidoResponse> criarPedido() {
        Cliente cliente = new Cliente(null, null, null);
        var pedido = criarPedidoUseCase.criarPedido(cliente);
        return ResponseEntity.ok(PedidoResponse.fromDomain(pedido));
    }
}