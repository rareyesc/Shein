package shein.micro_productos.service;

import shein.micro_productos.entity.Subcategoria;
import java.util.List;

public interface SubcategoriaService {
    List<Subcategoria> obtenerTodasLasSubcategorias();
    Subcategoria obtenerSubcategoriaPorId(Integer id);
    Subcategoria crearSubcategoria(Subcategoria subcategoria);
    Subcategoria actualizarSubcategoria(Integer id, Subcategoria subcategoria);
    void eliminarSubcategoria(Integer id);
}
