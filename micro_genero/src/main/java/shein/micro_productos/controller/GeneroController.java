package shein.micro_productos.controller;

import shein.micro_productos.entity.Genero;
import shein.micro_productos.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/generos")
@Tag(name = "Generos", description = "Operaciones relacionadas con los generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @Operation(summary = "Obtener todos los generos")
    @GetMapping
    public List<Genero> obtenerTodosLosGeneros() {
        return generoService.obtenerTodosLosGeneros();
    }

    @Operation(summary = "Obtener un genero por ID")
    @GetMapping("/{id}")
    public Genero obtenerGeneroPorId(@PathVariable("id") Integer id) {
        return generoService.obtenerGeneroPorId(id);
    }

    @Operation(summary = "Crear un nuevo genero")
    @PostMapping
    public Genero crearGenero(@Valid @RequestBody Genero genero) {
        return generoService.crearGenero(genero);
    }


    @Operation(summary = "Actualizar un genero existente")
    @PutMapping("/{id}")
    public Genero actualizarGenero(@PathVariable("id") Integer id,
                                         @Valid @RequestBody Genero detallesGenero) {
        return generoService.actualizarGenero(id, detallesGenero);
    }

    @Operation(summary = "Eliminar un genero")
    @DeleteMapping("/{id}")
    public void eliminarGenero(@PathVariable("id") Integer id) {
        generoService.eliminarGenero(id);
    }
}
