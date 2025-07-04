package shein.micro_talla.controller;

import shein.micro_talla.entity.Talla;
import shein.micro_talla.service.TallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tallas")
@Tag(name = "Tallas", description = "Operaciones relacionadas con las tallas")
public class TallaController {

    @Autowired
    private TallaService tallaService;

    @Operation(summary = "Obtener todas las tallas")
    @GetMapping
    public List<Talla> obtenerTodasLasTallas() {
        return tallaService.obtenerTodasLasTallas();
    }

    @Operation(summary = "Obtener una talla por ID")
    @GetMapping("/{id}")
    public Talla obtenerTallaPorId(@PathVariable("id") Integer id) {
        return tallaService.obtenerTallaPorId(id);
    }

    @Operation(summary = "Crear una nueva talla")
    @PostMapping
    public Talla crearTalla(@Valid @RequestBody Talla talla) {
        return tallaService.crearTalla(talla);
    }


    @Operation(summary = "Actualizar una talla existente")
    @PutMapping("/{id}")
    public Talla actualizarTalla(@PathVariable("id") Integer id,
                                         @Valid @RequestBody Talla detallesTalla) {
        return tallaService.actualizarTalla(id, detallesTalla);
    }

    @Operation(summary = "Eliminar una Talla")
    @DeleteMapping("/{id}")
    public void eliminarTalla(@PathVariable("id") Integer id) {
        tallaService.eliminarTalla(id);
    }
}
