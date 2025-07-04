package shein.micro_productos.controller;

import shein.micro_productos.dto.PedidoConProductos;
import shein.micro_productos.entity.Pedido;
import shein.micro_productos.entity.ProductoPedido;
import shein.micro_productos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "Operaciones relacionadas con los pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "Obtener todos los pedidos")
    @GetMapping
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoService.obtenerTodosLosPedidos();
    }

    @Operation(summary = "Obtener un pedido por ID")
    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable("id") Integer id) {
        return pedidoService.obtenerPedidoPorId(id);
    }

    @Operation(summary = "Crear un nuevo pedido")
    @PostMapping
    public Pedido crearPedido(@Valid @RequestBody PedidoConProductos pedidoConProductos) {
        return pedidoService.crearPedido(pedidoConProductos.getPedido(), pedidoConProductos.getProductos());
    }

    @Operation(summary = "Actualizar un pedido existente")
    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable("id") Integer id,
                                   @Valid @RequestBody PedidoConProductos pedidoConProductos) {
        return pedidoService.actualizarPedido(id, pedidoConProductos.getPedido(), pedidoConProductos.getProductos());
    }

    @Operation(summary = "Eliminar un pedido")
    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable("id") Integer id) {
        pedidoService.eliminarPedido(id);
    }

    @Operation(summary = "Obtener productos asociados a un pedido")
    @GetMapping("/{id}/productos")
    public List<ProductoPedido> obtenerProductosPorPedido(@PathVariable("id") Integer id) {
        return pedidoService.obtenerProductosPorPedido(id);
    }
}
