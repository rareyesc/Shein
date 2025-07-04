package shein.micro_correopedido.controller;

import shein.micro_correopedido.entity.CorreoPedido;
import shein.micro_correopedido.service.CorreoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/correospedidos")
@Tag(name = "CorreosPedidos", description = "Operaciones relacionadas con correos que hacen pedidos")
public class CorreoPedidoController {

    @Autowired
    private CorreoPedidoService correoPedidoService;

    @Operation(summary = "Obtener todos los correos que hicieron pedidos")
    @GetMapping
    public List<CorreoPedido> obtenerTodosLosCorreosPedidos() {
        return correoPedidoService.obtenerTodosLosCorreosPedidos();
    }

    @Operation(summary = "Obtener un correo de pedido por ID")
    @GetMapping("/{id}")
    public CorreoPedido obtenerCorreoPedidoPorId(@PathVariable("id") Integer id) {
        return correoPedidoService.obtenerCorreoPedidoPorId(id);
    }

    @Operation(summary = "Crear un nuevo correo de pedido")
    @PostMapping
    public CorreoPedido crearCorreoPedido(@Valid @RequestBody CorreoPedido correoPedido) {
        return correoPedidoService.crearCorreoPedido(correoPedido);
    }


    @Operation(summary = "Actualizar un correo de pedido existente")
    @PutMapping("/{id}")
    public CorreoPedido actualizarCorreoPedido(@PathVariable("id") Integer id,
                                         @Valid @RequestBody CorreoPedido detallesCorreoPedido) {
        return correoPedidoService.actualizarCorreoPedido(id, detallesCorreoPedido);
    }

    @Operation(summary = "Eliminar un correo de pedido")
    @DeleteMapping("/{id}")
    public void eliminarCorreoPedido(@PathVariable("id") Integer id) {
        correoPedidoService.eliminarCorreoPedido(id);
    }
}
