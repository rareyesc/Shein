package shein.micro_color.controller;

import shein.micro_color.entity.Color;
import shein.micro_color.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/colores")
@Tag(name = "Colores", description = "Operaciones relacionadas con colores")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @Operation(summary = "Obtener todos los colores")
    @GetMapping
    public List<Color> obtenerTodosLosColor() {
        return colorService.obtenerTodosLosColores();
    }

    @Operation(summary = "Obtener un color por ID")
    @GetMapping("/{id}")
    public Color obtenerColorPorId(@PathVariable("id") Integer id) {
        return colorService.obtenerColorPorId(id);
    }

    @Operation(summary = "Crear un nuevo color")
    @PostMapping
    public Color crearColor(@Valid @RequestBody Color color) {
        return colorService.crearColor(color);
    }


    @Operation(summary = "Actualizar un color existente")
    @PutMapping("/{id}")
    public Color actualizarColor(@PathVariable("id") Integer id,
                                         @Valid @RequestBody Color detallesColor) {
        return colorService.actualizarColor(id, detallesColor);
    }

    @Operation(summary = "Eliminar un color")
    @DeleteMapping("/{id}")
    public void eliminarColor(@PathVariable("id") Integer id) {
        colorService.eliminarColor(id);
    }
}
