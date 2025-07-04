package shein.micro_estado.controller;

import shein.micro_estado.entity.Estado;
import shein.micro_estado.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/estados")
@Tag(name = "Estados", description = "Operaciones relacionadas con los estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @Operation(summary = "Obtener todos los estados")
    @GetMapping
    public List<Estado> obtenerTodosLosEstados() {
        return estadoService.obtenerTodosLosEstados();
    }

    @Operation(summary = "Obtener un estado por ID")
    @GetMapping("/{id}")
    public Estado obtenerEstadoPorId(@PathVariable("id") Integer id) {
        return estadoService.obtenerEstadoPorId(id);
    }

    @Operation(summary = "Crear un nuevo estado")
    @PostMapping
    public Estado crearEstado(@Valid @RequestBody Estado estado) {
        return estadoService.crearEstado(estado);
    }


    @Operation(summary = "Actualizar un estado existente")
    @PutMapping("/{id}")
    public Estado actualizarEstado(@PathVariable("id") Integer id,
                                         @Valid @RequestBody Estado detallesEstado) {
        return estadoService.actualizarEstado(id, detallesEstado);
    }

    @Operation(summary = "Eliminar un estado")
    @DeleteMapping("/{id}")
    public void eliminarEstado(@PathVariable("id") Integer id) {
        estadoService.eliminarEstado(id);
    }
}
