package shein.micro_categoria.controller;

import shein.micro_categoria.entity.Categoria;
import shein.micro_categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Categorías", description = "Operaciones relacionadas con categorías")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Operation(summary = "Obtener todas las categorías")
    @GetMapping
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaService.obtenerTodasLasCategorias();
    }

    @Operation(summary = "Obtener una categoría por ID")
    @GetMapping("/{id}")
    public Categoria obtenerCategoriaPorId(@PathVariable("id") Integer id) {
        return categoriaService.obtenerCategoriaPorId(id);
    }

    @Operation(summary = "Crear una nueva categoría")
    @PostMapping
    public Categoria crearCategoria(@Valid @RequestBody Categoria categoria) {
        return categoriaService.crearCategoria(categoria);
    }

    @Operation(summary = "Actualizar una categoría existente")
    @PutMapping("/{id}")
    public Categoria actualizarCategoria(@PathVariable("id") Integer id,
                                         @Valid @RequestBody Categoria detallesCategoria) {
        return categoriaService.actualizarCategoria(id, detallesCategoria);
    }

    @Operation(summary = "Eliminar una categoría")
    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable("id") Integer id) {
        categoriaService.eliminarCategoria(id);
    }
}
