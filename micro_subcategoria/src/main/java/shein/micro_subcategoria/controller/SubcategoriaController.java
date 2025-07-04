package shein.micro_subcategoria.controller;

import shein.micro_subcategoria.entity.Subcategoria;
import shein.micro_subcategoria.service.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/subcategorias")
@Tag(name = "Subcategorías", description = "Operaciones relacionadas con las subcategorías")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @Operation(summary = "Obtener todas las subcategorías")
    @GetMapping
    public List<Subcategoria> obtenerTodasLasSubcategorias() {
        return subcategoriaService.obtenerTodasLasSubcategorias();
    }

    @Operation(summary = "Obtener una subcategoría por ID")
    @GetMapping("/{id}")
    public Subcategoria obtenerSubcategoriaPorId(@PathVariable("id") Integer id) {
        return subcategoriaService.obtenerSubcategoriaPorId(id);
    }

    @Operation(summary = "Crear una nueva subcategoría")
    @PostMapping
    public Subcategoria crearSubcategoria(@Valid @RequestBody Subcategoria subcategoria) {
        return subcategoriaService.crearSubcategoria(subcategoria);
    }

    @Operation(summary = "Actualizar una subcategoría existente")
    @PutMapping("/{id}")
    public Subcategoria actualizarSubcategoria(@PathVariable("id") Integer id,
                                               @Valid @RequestBody Subcategoria detallesSubcategoria) {
        return subcategoriaService.actualizarSubcategoria(id, detallesSubcategoria);
    }

    @Operation(summary = "Eliminar una subcategoría")
    @DeleteMapping("/{id}")
    public void eliminarSubcategoria(@PathVariable("id") Integer id) {
        subcategoriaService.eliminarSubcategoria(id);
    }
}
