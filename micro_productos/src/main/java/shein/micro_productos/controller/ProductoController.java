package shein.micro_productos.controller;

import org.springframework.web.multipart.MultipartFile;
import shein.micro_productos.entity.Producto;
import shein.micro_productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.io.IOException;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import shein.micro_productos.service.S3Service;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Operaciones relacionadas con los productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private S3Service s3Service;

    @Operation(summary = "Obtener todos los productos")
    @GetMapping
    public List<Producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @Operation(summary = "Obtener un producto por ID")
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable("id") Integer id) {
        return productoService.obtenerProductoPorId(id);
    }

    @Operation(summary = "Crear un nuevo producto")
    @PostMapping(consumes = {"multipart/form-data"})
    public Producto crearProducto(
            @Valid @RequestPart("producto") Producto producto,
            @RequestPart("imagen") MultipartFile imagen) throws IOException {

        String imagenUrl = s3Service.uploadFile(imagen);
        producto.setImagen(imagenUrl);
        return productoService.crearProducto(producto);
    }

    @Operation(summary = "Actualizar un producto existente")
    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public Producto actualizarProducto(
            @PathVariable("id") Integer id,
            @Valid @RequestPart("producto") Producto detallesProducto,
            @RequestPart(value = "imagen", required = false) MultipartFile imagen) throws IOException {

        if (imagen != null && !imagen.isEmpty()) {
            String imagenUrl = s3Service.uploadFile(imagen);
            detallesProducto.setImagen(imagenUrl);
        }
        return productoService.actualizarProducto(id, detallesProducto);
    }

    @Operation(summary = "Eliminar un producto")
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable("id") Integer id) {
        productoService.eliminarProducto(id);
    }

    @Operation(summary = "Buscar productos por nombre")
    @GetMapping("/buscar")
    public List<Producto> buscarProductosPorNombre(@RequestParam("nombre") String nombre) {
        return productoService.buscarProductosPorNombre(nombre);
    }

    @Operation(summary = "Obtener un producto por SKU")
    @GetMapping("/sku/{sku}")
    public Producto obtenerProductoPorSku(@PathVariable("sku") String sku) {
        return productoService.obtenerProductoPorSku(sku);
    }
}
